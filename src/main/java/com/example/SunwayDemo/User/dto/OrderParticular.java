package com.example.SunwayDemo.User.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderParticular {
    private String foodName;
    private Integer quantity;

}
