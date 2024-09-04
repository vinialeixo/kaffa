package com.codex.kaffa.worldClock;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("worldclock")
public class WorldClockController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping
    public String getMyTime() {
        // URL da API
        String url = "http://worldclockapi.com/api/json/utc/now";

        // Consultar a API
        String response = restTemplate.getForObject(url, String.class);

        // Processar a resposta JSON para extrair a data/hora
        String utcDateTime;
        try {
            JsonNode jsonNode = objectMapper.readTree(response);
            utcDateTime = jsonNode.get("currentDateTime").asText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON response", e);
        }

        // Converter para OffsetDateTime
        OffsetDateTime utcTime = OffsetDateTime.parse(utcDateTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        // Obter o fuso horário local
        ZoneId localZoneId = ZoneId.systemDefault();
        ZonedDateTime localTime = utcTime.atZoneSameInstant(localZoneId);

        // Formatar as datas para exibição
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTimeStr = localTime.format(formatter);
        String utcTimeStr = utcTime.format(formatter);

        // Retornar a data/hora local e UTC
        return "Local Time: " + localTimeStr + ", UTC Time: " + utcTimeStr;
    }

    @GetMapping("/now")
    public TimeResponse getCurrentTime() {
        // Obter o tempo atual no formato OffsetDateTime
        OffsetDateTime now = OffsetDateTime.now();

        // Criar uma instância de TimeResponse com o tempo atual
        TimeResponse response = new TimeResponse();
        response.setCurrentDateTime(now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

        // Retornar a resposta
        return response;
    }

    // Classe interna para encapsular a resposta JSON
    public static class TimeResponse {
        private String currentDateTime;

        public String getCurrentDateTime() {
            return currentDateTime;
        }

        public void setCurrentDateTime(String currentDateTime) {
            this.currentDateTime = currentDateTime;
        }
    }

}
