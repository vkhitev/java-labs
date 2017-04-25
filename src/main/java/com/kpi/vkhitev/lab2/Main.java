package com.kpi.vkhitev.lab2;

import com.kpi.vkhitev.lab2.Models.Timetable;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    System.out.println("Program started");

    Campus c = new Campus();

    Set<String> allRooms = c.getAllRooms();
    Set<String> busyRooms = c.getBusyRooms(1, 1, 1);
    Set<String> emptyRooms = c.getEmptyRooms(1, 1, 1);

    System.out.println("All rooms: " + allRooms);
    System.out.println("Busy rooms: " + busyRooms);
    System.out.println("Empty rooms: " + emptyRooms);

    List<String> sortedByBuildingRooms = allRooms
      .stream()
      .sorted(Comparator.comparing(name -> name.substring(name.length() - 2, name.length())))
      .collect(Collectors.toList());
    System.out.println("Sorted by building rooms: " + sortedByBuildingRooms);

    Set<String> roomsOfBuilding19 = c.getRoomsOfBuilding("19");
    System.out.println("Rooms of building 19: " + roomsOfBuilding19);
  }
}
