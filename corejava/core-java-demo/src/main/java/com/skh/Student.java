package com.skh;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Student {
    String name;

    Integer id;

    String subject;

    Double percentage;

    public Student(String name, Integer id, String subject, Double percentage) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", subject='" + subject + '\'' +
                ", percentage=" + percentage +
                '}';
    }

    public static List<Student> fetchAllStudents() {

        Random random = new Random();
        return IntStream.range(0, 5)
                .mapToObj(x -> new Student(UUID.randomUUID().toString().substring(0, 8), (Math.abs(random.nextInt() % 100)),
                        UUID.randomUUID().toString().substring(0, 8),
                        Math.ceil(random.nextDouble() * 100000)))
                .collect(Collectors.toList());
    }
}