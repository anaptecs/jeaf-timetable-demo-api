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
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = LegSegment.Builder.class)
public class LegSegment {
  /**
   * Constant for the name of attribute "from".
   */
  public static final String FROM = "from";

  /**
   * Constant for the name of attribute "to".
   */
  public static final String TO = "to";

  /**
   * Constant for the name of attribute "intermediateStops".
   */
  public static final String INTERMEDIATESTOPS = "intermediateStops";

  /**
   * Constant for the name of attribute "carrier".
   */
  public static final String CARRIER = "carrier";

  /**
   * Constant for the name of attribute "vehicleNumber".
   */
  public static final String VEHICLENUMBER = "vehicleNumber";

  /**
   * Constant for the name of attribute "transportMeans".
   */
  public static final String TRANSPORTMEANS = "transportMeans";

  /**
   * Constant for the name of attribute "vehicleType".
   */
  public static final String VEHICLETYPE = "vehicleType";

  @Valid
  @NotNull
  private final UICCode from;

  @Valid
  @NotNull
  private final UICCode to;

  @Valid
  private final List<UICCode> intermediateStops;

  @Valid
  @NotNull
  private final CarrierCode carrier;

  private final int vehicleNumber;

  @NotNull
  private final TransportMeans transportMeans;

  @NotNull
  private final VehicleType vehicleType;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected LegSegment( Builder pBuilder ) {
    // Read attribute values from builder.
    from = pBuilder.from;
    to = pBuilder.to;
    intermediateStops = (pBuilder.intermediateStops == null) ? List.of() : List.copyOf(pBuilder.intermediateStops);
    carrier = pBuilder.carrier;
    vehicleNumber = pBuilder.vehicleNumber;
    transportMeans = pBuilder.transportMeans;
    vehicleType = pBuilder.vehicleType;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new LegSegment objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>LegSegment</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private UICCode from;

    private UICCode to;

    private List<UICCode> intermediateStops;

    private CarrierCode carrier;

    private int vehicleNumber;

    private TransportMeans transportMeans;

    private VehicleType vehicleType;

    /**
     * Use {@link LegSegment#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link LegSegment#builder(LegSegment)} instead of private constructor to create new builder.
     */
    protected Builder( LegSegment pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setFrom(pObject.from);
        this.setTo(pObject.to);
        this.setIntermediateStops(pObject.intermediateStops);
        this.setCarrier(pObject.carrier);
        this.setVehicleNumber(pObject.vehicleNumber);
        this.setTransportMeans(pObject.transportMeans);
        this.setVehicleType(pObject.vehicleType);
      }
    }

    /**
     * Method sets association {@link #from}.<br/>
     *
     * @param pFrom Value to which {@link #from} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setFrom( UICCode pFrom ) {
      from = pFrom;
      return this;
    }

    /**
     * Method sets association {@link #to}.<br/>
     *
     * @param pTo Value to which {@link #to} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setTo( UICCode pTo ) {
      to = pTo;
      return this;
    }

    /**
     * Method sets association {@link #intermediateStops}.<br/>
     *
     * @param pIntermediateStops Collection to which {@link #intermediateStops} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP, contentNulls = Nulls.SKIP)
    public Builder setIntermediateStops( List<UICCode> pIntermediateStops ) {
      // To ensure immutability we have to copy the content of the passed collection.
      if (pIntermediateStops != null) {
        intermediateStops = new ArrayList<UICCode>(pIntermediateStops);
      }
      else {
        intermediateStops = null;
      }
      return this;
    }

    /**
     * Method adds the passed objects to association {@link #intermediateStops}.<br/>
     *
     * @param pIntermediateStops Array of objects that should be added to {@link #intermediateStops}. The parameter may
     * be null.
     * @return {@link Builder} Instance of this builder to support chaining. Method never returns null.
     */
    public Builder addToIntermediateStops( UICCode... pIntermediateStops ) {
      if (pIntermediateStops != null) {
        if (intermediateStops == null) {
          intermediateStops = new ArrayList<UICCode>();
        }
        intermediateStops.addAll(Arrays.asList(pIntermediateStops));
      }
      return this;
    }

    /**
     * Method sets association {@link #carrier}.<br/>
     *
     * @param pCarrier Value to which {@link #carrier} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setCarrier( CarrierCode pCarrier ) {
      carrier = pCarrier;
      return this;
    }

    /**
     * Method sets attribute {@link #vehicleNumber}.<br/>
     *
     * @param pVehicleNumber Value to which {@link #vehicleNumber} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setVehicleNumber( int pVehicleNumber ) {
      // Assign value to attribute
      vehicleNumber = pVehicleNumber;
      return this;
    }

    /**
     * Method sets association {@link #transportMeans}.<br/>
     *
     * @param pTransportMeans Value to which {@link #transportMeans} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setTransportMeans( TransportMeans pTransportMeans ) {
      transportMeans = pTransportMeans;
      return this;
    }

    /**
     * Method sets association {@link #vehicleType}.<br/>
     *
     * @param pVehicleType Value to which {@link #vehicleType} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setVehicleType( VehicleType pVehicleType ) {
      vehicleType = pVehicleType;
      return this;
    }

    /**
     * Method creates a new instance of class LegSegment. The object will be initialized with the values of the builder.
     *
     * @return LegSegment Created object. The method never returns null.
     */
    public LegSegment build( ) {
      return new LegSegment(this);
    }
  }

  /**
   * Method returns association {@link #from}.<br/>
   *
   * @return {@link UICCode} Value to which {@link #from} is set.
   */
  public UICCode getFrom( ) {
    return from;
  }

  /**
   * Method returns association {@link #to}.<br/>
   *
   * @return {@link UICCode} Value to which {@link #to} is set.
   */
  public UICCode getTo( ) {
    return to;
  }

  /**
   * Method returns association {@link #intermediateStops}.<br/>
   *
   * @return {@link List<UICCode>} Value to which {@link #intermediateStops} is set. The method never returns null and
   * the returned collection is unmodifiable.
   */
  public List<UICCode> getIntermediateStops( ) {
    return intermediateStops;
  }

  /**
   * Method returns association {@link #carrier}.<br/>
   *
   * @return {@link CarrierCode} Value to which {@link #carrier} is set.
   */
  public CarrierCode getCarrier( ) {
    return carrier;
  }

  /**
   * Method returns attribute {@link #vehicleNumber}.<br/>
   *
   * @return int Value to which {@link #vehicleNumber} is set.
   */
  public int getVehicleNumber( ) {
    return vehicleNumber;
  }

  /**
   * Method returns association {@link #transportMeans}.<br/>
   *
   * @return {@link TransportMeans} Value to which {@link #transportMeans} is set.
   */
  public TransportMeans getTransportMeans( ) {
    return transportMeans;
  }

  /**
   * Method returns association {@link #vehicleType}.<br/>
   *
   * @return {@link VehicleType} Value to which {@link #vehicleType} is set.
   */
  public VehicleType getVehicleType( ) {
    return vehicleType;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + Objects.hashCode(from);
    lResult = lPrime * lResult + Objects.hashCode(to);
    lResult = lPrime * lResult + Objects.hashCode(intermediateStops);
    lResult = lPrime * lResult + Objects.hashCode(carrier);
    lResult = lPrime * lResult + vehicleNumber;
    lResult = lPrime * lResult + Objects.hashCode(transportMeans);
    lResult = lPrime * lResult + Objects.hashCode(vehicleType);
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
      LegSegment lOther = (LegSegment) pObject;
      lEquals = Objects.equals(from, lOther.from) && Objects.equals(to, lOther.to)
          && Objects.equals(intermediateStops, lOther.intermediateStops) && Objects.equals(carrier, lOther.carrier)
          && vehicleNumber == lOther.vehicleNumber && Objects.equals(transportMeans, lOther.transportMeans)
          && Objects.equals(vehicleType, lOther.vehicleType);
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
    lBuilder.append("from: ");
    if (from != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(from.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("to: ");
    if (to != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(to.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("intermediateStops: ");
    if (intermediateStops != null) {
      lBuilder.append(intermediateStops.size());
      lBuilder.append(" element(s)");
    }
    else {
      lBuilder.append(" null");
    }
    lBuilder.append(System.lineSeparator());
    if (intermediateStops != null) {
      for (UICCode lNext : intermediateStops) {
        lBuilder.append(lNext.toStringBuilder(pIndent + "    "));
        lBuilder.append(System.lineSeparator());
      }
    }
    lBuilder.append(pIndent);
    lBuilder.append("carrier: ");
    if (carrier != null) {
      lBuilder.append(System.lineSeparator());
      lBuilder.append(carrier.toStringBuilder(pIndent + "    "));
    }
    else {
      lBuilder.append(" null");
      lBuilder.append(System.lineSeparator());
    }
    lBuilder.append(pIndent);
    lBuilder.append("vehicleNumber: ");
    lBuilder.append(vehicleNumber);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("transportMeans: ");
    lBuilder.append(transportMeans);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("vehicleType: ");
    lBuilder.append(vehicleType);
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
   * @return {@link Builder} New builder that can be used to create new LegSegment objects. The method never returns
   * null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}