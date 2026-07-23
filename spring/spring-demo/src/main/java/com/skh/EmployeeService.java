
package com.skh;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EmployeeService implements BeanPostProcessor {

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

    // 7. Custom init-method
    public void init() {
        System.out.println("8. Custom init-method called");
    }


    // 8. DisposableBean
    public void destroy() throws Exception {
        System.out.println("12. DisposableBean.destroy() called");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {

        System.out.println("BeforeInitialization : " + beanName);
        return bean;  // you can return any other object as well
    }
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {

        System.out.println("AfterInitialization : " + beanName);
        return bean;  // you can return any other object as well
    }

    @Override
    public String toString() {
        return "EmployeeService{" +
                "employeeName='" + employeeName + '\'' +
                '}';
    }
}

