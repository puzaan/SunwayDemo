package com.example.SunwayDemo.User.dto;

import lombok.*;



@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private Integer id;

    private String name;

    private String phoneNo;
    private String rollNum;

    private  String batch;


    private Integer facultyId;
    private String facultyName;

    public String getName() {
        return name.trim();
    }
}
