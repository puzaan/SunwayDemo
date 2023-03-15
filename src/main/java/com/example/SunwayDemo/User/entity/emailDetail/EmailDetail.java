package com.example.SunwayDemo.User.entity.emailDetail;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetail {
    private Set<String> recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
