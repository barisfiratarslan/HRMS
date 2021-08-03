package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(j.id, p.name, j.jobDescription, j.minSalary, j.maxSalary, j.openPosition, j.lastDate, j.creationDate, j.status, c.cityName, e.companyName) From JobAdvertisement j Inner Join j.city c Inner Join j.positionTitle p Inner Join j.employer e Where j.status=true")
	List<JobAdvertisementDto> getJobAdvertisementDetails();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(j.id, p.name, j.jobDescription, j.minSalary, j.maxSalary, j.openPosition, j.lastDate, j.creationDate, j.status, c.cityName, e.companyName) From JobAdvertisement j Inner Join j.city c Inner Join j.positionTitle p Inner Join j.employer e Where j.status=true")
	List<JobAdvertisementDto> getJobAdvertisementDetailsSorted(Sort sort);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(j.id, p.name, j.jobDescription, j.minSalary, j.maxSalary, j.openPosition, j.lastDate, j.creationDate, j.status, c.cityName, e.companyName) From JobAdvertisement j Inner Join j.city c Inner Join j.positionTitle p Inner Join j.employer e Where j.status=true and e.companyName=:companyName")
	List<JobAdvertisementDto> getJobAdvertisementDetailsByCompanyName(String companyName);
}
