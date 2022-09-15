package org.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Subgraph;
@Embeddable
public class StudentCertificate {

    private String course;

    @Column(name = "certificate_duration")
    private String courseDuration;

    public StudentCertificate() {
        super();
    }

    public StudentCertificate(String course, String courseDuration) {
        this.course = course;
        this.courseDuration = courseDuration;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    @Override
    public String toString() {
        return "StudentCertificate{" +
                "course='" + course + '\'' +
                ", courseDuration='" + courseDuration + '\'' +
                '}';
    }
}
