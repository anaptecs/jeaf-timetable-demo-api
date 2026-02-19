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
import jakarta.validation.constraints.NotNull;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Message.Builder.class)
public class Message {
  /**
   * Constant for the name of attribute "id".
   */
  public static final String ID = "id";

  /**
   * Constant for the name of attribute "text".
   */
  public static final String TEXT = "text";

  private final int id;

  @NotNull
  private final String text;

  /**
   * Initialize object using the passed builder.
   *
   * @param pBuilder Builder that should be used to initialize this object. The parameter must not be null.
   */
  protected Message( Builder pBuilder ) {
    // Read attribute values from builder.
    id = pBuilder.id;
    text = pBuilder.text;
  }

  /**
   * Method returns a new builder.
   *
   * @return {@link Builder} New builder that can be used to create new Message objects.
   */
  public static Builder builder( ) {
    return new Builder();
  }

  /**
   * Class implements builder to create a new instance of class <code>Message</code>.
   */
  @JsonPOJOBuilder(withPrefix = "set")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Builder {
    private int id;

    private String text;

    /**
     * Use {@link Message#builder()} instead of private constructor to create new builder.
     */
    protected Builder( ) {
    }

    /**
     * Use {@link Message#builder(Message)} instead of private constructor to create new builder.
     */
    protected Builder( Message pObject ) {
      if (pObject != null) {
        // Read attribute values from passed object.
        this.setId(pObject.id);
        this.setText(pObject.text);
      }
    }

    /**
     * Method sets attribute {@link #id}.<br/>
     *
     * @param pId Value to which {@link #id} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setId( int pId ) {
      // Assign value to attribute
      id = pId;
      return this;
    }

    /**
     * Method sets attribute {@link #text}.<br/>
     *
     * @param pText Value to which {@link #text} should be set.
     * @return {@link Builder} Instance of this builder to support chaining setters. Method never returns null.
     */
    @JsonSetter(nulls = Nulls.SKIP)
    public Builder setText( String pText ) {
      // Assign value to attribute
      text = pText;
      return this;
    }

    /**
     * Method creates a new instance of class Message. The object will be initialized with the values of the builder.
     *
     * @return Message Created object. The method never returns null.
     */
    public Message build( ) {
      return new Message(this);
    }
  }

  /**
   * Method returns attribute {@link #id}.<br/>
   *
   * @return int Value to which {@link #id} is set.
   */
  public int getId( ) {
    return id;
  }

  /**
   * Method returns attribute {@link #text}.<br/>
   *
   * @return {@link String} Value to which {@link #text} is set.
   */
  public String getText( ) {
    return text;
  }

  @Override
  public int hashCode( ) {
    final int lPrime = 31;
    int lResult = 1;
    lResult = lPrime * lResult + id;
    lResult = lPrime * lResult + Objects.hashCode(text);
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
      Message lOther = (Message) pObject;
      lEquals = id == lOther.id && Objects.equals(text, lOther.text);
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
    lBuilder.append("id: ");
    lBuilder.append(id);
    lBuilder.append(System.lineSeparator());
    lBuilder.append(pIndent);
    lBuilder.append("text: ");
    lBuilder.append(text);
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
   * @return {@link Builder} New builder that can be used to create new Message objects. The method never returns null.
   */
  public Builder toBuilder( ) {
    return new Builder(this);
  }
}