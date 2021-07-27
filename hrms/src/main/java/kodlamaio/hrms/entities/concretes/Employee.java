package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="employees")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User{
	
	@Column(name="employee_first_name")
	@NotBlank
	@NotNull
	private String name;
	
	@Column(name="employee_last_name")
	@NotBlank
	@NotNull
	private String surname;
	
	@Column(name="employee_tck")
	@NotBlank
	@NotNull
	private String tck;
	
	@Column(name="employee_birth_date")
	private Date birthDate;

	public Employee(int id, String email, String password, @NotBlank String name, @NotBlank String surname,
			@NotBlank String tck, Date birthDate) {
		super(id, email, password);
		this.name = name;
		this.surname = surname;
		this.tck = tck;
		this.birthDate = birthDate;
	}
}
