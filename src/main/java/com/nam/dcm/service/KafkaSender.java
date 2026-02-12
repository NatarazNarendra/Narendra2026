package com.nam.dcm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/*
 * @Service public class KafkaSender {
 * 
 * @Autowired private KafkaTemplate<String, String> kafkaTemplate;
 * 
 * String kafkaTopic = "Nam_DCM_topic";
 * 
 * public void send(String data) {
 * 
 * kafkaTemplate.send(kafkaTopic, data); } }
 */


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

    private static final String TOPIC = "NamDC_topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
