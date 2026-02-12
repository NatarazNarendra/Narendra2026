package com.nam.dcm.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class FileStorageService {
	@Value("${file.storage.path:/tmp/default-storage}")
	private String fileStoragePath;

    public synchronized void save(String message) {

        String record = LocalDateTime.now() + "," + message;

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileStoragePath, true))) {

            writer.write(record);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//file.storage.path=C:/logs/messages.txt