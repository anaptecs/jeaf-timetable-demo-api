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

public class UICCode implements Comparable<UICCode> {
  /**
   * Constant for the name of attribute "code".
   */
  public static final String CODE = "code";

  private final int code;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected UICCode( Builder pBuilder ) {
    // Read attribute values from builder.
    code = pBuilder.code;
  }

  /**
   * Constructor is intended to be used by <code>of(...)</code> operation to efficiently create new objects by avoiding
   * usage of builder.
   */
  private UICCode( int pCode ) {
    code = pCode;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new UICCode objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Convenience method to create new instance of class UICCode.
   *
   *
   * @param pCode Value to which {@link #code} should be set.
   *
   * @return {@link UICCode}
   */
  public static UICCode of( int pCode ) {
    return new UICCode(pCode);
  }

  /**
   * Class implements builder to create a new instance of class <code>UICCode</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private int code;

    /**
     * Use {@link UICCode#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link UICCode#builder(UICCode)} instead of private constructor to create new builder.
     */
    protected Builder( UICCode pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setCode(pObject.code);
      }
    }

    /**
     * Method sets attribute {@link #code}.<br/>
     *
     * @param pCode Value to which {@link #code} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setCode( int pCode ) {
      // Assign value to attribute
      code = pCode;
      return this;
    }

    /**
     * Method creates a new instance of class UICCode. The object will be initialized with the values of the builder.
     *
     * @return UICCode Created object. The method never returns null.
     */
    public UICCode build( ) {
      return new UICCode(this);
    }
  }

  /**
   * Method returns attribute {@link #code}.<br/>
   *
   * @return int Value to which {@link #code} is set.
   */
  public int getCode( ) {
    return code;
  }

  @Override
  public int hashCode( ) {
    return code;
  }

  @Override
  public boolean equals( Object pOtherObject ) {
    boolean lEquals;
    if (this == pOtherObject) {
      lEquals = true;
    }
    else if (pOtherObject instanceof UICCode == false) {
      lEquals = false;
    }
    else {
      lEquals = (code == ((UICCode) pOtherObject).getCode());
    }
    return lEquals;
  }

  @Override
  public int compareTo( UICCode pOther ) {
    return Integer.compare(this.getCode(), pOther.getCode());
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
    lBuilder.append("code: ");
    lBuilder.append(code);
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
   * @return {@link Builder} New builder that can be used to create new UICCode objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}