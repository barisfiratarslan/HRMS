package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı başarıyla eklenmiştir");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDetails());
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsSorted() {
		Sort sort=Sort.by(Sort.Direction.ASC, "lastDate");
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDetailsSorted(sort));
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByCompanyName(@RequestParam String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDetailsByCompanyName(companyName));
	}

	@Override
	public Result updateStatus(int jobAdvertisementId) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.getById(jobAdvertisementId);
		jobAdvertisement.setStatus(false);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı başarıyla güncellenmiştir");
	}
}
