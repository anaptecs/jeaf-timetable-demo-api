/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * Class represents a generic context for requests. It contains context information that are present for any kind of
 * request..<br/>
 * <br/>
 * The class may be extended to add additional information for specific services.
 *
 * @author JEAF Generator
 * @version 1.0
 */
public class DemoContext {
  /**
   * Constant for the name of attribute "traceParent".
   */
  public static final String TRACEPARENT = "traceParent";

  /**
   * Constant for the name of attribute "traceState".
   */
  public static final String TRACESTATE = "traceState";

  /**
   * Constant for the name of attribute "acceptLanguage".
   */
  public static final String ACCEPTLANGUAGE = "acceptLanguage";

  /**
   * Constant for the name of attribute "dateShift".
   */
  public static final String DATESHIFT = "dateShift";

  /**
   * Constant for the name of attribute "timeShift".
   */
  public static final String TIMESHIFT = "timeShift";

  /**
   * The traceparent header describes the position of the incoming request in its trace graph in a portable,
   * fixed-length format. Its design focuses on fast parsing. Every tracing tool MUST properly set traceparent even when
   * it only relies on vendor-specific information in tracestate (see W3C Trace Context,
   * https://www.w3.org/TR/trace-context).
   * <p/>
   * <b>Header-Param:</b> <code>traceparent</code>
   */
  private final String traceParent;

  /**
   * The tracestate extends traceparent with vendor-specific data represented by a set of name/value pairs. Storing
   * information in tracestate is optional (see W3C Trace Context).
   * <p/>
   * <b>Header-Param:</b> <code>tracestate</code>
   */
  private final String traceState;

  /**
   * Preferred language of the requesting client. Attribute can be filled according to logic of HTTP Header field as
   * defined on Accept-Language.
   * <p/>
   * <b>Header-Param:</b> <code>Accept-Language</code>
   */
  private final String acceptLanguage;

  /**
   * Header field can be used to modify the date part of the request time stamp. It can either be defined as an absolute
   * date in format &quot;YYYY-MM-DD&quot; or as an relative shift using '+' / '-' in combination with a shift value as
   * absolute number for the amount of days that should be shifted (e.g. &quot;-7&quot; or &quot;+2&quot; days).<br/>
   * <br/>
   * Date shift is only supported on non productive environments.
   * <p/>
   * <b>Header-Param:</b> <code>Date-Shift</code>
   */
  private final String dateShift;

  /**
   * Header field can be used to modify the time part of the request time stamp. It can either be defined as an absolute
   * time in format HH:mm:ss or as an relative shift using '+' / '-' in combination with a shift value as absolute
   * number for the amount of minutes that should be shifted (e.g. &quot;-31&quot; or &quot;+120&quot; minutes).<br/>
   * <br/>
   * Time shift is only supported on non productive environments.
   * <p/>
   * <b>Header-Param:</b> <code>Time-Shift</code>
   */
  private final String timeShift;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected DemoContext( Builder pBuilder ) {
    // Read attribute values from builder.
    traceParent = pBuilder.traceParent;
    traceState = pBuilder.traceState;
    acceptLanguage = pBuilder.acceptLanguage;
    dateShift = pBuilder.dateShift;
    timeShift = pBuilder.timeShift;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new DemoContext objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>DemoContext</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    /**
     * The traceparent header describes the position of the incoming request in its trace graph in a portable,
     * fixed-length format. Its design focuses on fast parsing. Every tracing tool MUST properly set traceparent even
     * when it only relies on vendor-specific information in tracestate (see W3C Trace Context,
     * https://www.w3.org/TR/trace-context).
     * <p/>
     * <b>Header-Param:</b> <code>traceparent</code>
     */
    private String traceParent;

    /**
     * The tracestate extends traceparent with vendor-specific data represented by a set of name/value pairs. Storing
     * information in tracestate is optional (see W3C Trace Context).
     * <p/>
     * <b>Header-Param:</b> <code>tracestate</code>
     */
    private String traceState;

    /**
     * Preferred language of the requesting client. Attribute can be filled according to logic of HTTP Header field as
     * defined on Accept-Language.
     * <p/>
     * <b>Header-Param:</b> <code>Accept-Language</code>
     */
    private String acceptLanguage;

    /**
     * Header field can be used to modify the date part of the request time stamp. It can either be defined as an
     * absolute date in format &quot;YYYY-MM-DD&quot; or as an relative shift using '+' / '-' in combination with a
     * shift value as absolute number for the amount of days that should be shifted (e.g. &quot;-7&quot; or
     * &quot;+2&quot; days).<br/>
     * <br/>
     * Date shift is only supported on non productive environments.
     * <p/>
     * <b>Header-Param:</b> <code>Date-Shift</code>
     */
    private String dateShift;

    /**
     * Header field can be used to modify the time part of the request time stamp. It can either be defined as an
     * absolute time in format HH:mm:ss or as an relative shift using '+' / '-' in combination with a shift value as
     * absolute number for the amount of minutes that should be shifted (e.g. &quot;-31&quot; or &quot;+120&quot;
     * minutes).<br/>
     * <br/>
     * Time shift is only supported on non productive environments.
     * <p/>
     * <b>Header-Param:</b> <code>Time-Shift</code>
     */
    private String timeShift;

    /**
     * Use {@link DemoContext#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link DemoContext#builder(DemoContext)} instead of private constructor to create new builder.
     */
    protected Builder( DemoContext pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setTraceParent(pObject.traceParent);
        this.setTraceState(pObject.traceState);
        this.setAcceptLanguage(pObject.acceptLanguage);
        this.setDateShift(pObject.dateShift);
        this.setTimeShift(pObject.timeShift);
      }
    }

    /**
     * Method sets attribute {@link #traceParent}.<br/>
     *
     * @param pTraceParent Value to which {@link #traceParent} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setTraceParent( String pTraceParent ) {
      // Assign value to attribute
      traceParent = pTraceParent;
      return this;
    }

    /**
     * Method sets attribute {@link #traceState}.<br/>
     *
     * @param pTraceState Value to which {@link #traceState} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setTraceState( String pTraceState ) {
      // Assign value to attribute
      traceState = pTraceState;
      return this;
    }

    /**
     * Method sets attribute {@link #acceptLanguage}.<br/>
     *
     * @param pAcceptLanguage Value to which {@link #acceptLanguage} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setAcceptLanguage( String pAcceptLanguage ) {
      // Assign value to attribute
      acceptLanguage = pAcceptLanguage;
      return this;
    }

    /**
     * Method sets attribute {@link #dateShift}.<br/>
     *
     * @param pDateShift Value to which {@link #dateShift} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setDateShift( String pDateShift ) {
      // Assign value to attribute
      dateShift = pDateShift;
      return this;
    }

    /**
     * Method sets attribute {@link #timeShift}.<br/>
     *
     * @param pTimeShift Value to which {@link #timeShift} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setTimeShift( String pTimeShift ) {
      // Assign value to attribute
      timeShift = pTimeShift;
      return this;
    }

    /**
     * Method creates a new instance of class DemoContext. The object will be initialized with the values of the
     * builder.
     *
     * @return DemoContext Created object. The method never returns null.
     */
    public DemoContext build( ) {
      return new DemoContext(this);
    }
  }

  /**
   * Method returns attribute {@link #traceParent}.<br/>
   * The traceparent header describes the position of the incoming request in its trace graph in a portable,
   * fixed-length format. Its design focuses on fast parsing. Every tracing tool MUST properly set traceparent even when
   * it only relies on vendor-specific information in tracestate (see W3C Trace Context,
   * https://www.w3.org/TR/trace-context).
   *
   * @return {@link String} Value to which {@link #traceParent} is set.
   */
  public String getTraceParent( ) {
    return traceParent;
  }

  /**
   * Method returns attribute {@link #traceState}.<br/>
   * The tracestate extends traceparent with vendor-specific data represented by a set of name/value pairs. Storing
   * information in tracestate is optional (see W3C Trace Context).
   *
   * @return {@link String} Value to which {@link #traceState} is set.
   */
  public String getTraceState( ) {
    return traceState;
  }

  /**
   * Method returns attribute {@link #acceptLanguage}.<br/>
   * Preferred language of the requesting client. Attribute can be filled according to logic of HTTP Header field as
   * defined on Accept-Language.
   *
   * @return {@link String} Value to which {@link #acceptLanguage} is set.
   */
  public String getAcceptLanguage( ) {
    return acceptLanguage;
  }

  /**
   * Method returns attribute {@link #dateShift}.<br/>
   * Header field can be used to modify the date part of the request time stamp. It can either be defined as an absolute
   * date in format &quot;YYYY-MM-DD&quot; or as an relative shift using '+' / '-' in combination with a shift value as
   * absolute number for the amount of days that should be shifted (e.g. &quot;-7&quot; or &quot;+2&quot; days).<br/>
   * <br/>
   * Date shift is only supported on non productive environments.
   *
   * @return {@link String} Value to which {@link #dateShift} is set.
   */
  public String getDateShift( ) {
    return dateShift;
  }

  /**
   * Method returns attribute {@link #timeShift}.<br/>
   * Header field can be used to modify the time part of the request time stamp. It can either be defined as an absolute
   * time in format HH:mm:ss or as an relative shift using '+' / '-' in combination with a shift value as absolute
   * number for the amount of minutes that should be shifted (e.g. &quot;-31&quot; or &quot;+120&quot; minutes).<br/>
   * <br/>
   * Time shift is only supported on non productive environments.
   *
   * @return {@link String} Value to which {@link #timeShift} is set.
   */
  public String getTimeShift( ) {
    return timeShift;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(traceParent);
    lResult = lPrime * lResult + Objects.hashCode(traceState);
    lResult = lPrime * lResult + Objects.hashCode(acceptLanguage);
    lResult = lPrime * lResult + Objects.hashCode(dateShift);
    lResult = lPrime * lResult + Objects.hashCode(timeShift);
    return lResult;
  }

  @Override
  public boolean equals( Object pObject ) {
    boolean lEquals;
    if (this == pObject) {
      lEquals = true;
    }
    else if (pObject == null) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      DemoContext lOther = (DemoContext) pObject;
      lEquals = Objects.equals(traceParent, lOther.traceParent) && Objects.equals(traceState, lOther.traceState)
          && Objects.equals(acceptLanguage, lOther.acceptLanguage) && Objects.equals(dateShift, lOther.dateShift)
          && Objects.equals(timeShift, lOther.timeShift);
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = new StringBuilder();
    lBuilder.append(pIndent);
    lBuilder.append(this.getClass().getName());
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("traceParent: ");
    lBuilder.append(traceParent);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("traceState: ");
    lBuilder.append(traceState);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("acceptLanguage: ");
    lBuilder.append(acceptLanguage);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("dateShift: ");
    lBuilder.append(dateShift);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("timeShift: ");
    lBuilder.append(timeShift);
    lBuilder.append(System.lineSeparator());
    return lBuilder;
  }

  /**
   * Method creates a new String with the values of all attributes of this class. All references to other objects will
   * be ignored.
   *
   * @return {@link String} String representation of this object. The method never returns null.
   */
  @Override
  public String toString( ) {
    return this.toStringBuilder("").toString();
  }

  /**
   * Method creates a new builder and initializes it with the data of this object.
   *
   * @return {@link Builder} New builder that can be used to create new DemoContext objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}