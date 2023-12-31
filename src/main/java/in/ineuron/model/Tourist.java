package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Tourist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tid;
	private String name;
	private String city;
	private String packageType;
	private Double budget;

	
}
