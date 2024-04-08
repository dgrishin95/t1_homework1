package com.mysite.t1_homework1;

import com.mysite.t1_homework1.service.TimeTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class HomeworkApplication {

    private final TimeTrackingService timeTrackingService;

    public static void main(String[] args) {
        SpringApplication.run(HomeworkApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onReady() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            timeTrackingService.testTrackTimeAnnotation();
            timeTrackingService.testAsyncTrackTimeAnnotation();
        }
    }
}
