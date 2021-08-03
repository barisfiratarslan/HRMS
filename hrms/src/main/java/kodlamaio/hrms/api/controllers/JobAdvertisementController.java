package kodlamaio.hrms.api.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
		jobAdvertisement.setCreationDate(new Date());
		return this.jobAdvertisementService.addJobAdvertisement(jobAdvertisement);
	}
	
	@PostMapping("/updatestatus")
	public Result updateStatus(int jobAdvertisementId){
		return this.jobAdvertisementService.updateStatus(jobAdvertisementId);
	}
	
	@GetMapping("/getDetails")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetails(){
		return this.jobAdvertisementService.getJobAdvertisementDetails();
	}
	
	@GetMapping("/getDetailsSorted")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsSorted(){
		return this.jobAdvertisementService.getJobAdvertisementDetailsSorted();
	}
	
	@GetMapping("/getDetailsByCompanyName")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByCompanyName(String companyName){
		return this.jobAdvertisementService.getJobAdvertisementDetailsByCompanyName(companyName);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors=new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
}
