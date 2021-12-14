import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.loader.custom.sql.SQLQueryParser;

import java.util.Date;
import java.util.List;

public class Service {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void createAccount(User user, int accountNumber, int cardNumber,
                              Account.AccountType accountType, int balance, int cvv,
                              Date expire) {
        Account account = new Account(accountNumber, cardNumber, accountType,
                balance, cvv, expire, user);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
        //   sessionFactory.close();

    }

    public User createUser(String firstName, String lastName, int nationalCode
            , User.UserType userType) {
        User user = new User(firstName, lastName, nationalCode, userType);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return user;

    }

    public void close() {
        sessionFactory.close();
    }
    public List<User> findByFirstName(String firstName){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql="select * from user where firstName='"+firstName+"'";
        SQLQuery query=session.createSQLQuery(sql);
        query.addEntity(User.class);
        return query.list();

    }
    public List<User> findByLastName(String lastName){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql="select * from user where lastName = :lastName";
        SQLQuery query=session.createSQLQuery(sql);
        query.addEntity(User.class);
        return query.list();

    }
    

}
