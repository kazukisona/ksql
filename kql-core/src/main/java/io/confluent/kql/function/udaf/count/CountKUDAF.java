/**
 * Copyright 2017 Confluent Inc.
 **/
package io.confluent.kql.function.udaf.count;

import org.apache.kafka.connect.data.Schema;

import java.util.Arrays;

import io.confluent.kql.function.KQLAggregateFunction;

public class CountKUDAF extends KQLAggregateFunction<Object, Long> {

  public CountKUDAF(Integer argIndexInValue) {
    super(argIndexInValue, 0L, Schema.INT64_SCHEMA, Arrays.asList(Schema.FLOAT64_SCHEMA),
          "COUNT", CountKUDAF.class);
  }

  @Override
  public Long aggregate(Object currentVal, Long currentAggVal) {
    return currentAggVal + 1;
  }
}