package com.singleton.tradeproducer.config;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import stock.Trade;

@Configuration
public class KafkaConfig {

  @Bean
  public Producer<Long, Trade> kafkaProducer() {
    final var props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("key.serializer", "org.apache.kafka.common.serialization.LongSerializer");
    props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
    props.put("schema.registry.url", "http://localhost:8081");

    return new KafkaProducer<>(props);
  }
}
