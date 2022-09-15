package org.hibernate;

import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );

        SessionFactory sessionFactory = new Configuration().configure(new File("src/main/java/Resources/hibernate.cfg.xml")).buildSessionFactory();
        System.out.println(sessionFactory);

        Student student = new Student();
        //student.setId(1); //no need to set id since we are using auto generated logic
        student.setName("Manmohan");
        student.setCity("Siwan");
        System.out.println(student);

        StudentAddress studentAddress = new StudentAddress();

        studentAddress.setCity("Siwan");
        studentAddress.setStreet("Kumhati");
        studentAddress.setOpen(true);
        studentAddress.setAddedDate(new Date());
        studentAddress.setX(12.12);
        FileInputStream fileInputStream = new FileInputStream("src/main/java/Resources/img.png");

        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);
        studentAddress.setImage(data);

        StudentCertificate studentCertificate = new StudentCertificate();
        studentCertificate.setCourse("backend");
        studentCertificate.setCourseDuration("2 Months");
        student.setStudentCertificate(studentCertificate);
        System.out.println(studentCertificate);

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.save(studentAddress);

        /**
         * One To one mapping with Question and Answer class
         */
        Question question = new Question();
        Answer answer = new Answer();

        question.setQuestion("Who is Lord Shiva");
        question.setQnsId(1);

        answer.setAnsId(1);
        answer.setAnswer("Supreme Leader");

        question.setAnswer(answer);

        /**
         * By saving question we can also save answer id
         * to save all entity of Answer, need to call save method for answer object also
         */
        session.save(question);

        answer.setQuestion(question);
        session.save(answer);

        /**
         * one to many case
         */
        SubjectiveQuestion subjectiveQuestion = new SubjectiveQuestion();
        subjectiveQuestion.setQuestionId(1);
        subjectiveQuestion.setQuestion("what is the properties of hibernate");

        SubjectiveAnswer subjectiveAnswer1 = new SubjectiveAnswer();
        subjectiveAnswer1.setAnswerId(1);
        subjectiveAnswer1.setAnswer("hibernate.connection.driver_class");

        SubjectiveAnswer subjectiveAnswer2 = new SubjectiveAnswer();
        subjectiveAnswer2.setAnswerId(2);
        subjectiveAnswer2.setAnswer("hibernate.connection.url");

        SubjectiveAnswer subjectiveAnswer3 = new SubjectiveAnswer();
        subjectiveAnswer3.setAnswerId(3);
        subjectiveAnswer3.setAnswer("hibernate.dialect");

        List<SubjectiveAnswer> answerList = new ArrayList<SubjectiveAnswer>();
        answerList.add(subjectiveAnswer1);
        answerList.add(subjectiveAnswer2);
        answerList.add(subjectiveAnswer3);

        subjectiveAnswer1.setSubjectiveQuestion(subjectiveQuestion);
        subjectiveAnswer2.setSubjectiveQuestion(subjectiveQuestion);
        subjectiveAnswer3.setSubjectiveQuestion(subjectiveQuestion);

        subjectiveQuestion.setAnswerList(answerList );

        session.save(subjectiveQuestion);
        session.save(subjectiveAnswer1);
        session.save(subjectiveAnswer2);
        session.save(subjectiveAnswer3);




        transaction.commit();
        student = (Student) session.get(Student.class,0);// to fetch the data from db
        System.out.println("Student "+student);





        session.close();
    }
}
