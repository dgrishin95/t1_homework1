package com.mysite.t1_homework1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class TimeTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loggingMethod;

    private String methodName;

    private long executionTime;

    public TimeTracking(String loggingMethod, String methodName, long executionTime) {
        this.loggingMethod = loggingMethod;
        this.methodName = methodName;
        this.executionTime = executionTime;
    }
}
