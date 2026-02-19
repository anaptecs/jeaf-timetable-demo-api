/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api.serializers;

import com.anaptecs.jeaf.timetable.api.VehicleType;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Class implements a JSON / Jackson serializer for class VehicleType.
 */
public class VehicleTypeSerializer extends ValueSerializer<VehicleType> {
  @Override
  public void serialize( VehicleType pObject, JsonGenerator pGenerator, SerializationContext pSerializers ) {
    // Write value directly to JSON and avoid nesting object structures. Existing toString() operation is exactly what
    // we need.
    pGenerator.writeString(pObject.toString());
  }
}