package com.kpi.vkhitev.lab2.Models;

import java.util.Map;

public class Timetable {
  private String group_full_name;
  private Map<String, Week> weeks;

  public Map<String, Week> getWeeks() {
    return weeks;
  }

  public String getGroupFullName() {
    return group_full_name;
  }
}
