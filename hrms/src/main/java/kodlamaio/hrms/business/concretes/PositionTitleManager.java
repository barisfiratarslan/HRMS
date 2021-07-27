package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionTitleDao;
import kodlamaio.hrms.entities.concretes.PositionTitle;

@Service
public class PositionTitleManager implements PositionTitleService{

private PositionTitleDao positionTitleDao;
	
	@Autowired
	public PositionTitleManager(PositionTitleDao positionTitleDao) {
		super();
		this.positionTitleDao = positionTitleDao;
	}
	
	@Override
	public DataResult<List<PositionTitle>> getAll() {
		return new SuccessDataResult<List<PositionTitle>>(this.positionTitleDao.findAll(),"İş pozisyonları başarıyla listelendi");
	}

	@Override
	public Result addPositionTitle(PositionTitle positionTitle) {
		if(this.positionTitleDao.getByName(positionTitle.getName()).size()>0) {
			return new ErrorResult("İş pozisyonu bulunmaktadır!"); 
		}
		this.positionTitleDao.save(positionTitle);
		return new SuccessResult("İş pozisyonu eklenmiştir");
	}

}
