package com.taizilibai.mall.config.domain;

import java.time.LocalTime;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/10/16 14:12
 */
public class BusinessHours {
    private LocalTime openTime;
    private LocalTime closeTime;
    private LocalTime[][] times;

    public LocalTime[][] getTimes() {
        return times;
    }

    public void setTimes(LocalTime[][] times) {
        this.times = times;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }
}
