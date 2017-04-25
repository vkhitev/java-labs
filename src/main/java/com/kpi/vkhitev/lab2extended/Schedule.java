package com.kpi.vkhitev.lab2extended;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by vkhit on 11.04.2017.
 */
public class Schedule implements Schedulable<Classroom, String> {
  final private List<Entity> schedule;

  public Schedule() {
    schedule = new ArrayList<>();
  }

  @Override
  public void setLesson(int day, int lesson, Classroom classroom, String group, String subjectName) {
    this.schedule.add(new Entity(day, lesson, classroom, group, subjectName));
  }

  @Override
  public Set<Entity> getLessonsAt(int day, int lesson) {
    return this.getAllLessons()
      .stream()
      .filter(e -> e.getDay() == day && e.getLesson() == lesson)
      .collect(Collectors.toSet());
  }

  @Override
  public Set<Classroom> getClassrooms() {
    return this.schedule
      .stream()
      .map(Entity::getClassroom)
      .collect(Collectors.toSet());
  }

  @Override
  public Set<String> getGroups() {
    return this.schedule
      .stream()
      .map(Entity::getGroup)
      .collect(Collectors.toSet());
  }

  @Override
  public List<Entity> getAllLessons() {
    return schedule;
  }
}
