package com.kpi.vkhitev.lab2extended;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by vkhit on 11.04.2017.
 */
public class ScheduleAggregator {
  private final Schedule schedule;

  ScheduleAggregator (Schedule schedule) {
    this.schedule = schedule;
  }

  public Set<Classroom> getBusyClassrooms (int day, int lesson) {
    return this.schedule.getLessonsAt(day, lesson)
      .stream()
      .map(Schedulable.Entity::getClassroom)
      .collect(Collectors.toSet());
  }

  public Set<Classroom> getEmptyClassrooms (int day, int lesson) {
    Set<Classroom> classrooms = schedule.getClassrooms();
    classrooms.removeAll(getBusyClassrooms(day, lesson));
    return classrooms;
  }
}
