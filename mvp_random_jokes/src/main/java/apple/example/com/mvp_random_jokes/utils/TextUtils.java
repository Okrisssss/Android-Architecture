package apple.example.com.mvp_random_jokes.utils;

import java.util.Random;

public class TextUtils {
    public static String getRandomDigit() {
        String randomNumber = new Random().nextInt(100) + "";
        return randomNumber;
    }
}
