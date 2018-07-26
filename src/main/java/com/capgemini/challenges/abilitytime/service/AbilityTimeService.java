package com.capgemini.challenges.abilitytime.service;

import com.capgemini.challenges.abilitytime.AbilityTimeEntity;
import com.capgemini.challenges.abilitytime.dao.AbilityTimeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityTimeService {

    private AbilityTimeDao abilityTimeDao;

    @Autowired
    public AbilityTimeService(AbilityTimeDao abilityTimeDao) {
        this.abilityTimeDao = abilityTimeDao;
    }


    public List<Long> findPlayersIdByAbilityTime(AbilityTimeEntity abilityTime) {
        return abilityTimeDao.findPlayersIdByAbilityTime(abilityTime);
    }
}
