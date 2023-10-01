package com.example.randomnumbermemorization2;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import android.content.Context;

public class FileUtil {
    public static void saveArrayList(Context context, ArrayList<String> arrayList) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("GameScoreCard", Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(arrayList);
            out.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getSavedArrayList(Context context) {
        ArrayList<String> savedArrayList = new ArrayList<>();

        try {
            FileInputStream inputStream = context.openFileInput("GameScoreCard");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            savedArrayList = (ArrayList<String>) in.readObject();
            in.close();
            inputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return savedArrayList;
    }


}
