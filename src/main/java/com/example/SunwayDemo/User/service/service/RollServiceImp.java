package com.example.SunwayDemo.User.service.service;

import com.example.SunwayDemo.User.entity.roll.Roll;
import com.example.SunwayDemo.User.repository.roll.RollRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RollServiceImp implements RollService{

    private final RollRepo rollRepo;

    public RollServiceImp(RollRepo rollRepo) {
        this.rollRepo = rollRepo;
    }

    @Override
    public Roll create(Roll roll) {
        return rollRepo.save(roll);
    }

    @Override
    public List<Roll> getAll() {
        return rollRepo.findAll();
    }
}
