package com.kpi.vkhitev.lab2extended;

/**
 * Created by vkhit on 11.04.2017.
 */
public final class Laboratory extends Classroom {
  private String type = "";

  public Laboratory(String name, String type) {
    super(name);
    this.type = type;
  }

  @Override
  public String toString() {
    return "Laboratory #" + this.name + " of " + this.type;
  }
}
