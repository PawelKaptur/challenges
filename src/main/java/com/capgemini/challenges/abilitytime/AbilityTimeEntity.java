package com.capgemini.challenges.abilitytime;

public class AbilityTimeEntity {
    private long ablilityTimeId;
    private long playerId;
    private DayOfWeek dayOfWeek;
    private TimeOfDay timeOfDay;

    public AbilityTimeEntity(long ablilityTimeId, long playerId, DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        this.ablilityTimeId = ablilityTimeId;
        this.playerId = playerId;
        this.dayOfWeek = dayOfWeek;
        this.timeOfDay = timeOfDay;
    }

    public AbilityTimeEntity(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        this.dayOfWeek = dayOfWeek;
        this.timeOfDay = timeOfDay;
    }

    public long getAblilityTimeId() {
        return ablilityTimeId;
    }

    public void setAblilityTimeId(long ablilityTimeId) {
        this.ablilityTimeId = ablilityTimeId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(TimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
    }
}
