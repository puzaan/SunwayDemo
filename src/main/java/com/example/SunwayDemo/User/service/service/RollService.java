package com.example.SunwayDemo.User.service.service;

import com.example.SunwayDemo.User.entity.roll.Roll;

import java.util.List;

public interface RollService {

    Roll create (Roll roll);
    List<Roll> getAll();
}
