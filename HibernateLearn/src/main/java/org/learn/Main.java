package org.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Tribhuvan");
        s1.setsAge(24);
        s1.setRoll_no(29);

        Student s2=null;

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.learn.Student.class);
//        cfg.configure();
        SessionFactory sf = new Configuration()
                            .addAnnotatedClass(org.learn.Student.class)
                            .configure()
                            .buildSessionFactory(); //cfg.buildSessionFactory();

        Session session = sf.openSession();
       //Transaction transaction = session.beginTransaction();

        //session.persist(s1);
        //transaction.commit();

        s2=session.find(Student.class,29);
        System.out.println(s2);
        session.close();
        sf.close();
        //System.out.println(s1);
    }
}