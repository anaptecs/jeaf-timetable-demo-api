/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api.serializers;

import com.anaptecs.jeaf.timetable.api.CarrierCode;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.StringNode;

/**
 * Class implements a JSON / Jackson deserializer for class CarrierCode.
 */
public class CarrierCodeDeserializer extends ValueDeserializer<CarrierCode> {
  @Override
  public CarrierCode deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pParser.objectReadContext().readTree(pParser);
    if (lNode instanceof StringNode) {
      return CarrierCode.of(lNode.asString());
    }
    // Node is not of expected type.
    else {
      throw DatabindException.from(pContext,
          "Unable to deserialize object of type CarrierCode. Expected node type that matches to data type but received other JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}