/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api.resource;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.anaptecs.jeaf.timetable.api.DemoContext;
import com.anaptecs.jeaf.timetable.api.IntervalSearchRequest;
import com.anaptecs.jeaf.timetable.api.TimetableResponse;
import com.anaptecs.jeaf.timetable.api.TimetableService;
import com.anaptecs.jeaf.timetable.api.TripSearchRequest;
import com.anaptecs.jeaf.timetable.api.UICCode;
import com.anaptecs.jeaf.validation.api.ValidationExecutor;

@RequestMapping(path = "/timetable")
@RestController
public class TimetableServiceResource {
  /**
   * REST Controller was generated with request / response validation enabled. The actual validation will be delegated
   * to the implementation of this interface.
   */
  private final ValidationExecutor validationExecutor;

  /**
   * All request to this class will be delegated to {@link TimetableService}.
   */
  private final TimetableService timetableService;

  /**
   * Initialize object.
   *
   * @param pTimetableService Dependency on concrete {@link TimetableService} implementation that should be used.
   * @param pValidationExecutor Validation executor for request / response validation.
   */
  public TimetableServiceResource( TimetableService pTimetableService, ValidationExecutor pValidationExecutor ) {
    timetableService = pTimetableService;
    validationExecutor = pValidationExecutor;
  }

  /**
   * {@link TimetableService#executeTripSearch()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "trips", method = { RequestMethod.GET })
  public TimetableResponse executeTripSearch( @RequestParam(name = "origin", required = true) int pOriginAsBasicType,
      @RequestParam(name = "destination", required = true) int pDestinationAsBasicType,
      @RequestParam(name = "vias", required = false) int[] pViasAsBasicType,
      @RequestParam(name = "start", required = true) String pStartAsBasicType,
      @RequestParam(name = "maxConnections", required = false, defaultValue = "5") int pMaxConnections,
      @RequestHeader(name = "traceparent", required = false) String pTraceParent,
      @RequestHeader(name = "tracestate", required = false) String pTraceState,
      @RequestHeader(name = "Accept-Language", required = false) String pAcceptLanguage,
      @RequestHeader(name = "Date-Shift", required = false) String pDateShift,
      @RequestHeader(name = "Time-Shift", required = false) String pTimeShift ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lRequestBuilder = TripSearchRequest.builder();
    // Handle bean parameter request.origin
    lRequestBuilder.setOrigin(UICCode.builder().setCode(pOriginAsBasicType).build());
    // Handle bean parameter request.destination
    lRequestBuilder.setDestination(UICCode.builder().setCode(pDestinationAsBasicType).build());
    // Handle bean parameter request.vias
    if (pViasAsBasicType != null) {
      List<UICCode> lVias = new ArrayList<UICCode>();
      for (int lNext : pViasAsBasicType) {
        lVias.add(UICCode.builder().setCode(lNext).build());
      }
      lRequestBuilder.setVias(lVias);
    }
    // Handle bean parameter request.start
    if (pStartAsBasicType != null) {
      lRequestBuilder.setStart(OffsetDateTime.parse(pStartAsBasicType));
    }
    lRequestBuilder.setMaxConnections(pMaxConnections);
    TripSearchRequest request = lRequestBuilder.build();
    var lContextBuilder = DemoContext.builder();
    lContextBuilder.setTraceParent(pTraceParent);
    lContextBuilder.setTraceState(pTraceState);
    lContextBuilder.setAcceptLanguage(pAcceptLanguage);
    lContextBuilder.setDateShift(pDateShift);
    lContextBuilder.setTimeShift(pTimeShift);
    DemoContext pContext = lContextBuilder.build();
    // Validate request parameter(s).
    validationExecutor.validateRequest(TimetableService.class, request, pContext);
    // Delegate request to service.
    TimetableResponse lResponse = timetableService.executeTripSearch(request, pContext);
    // Validate response and return it.
    validationExecutor.validateResponse(TimetableService.class, lResponse);
    return lResponse;
  }

  /**
   * {@link TimetableService#executeIntervalSearch()}
   */
  @ResponseStatus(HttpStatus.OK)
  @RequestMapping(path = "interval", method = { RequestMethod.GET })
  public TimetableResponse executeIntervalSearch(
      @RequestParam(name = "origin", required = true) int pOriginAsBasicType,
      @RequestParam(name = "destination", required = true) int pDestinationAsBasicType,
      @RequestParam(name = "vias", required = false) int[] pViasAsBasicType,
      @RequestParam(name = "start", required = true) String pStartAsBasicType,
      @RequestParam(name = "interval", required = false, defaultValue = "1440") int pInterval,
      @RequestHeader(name = "traceparent", required = false) String pTraceParent,
      @RequestHeader(name = "tracestate", required = false) String pTraceState,
      @RequestHeader(name = "Accept-Language", required = false) String pAcceptLanguage,
      @RequestHeader(name = "Date-Shift", required = false) String pDateShift,
      @RequestHeader(name = "Time-Shift", required = false) String pTimeShift ) {
    // Convert parameters into object as "BeanParams" are not supported by Spring Web. This way we do not pollute the
    // service interface but "only" our REST controller.
    var lRequestBuilder = IntervalSearchRequest.builder();
    // Handle bean parameter pRequest.origin
    lRequestBuilder.setOrigin(UICCode.builder().setCode(pOriginAsBasicType).build());
    // Handle bean parameter pRequest.destination
    lRequestBuilder.setDestination(UICCode.builder().setCode(pDestinationAsBasicType).build());
    // Handle bean parameter pRequest.vias
    if (pViasAsBasicType != null) {
      List<UICCode> lVias = new ArrayList<UICCode>();
      for (int lNext : pViasAsBasicType) {
        lVias.add(UICCode.builder().setCode(lNext).build());
      }
      lRequestBuilder.setVias(lVias);
    }
    // Handle bean parameter pRequest.start
    if (pStartAsBasicType != null) {
      lRequestBuilder.setStart(OffsetDateTime.parse(pStartAsBasicType));
    }
    lRequestBuilder.setInterval(pInterval);
    IntervalSearchRequest pRequest = lRequestBuilder.build();
    var lContextBuilder = DemoContext.builder();
    lContextBuilder.setTraceParent(pTraceParent);
    lContextBuilder.setTraceState(pTraceState);
    lContextBuilder.setAcceptLanguage(pAcceptLanguage);
    lContextBuilder.setDateShift(pDateShift);
    lContextBuilder.setTimeShift(pTimeShift);
    DemoContext pContext = lContextBuilder.build();
    // Validate request parameter(s).
    validationExecutor.validateRequest(TimetableService.class, pRequest, pContext);
    // Delegate request to service.
    TimetableResponse lResponse = timetableService.executeIntervalSearch(pRequest, pContext);
    // Validate response and return it.
    validationExecutor.validateResponse(TimetableService.class, lResponse);
    return lResponse;
  }
}