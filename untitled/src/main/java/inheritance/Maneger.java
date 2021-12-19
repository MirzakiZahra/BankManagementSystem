package inheritance;

import lombok.Data;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
@Setter
@DiscriminatorValue(value = "modir")
 public class Maneger  extends Employee{
    private String additinalSalery;

}
