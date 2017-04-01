package com.kpi.vkhitev.lab2;

import com.google.gson.Gson;
import java.util.List;

public class Main {
  public static void main(String[] args) {
//    Campus c = new Campus();
//    System.out.println(c.getEmptyClassrooms(1, 2));
    try {
      List<String> data = ScheduleRequester.fetchGroups();
      System.out.println(data);
    } catch (Exception e) {
      System.out.println("ERROR");
    }
  }
}
