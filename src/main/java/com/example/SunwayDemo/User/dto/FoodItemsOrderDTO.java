package com.example.SunwayDemo.User.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodItemsOrderDTO {
    private Integer foodId;
    private Integer quantity;

}
