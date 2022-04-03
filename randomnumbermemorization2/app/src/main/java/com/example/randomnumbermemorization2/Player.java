package com.example.randomnumbermemorization2;

import java.util.Comparator;

import javax.xml.namespace.QName;

public class Player implements Comparable<Player> {
    public String name;
    public String score;

    public Player(String name, String score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public int compareTo(Player u) {
        if (score == null || u.score == null) {
            return 0;
        }
        return u.score.compareTo(score);
    }


}
