
package com.skh;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EmployeeService implements
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean {

    private String employeeName;

    // 1. Constructor
    public EmployeeService() {
        System.out.println("1. Constructor called");
    }

    // 2. Setter Injection
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        System.out.println("2. Setter Injection called");
    }

    // 3. BeanNameAware
    @Override
    public void setBeanName(String name) {
        System.out.println("3. BeanNameAware.setBeanName() called");
    }

    // 4. BeanFactoryAware
    @Override
    public void setBeanFactory(BeanFactory beanFactory)
            throws BeansException {
        System.out.println("4. BeanFactoryAware.setBeanFactory() called");
    }

    // 5. ApplicationContextAware
    @Override
    public void setApplicationContext(
            ApplicationContext applicationContext)
            throws BeansException {
        System.out.println(
                "5. ApplicationContextAware.setApplicationContext() called");
    }

    // 6. InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(
                "7. InitializingBean.afterPropertiesSet() called");
    }

    // 7. Custom init-method
    public void customInit() {
        System.out.println("8. Custom init-method called");
    }

    public void display() {
        System.out.println(
                "Bean is ready for use. Employee Name = " + employeeName);
    }

    // 8. DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("12. DisposableBean.destroy() called");
    }

    // 9. Custom destroy-method
    public void customDestroy() {
        System.out.println("13. Custom destroy-method called");
    }
}

