package com.kpi.vkhitev.lab1.task2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Deposit {
  public static BigDecimal Calculate(BigDecimal initial, double yearPercent, int years) {
    BigDecimal result = new BigDecimal(initial.toString());
    BigDecimal percent = new BigDecimal(yearPercent / 100, MathContext.UNLIMITED);
    for (int i = 0; i < years; i++)
      result = result.add(result.multiply(percent));
    return result.setScale(2, RoundingMode.CEILING);
  }
}
