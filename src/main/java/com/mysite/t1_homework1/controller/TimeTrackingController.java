package com.mysite.t1_homework1.controller;

import com.mysite.t1_homework1.service.TimeTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/time-tracking")
@RequiredArgsConstructor
public class TimeTrackingController {

    private final TimeTrackingService timeTrackingService;

    @GetMapping("/average-time-for-async-logging")
    public ResponseEntity<Double> findAverageExecutionTimeForAsyncLogging() {
        return new ResponseEntity<>(timeTrackingService.findAverageExecutionTimeForAsyncLogging(), HttpStatus.OK);
    }

    @GetMapping("/average-time-for-not-async-logging")
    public ResponseEntity<Double> findAverageExecutionTimeForNotAsyncLogging() {
        return new ResponseEntity<>(timeTrackingService.findAverageExecutionTimeForNotAsyncLogging(), HttpStatus.OK);
    }

    @GetMapping("/total-time-for-async-logging")
    public ResponseEntity<Long> findTotalExecutionTimeForAsyncLogging() {
        return new ResponseEntity<>(timeTrackingService.findTotalExecutionTimeForAsyncLogging(), HttpStatus.OK);
    }

    @GetMapping("/total-time-for-not-async-logging")
    public ResponseEntity<Long> findTotalExecutionTimeForNotAsyncLogging() {
        return new ResponseEntity<>(timeTrackingService.findTotalExecutionTimeForNotAsyncLogging(), HttpStatus.OK);
    }
}
