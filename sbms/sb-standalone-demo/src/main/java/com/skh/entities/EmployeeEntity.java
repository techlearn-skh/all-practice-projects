package com.skh.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEES_ET")
public class EmployeeEntity {

    @Id
    @Column(name = "EMP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "EMP_ADDRESS")
    private String empAddress;

    @Column(name = "EMP_DOJ")
    @SuppressWarnings("deprecation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date empDOJ;

    @Column(name = "EMP_SALARY")
    private Double empSalary;

    @Column(name = "IS_PERM_EMP")
    @Convert(converter = YesNoConverter.class)
    private Boolean isPermenentEmp;


    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getEmpDOJ() {
        return empDOJ;
    }

    public void setEmpDOJ(Date empDOJ) {
        this.empDOJ = empDOJ;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public Boolean getPermenentEmp() {
        return isPermenentEmp;
    }

    public void setPermenentEmp(Boolean permenentEmp) {
        isPermenentEmp = permenentEmp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(empId, that.empId) && Objects.equals(empName, that.empName) && Objects.equals(empAddress, that.empAddress) && Objects.equals(empDOJ, that.empDOJ) && Objects.equals(empSalary, that.empSalary) && Objects.equals(isPermenentEmp, that.isPermenentEmp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empAddress, empDOJ, empSalary, isPermenentEmp);
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empDOJ=" + empDOJ +
                ", empSalary=" + empSalary +
                ", isPermenentEmp=" + isPermenentEmp +
                '}';
    }
}
