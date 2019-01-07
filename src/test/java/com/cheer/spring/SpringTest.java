package com.cheer.spring;

import com.cheer.spring.dao.EmpDao;
import com.cheer.spring.dao.impl.EmpDaoImpl;
import com.cheer.spring.model.Emp;
import com.cheer.spring.model.Person;
import com.cheer.spring.service.EmpService;
import com.cheer.spring.service.impl.EmpServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class SpringTest {
    private static final Logger LOGGER = LogManager.getLogger(SpringTest.class);

    @Test
    public void createObject() throws ClassNotFoundException, IllegalAccessException, InstantiationError, NoSuchMethodException, InvocationTargetException, InstantiationException {
        // new style
        Person person = new Person();
        person.setName("贾分秒");
        LOGGER.debug(person);

        // java reflect style
        // 获取Class对象
        Class<?> clazz = Class.forName("com.cheer.spring.model.Person");
        // 创建对象
        Object obj = clazz.newInstance();
        // 获取方法对象
        Method setter = clazz.getDeclaredMethod("setName", String.class);
        // 调用对象
        setter.invoke(obj,"非常爱");
        LOGGER.debug(obj);

        // Spring style
        // 获取Spring应用对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring.beans.xml");
        // 获取实例
        Person person1 = applicationContext.getBean(Person.class);
        person1.setName("吔屎!");
        LOGGER.debug(person1);
    }

    @Test
    public void dependency() {
        // old style
        EmpService empService = new EmpServiceImpl();
        EmpDao empDao = new EmpDaoImpl();
        // setter
        ((EmpServiceImpl)empService).setEmpDao(empDao);
        Emp emp = empService.getEmp();
        System.out.println(emp);

        // spring style
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring.beans.xml");
        EmpService empService1 = applicationContext.getBean(EmpService.class);
        Emp emp1 = empService1.getEmp();
        System.out.println(emp1);
    }
}
