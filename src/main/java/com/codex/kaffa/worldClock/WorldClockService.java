package com.codex.kaffa.worldClock;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WorldClockService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private String getResponse(String url) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch data from API", e);
        }
    }

    public String getCurrentDateTime() {
        String url = "http://worldclockapi.com/api/json/utc/now";

        String response = getResponse(url);

        try {
            JsonNode jsonNode = objectMapper.readTree(response);
            String utcDateTime = jsonNode.get("currentDateTime").asText();

            OffsetDateTime utcTime = OffsetDateTime.parse(utcDateTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

            ZoneId localZoneId = ZoneId.systemDefault();
            ZonedDateTime localTime = utcTime.atZoneSameInstant(localZoneId);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String localTimeStr = localTime.format(formatter);
            String utcTimeStr = utcTime.format(formatter);

            return "Local Time: " + localTimeStr + ", UTC Time: " + utcTimeStr;
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON response", e);
        }
    }

    public TimeResponse getCurrenTime() {
        // URL da API
        String url = "http://worldclockapi.com/api/json/utc/now";

        String response = getResponse(url);
        try {
            JsonNode jsonNode = objectMapper.readTree(response);
            String utcDateTime = jsonNode.get("currentDateTime").asText();
            return new TimeResponse(utcDateTime);

        } catch (Exception e) {
            throw new RuntimeException("Failed to get JSON response", e);
        }

    }

}
