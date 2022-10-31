package com.sample.reporting.dataObjects;

public class APIStatusTimeDTO {

    String basePath;
    Long averageResponseTime = 0L;
    Long minTime = 99999L;
    Long maxTime = 0L;
    Long totalHits = 0L;

    public APIStatusTimeDTO(String basePath) {
        this.basePath = basePath;
    }

    public void setResponseTime(Long responseTime){
        if(responseTime!=0){
            setAverageResponseTime(responseTime);
            setMaxTime(responseTime);
            setMinTime(responseTime);
            this.totalHits++;
        }
    }

    public Long getAverageResponseTime() {
        return averageResponseTime;
    }

    public void setAverageResponseTime(Long responseTime) {
        if(this.averageResponseTime!=0){
            this.averageResponseTime = ((this.averageResponseTime + responseTime) / 2);
        }else{
            this.averageResponseTime=responseTime;
        }
    }

    public Long getMinTime() {
        return minTime;
    }

    public void setMinTime(Long minTime) {
        if (this.minTime > minTime)
            this.minTime = minTime;
    }

    public Long getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Long maxTime) {
        if (this.maxTime < maxTime)
            this.maxTime = maxTime;
    }

    public Long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Long totalHits) {
        this.totalHits = totalHits;
    }
}
