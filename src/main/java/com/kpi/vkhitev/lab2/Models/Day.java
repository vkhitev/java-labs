package com.kpi.vkhitev.lab2.Models;

import java.util.List;

public class Day {
  private String day_name;
  private Integer day_number;
  private List<Lesson> lessons;

  public List<Lesson> getLessons() {
    return lessons;
  }

  public String getDayName() {
    return day_name;
  }

  public Integer getDayNumber() {
    return day_number;
  }
}
