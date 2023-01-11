package com.example.SunwayDemo.User.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private Integer id;

    private String name;


    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    private String phoneNo;
    private String rollNum;

    private  String batch;


    private Integer facultyId;
    private String facultyName;

    public String getName() {
        return name.trim();
    }
}
