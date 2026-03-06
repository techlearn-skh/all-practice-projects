package com.skh;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeVOTest  implements  Comparable<EmployeeVOTest>{


    private Integer empId;
    private String empName;
    private Date empDOJ;
    private Double empSalary;
    private Boolean isPermenentEmp;

    public static String companyType = "IN";

    public EmployeeVOTest() {

    }

    public EmployeeVOTest(Integer empId, String empName, Date empDOJ, Double empSalary, Boolean isPermenentEmp) {
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
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", empDOJ=" + empDOJ + ", empSalary=" + empSalary
                + ", isPermenentEmp=" + isPermenentEmp + "]" + "\n";
    }

    public static List<EmployeeVOTest> fetchAllEmployees() {

        Random random = new Random();
        return IntStream.range(0, 5)
                .mapToObj(x -> new EmployeeVOTest((Math.abs(random.nextInt() % 100)), UUID.randomUUID().toString().substring(0, 8),
                        (random.nextInt() % 2 == 0 ? new Date() : new Date(new Date().getTime() + 86400000)),
                        Math.ceil(random.nextDouble() * 100000), ((Math.abs(random.nextInt() % 100)) % 2 == 0)))
                .collect(Collectors.toList());
    }

    public static List<EmployeeVOTest> fetchAllEmployeesCustomized() {
        Random random = new Random();
        List<EmployeeVOTest> customizedEmpList = IntStream.range(0, 5)
                .mapToObj(x -> new EmployeeVOTest((Math.abs(random.nextInt() % 100)), UUID.randomUUID().toString().substring(0, 8),
                        (random.nextInt() % 2 == 0 ? new Date() : new Date(new Date().getTime() + 86400000)),
                        Math.ceil(random.nextDouble() * 100000), ((Math.abs(random.nextInt() % 100)) % 2 == 0)))
                .collect(Collectors.toList());
        customizedEmpList.add(new EmployeeVOTest(1, "kamal", new Date(), 12345d, true));
        customizedEmpList.add(new EmployeeVOTest(2, "kamal", new Date(), 45675d, false));
        customizedEmpList.add(new EmployeeVOTest(3, "shaik", new Date(), 12345d, true));
        customizedEmpList.add(new EmployeeVOTest(4, "john", new Date(), 12345d, false));
        return customizedEmpList;
    }

    public static EmployeeVOTest[] fetchAllEmployeesArrayCustomized() {
        EmployeeVOTest[] empArraCustomized = new EmployeeVOTest[5];
        empArraCustomized[0] = new EmployeeVOTest(1, "kamal", new Date(), 3000d, true);
        empArraCustomized[1] = new EmployeeVOTest(2, "kamal", new Date(), 4000d, false);
        empArraCustomized[2] = new EmployeeVOTest(3, "shaik", new Date(), 5000d, true);
        empArraCustomized[3] = new EmployeeVOTest(4, "john", new Date(), 6000d, false);
        empArraCustomized[4] = new EmployeeVOTest(4, "john", new Date(), 7000d, false);
        return empArraCustomized;
    }

    public void displayEmployee(Employee e) {
        System.out.println(e);

    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeVOTest that = (EmployeeVOTest) o;
        return Objects.equals(empId, that.empId) && Objects.equals(empName, that.empName) && Objects.equals(empDOJ, that.empDOJ) && Objects.equals(empSalary, that.empSalary) && Objects.equals(isPermenentEmp, that.isPermenentEmp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empDOJ, empSalary, isPermenentEmp);
    }

    @Override
    public int compareTo(EmployeeVOTest o) {
        return this.getEmpName().compareTo(o.getEmpName());
    }
}
