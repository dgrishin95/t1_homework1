package com.mysite.t1_homework1.repository;

import com.mysite.t1_homework1.model.TimeTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTrackingRepository extends JpaRepository<TimeTracking, Long> {

    @Query("select avg(t.executionTime) from TimeTracking t where t.loggingMethod = 'async' group by t.loggingMethod")
    Double findAverageExecutionTimeForAsyncLogging();

    @Query("select avg(t.executionTime) from TimeTracking t where t.loggingMethod = 'not-async' group by t.loggingMethod")
    Double findAverageExecutionTimeForNotAsyncLogging();

    @Query("select sum(t.executionTime) from TimeTracking t where t.loggingMethod = 'async' group by t.loggingMethod")
    Long findTotalExecutionTimeForAsyncLogging();

    @Query("select sum(t.executionTime) from TimeTracking t where t.loggingMethod = 'not-async' group by t.loggingMethod")
    Long findTotalExecutionTimeForNotAsyncLogging();
}
