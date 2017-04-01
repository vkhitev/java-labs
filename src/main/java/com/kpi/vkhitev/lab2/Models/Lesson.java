package com.kpi.vkhitev.lab2.Models;

import java.util.List;

public class Lesson {
  private String day_name;
  private String lesson_name;
  private String lesson_number;
  private List<Room> rooms;

  public List<Room> getRooms() {
    return rooms;
  }

  public String getDayName() {
    return day_name;
  }

  public String getLessonName() {
    return lesson_name;
  }

  public String getLessonNumber() {
    return lesson_number;
  }
}
