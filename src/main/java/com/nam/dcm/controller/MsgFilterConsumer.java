package com.nam.dcm.controller;


import com.nam.dcm.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MsgFilterConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(MsgFilterConsumer.class);

    private final FileStorageService fileStorageService;

    public MsgFilterConsumer(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @KafkaListener(topics = "NamDC_topic", group = "namdcm-group")
    public void consume(String message) {

        log.info("Received: {}", message);

        if (isValid(message)) {
            fileStorageService.save(message);
        } else {
            log.error("Invalid message format: {}", message);
        }
    }

    private boolean isValid(String msg) {
        if (msg == null) return false;

        String lower = msg.toLowerCase();
        return lower.contains("successful") || lower.contains("failed");
    }
}

