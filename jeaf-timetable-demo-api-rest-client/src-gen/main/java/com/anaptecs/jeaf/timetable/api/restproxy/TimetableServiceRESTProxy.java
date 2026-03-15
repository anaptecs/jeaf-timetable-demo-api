/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api.restproxy;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.anaptecs.jeaf.rest.executor.api.ContentType;
import com.anaptecs.jeaf.rest.executor.api.HttpMethod;
import com.anaptecs.jeaf.rest.executor.api.ObjectType;
import com.anaptecs.jeaf.rest.executor.api.RESTRequest;
import com.anaptecs.jeaf.rest.executor.api.RESTRequestExecutor;
import com.anaptecs.jeaf.timetable.api.DemoContext;
import com.anaptecs.jeaf.timetable.api.IntervalSearchRequest;
import com.anaptecs.jeaf.timetable.api.TimetableResponse;
import com.anaptecs.jeaf.timetable.api.TimetableService;
import com.anaptecs.jeaf.timetable.api.TripSearchRequest;
import com.anaptecs.jeaf.timetable.api.UICCode;
import com.anaptecs.jeaf.validation.api.ValidationExecutor;

/**
 * Class implements a proxy for REST Service {@link TimetableService}. The proxy is implemented as Spring services. This
 * way to developers it looks like a plain Spring Service.
 *
 * This implementation deals with everything that is required to call the external REST service including the following
 * things:
 * <ul>
 * <li>Serialization / deserialization between Java and JSON</li>
 * <li>Proper connection pooling and timeouts for HTTP requests</li>
 * <li>Proper setting of HTTP header</li>
 * <li>Circuit breaker in case of availabilities problems of the REST service</li>
 * </ul>
 *
 * However, as an transactional context can not be propagated to another REST resource developers still have to take
 * care about proper transaction handling if needed.
 */
@Service
public class TimetableServiceRESTProxy implements TimetableService {
  /**
   * REST request executor is used to send REST request to the proxied REST resource. Depending on the Spring
   * configuration the matching implementation will be injected here.
   */
  private final RESTRequestExecutor requestExecutor;

  /**
   * REST Service Proxy was generated with request / response validation enabled. The actual validation will be
   * delegated to the implementation of this interface.
   */
  private final ValidationExecutor validationExecutor;

  /**
   * Initialize object.
   *
   * @param pRequestExecutor Dependency on concrete {@link RESTRequestExecutor} implementation that should be used.
   * @param pValidationExecutor Validation executor for request / response validation.
   */
  public TimetableServiceRESTProxy( RESTRequestExecutor pRequestExecutor, ValidationExecutor pValidationExecutor ) {
    requestExecutor = pRequestExecutor;
    validationExecutor = pValidationExecutor;
  }

  /**
   * @param request
   * @param pContext
   * @return {@link TimetableResponse}
   */
  @Override
  public TimetableResponse executeTripSearch( TripSearchRequest request, DemoContext pContext ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(TimetableService.class, request, pContext);
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(TimetableService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/timetable");
    lPathBuilder.append('/');
    lPathBuilder.append("trips");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (request != null) {
      if (request.getOrigin() != null) {
        lRequestBuilder.setQueryParameter("origin", request.getOrigin().getCode());
      }
      if (request.getDestination() != null) {
        lRequestBuilder.setQueryParameter("destination", request.getDestination().getCode());
      }
      if (request.getVias() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (UICCode lNext : request.getVias()) {
          lValues.add(String.valueOf(lNext.getCode()));
        }
        lRequestBuilder.setQueryParameter("vias", lValues);
      }
      if (request.getStart() != null) {
        lRequestBuilder.setQueryParameter("start", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(request.getStart()));
      }
      lRequestBuilder.setQueryParameter("maxConnections", String.valueOf(request.getMaxConnections()));
    }
    // Set HTTP header(s)
    if (pContext != null) {
      if (pContext.getTraceParent() != null) {
        lRequestBuilder.setHeader("traceparent", pContext.getTraceParent());
      }
      if (pContext.getTraceState() != null) {
        lRequestBuilder.setHeader("tracestate", pContext.getTraceState());
      }
      if (pContext.getAcceptLanguage() != null) {
        lRequestBuilder.setHeader("Accept-Language", pContext.getAcceptLanguage());
      }
      if (pContext.getDateShift() != null) {
        lRequestBuilder.setHeader("Date-Shift", pContext.getDateShift());
      }
      if (pContext.getTimeShift() != null) {
        lRequestBuilder.setHeader("Time-Shift", pContext.getTimeShift());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(TimetableResponse.class);
    TimetableResponse lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(TimetableService.class, lResult);
    return lResult;
  }

  /**
   * @param pRequest
   * @param pContext
   * @return {@link TimetableResponse}
   */
  @Override
  public TimetableResponse executeIntervalSearch( IntervalSearchRequest pRequest, DemoContext pContext ) {
    // Validate request parameter(s).
    validationExecutor.validateRequest(TimetableService.class, pRequest, pContext);
    // Create builder for GET request
    RESTRequest.Builder lRequestBuilder = RESTRequest.builder(TimetableService.class, HttpMethod.GET, ContentType.JSON);
    // Build path of request
    StringBuilder lPathBuilder = new StringBuilder();
    lPathBuilder.append("/timetable");
    lPathBuilder.append('/');
    lPathBuilder.append("interval");
    lRequestBuilder.setPath(lPathBuilder.toString());
    // Add query parameter(s) to request
    if (pRequest != null) {
      if (pRequest.getOrigin() != null) {
        lRequestBuilder.setQueryParameter("origin", pRequest.getOrigin().getCode());
      }
      if (pRequest.getDestination() != null) {
        lRequestBuilder.setQueryParameter("destination", pRequest.getDestination().getCode());
      }
      if (pRequest.getVias() != null) {
        List<Object> lValues = new ArrayList<Object>();
        for (UICCode lNext : pRequest.getVias()) {
          lValues.add(String.valueOf(lNext.getCode()));
        }
        lRequestBuilder.setQueryParameter("vias", lValues);
      }
      if (pRequest.getStart() != null) {
        lRequestBuilder.setQueryParameter("start", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(pRequest.getStart()));
      }
      lRequestBuilder.setQueryParameter("interval", String.valueOf(pRequest.getInterval()));
    }
    // Set HTTP header(s)
    if (pContext != null) {
      if (pContext.getTraceParent() != null) {
        lRequestBuilder.setHeader("traceparent", pContext.getTraceParent());
      }
      if (pContext.getTraceState() != null) {
        lRequestBuilder.setHeader("tracestate", pContext.getTraceState());
      }
      if (pContext.getAcceptLanguage() != null) {
        lRequestBuilder.setHeader("Accept-Language", pContext.getAcceptLanguage());
      }
      if (pContext.getDateShift() != null) {
        lRequestBuilder.setHeader("Date-Shift", pContext.getDateShift());
      }
      if (pContext.getTimeShift() != null) {
        lRequestBuilder.setHeader("Time-Shift", pContext.getTimeShift());
      }
    }
    // Execute request and return result.
    RESTRequest lRequest = lRequestBuilder.build();
    ObjectType lObjectType = ObjectType.createObjectType(TimetableResponse.class);
    TimetableResponse lResult = requestExecutor.executeSingleObjectResultRequest(lRequest, 200, lObjectType);
    // Validate response and return it.
    validationExecutor.validateResponse(TimetableService.class, lResult);
    return lResult;
  }
}