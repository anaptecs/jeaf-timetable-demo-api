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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Trip.Builder.class)
public class Trip {
  /**
   * Constant for the name of attribute "legs".
   */
  public static final String LEGS = "legs";

  @Valid
  @Size(min = 1)
  @NotNull
  private final List<Leg> legs;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Trip( Builder pBuilder ) {
    // Read attribute values from builder.
    legs = (pBuilder.legs == null) ? List.of() : List.copyOf(pBuilder.legs);
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Trip objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>Trip</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private List<Leg> legs;

    /**
     * Use {@link Trip#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Trip#builder(Trip)} instead of private constructor to create new builder.
     */
    protected Builder( Trip pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setLegs(pObject.legs);
      }
    }

    /**
     * Method sets association {@link #legs}.<br/>
     *
     * @param pLegs Collection to which {@link #legs} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public Builder setLegs( List<Leg> pLegs ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pLegs != null) {
        legs = new ArrayList<Leg>(pLegs);
      }
      else {
        legs = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #legs}.<br/>
     *
     * @param pLegs Array of objects that should be added to {@link #legs}. The parameter may be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToLegs( Leg... pLegs ) {
      if (pLegs != null) {
        if (legs == null) {
          legs = new ArrayList<Leg>();
        }
        legs.addAll(Arrays.asList(pLegs));
      }
      return this;
    }

    /**
     * Method creates a new instance of class Trip. The object will be initialized with the values of the builder.
     *
     * @return Trip Created object. The method never returns null.
     */
    public Trip build( ) {
      return new Trip(this);
    }
  }

  /**
   * Method returns association {@link #legs}.<br/>
   *
   * @return {@link List<Leg>} Value to which {@link #legs} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  public List<Leg> getLegs( ) {
    return legs;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(legs);
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
      Trip lOther = (Trip) pObject;
      lEquals = Objects.equals(legs, lOther.legs);
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
    lBuilder.append("legs: ");
    if (legs != null) {
      lBuilder.append(legs.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (legs != null) {
      for (Leg lNext : legs) {
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
   * @return {@link Builder} New builder that can be used to create new Trip objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}