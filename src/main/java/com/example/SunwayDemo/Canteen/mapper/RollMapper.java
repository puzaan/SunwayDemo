package com.example.SunwayDemo.Canteen.mapper;

import com.example.SunwayDemo.User.dto.RollDto;
import com.example.SunwayDemo.User.entity.roll.Roll;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RollMapper {


    public static Roll rollDtoToRoll(RollDto rollDto){
        Roll roll = new Roll();
        roll.setId(rollDto.getId());
        roll.setRollName(rollDto.getRollName());
        roll.setRollDescription(rollDto.getRollDescription());
        return roll;
    }

    public static Set<Roll> rollDtoToRoll(Set<RollDto> rollDtos){
        Set<Roll> rolls = new HashSet<>();
        for (RollDto rollDto : rollDtos){
            rolls.add(rollDtoToRoll(rollDto));
        }
        return rolls;
    }
}
