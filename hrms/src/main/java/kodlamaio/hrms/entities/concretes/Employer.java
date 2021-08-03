package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_advertisements"})
public class Employer extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employer_id")
	private int id;

	@Column(name="employer_company_name")
	@NotBlank
	@NotNull
	private String companyName;

	@Column(name="employer_website")
	@NotBlank
	@NotNull
	private String website;

	@Column(name="employer_phone")
	@NotBlank
	@NotNull
	private String phone;

	public Employer(int id, String email, String password, int id2, @NotBlank String companyName,
			@NotBlank String website, @NotBlank String phone) {
		super(id, email, password);
		id = id2;
		this.companyName = companyName;
		this.website = website;
		this.phone = phone;
	}	
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
}
