package com.skh;

import java.util.Comparator;

public class EmployeeSortByName implements Comparator<EmployeeVO> {
    @Override
    public int compare(EmployeeVO o1, EmployeeVO o2) {
        return o1.getEmpName().compareTo(o2.getEmpName());
    }
}
