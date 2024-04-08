package com.mysite.t1_homework1.service;

import com.mysite.t1_homework1.annotation.TrackAsyncTime;
import com.mysite.t1_homework1.annotation.TrackTime;
import com.mysite.t1_homework1.model.TimeTracking;
import com.mysite.t1_homework1.repository.TimeTrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TimeTrackingService {

    private final TimeTrackingRepository timeTrackingRepository;

    @Transactional
    public void saveExecutionTime(String loggingMethod, String methodName, long executionTime) {
        timeTrackingRepository.save(new TimeTracking(loggingMethod, methodName, executionTime));
    }

    @TrackTime
    public void testTrackTimeAnnotation() throws InterruptedException {
        Thread.sleep(1);
    }

    @TrackAsyncTime
    public void testAsyncTrackTimeAnnotation() throws InterruptedException {
        Thread.sleep(1);
    }

    public Double findAverageExecutionTimeForAsyncLogging() {
        return timeTrackingRepository.findAverageExecutionTimeForAsyncLogging();
    }

    public Double findAverageExecutionTimeForNotAsyncLogging() {
        return timeTrackingRepository.findAverageExecutionTimeForNotAsyncLogging();
    }

    public Long findTotalExecutionTimeForAsyncLogging() {
        return timeTrackingRepository.findTotalExecutionTimeForAsyncLogging();
    }

    public Long findTotalExecutionTimeForNotAsyncLogging() {
        return timeTrackingRepository.findTotalExecutionTimeForNotAsyncLogging();
    }
}
