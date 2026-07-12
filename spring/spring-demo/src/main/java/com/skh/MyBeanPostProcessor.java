package com.skh;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(
            Object bean, String beanName)
            throws BeansException {

        System.out.println(
                "6. BeanPostProcessor.postProcessBeforeInitialization() called");

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(
            Object bean, String beanName)
            throws BeansException {

        System.out.println(
                "10. BeanPostProcessor.postProcessAfterInitialization() called");

        return bean;
    }
}