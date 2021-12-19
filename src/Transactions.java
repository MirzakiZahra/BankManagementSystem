import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter

public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fee;
    private Date date;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @ManyToOne
    private Account account=new Account();

    public Transactions() {
    }

    public Transactions(int fee, Date date, TransactionType transactionType, Account account) {
        this.fee = fee;
        this.date = date;
        this.transactionType = transactionType;
        this.account = account;
    }

    enum TransactionType{
        DEPOSIT,WITHDRAW
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "id=" + id +
                ", fee=" + fee +
                ", date=" + date +
                ", transactionType=" + transactionType +
                ", account=" + account +
                '}';
    }
}
