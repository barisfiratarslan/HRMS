package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advertisement_id")
	private int id;	
	
	@Column(name="job_advertisement_job_description")
	@NotBlank
	@NotNull
	private String jobDescription;
	
	@Column(name="job_advertisement_min_salary")
	private int minSalary;
	
	@Column(name="job_advertisement_max_salary")
	private int maxSalary;
	
	@Column(name="job_advertisement_open_position")
	private int openPosition;
	
	@Column(name="job_advertisement_last_date")
	private Date lastDate;
	
	@Column(name="job_advertisement_creation_date")
	private Date creationDate;
	
	@Column(name="job_advertisement_status")
	private boolean status;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="position_title_id")
	private PositionTitle positionTitle;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private Employer employer;
}
