package org.hibernate;

import javax.persistence.*;

/**
 * Subjective Question have multiple answer
 * This will be achieved by one to many mapping
 */
@Entity
@Table
public class SubjectiveAnswer {
    @Id
    private int answerId;
    private String answer;

    @ManyToOne
    private SubjectiveQuestion subjectiveQuestion;

    public SubjectiveAnswer() {
        super();
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public SubjectiveQuestion getSubjectiveQuestion() {
        return subjectiveQuestion;
    }

    public void setSubjectiveQuestion(SubjectiveQuestion subjectiveQuestion) {
        this.subjectiveQuestion = subjectiveQuestion;
    }

    @Override
    public String toString() {
        return "SubjectiveAnswer{" +
                "answerId=" + answerId +
                ", answer='" + answer + '\'' +
                ", question=" + subjectiveQuestion +
                '}';
    }
}
