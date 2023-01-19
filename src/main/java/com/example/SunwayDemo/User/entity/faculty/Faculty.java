package com.example.SunwayDemo.User.entity.faculty;

import com.example.SunwayDemo.User.entity.subjects.Subjects;
import lombok.*;
import org.hibernate.mapping.Selectable;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "faculty")
public class Faculty extends RepresentationModel<Faculty> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String shortName;

    @Column(columnDefinition = "TEXT")
    private String details;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name = "faculty_id", foreignKey = @ForeignKey(name = "FK_FACULTY_SUBJECTS"))
    private List<Subjects> subjectsList;


    public void setResource(Links resource) {
        this.add(resource);
    }

    public Faculty(Integer id) {
        this.id = id;
    }

}
