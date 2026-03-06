package com.skh.models;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeVO {


    private Integer empId;
    private String empName;
    private Date empDOJ;
    private Double empSalary;
    private Boolean isPermenentEmp;

    public static String companyType = "IN";

    public EmployeeVO() {

    }

    public EmployeeVO(Integer empId, String empName, Date empDOJ, Double empSalary, Boolean isPermenentEmp) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.empDOJ = empDOJ;
        this.empSalary = empSalary;
        this.isPermenentEmp = isPermenentEmp;
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

    public Boolean getIsPermenentEmp() {
        return isPermenentEmp;
    }

    public void setIsPermenentEmp(Boolean isPermenentEmp) {
        this.isPermenentEmp = isPermenentEmp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empDOJ, empId, empName, empSalary, isPermenentEmp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmployeeVO other = (EmployeeVO) obj;
        return Objects.equals(empDOJ, other.empDOJ) && Objects.equals(empId, other.empId)
                && Objects.equals(empName, other.empName) && Objects.equals(empSalary, other.empSalary)
                && Objects.equals(isPermenentEmp, other.isPermenentEmp);
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", empDOJ=" + empDOJ + ", empSalary=" + empSalary
                + ", isPermenentEmp=" + isPermenentEmp + "]" + "\n";
    }

    public static List<EmployeeVO> fetchAllEmployees() {

        Random random = new Random();
        return IntStream.range(0, 5)
                .mapToObj(x -> new EmployeeVO((Math.abs(random.nextInt() % 100)), UUID.randomUUID().toString().substring(0, 8),
                        (random.nextInt() % 2 == 0 ? new Date() : new Date(new Date().getTime() + 86400000)),
                        Math.ceil(random.nextDouble() * 100000), ((Math.abs(random.nextInt() % 100)) % 2 == 0)))
                .collect(Collectors.toList());
    }

    public static List<EmployeeVO> fetchAllEmployeesCustomized() {
        Random random = new Random();
        List<EmployeeVO> customizedEmpList = IntStream.range(0, 5)
                .mapToObj(x -> new EmployeeVO((Math.abs(random.nextInt() % 100)), UUID.randomUUID().toString().substring(0, 8),
                        (random.nextInt() % 2 == 0 ? new Date() : new Date(new Date().getTime() + 86400000)),
                        Math.ceil(random.nextDouble() * 100000), ((Math.abs(random.nextInt() % 100)) % 2 == 0)))
                .collect(Collectors.toList());
        customizedEmpList.add(new EmployeeVO(1, "kamal", new Date(), 12345d, true));
        customizedEmpList.add(new EmployeeVO(2, "kamal", new Date(), 45675d, false));
        customizedEmpList.add(new EmployeeVO(3, "shaik", new Date(), 12345d, true));
        customizedEmpList.add(new EmployeeVO(4, "Roopak", new Date(), 12345d, false));
        return customizedEmpList;
    }

    public static EmployeeVO[] fetchAllEmployeesArrayCustomized() {
        EmployeeVO[] empArraCustomized = new EmployeeVO[5];
        empArraCustomized[0] = new EmployeeVO(1, "kamal", new Date(), 3000d, true);
        empArraCustomized[1] = new EmployeeVO(2, "kamal", new Date(), 4000d, false);
        empArraCustomized[2] = new EmployeeVO(3, "shaik", new Date(), 5000d, true);
        empArraCustomized[3] = new EmployeeVO(4, "john", new Date(), 6000d, false);
        empArraCustomized[4] = new EmployeeVO(4, "john", new Date(), 7000d, false);
        return empArraCustomized;
    }

    public void displayEmployee(EmployeeVO e) {
        System.out.println(e);

    }

}
