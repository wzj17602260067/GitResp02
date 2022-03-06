package com.yidong.yun.statistics;

import lombok.Data;

import java.util.LongSummaryStatistics;

@Data
public class MethodElapsedStatistic {

        private String methodName;
        private Long maxTime;
        private Long minTime;
        private double avgTime;
        private Long sumTime;
        private long count;

        public static MethodElapsedStatistic fromSummaryStatistics(String methodName,
                                                                   LongSummaryStatistics summaryStatistics)
        {

            MethodElapsedStatistic elapsedTimeStatistic  = new MethodElapsedStatistic();

            elapsedTimeStatistic.setMethodName(methodName);
            elapsedTimeStatistic.setAvgTime(summaryStatistics.getAverage());
            elapsedTimeStatistic.setMaxTime(summaryStatistics.getMax());
            elapsedTimeStatistic.setMinTime(summaryStatistics.getMin());
            elapsedTimeStatistic.setSumTime(summaryStatistics.getSum());
            elapsedTimeStatistic.setCount(summaryStatistics.getCount());

            return elapsedTimeStatistic;


        }

    @Override
    public String toString() {
        return "MethodElapsedStatistic{" +
                "methodName='" + methodName + '\'' +
                ", maxTime=" + maxTime +
                ", minTime=" + minTime +
                ", avgTime=" + avgTime +
                ", sumTime=" + sumTime +
                ", count=" + count +
                '}';
    }
}
