/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api;

public interface TimetableService {
  /**
   * @param request
   * @param pContext
   * @return {@link TimetableResponse}
   */
  TimetableResponse executeTripSearch( TripSearchRequest request, DemoContext pContext );

  /**
   * @param pRequest
   * @param pContext
   * @return {@link TimetableResponse}
   */
  TimetableResponse executeIntervalSearch( IntervalSearchRequest pRequest, DemoContext pContext );
}