package com.hibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Grade")
public class Grade {
    @Id
    @Column(name="gId")
    private int id;

    @Column(name="gradeName")
    private String gradeName;

    @OneToMany
    @JoinColumn(name="gradeId")
    private List<Student> studentList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
