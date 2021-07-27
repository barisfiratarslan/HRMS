package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.fakeServices.EmailService;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private EmailService emailService;

	public EmployerManager(EmployerDao employerDao, EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi.");
	}

	@Override
	public Result addEmployer(Employer employer) {
		if(!this.emailService.verificationEmail(employer.getEmail())) {
			return new ErrorResult("Email doğrulaması başarısız!! Emailinizi kontrol ediniz.");
		}
		if(!employer.getEmail().split("@")[1].equals(employer.getWebsite())) {
			return new ErrorResult("Email website ile aynı domaine sahip olmak zorundadır!");
		}
		this.employerDao.save(employer);
		return new SuccessResult("İş veren başarıyla eklenmiştir");
	}
}
