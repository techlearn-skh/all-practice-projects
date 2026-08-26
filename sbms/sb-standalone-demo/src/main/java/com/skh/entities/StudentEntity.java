package com.skh.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "STU_ET")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private Integer stuId;

    @Column(name = "STUDENT_NAME")
    private String stuName;

    @Column(name = "STUDENT_CLASS")
    private String stuClass;

    @Column(name = "STUDENT_SECTION")
    private String stuSection;

    @Column(name = "STUDENT_GRADE")
    private Integer stuGrade;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuSection() {
        return stuSection;
    }

    public void setStuSection(String stuSection) {
        this.stuSection = stuSection;
    }

    public Integer getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(Integer stuGrade) {
        this.stuGrade = stuGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(stuId, that.stuId) && Objects.equals(stuName, that.stuName) && Objects.equals(stuClass, that.stuClass) && Objects.equals(stuSection, that.stuSection) && Objects.equals(stuGrade, that.stuGrade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, stuName, stuClass, stuSection, stuGrade);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuSection='" + stuSection + '\'' +
                ", stuGrade=" + stuGrade +
                '}';
    }
}
