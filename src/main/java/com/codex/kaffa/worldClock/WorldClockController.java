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

        return ResponseEntity.status(HttpStatus.OK).body(worldClockService.getCurrentDateTime());

    }

    @GetMapping("/now")
    public ResponseEntity<TimeResponse> getCurrentTime() {
        return ResponseEntity.status(HttpStatus.OK).body(worldClockService.getCurrenTime());
    }

}
