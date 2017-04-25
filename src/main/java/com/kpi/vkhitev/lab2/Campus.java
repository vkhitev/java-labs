package com.kpi.vkhitev.lab2;

import com.kpi.vkhitev.lab2.Models.Lesson;
import com.kpi.vkhitev.lab2.Models.Room;
import com.kpi.vkhitev.lab2.Models.Timetable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Campus {
//  private List<Room> classrooms;
  private Map<String, Timetable> schedule;

  Campus() {
//    this.classrooms = new ArrayList<Room>();

    this.schedule = ScheduleRequester.fetchGroupNames()
      .parallelStream()
      .map(ScheduleRequester::fetchTimetable)
      .limit(5)
      .filter(timetable -> timetable != null && !timetable.getWeeks().isEmpty())
      .collect(Collectors.toMap(Timetable::getGroupFullName, Function.identity()));

    System.out.println("Campus constructed");
  }

//  public List<Room> getClassrooms() {
//    return classrooms;
//  }

  public Map<String, Timetable> getSchedule() {
    return schedule;
  }

  public Set<String> getAllRooms() {
    return schedule.values()
      .stream()
      .flatMap(t -> t
        .getWeeks()
        .entrySet()
        .stream()
      )
      .flatMap(ew -> ew
        .getValue()
        .getDays()
        .entrySet()
        .stream()
      )
      .flatMap(ed -> ed
        .getValue()
        .getLessons()
        .stream()
      )
      .flatMap(l -> l
        .getRooms()
        .stream()
        .map(Room::getRoomName)
      )
      .collect(Collectors.toSet());
  }

  public Set<String> getBusyRooms(int week, int day, int lesson) {
    return schedule.values()
      .stream()
      .flatMap(t -> t
        .getWeeks()
        .entrySet()
        .stream()
        .filter(ew -> ew.getKey().equals(Integer.toString(week)))
      )
      .flatMap(ew -> ew
        .getValue()
        .getDays()
        .entrySet()
        .stream()
        .filter(ed -> ed.getKey().equals(Integer.toString(day)))
      )
      .flatMap(ed -> ed
        .getValue()
        .getLessons()
        .stream()
        .filter(l -> l.getLessonNumber().equals(Integer.toString(lesson)))
      )
      .flatMap(l -> l
        .getRooms()
        .stream()
        .map(Room::getRoomName)
      )
      .collect(Collectors.toSet());
  }

  public Set<String> getEmptyRooms(int week, int day, int lesson) {
    Set<String> allRooms = getAllRooms();
    allRooms.removeAll(getBusyRooms(week, day, lesson));
    return allRooms;
  }

  public Set<String> getRoomsOfBuilding(String builing) {
    Set<String> rooms = getAllRooms();
    return rooms
      .stream()
      .filter(name -> name.substring(name.length() - 2, name.length()).equals(builing))
      .collect(Collectors.toSet());
  }
}
