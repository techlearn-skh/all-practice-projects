package com.skh;


public final class EmployeeImmutable {
    private final Integer empId;
    private final String empName;
    private final Double empSalary;
    private final Boolean isPermenentEmp;

    public EmployeeImmutable(Integer empId, String empName, Double empSalary, Boolean isPermenentEmp) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.isPermenentEmp = isPermenentEmp;
    }

    public Boolean getPermenentEmp() {
        return isPermenentEmp;
    }

    public Double getEmpSalary() {
        return empSalary;
    }


    public String getEmpName() {
        return empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    @Override
    public String toString() {
        return "EmployeeImmutable{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", isPermenentEmp=" + isPermenentEmp +
                '}';
    }
}
