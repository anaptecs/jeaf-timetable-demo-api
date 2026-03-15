/*
 * Please add organization file header by setting property "fileHeaderCompany"
 *
 * All rights reserved.
 */
package com.anaptecs.jeaf.timetable.api.serializers;

import com.anaptecs.jeaf.timetable.api.CarrierCode;
import com.anaptecs.jeaf.timetable.api.UICCode;
import com.anaptecs.jeaf.timetable.api.VehicleType;
import tools.jackson.databind.JacksonModule;
import tools.jackson.databind.module.SimpleModule;

/**
 * Factory assembles all configured serializers / deserializers into a module.
 */
public class TimetableDemoModuleFactory {
  /**
   * Method creates a module that consists of all serializers / deserializers for data types.
   */
  public static JacksonModule createDataTypeSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("DataTypeSerializerModule." + TimetableDemoModuleFactory.class.getName());
    // Add serializers and deserializers for data types
    lModule.addSerializer(CarrierCode.class, new CarrierCodeSerializer());
    lModule.addDeserializer(CarrierCode.class, new CarrierCodeDeserializer());
    lModule.addSerializer(UICCode.class, new UICCodeSerializer());
    lModule.addDeserializer(UICCode.class, new UICCodeDeserializer());
    // Return created module.
    return lModule;
  }

  /**
   * Method creates a module that consists of all serializers / deserializers for enums.
   */
  public static JacksonModule createEnumSerializerModule( ) {
    // Create module for serializers / deserializers that are located in this package
    SimpleModule lModule = new SimpleModule("EnumSerializerModule." + TimetableDemoModuleFactory.class.getName());
    // Add serializers and deserializers for enumerations
    lModule.addSerializer(VehicleType.class, new VehicleTypeSerializer());
    lModule.addDeserializer(VehicleType.class, new VehicleTypeDeserializer());
    // Return created module.
    return lModule;
  }
}