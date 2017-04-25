package com.kpi.vkhitev.lab2extended;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by vkhit on 11.04.2017.
 */
public class Campus {
  /*
  * Main function
  */
  public static void main(String[] args) {
    class ScheduleLocalAdapter {
      private Schedule schedule;

      ScheduleLocalAdapter (Schedule schedule) {
        this.schedule = schedule;
      }

      private String prettyFormat (Collection<?> iterable) {
        return iterable
          .stream()
          .map(c -> " - " + c.toString())
          .collect(Collectors.joining("\n"));
      }

      void printBusyRooms (int day, int lesson) {
        System.out.println(
          "Busy rooms on day " + day + ", on lesson " + lesson + ": \n" +
            prettyFormat(new ScheduleAggregator(schedule).getBusyClassrooms(day, lesson))
        );
      }

      void printEmptyRooms (int day, int lesson) {
        System.out.println(
          "Empty rooms on day " + day + ", on lesson " + lesson + ": \n" +
            prettyFormat(new ScheduleAggregator(schedule).getEmptyClassrooms(day, lesson))
        );
      }

      void printAllRooms () {
        System.out.println(
          "All rooms: \n" +
            prettyFormat(schedule.getClassrooms())
        );
      }

      void printAllGroups () {
        System.out.println(
          "All groups: \n" +
            prettyFormat(schedule.getGroups())
        );
      }
    }

    final Map<String, Classroom> classrooms = initFakeClassrooms();
    final Schedule schedule = initFakeSchedule(classrooms);

    ScheduleLocalAdapter sla = new ScheduleLocalAdapter(schedule);

    sla.printAllRooms();
    sla.printAllGroups();

    sla.printBusyRooms(1, 1);
    sla.printEmptyRooms(1, 1);
  }




  private static Map<String, Classroom> initFakeClassrooms() {
    Map<String, Classroom> lessons = new HashMap<>();
    lessons.put("301", new Classroom("301"));
    lessons.put("302", new Classroom("302"));
    lessons.put("303", new Classroom("303"));
    lessons.put("416", new Laboratory("416", "optical physics"));
    lessons.put("417", new Laboratory("417", "optical physics"));
    lessons.put("418", new Laboratory("418", "quantum physics"));
    return lessons;
  }

  private static Schedule initFakeSchedule(Map<String, Classroom> classrooms) {
    Schedule schedule = new Schedule();
    schedule.setLesson(1, 1, classrooms.get("301"), "is-41", "subject 1");
    schedule.setLesson(1, 2, classrooms.get("302"), "is-42", "subject 2");
    schedule.setLesson(2, 1, classrooms.get("303"), "is-41", "subject 3");
    schedule.setLesson(2, 2, classrooms.get("301"), "is-43", "subject 4");
    schedule.setLesson(3, 2, classrooms.get("416"), "is-41", "subject 1");
    schedule.setLesson(3, 3, classrooms.get("417"), "is-42", "subject 2");
    schedule.setLesson(4, 2, classrooms.get("416"), "is-41", "subject 3");
    schedule.setLesson(4, 4, classrooms.get("302"), "is-41", "subject 4");
    schedule.setLesson(5, 1, classrooms.get("418"), "is-43", "subject 1");
    schedule.setLesson(5, 3, classrooms.get("418"), "is-41", "subject 2");
    return schedule;
  }
}
