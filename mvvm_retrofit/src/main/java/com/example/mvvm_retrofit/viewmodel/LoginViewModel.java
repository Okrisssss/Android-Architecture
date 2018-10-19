package com.example.mvvm_retrofit.viewmodel;

import android.content.Context;
import android.widget.Toast;

import java.util.Observable;

public class LoginViewModel extends Observable {

    private Context context;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public void sendLoginRequest(){
    showToast("Inside LoginViewModel");
    }
    void showToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
