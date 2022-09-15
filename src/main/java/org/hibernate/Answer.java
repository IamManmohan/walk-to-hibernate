package org.hibernate;

import javax.persistence.*;

@Entity
@Table
public class Answer {
    @Id
    @Column(name = "id")
    private int ansId;
    private String answer;

    /**
     * if we use one to one mapping for bath Question and Answer class then both table will maintain foreign key
     * but by using mappedBy property of one to one join
     * here we are applying mapped by property to answer table on Question so entry will maintain in Question table
     */
    @OneToOne(mappedBy = "answer")
    private Question question;

    public Answer() {
        super();
    }

    public Answer(int ansId, String answer, Question question) {
        this.ansId = ansId;
        this.answer = answer;
        this.question = question;
    }

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "ansId=" + ansId +
                ", answer='" + answer + '\'' +
                ", question=" + question +
                '}';
    }
}
