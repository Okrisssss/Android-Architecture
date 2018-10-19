package com.example.just_simple_mvvm.utils;

import java.util.Random;

public class TextUtils {
    public static String getRandomDigit() {
        String randomNumber = new Random().nextInt(603) + "";
        return randomNumber;
    }
}
