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
import tools.jackson.databind.annotation.JsonPOJOBuilder;

public abstract class AbstractTimetableRequest {
  /**
   * Constant for the name of attribute "origin".
   */
  public static final String ORIGIN = "origin";

  /**
   * Constant for the name of attribute "destination".
   */
  public static final String DESTINATION = "destination";

  /**
   * Constant for the name of attribute "vias".
   */
  public static final String VIAS = "vias";

  /**
   * Constant for the name of attribute "start".
   */
  public static final String START = "start";

  @Valid
  @NotNull
  private final UICCode origin;

  @Valid
  @NotNull
  private final UICCode destination;

  @Valid
  private final List<UICCode> vias;

  @NotNull
  private final OffsetDateTime start;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected AbstractTimetableRequest( AbstractTimetableRequestBuilder<?, ?> pBuilder ) {
    // Read attribute values from builder.
    origin = pBuilder.origin;
    destination = pBuilder.destination;
    vias = (pBuilder.vias == null) ? List.of() : List.copyOf(pBuilder.vias);
    start = pBuilder.start;
  }

  /**
   * Class implements builder to create a new instance of class <code>AbstractTimetableRequest</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static abstract class AbstractTimetableRequestBuilder<T extends AbstractTimetableRequest, B extends AbstractTimetableRequestBuilder<T, B>> {
    private UICCode origin;

    private UICCode destination;

    private List<UICCode> vias;

    private OffsetDateTime start;

    /**
     * Use {@link AbstractTimetableRequest#builder()} instead of private constructor to create new builder.
     */
    protected AbstractTimetableRequestBuilder( ) {
    }

    /**
     * Use {@link AbstractTimetableRequest#builder(AbstractTimetableRequest)} instead of private constructor to create
     * new builder.
     */
    protected AbstractTimetableRequestBuilder( AbstractTimetableRequest pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setOrigin(pObject.origin);
        this.setDestination(pObject.destination);
        this.setVias(pObject.vias);
        this.setStart(pObject.start);
      }
    }

    /**
     * Method sets association {@link #origin}.<br/>
     *
     * @param pOrigin Value to which {@link #origin} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setOrigin( UICCode pOrigin ) {
      origin = pOrigin;
      return this.self();
    }

    /**
     * Method sets association {@link #destination}.<br/>
     *
     * @param pDestination Value to which {@link #destination} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setDestination( UICCode pDestination ) {
      destination = pDestination;
      return this.self();
    }

    /**
     * Method sets association {@link #vias}.<br/>
     *
     * @param pVias Collection to which {@link #vias} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public B setVias( List<UICCode> pVias ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pVias != null) {
        vias = new ArrayList<UICCode>(pVias);
      }
      else {
        vias = null;
      }
      return this.self();
    }

    /**
     * Method adds the passed objects to association {@link #vias}.<br/>
     *
     * @param pVias Array of objects that should be added to {@link #vias}. The parameter may be null.
     * @return {@link B} Instance of this builder to support chaining. Method never returns null.
     */
    public B addToVias( UICCode... pVias ) {
      if (pVias != null) {
        if (vias == null) {
          vias = new ArrayList<UICCode>();
        }
        vias.addAll(Arrays.asList(pVias));
      }
      return this.self();
    }

    /**
     * Method sets attribute {@link #start}.<br/>
     *
     * @param pStart Value to which {@link #start} should be set.
     * @return {@link B} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public B setStart( OffsetDateTime pStart ) {
      // Assign value to attribute
      start = pStart;
      return this.self();
    }

    /**
     * Method returns instance of this builder. Operation is part of generic builder pattern.
     */
    protected abstract B self( );
  }

  /**
   * Method returns association {@link #origin}.<br/>
   *
   * @return {@link UICCode} Value to which {@link #origin} is set.
   */
  public UICCode getOrigin( ) {
    return origin;
  }

  /**
   * Method returns association {@link #destination}.<br/>
   *
   * @return {@link UICCode} Value to which {@link #destination} is set.
   */
  public UICCode getDestination( ) {
    return destination;
  }

  /**
   * Method returns association {@link #vias}.<br/>
   *
   * @return {@link List<UICCode>} Value to which {@link #vias} is set. The method never returns null and the returned
   * collection is unmodifiable.
   */
  public List<UICCode> getVias( ) {
    return vias;
  }

  /**
   * Method returns attribute {@link #start}.<br/>
   *
   * @return {@link OffsetDateTime} Value to which {@link #start} is set.
   */
  public OffsetDateTime getStart( ) {
    return start;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(origin);
    lResult = lPrime * lResult + Objects.hashCode(destination);
    lResult = lPrime * lResult + Objects.hashCode(vias);
    lResult = lPrime * lResult + Objects.hashCode(start);
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
      AbstractTimetableRequest lOther = (AbstractTimetableRequest) pObject;
      lEquals = Objects.equals(origin, lOther.origin) && Objects.equals(destination, lOther.destination)
          && Objects.equals(vias, lOther.vias) && Objects.equals(start, lOther.start);
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
    lBuilder.append("origin: ");
    if (origin != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(origin.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("destination: ");
    if (destination != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(destination.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("vias: ");
    if (vias != null) {
      lBuilder.append(vias.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (vias != null) {
      for (UICCode lNext : vias) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("start: ");
    lBuilder.append(start);
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
}