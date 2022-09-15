package org.hibernate;

import javax.persistence.*;

@Entity
@Table
public class Question {
    @Id
    @Column(name = "id")
    private int qnsId;
    private String question;


    @OneToOne
    private Answer answer;

    public Question() {
        super();
    }

    public int getQnsId() {
        return qnsId;
    }

    public void setQnsId(int qnsId) {
        this.qnsId = qnsId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "qnsId=" + qnsId +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
