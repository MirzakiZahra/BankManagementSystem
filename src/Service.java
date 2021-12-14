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
         //  sessionFactory.close();

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
        String sql="select * from user where firstName= :firstName";
        SQLQuery query=session.createSQLQuery(sql);
        query.addEntity(User.class);
        query.setParameter("firstName",firstName);
        List<User>list= query.list();
        session.close();
        return list;

    }
    public List<User> findByLastName(String lastName){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql="select * from user where lastName = :lastName";
        SQLQuery query=session.createSQLQuery(sql);
        query.addEntity(User.class);
        query.setParameter("lastName",lastName);
        List<User>list= query.list();
        session.close();
        return list;

    }
    public User findByCardNumber(int cardNumber){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql="select * from account where cardNumber = :cardNumber";
        SQLQuery query=session.createSQLQuery(sql);
        query.addEntity(Account.class);
        query.setParameter("cardNumber",cardNumber);
        Account account= (Account) query.list().get(0);
        session.close();
        return account.getUser();

    }
    public Account findAccountByCardNumber(int cardNumber){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql="select * from account where cardNumber = :cardNumber";
        SQLQuery query=session.createSQLQuery(sql);
        query.addEntity(Account.class);
        query.setParameter("cardNumber",cardNumber);
        Account account= (Account) query.list().get(0);
        session.close();
        return account;

    }
    public void withdraw(int caredNumber,int fee){
        Account account= findAccountByCardNumber(caredNumber);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        account = session.load(Account.class,account.getId());
        float temp=account.getBalance()-fee;
        account.setBalance(temp);
        session.update(account);
        transaction.commit();
        session.close();



    }


}
