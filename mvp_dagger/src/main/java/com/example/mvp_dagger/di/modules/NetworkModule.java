package com.example.mvp_dagger.di.modules;

import com.example.mvp_dagger.BuildConfig;
import com.example.mvp_dagger.api.ApiInterface;
import com.example.mvp_dagger.utils.DateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit provideRetrofitWithGson(Gson gson, OkHttpClient okHttpClient) {
        return getRetrofitBuilder(okHttpClient, gson)
                .baseUrl(BuildConfig.BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        int READ_TIME_OUT = 30;
        builder.readTimeout(READ_TIME_OUT, TimeUnit.SECONDS);
        builder.addInterceptor(httpLoggingInterceptor);
        OkHttpClient okHttpClient = builder.build();
        return okHttpClient;
    }

    @Provides
    @Singleton
    ApiInterface provideJokeRestApi(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }

    private Retrofit.Builder getRetrofitBuilder(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson));
    }
}
