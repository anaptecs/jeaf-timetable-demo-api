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

public class TripSearchRequest extends AbstractTimetableRequest {
  /**
   * Constant for the name of attribute "maxConnections".
   */
  public static final String MAXCONNECTIONS = "maxConnections";

  /**
   * <br/>
   * <b>Default Value:</b> <code>5</code>
   */
  private final int maxConnections;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TripSearchRequest( TripSearchRequestBuilder<?, ?> pBuilder ) {
    // Call constructor of super class.
    super(pBuilder);
    // Read attribute values from builder.
    maxConnections = pBuilder.maxConnections;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link TripSearchRequestBuilder} New builder that can be used to create new TripSearchRequest objects.
   */
  public static TripSearchRequestBuilder<?, ?> builder( ) {
    return new TripSearchRequestBuilderImpl();
  }

  /**
   * Class implements builder to create a new instance of class <code>TripSearchRequest</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class TripSearchRequestBuilder<T extends TripSearchRequest, B extends TripSearchRequestBuilder<T, B>>
      extends AbstractTimetableRequestBuilder<T, B> {
    /**
     * <br/>
     * <b>Default Value:</b> <code>5</code>
     */
    private int maxConnections = 5;

    /**
     * Use {@link TripSearchRequest#builder()} instead of private constructor to create new builder.
     */
    protected TripSearchRequestBuilder( ) {
      super();
    }

    /**
     * Use {@link TripSearchRequest#builder(TripSearchRequest)} instead of private constructor to create new builder.
     */
    protected TripSearchRequestBuilder( TripSearchRequest pObject ) {
      super(pObject);
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMaxConnections(pObject.maxConnections);
      }
    }

    /**
     * Method sets attribute {@link #maxConnections}.<br/>
     *
     * @param pMaxConnections Value to which {@link #maxConnections} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setMaxConnections( int pMaxConnections ) {
      // Assign value to attribute
      maxConnections = pMaxConnections;
      return this.self();
    }

    /**
     * Method creates a new instance of class TripSearchRequest. The object will be initialized with the values of the
     * builder.
     *
     * @return TripSearchRequest Created object. The method never returns null.
     */
    public abstract T build( );
  }

  static final class TripSearchRequestBuilderImpl
      extends TripSearchRequestBuilder<TripSearchRequest, TripSearchRequestBuilderImpl> {
    protected TripSearchRequestBuilderImpl( ) {
    }

    protected TripSearchRequestBuilderImpl( TripSearchRequest pObject ) {
      super(pObject);
    }

    @Override
    protected TripSearchRequestBuilderImpl self( ) {
      return this;
    }

    @Override
    public TripSearchRequest build( ) {
      return new TripSearchRequest(this);
    }
  }

  /**
   * Method returns attribute {@link #maxConnections}.<br/>
   *
   * @return int Value to which {@link #maxConnections} is set.
   */
  public int getMaxConnections( ) {
    return maxConnections;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = super.hashCode();
    lResult = lPrime * lResult + maxConnections;
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
      TripSearchRequest lOther = (TripSearchRequest) pObject;
      lEquals = maxConnections == lOther.maxConnections;
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
    lBuilder.append("maxConnections: ");
    lBuilder.append(maxConnections);
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
   * @return {@link TripSearchRequestBuilder} New builder that can be used to create new TripSearchRequest objects. The
   * method never returns null.
   */
  public TripSearchRequestBuilder<?, ?> toBuilder( ) {
    return new TripSearchRequestBuilderImpl(this);
  }
}