package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	private int id;	
	private String positionName;
	private String jobDescription;
	private int minSalary;
	private int maxSalary;
	private int openPosition;
	private Date lastDate;
	private Date creationDate;
	private boolean status;
	private String cityName;
	private String companyName;
}
