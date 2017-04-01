package com.kpi.vkhitev.lab2.Models;

import java.util.Map;

public class Week {
  private Integer week_number;
  private Map<String, Day> days;

  public Map<String, Day> getDays() {
    return days;
  }

  public Integer getWeekNumber() {
    return week_number;
  }
}
