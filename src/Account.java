import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int accountNumber;
    private int cardNumber;
    @CreationTimestamp
    private Date openDate;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private float balance;
    private int cvv;
    @Timestamp
    private Date expire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account",fetch = FetchType.EAGER)
    private List<Transactions>transactionList=new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

  //  public User getUser() {
    //    return user;
    //}

    public Account() {
    }

    public Account(int accountNumber, int cardNumber, AccountType accountType, float balance, int cvv, Date expire, User user) {
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.cvv = cvv;
        this.expire = expire;
        this.user = user;
    }

    enum AccountType {
        INTERESTFREE,CURRENT,LONGTERM,SHORTTERM
    }
}
