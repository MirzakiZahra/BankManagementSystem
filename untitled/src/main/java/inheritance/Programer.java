package inheritance;

import lombok.Data;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@Setter
@DiscriminatorValue(value = "barnamenevis")
public class Programer  extends Employee{
    private String language;

}
