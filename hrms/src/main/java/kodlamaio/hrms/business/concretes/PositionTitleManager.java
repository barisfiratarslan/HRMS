package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionTitleService;
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
	public List<PositionTitle> getAll() {
		return this.positionTitleDao.findAll();
	}

}
