package com.example.SunwayDemo.User.entity.subjects;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "subjects")
@Builder
@DynamicInsert
@DynamicUpdate
public class Subjects extends RepresentationModel<Subjects> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String shortName;
    private Integer creditHrs;
    @Column(columnDefinition = "TEXT")
    private String details;

    public void setResource(Links resource) {
        this.add(resource);
    }


}
