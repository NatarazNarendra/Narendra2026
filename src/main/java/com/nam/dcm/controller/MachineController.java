package com.nam.dcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nam.dcm.service.KafkaSender;

//@RestController
//@RequestMapping(value = "/namdcm-kafka/")
//public class ApacheKafkaWebController {
//
//	@Autowired
//	KafkaSender kafkaSender;
//
//	/*
//	 * @GetMapping(value = "/producer") public String
//	 * producer(@RequestParam("message") String message) {
//	 * kafkaSender.send(message);
//	 * 
//	 * return "Message sent to the Kafka Topic NamDC_topic Successfully"; }
//	 */
//
//	
//	@GetMapping("/producer")
//	public String producer(@RequestParam(value = "message", required = false) String message) {
//	    if (message == null) {
//	        return "Message can be faild for Nam Region";
//	    }
//	    kafkaSender.send(message);
//	    return "Message sent successfully for  Nam Region ";
//	}
//}
//http://localhost:8080//namdcm-kafka/producer?message=test
//http://localhost:8080/namdcm-kafka/producer


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nam.dcm.service.KafkaSender;

@RestController
@RequestMapping("/namdcm-kafka")
public class MachineController {

    private final KafkaSender kafkaSender;

    public MachineController(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @GetMapping("/producer")
    public ResponseEntity<String> producer(
            @RequestParam(value = "message", required = false) String message) {

        if (message == null || message.trim().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Message cannot be null or empty");
        }

        kafkaSender.send(message);
        return ResponseEntity.ok("Message sent successfully to Kafka");
    }
}
//http://localhost:9080/namdcm-kafka/producer