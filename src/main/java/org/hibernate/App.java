package org.hibernate;

import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

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




        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.save(studentAddress);
        transaction.commit();
        student = (Student) session.get(Student.class,0);// to fetch the data from db
        System.out.println("Student"+student);
        session.close();
    }
}
