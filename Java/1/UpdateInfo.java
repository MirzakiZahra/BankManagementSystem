import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Data
@Setter
@Getter
public class UpdateInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private Date date;
    @ManyToOne
    private User user=new User();


}
