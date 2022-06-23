package com.emrap.app.background.jobrunr.service;

import org.jobrunr.jobs.annotations.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PickWinnerJobService {

    public static final long EXECUTION_TIME = 5000L;
    private Logger logger = LoggerFactory.getLogger(getClass());
    private AtomicInteger count = new AtomicInteger();

    @Job(name = "The sample job with variable %0", retries = 2)
    public void executeJob(String variable) {

        logger.info("The sample job has begun. The variable you passed is {}", variable);
        try {
            // TODO
            Thread.sleep(EXECUTION_TIME);
        } catch (InterruptedException e) {
            logger.error("Error while executing sample job", e);
        } finally {
            count.incrementAndGet();
            logger.info("Sample job has finished...");
        }
    }

    public int getNumberOfInvocations() {
        return count.get();
    }
}
