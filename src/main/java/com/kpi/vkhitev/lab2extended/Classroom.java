package com.kpi.vkhitev.lab2extended;

/**
 * Created by vkhit on 11.04.2017.
 */
public class Classroom implements Comparable<Classroom> {
  protected String name = "";

  public Classroom(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Classroom o) {
    return this.name.compareTo(o.name);
  }

  @Override
  public String toString() {
    return "Classroom #" + this.name;
  }
}
