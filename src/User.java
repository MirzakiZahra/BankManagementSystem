import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int nationalCode;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Account> accountList = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @CreationTimestamp
    private Date creationDate;
    @UpdateTimestamp
    private Date lastUpdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UpdateInfo> updateInfos = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, int nationalCode, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode=" + nationalCode +
                ", userType=" + userType +
                '}';
    }

    enum UserType {
        GOODDEALLER, BADDEALER, NOHISTORY;
    }


}
