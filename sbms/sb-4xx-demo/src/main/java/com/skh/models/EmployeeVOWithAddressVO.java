package com.skh.models;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeVOWithAddressVO {


    private Integer empId;
    private String empName;
    private Date empDOJ;
    private Double empSalary;
    private Boolean isPermenentEmp;

    private List<AddressVO> eAddressList;

    public static String companyType = "IN";

    public EmployeeVOWithAddressVO() {

    }

    public EmployeeVOWithAddressVO(Integer empId, String empName, Date empDOJ, Double empSalary, Boolean isPermenentEmp, List<AddressVO> eAddressList) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.empDOJ = empDOJ;
        this.empSalary = empSalary;
        this.isPermenentEmp = isPermenentEmp;
        this.eAddressList = eAddressList;
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

    public Boolean getPermenentEmp() {
        return isPermenentEmp;
    }

    public void setPermenentEmp(Boolean permenentEmp) {
        isPermenentEmp = permenentEmp;
    }

    public List<AddressVO> geteAddressList() {
        return eAddressList;
    }

    public void seteAddressList(List<AddressVO> eAddressList) {
        this.eAddressList = eAddressList;
    }

    public static String getCompanyType() {
        return companyType;
    }

    public static void setCompanyType(String companyType) {
        EmployeeVOWithAddressVO.companyType = companyType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeVOWithAddressVO that = (EmployeeVOWithAddressVO) o;
        return Objects.equals(empId, that.empId) && Objects.equals(empName, that.empName) && Objects.equals(empDOJ, that.empDOJ) && Objects.equals(empSalary, that.empSalary) && Objects.equals(isPermenentEmp, that.isPermenentEmp) && Objects.equals(eAddressList, that.eAddressList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empDOJ, empSalary, isPermenentEmp, eAddressList);
    }

    @Override
    public String toString() {
        return "EmployeeVOWithAddressVO{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empDOJ=" + empDOJ +
                ", empSalary=" + empSalary +
                ", isPermenentEmp=" + isPermenentEmp +
                ", eAddressList=" + eAddressList +
                '}';
    }

    public static List<EmployeeVOWithAddressVO> fetchAllEmployees() {


        Random random = new Random();
        return IntStream.range(0, 5)
                .mapToObj(x -> new EmployeeVOWithAddressVO((Math.abs(random.nextInt() % 100)), UUID.randomUUID().toString().substring(0, 8),
                        (random.nextInt() % 2 == 0 ? new Date() : new Date(new Date().getTime() + 86400000)),
                        Math.ceil(random.nextDouble() * 100000), ((Math.abs(random.nextInt() % 100)) % 2 == 0),
                        List.of(new AddressVO(UUID.randomUUID().toString().substring(0, 8),UUID.randomUUID().toString().substring(0, 8),
                                UUID.randomUUID().toString().substring(0, 8), UUID.randomUUID().toString().substring(0, 6),UUID.randomUUID().toString().substring(0, 8)))))
                .collect(Collectors.toList());
    }

    public static List<EmployeeVOWithAddressVO> fetchAllEmployeesCustomized() {
        AddressVO addressVO = new AddressVO(UUID.randomUUID().toString().substring(0, 8), UUID.randomUUID().toString().substring(0, 8),
                UUID.randomUUID().toString().substring(0, 8), UUID.randomUUID().toString().substring(0, 6), UUID.randomUUID().toString().substring(0, 8));


        Random random = new Random();
        List<EmployeeVOWithAddressVO> customizedEmpList = IntStream.range(0, 5)
                .mapToObj(x -> new EmployeeVOWithAddressVO((Math.abs(random.nextInt() % 100)), UUID.randomUUID().toString().substring(0, 8),
                        (random.nextInt() % 2 == 0 ? new Date() : new Date(new Date().getTime() + 86400000)),
                        Math.ceil(random.nextDouble() * 100000), ((Math.abs(random.nextInt() % 100)) % 2 == 0), List.of(addressVO)))
                .collect(Collectors.toList());
        customizedEmpList.add(new EmployeeVOWithAddressVO(1, "kamal", new Date(), 12345d, true, List.of(addressVO)));
        customizedEmpList.add(new EmployeeVOWithAddressVO(2, "kamal", new Date(), 45675d, false, List.of(addressVO)));
        customizedEmpList.add(new EmployeeVOWithAddressVO(3, "shaik", new Date(), 12345d, true, List.of(addressVO)));
        customizedEmpList.add(new EmployeeVOWithAddressVO(4, "Roopak", new Date(), 12345d, false, List.of(addressVO)));
        return customizedEmpList;
    }

    public static EmployeeVOWithAddressVO[] fetchAllEmployeesArrayCustomized() {
        AddressVO addressVO = new AddressVO(UUID.randomUUID().toString().substring(0, 8), UUID.randomUUID().toString().substring(0, 8),
                UUID.randomUUID().toString().substring(0, 8), UUID.randomUUID().toString().substring(0, 6), UUID.randomUUID().toString().substring(0, 8));

        EmployeeVOWithAddressVO[] empArraCustomized = new EmployeeVOWithAddressVO[5];
        empArraCustomized[0] = new EmployeeVOWithAddressVO(1, "kamal", new Date(), 3000d, true, List.of(addressVO));
        empArraCustomized[1] = new EmployeeVOWithAddressVO(2, "kamal", new Date(), 4000d, false, List.of(addressVO));
        empArraCustomized[2] = new EmployeeVOWithAddressVO(3, "shaik", new Date(), 5000d, true, List.of(addressVO));
        empArraCustomized[3] = new EmployeeVOWithAddressVO(4, "john", new Date(), 6000d, false, List.of(addressVO));
        empArraCustomized[4] = new EmployeeVOWithAddressVO(4, "john", new Date(), 7000d, false, List.of(addressVO));
        return empArraCustomized;
    }

    public void displayEmployee(EmployeeVOWithAddressVO e) {
        System.out.println(e);

    }

}
