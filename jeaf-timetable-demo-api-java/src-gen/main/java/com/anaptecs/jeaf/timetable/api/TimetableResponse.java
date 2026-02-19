/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = TimetableResponse.Builder.class)
public class TimetableResponse {
  /**
   * Constant for the name of attribute "messages".
   */
  public static final String MESSAGES = "messages";

  /**
   * Constant for the name of attribute "trips".
   */
  public static final String TRIPS = "trips";

  @Valid
  private final List<Message> messages;

  @Valid
  private final List<Trip> trips;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected TimetableResponse( Builder pBuilder ) {
    // Read attribute values from builder.
    messages = (pBuilder.messages == null) ? List.of() : List.copyOf(pBuilder.messages);
    trips = (pBuilder.trips == null) ? List.of() : List.copyOf(pBuilder.trips);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new TimetableResponse objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>TimetableResponse</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private List<Message> messages;

    private List<Trip> trips;

    /**
     * Use {@link TimetableResponse#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link TimetableResponse#builder(TimetableResponse)} instead of private constructor to create new builder.
     */
    protected Builder( TimetableResponse pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setMessages(pObject.messages);
        this.setTrips(pObject.trips);
      }
    }

    /**
     * Method sets association {@link #messages}.<br/>
     *
     * @param pMessages Collection to which {@link #messages} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public Builder setMessages( List<Message> pMessages ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pMessages != null) {
        messages = new ArrayList<Message>(pMessages);
      }
      else {
        messages = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #messages}.<br/>
     *
     * @param pMessages Array of objects that should be added to {@link #messages}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToMessages( Message... pMessages ) {
      if (pMessages != null) {
        if (messages == null) {
          messages = new ArrayList<Message>();
        }
        messages.addAll(Arrays.asList(pMessages));
      }
      return this;
    }

    /**
     * Method sets association {@link #trips}.<br/>
     *
     * @param pTrips Collection to which {@link #trips} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public Builder setTrips( List<Trip> pTrips ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pTrips != null) {
        trips = new ArrayList<Trip>(pTrips);
      }
      else {
        trips = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #trips}.<br/>
     *
     * @param pTrips Array of objects that should be added to {@link #trips}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToTrips( Trip... pTrips ) {
      if (pTrips != null) {
        if (trips == null) {
          trips = new ArrayList<Trip>();
        }
        trips.addAll(Arrays.asList(pTrips));
      }
      return this;
    }

    /**
     * Method creates a new instance of class TimetableResponse. The object will be initialized with the values of the
     * builder.
     *
     * @return TimetableResponse Created object. The method never returns null.
     */
    public TimetableResponse build( ) {
      return new TimetableResponse(this);
    }
  }

  /**
   * Method returns association {@link #messages}.<br/>
   *
   * @return {@link List<Message>} Value to which {@link #messages} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<Message> getMessages( ) {
    return messages;
  }

  /**
   * Method returns association {@link #trips}.<br/>
   *
   * @return {@link List<Trip>} Value to which {@link #trips} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  public List<Trip> getTrips( ) {
    return trips;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(messages);
    lResult = lPrime * lResult + Objects.hashCode(trips);
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
      TimetableResponse lOther = (TimetableResponse) pObject;
      lEquals = Objects.equals(messages, lOther.messages) && Objects.equals(trips, lOther.trips);
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
    lBuilder.append("messages: ");
    if (messages != null) {
      lBuilder.append(messages.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (messages != null) {
      for (Message lNext : messages) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("trips: ");
    if (trips != null) {
      lBuilder.append(trips.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (trips != null) {
      for (Trip lNext : trips) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
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
   * @return {@link Builder} New builder that can be used to create new TimetableResponse objects. The method never
   * returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}