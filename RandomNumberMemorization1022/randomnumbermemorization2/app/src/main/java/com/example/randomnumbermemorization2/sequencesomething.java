package com.example.randomnumbermemorization2;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.ArrayList;

public class sequencesomething {

    public static int randomNumberGenerator() {
        Random rand = new Random();
        int upperbound = 9;
        int int_random = rand.nextInt(upperbound) + 1;

        return int_random;
    }

    public static String makeArray() {
        ArrayList<Integer> numb = new ArrayList<Integer>();
        int number = randomNumberGenerator();
        numb.add(number);
        String finalsequence = joinArray(numb);
        return finalsequence;
    }

    public static String joinArray(ArrayList<Integer> numb) {
        StringBuilder finalsequence = new StringBuilder();
        for (int i = 0; i < numb.size(); i++) {
            finalsequence.append(numb.get(i) + "  ");
        }
        return finalsequence.toString();
    }

}
