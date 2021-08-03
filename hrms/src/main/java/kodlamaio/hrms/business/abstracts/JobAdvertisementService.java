package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails();
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsSorted();
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByCompanyName(String companyName);
	Result addJobAdvertisement(JobAdvertisement jobAdvertisement);
	Result updateStatus(int jobAdvertisementId);
}
