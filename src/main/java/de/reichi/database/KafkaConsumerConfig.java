package de.reichi.database;

import de.reichi.database.entity.Contract;
import de.reichi.database.listener.KafkaListeners;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Profile("!ide")
@EnableKafka
@Configuration
public class KafkaConsumerConfig {

  @Value(value = "${kafka.bootstrapAddress}")
  private String bootstrapAddress;

  @Bean
  public ConsumerFactory<String, Contract> consumerFactory() {
    Map<String, Object> props = Map.of(
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress,
      ConsumerConfig.GROUP_ID_CONFIG,"foo",
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    return new DefaultKafkaConsumerFactory(props, new StringDeserializer(), new JsonDeserializer<>(Contract.class));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Contract>
  kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Contract> factory =
      new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

  @Bean
  public KafkaListeners kafkaListeners() {
    return new KafkaListeners();
  }
}
