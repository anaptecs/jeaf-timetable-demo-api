/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Leg.Builder.class)
public class Leg {
  /**
   * Constant for the name of attribute "departure".
   */
  public static final String DEPARTURE = "departure";

  /**
   * Constant for the name of attribute "arrival".
   */
  public static final String ARRIVAL = "arrival";

  /**
   * Constant for the name of attribute "segments".
   */
  public static final String SEGMENTS = "segments";

  @NotNull
  private final OffsetDateTime departure;

  @NotNull
  private final OffsetDateTime arrival;

  @Valid
  @Size(min = 1)
  @NotNull
  private final List<LegSegment> segments;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Leg( Builder pBuilder ) {
    // Read attribute values from builder.
    departure = pBuilder.departure;
    arrival = pBuilder.arrival;
    segments = (pBuilder.segments == null) ? List.of() : List.copyOf(pBuilder.segments);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Leg objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>Leg</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private OffsetDateTime departure;

    private OffsetDateTime arrival;

    private List<LegSegment> segments;

    /**
     * Use {@link Leg#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Leg#builder(Leg)} instead of private constructor to create new builder.
     */
    protected Builder( Leg pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setDeparture(pObject.departure);
        this.setArrival(pObject.arrival);
        this.setSegments(pObject.segments);
      }
    }

    /**
     * Method sets attribute {@link #departure}.<br/>
     *
     * @param pDeparture Value to which {@link #departure} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setDeparture( OffsetDateTime pDeparture ) {
      // Assign value to attribute
      departure = pDeparture;
      return this;
    }

    /**
     * Method sets attribute {@link #arrival}.<br/>
     *
     * @param pArrival Value to which {@link #arrival} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setArrival( OffsetDateTime pArrival ) {
      // Assign value to attribute
      arrival = pArrival;
      return this;
    }

    /**
     * Method sets association {@link #segments}.<br/>
     *
     * @param pSegments Collection to which {@link #segments} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public Builder setSegments( List<LegSegment> pSegments ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pSegments != null) {
        segments = new ArrayList<LegSegment>(pSegments);
      }
      else {
        segments = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #segments}.<br/>
     *
     * @param pSegments Array of objects that should be added to {@link #segments}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToSegments( LegSegment... pSegments ) {
      if (pSegments != null) {
        if (segments == null) {
          segments = new ArrayList<LegSegment>();
        }
        segments.addAll(Arrays.asList(pSegments));
      }
      return this;
    }

    /**
     * Method creates a new instance of class Leg. The object will be initialized with the values of the builder.
     *
     * @return Leg Created object. The method never returns null.
     */
    public Leg build( ) {
      return new Leg(this);
    }
  }

  /**
   * Method returns attribute {@link #departure}.<br/>
   *
   * @return {@link OffsetDateTime} Value to which {@link #departure} is set.
   */
  public OffsetDateTime getDeparture( ) {
    return departure;
  }

  /**
   * Method returns attribute {@link #arrival}.<br/>
   *
   * @return {@link OffsetDateTime} Value to which {@link #arrival} is set.
   */
  public OffsetDateTime getArrival( ) {
    return arrival;
  }

  /**
   * Method returns association {@link #segments}.<br/>
   *
   * @return {@link List<LegSegment>} Value to which {@link #segments} is set. The method never returns null and the
   * returned collection is unmodifiable.
   */
  public List<LegSegment> getSegments( ) {
    return segments;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(departure);
    lResult = lPrime * lResult + Objects.hashCode(arrival);
    lResult = lPrime * lResult + Objects.hashCode(segments);
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
      Leg lOther = (Leg) pObject;
      lEquals = Objects.equals(departure, lOther.departure) && Objects.equals(arrival, lOther.arrival)
          && Objects.equals(segments, lOther.segments);
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
    lBuilder.append("departure: ");
    lBuilder.append(departure);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("arrival: ");
    lBuilder.append(arrival);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("segments: ");
    if (segments != null) {
      lBuilder.append(segments.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (segments != null) {
      for (LegSegment lNext : segments) {
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
   * @return {@link Builder} New builder that can be used to create new Leg objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}