package com.cheer.spring.service.impl;

import com.cheer.spring.dao.EmpDao;
import com.cheer.spring.dao.impl.EmpDaoImpl;
import com.cheer.spring.model.Emp;
import com.cheer.spring.service.EmpService;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao;

    public EmpDao getEmpDao() {
        return empDao;
    }

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    @Override
    public Emp getEmp() {
        Emp emp = empDao.getEmp();
        return emp;
    }
}
