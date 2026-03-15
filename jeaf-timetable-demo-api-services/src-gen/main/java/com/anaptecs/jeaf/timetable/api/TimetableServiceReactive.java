/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api;

import reactor.core.publisher.Mono;

public interface TimetableServiceReactive {
  /**
   * @param request
   * @param pContext
   * @return {@link TimetableResponse}
   */
  Mono<TimetableResponse> executeTripSearch( TripSearchRequest request, DemoContext pContext );

  /**
   * @param pRequest
   * @param pContext
   * @return {@link TimetableResponse}
   */
  Mono<TimetableResponse> executeIntervalSearch( IntervalSearchRequest pRequest, DemoContext pContext );
}