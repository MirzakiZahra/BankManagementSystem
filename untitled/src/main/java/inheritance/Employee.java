package inheritance;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name= "employee-Type")
@DiscriminatorValue(value = "karmand")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String name;
    private String family;

}
