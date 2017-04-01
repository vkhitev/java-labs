package com.kpi.vkhitev.lab2;

import com.kpi.vkhitev.lab2.Classroom;
import com.kpi.vkhitev.lab2.Schedule;
import java.util.ArrayList;
import java.util.List;

public class Campus {
  private List<Classroom> classrooms;
  private Schedule schedule;

  Campus() {
    this.classrooms = new ArrayList<Classroom>();
    this.schedule = new Schedule();
  }

  public List<Classroom> getClassrooms() {
    return classrooms;
  }

  public Schedule getSchedule() {
    return schedule;
  }

//  public syncWithRemote() {
//
//  }

//    public List<Classroom> getEmptyClassrooms(int lesson, int week) {
//    return this.classrooms
//      .stream()
//      .filter(classroom -> classroom);
//  }
}
