package com.capgemini.challenges;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
@Aspect
public class MonitorAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorAspect.class);

    private long start;
    private long finish;
    private long measurment;

    @Before("execution(* com.capgemini.challenges.challenge.service.ChallengeService.*(..))")
    public void startTime() {
        this.start = System.currentTimeMillis();
    }

    @After("execution(* com.capgemini.challenges.challenge.service.ChallengeService.*(..))")
    public void stopTime() {
        this.finish = System.currentTimeMillis();
        measureTime();
    }

    public void measureTime() {
        this.measurment = finish - start;
        LOGGER.info("Time elapsed for execution of method: " + measurment);
    }
}
