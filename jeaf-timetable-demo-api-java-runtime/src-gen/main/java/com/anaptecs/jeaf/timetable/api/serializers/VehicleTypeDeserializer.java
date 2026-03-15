/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api.serializers;

import com.anaptecs.jeaf.timetable.api.VehicleType;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.node.StringNode;

/**
 * Class implements a JSON / Jackson deserializer for class VehicleType.
 */
public class VehicleTypeDeserializer extends ValueDeserializer<VehicleType> {
  @Override
  public VehicleType deserialize( JsonParser pParser, DeserializationContext pContext ) {
    // Parse JSON content.
    JsonNode lNode = pParser.objectReadContext().readTree(pParser);
    // We expect that enumerations are always serialized as plain text which will result in a TextNode.
    if (lNode instanceof StringNode) {
      VehicleType lLiteral;
      try {
        String lLiteralName = lNode.asString();
        lLiteral = VehicleType.valueOf(lLiteralName);
      }
      // Literal is unknown.
      catch (IllegalArgumentException e) {
        lLiteral = VehicleType.UNKNOWN;
      }
      return lLiteral;
    }
    // Node is not a TextNode
    else {
      throw DatabindException.from(pContext,
          "Unable to deserialize object of type ''VehicleType''. Expected text node but received other type of JSON content. Current JSON node ''"
              + lNode.toString() + "'' is of type ''" + lNode.getClass().getName() + "''.");
    }
  }
}