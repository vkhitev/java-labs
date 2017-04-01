package com.kpi.vkhitev.lab1;

import com.kpi.vkhitev.lab1.task2.Deposit;
import com.kpi.vkhitev.lab1.task1.Classroom;
import com.kpi.vkhitev.lab1.task1.ClassroomSize;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        task1();
        System.out.println("================");
        task2();
    }

    public static void task1() {
        Classroom classroom = new Classroom("416-a", ClassroomSize.SMALL);

        System.out.println("Is empty: " + classroom.isEmpty());

        try {
            classroom.takePlace(2);
            classroom.takePlace(12);
            classroom.emptyPlace(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        classroom.setAmountOfPlaces(6);
        classroom.setAmountOfPlaces(4);

        System.out.println("Is empty: " + classroom.isEmpty());
        System.out.println("Information about classroom:");
        System.out.println(classroom.toString());

        Classroom classroom2 = new Classroom("416-b", 40);

        if (classroom2.compareTo(classroom) == 0) {
            System.out.println("Classrooms are equal");
        } else {
            System.out.println("Classrooms are not equal");
        }
    }

    public static void task2() {
        BigDecimal initial = new BigDecimal("11.04");
        BigDecimal result = Deposit.Calculate(initial, 10, 1);
        System.out.println(result);

        initial = new BigDecimal("230.44");
        result = Deposit.Calculate(initial, 14, 3);
        System.out.println(result);
    }
}
