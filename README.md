# Narendra2026
**probleam.**
C moto is simple to persist/save the particular message into file storage of disk
 
1. Start-> H/W machine publisher, can feed it's operational messages to kf engine continuously to the downstream,  via topic
2. MsgFilter is a consumer from kf engineer these messages and validate them all necessary syntax present or not
3. calls the RestController to extract line by line and store into text file, each msg at new line
4. no db, only file storage, kind of csv or excel
   Kafka Producer simulates hardware machine messages.
**solutation:**
Kasolutafka Consumer (MsgFilter) validates each message.

Messages must contain successful or failed; invalid messages are logged.

Valid messages are stored line by line in a text file 

Optional REST API to publish and read messages.

No database, only file-based storage

**Build and run:**

mvn clean install
mvn spring-boot:run
**url**
}
http://localhost:9081/namdcm-kafka/producer

//http://localhost:8080//namdcm-kafka/producer?message=test

http://localhost:9081//namdcm-kafka/producer?message=test
<img width="2607" height="1408" alt="image" src="https://github.com/user-attachments/assets/a8496f28-cddb-4859-8c52-b95fb63b5e57" />



