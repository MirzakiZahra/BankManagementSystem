import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Service {
   static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public void createAccount(User user, int accountNumber, int cardNumber,
                              Account.AccountType accountType, int balance, int cvv,
                              Date expire ){
        Account account=new Account(accountNumber,cardNumber,accountType,
                balance,cvv,expire,user);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }

    public void createUser(String firstName, String lastName, int nationalCode
            , User.UserType userType) {

    }
}
