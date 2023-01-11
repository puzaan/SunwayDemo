package com.example.SunwayDemo.User.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectDTO {
    private Integer id;
    private String name;
    private String shortName;
    private Integer creditHrs;
    @Column(columnDefinition = "TEXT")
    private String details;
    private Integer facultyId;
}
