package org.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table
public class SubjectiveQuestion {
    @Id
    private int questionId;
    private String question;

    /**
     * here we are grouping on question on Subjective Answer table
     * so entry will maintain in subjective answer table
     */
    @OneToMany(mappedBy = "subjectiveQuestion")
    private List<SubjectiveAnswer> answerList;

    public SubjectiveQuestion() {
        super();
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<SubjectiveAnswer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<SubjectiveAnswer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String  toString() {
        return "SubjectiveQuestion{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
