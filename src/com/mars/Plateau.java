package com.mars;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Plateau {
    private static final Plateau instance = new Plateau();
    public static final Map<String, String> ORIENTATION_MAP = Stream.of(new String[][] {
            { "NL", "W" },
            { "NR", "E" },
            { "SL", "E" },
            { "SR", "W" },
            { "EL", "N" },
            { "ER", "S" },
            { "WL", "S" },
            { "WR", "N" },
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    private int upperBoundary;
    private int rightBoundary;

    public static Plateau getInstance(){
        return instance;
    }

    public int getRightBoundary() {
        return rightBoundary;
    }

    public int getUpperBoundary() {
        return upperBoundary;
    }

    public void setRightBoundary(int rightBoundary) {
        this.rightBoundary = rightBoundary;
    }

    public void setUpperBoundary(int upperBoundary) {
        this.upperBoundary = upperBoundary;
    }
}
