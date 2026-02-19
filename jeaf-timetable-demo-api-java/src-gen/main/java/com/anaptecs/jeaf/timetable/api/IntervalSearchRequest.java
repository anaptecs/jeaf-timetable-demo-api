/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

public class IntervalSearchRequest extends AbstractTimetableRequest {
  /**
   * Constant for the name of attribute "interval".
   */
  public static final String INTERVAL = "interval";

  /**
   * Interval search length in minutes. <br/>
   * <b>Default Value:</b> <code>1440</code>
   */
  private final int interval;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected IntervalSearchRequest( IntervalSearchRequestBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    interval = pBuilder.interval;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link IntervalSearchRequestBuilder} New builder that can be used to create new IntervalSearchRequest
   * objects.
   */
  public static IntervalSearchRequestBuilder<?, ?> builder( ) {
    return new IntervalSearchRequestBuilderImpl();
  }

  /**
   * Class implements builder to create a new instance of class <code>IntervalSearchRequest</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class IntervalSearchRequestBuilder<T extends IntervalSearchRequest, B extends IntervalSearchRequestBuilder<T, B>>
      extends AbstractTimetableRequestBuilder<T, B> {
    /**
     * Interval search length in minutes. <br/>
     * <b>Default Value:</b> <code>1440</code>
     */
    private int interval = 1440;

    /**
     * Use {@link IntervalSearchRequest#builder()} instead of private constructor to create new builder.
     */
    protected IntervalSearchRequestBuilder( ) {
      super();
    }

    /**
     * Use {@link IntervalSearchRequest#builder(IntervalSearchRequest)} instead of private constructor to create new
     * builder.
     */
    protected IntervalSearchRequestBuilder( IntervalSearchRequest pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setInterval(pObject.interval);
      }
    }

    /**
     * Method sets attribute {@link #interval}.<br/>
     *
     * @param pInterval Value to which {@link #interval} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setInterval( int pInterval ) {
      // Assign value to attribute
      interval = pInterval;
      return this.self();
    }

    /**
     * Method creates a new instance of class IntervalSearchRequest. The object will be initialized with the values of
     * the builder.
     *
     * @return IntervalSearchRequest Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class IntervalSearchRequestBuilderImpl
      extends IntervalSearchRequestBuilder<IntervalSearchRequest, IntervalSearchRequestBuilderImpl> {
    protected IntervalSearchRequestBuilderImpl( ) {
    }

    protected IntervalSearchRequestBuilderImpl( IntervalSearchRequest pObject ) {
      super(pObject);
    }

    @Override
    protected IntervalSearchRequestBuilderImpl self( ) {
      return this;
    }

    @Override
    public IntervalSearchRequest build( ) {
      return new IntervalSearchRequest(this);
    }
  }

  /**
   * Method returns attribute {@link #interval}.<br/>
   * Interval search length in minutes.
   *
   * @return int Value to which {@link #interval} is set.
   */
  public int getInterval( ) {
    return interval;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + interval;
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
    else if (!super.equals(pObject)) {
      lEquals = false;
    }
    else if (this.getClass() != pObject.getClass()) {
      lEquals = false;
    }
    else {
      IntervalSearchRequest lOther = (IntervalSearchRequest) pObject;
      lEquals = interval == lOther.interval;
    }
    return lEquals;
  }

  /**
   * Method returns a StringBuilder that can be used to create a String representation of this object. The returned
   * StringBuilder also takes care about attributes of super classes.
   *
   * @return {@link StringBuilder} StringBuilder representing this object. The method never returns null.
   */
  @Override
  public StringBuilder toStringBuilder( String pIndent ) {
    StringBuilder lBuilder = super.toStringBuilder(pIndent);
    lBuilder.append(pIndent);
    lBuilder.append("interval: ");
    lBuilder.append(interval);
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
   * @return {@link IntervalSearchRequestBuilder} New builder that can be used to create new IntervalSearchRequest
   * objects. The method never returns null.
   */
  public IntervalSearchRequestBuilder<?, ?> toBuilder( ) {
    return new IntervalSearchRequestBuilderImpl(this);
  }
}