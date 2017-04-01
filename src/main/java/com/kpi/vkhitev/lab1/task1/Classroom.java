package com.kpi.vkhitev.lab1.task1;

public final class Classroom implements Comparable<Classroom> {
  private boolean[] busyPlaces;
  private String name;

  // Constructors

  public Classroom(String name, ClassroomSize size) {
    this.name = name;
    int places = size.getValue();
    this.busyPlaces = new boolean[places];
  }

  public Classroom(String name, int totalNumberOfPlaces) {
    this.name = name;
    this.busyPlaces = new boolean[totalNumberOfPlaces];
  }

  public Classroom() {
    this.name = "";
    this.busyPlaces = new boolean[0];
  }

  // Setters and getters

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setAmountOfPlaces(int places) {
    int oldSize = this.busyPlaces.length;
    boolean[] tmp = new boolean[places];
    if (places >= oldSize) {
      System.arraycopy(this.busyPlaces, 0, tmp, 0, oldSize);
      for (int i = oldSize + 1; i < places; i++) {
        tmp[i] = false;
      }
    } else {
      System.arraycopy(this.busyPlaces, 0, tmp, 0, places);
    }
    this.busyPlaces = tmp;
  }

  public int getAmountOfPlaces() {
    return busyPlaces.length;
  }

  public boolean[] getPlaces() {
    return this.busyPlaces;
  }

  // Logic

  public boolean isEmpty() {
    for (boolean place : this.busyPlaces) {
      if (place) {
        return false;
      }
    }
    return true;
  }

  // Specific

  public void takePlace(int place) throws Exception {
    this.setPlace(place, true);
  }

  public void emptyPlace(int place) throws Exception {
    this.setPlace(place, false);
  }

  private void setPlace(int place, boolean value) throws Exception {
    if (place > this.busyPlaces.length) {
      throw new Exception("No such place: " + place);
    } else if (this.busyPlaces[place - 1] == value) {
      if (value) {
        throw new Exception("Place is busy");
      } else {
        throw new Exception("Place is empty");
      }
    }
    this.busyPlaces[place - 1] = value;
  }

  public int compareTo(Classroom classroom) {
    return this.name.compareTo(classroom.name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("Name: %s, Empty: %b\n", this.name, this.isEmpty()));
    for (int i = 0; i < this.busyPlaces.length; i++) {
      sb.append(i + 1).append(" - ");
      if (this.busyPlaces[i]) {
        sb.append("busy\n");
      } else {
        sb.append("not busy\n");
      }
    }
    return sb.toString();
  }
}

