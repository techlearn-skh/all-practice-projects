package com.skh;

import java.util.Comparator;

public class EmployeeortById implements Comparator<EmployeeVO> {
    @Override
    public int compare(EmployeeVO o1, EmployeeVO o2) {
        return o1.getEmpId() - o2.getEmpId();
    }
}
