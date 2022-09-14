package com.kurdsoft.khanoo.custom_metrics;

import org.springframework.scheduling.annotation.Scheduled;

public class DemoMetricsScheduler {
    private final DemoMetrics demoMetrics;

    public DemoMetricsScheduler(DemoMetrics demoMetrics) {
        this.demoMetrics = demoMetrics;
    }

    @Scheduled(fixedRate = 1000)
    public void triggerCustomMetrics() {
        demoMetrics.getRandomMetricsData();
    }
}
