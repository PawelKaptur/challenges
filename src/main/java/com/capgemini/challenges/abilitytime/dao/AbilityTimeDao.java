package com.capgemini.challenges.abilitytime.dao;

import com.capgemini.challenges.abilitytime.AbilityTimeEntity;
import com.capgemini.challenges.abilitytime.DayOfWeek;
import com.capgemini.challenges.abilitytime.TimeOfDay;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AbilityTimeDao {
    private static long idCounter = 0;
    private List<AbilityTimeEntity> abilityTimes = new ArrayList<>();

    public AbilityTimeDao() {
        addAbilityTimes();
    }

    private void addAbilityTimes() {
        abilityTimes.add(new AbilityTimeEntity(createID(), 0, DayOfWeek.MONDAY, TimeOfDay.AFTERNOON));
        abilityTimes.add(new AbilityTimeEntity(createID(), 0, DayOfWeek.THURSDAY, TimeOfDay.AFTERNOON));
        abilityTimes.add(new AbilityTimeEntity(createID(), 1, DayOfWeek.MONDAY, TimeOfDay.AFTERNOON));
        abilityTimes.add(new AbilityTimeEntity(createID(), 1, DayOfWeek.SATURDAY, TimeOfDay.MORNING));
        abilityTimes.add(new AbilityTimeEntity(createID(), 2, DayOfWeek.TUESDAY, TimeOfDay.NOON));
        abilityTimes.add(new AbilityTimeEntity(createID(), 3, DayOfWeek.SUNDAY, TimeOfDay.EVENING));
        abilityTimes.add(new AbilityTimeEntity(createID(), 3, DayOfWeek.WEDNESDAY, TimeOfDay.EVENING));
        abilityTimes.add(new AbilityTimeEntity(createID(), 4, DayOfWeek.FRIDAY, TimeOfDay.MORNING));
        abilityTimes.add(new AbilityTimeEntity(createID(), 4, DayOfWeek.THURSDAY, TimeOfDay.NIGHT));
    }

    private static long createID() {
        return idCounter++;
    }

    public List<AbilityTimeEntity> findAbilityTime(AbilityTimeEntity abilityTime) {
        return abilityTimes.stream().filter(a -> a.getDayOfWeek().equals(abilityTime.getDayOfWeek()) && a.getTimeOfDay().equals(abilityTime.getTimeOfDay())).collect(Collectors.toList());
    }

    public List<Long> findPlayersIdByAbilityTime(AbilityTimeEntity abilityTime){
        return findAbilityTime(abilityTime).stream().map(a -> a.getPlayerId()).collect(Collectors.toList());
    }
}
