package com.kpi.vkhitev.lab1.task1;

public final class ClassroomSize {
    private final int value;

    public ClassroomSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static final ClassroomSize SMALL = new ClassroomSize(10);
    public static final ClassroomSize MEDIUM = new ClassroomSize(20);
    public static final ClassroomSize BIG = new ClassroomSize(30);
}