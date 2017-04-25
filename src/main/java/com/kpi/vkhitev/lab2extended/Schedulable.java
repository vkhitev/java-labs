package com.kpi.vkhitev.lab2extended;

/**
 * Created by vkhit on 11.04.2017.
 */
public interface Schedulable<ClassroomType, GroupType> {
  void setLesson(int day, int lesson, ClassroomType classroom, GroupType group, String subjectName);
  Iterable<Entity> getAllLessons();
  Iterable<Entity> getLessonsAt(int day, int lesson);
  Iterable<ClassroomType> getClassrooms();
  Iterable<GroupType> getGroups();

  public class Entity {
    private final int day;
    private final int lesson;
    private final Classroom classroom;
    private final String group;
    private final String subjectName;

    public int getDay () {
      return day;
    }

    public int getLesson () {
      return lesson;
    }

    public Classroom getClassroom () {
      return classroom;
    }

    public String getGroup () {
      return group;
    }

    public String getSubjectName () {
      return subjectName;
    }

    Entity (int day, int lesson, Classroom classroom, String group, String subjectName) {
      this.day = day;
      this.lesson = lesson;
      this.classroom = classroom;
      this.group = group;
      this.subjectName = subjectName;
    }
  }
}
