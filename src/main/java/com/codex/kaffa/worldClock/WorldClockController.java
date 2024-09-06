package com.codex.kaffa.worldClock;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("worldclock")
public class WorldClockController {

    private final WorldClockService worldClockService;

    @GetMapping
    public ResponseEntity<String> getMyTime() {

        try {
            return worldClockService.getCurrentDateTime();
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

    }

    @GetMapping("/now")
    public ResponseEntity<TimeResponse> getCurrentTime() {
        return ResponseEntity.status(HttpStatus.OK).body(worldClockService.getCurrenTime());
    }
}
