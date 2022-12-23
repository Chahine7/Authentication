package com.auth_kafka.Config.Kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    // Create the TOPIC!!!

    @Bean
    public NewTopic mailTopic(){
        return TopicBuilder.name("gmail")
                .build();
    }
}
