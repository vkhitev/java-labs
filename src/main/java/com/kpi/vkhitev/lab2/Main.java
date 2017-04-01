package com.kpi.vkhitev.lab2;

import com.kpi.vkhitev.lab2.Models.Timetable;
import java.util.Map;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Campus c = new Campus();

    System.out.println(c.getSchedule());

    Set<String> allRooms = c.getAllRooms();
    Set<String> busyRooms = c.getBusyRooms(1, 1, 1);
    Set<String> emptyRooms = c.getEmptyRooms(1, 1, 1);
    System.out.println(allRooms);
    System.out.println(busyRooms);
    System.out.println(emptyRooms);
  }
}
