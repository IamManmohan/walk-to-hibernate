package org.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private String city;

    private StudentCertificate studentCertificate;

    public StudentCertificate getStudentCertificate() {
        return studentCertificate;
    }

    public void setStudentCertificate(StudentCertificate studentCertificate) {
        this.studentCertificate = studentCertificate;
    }

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Student() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", studentCertificate=" + studentCertificate +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
