package com.cheer.spring.dao.impl;

import com.cheer.spring.dao.EmpDao;
import com.cheer.spring.model.Emp;

public class EmpDaoImpl implements EmpDao {
    @Override
    public Emp getEmp() {
        Emp emp = new Emp();
        emp.setName("JJ");
        return emp;
    }
}
