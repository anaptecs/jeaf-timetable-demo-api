/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api;

public enum VehicleType {
  TGV, ICE, IC, RE, S, PEX,
  /**
   * Literal UNKNOWN is used in case that an unknown literal of this enumeration is received e.g. via an external
   * interface.
   */
  UNKNOWN;
}