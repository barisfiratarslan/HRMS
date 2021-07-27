package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.fakeServices.EmailService;
import kodlamaio.hrms.fakeServices.MernisService;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	private MernisService mernisService;
	private EmailService emailService;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, MernisService mernisService, EmailService emailService) {
		super();
		this.employeeDao = employeeDao;
		this.mernisService = mernisService;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"İş arayanlar başarıyla listelendi");
	}

	@Override
	public Result addEmployee(Employee employee) {
		if(!this.emailService.verificationEmail(employee.getEmail())) {
			return new ErrorResult("Email doğrulaması başarısız!! Emailinizi kontrol ediniz.");
		}
		if(!this.mernisService.verificationMernis(employee.getTck())) {
			return new ErrorResult("Mernis doğrulaması başarısız!! TCK no kontrol ediniz.");
		}
		if(this.employeeDao.getByEmail(employee.getEmail()).size()!=0) {
			return new ErrorResult("Aynı maile sahip başka kullanıcı bulunmaktadır");
		}
		if(this.employeeDao.getByTck(employee.getTck()).size()!=0) {
			return new ErrorResult("Aynı TCK no sahip başka kullanıcı bulunmaktadır");
		}
		this.employeeDao.save(employee);
		return new SuccessResult("İş arayan başarıyla eklenmiştir");
	}

}
