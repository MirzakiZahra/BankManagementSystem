package inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {


        Employee employee = new Employee();
        employee.setName("sara");
        employee.setFamily("akbari");
        Maneger maneger = new Maneger();
        maneger.setName("fateme");
        maneger.setFamily("razavi");
        maneger.setAdditinalSalery("10000");
        Programer programer=new Programer();
        programer.setName("akram");
        programer.setFamily("karimi");
        programer.setLanguage("java");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        session.save(programer);
        session.save(maneger);

        transaction.commit();
        session.close();
       // sessionFactory.close();
    }
}
