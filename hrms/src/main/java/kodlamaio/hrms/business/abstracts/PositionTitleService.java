package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.PositionTitle;

public interface PositionTitleService {
	DataResult<List<PositionTitle>> getAll();
	Result addPositionTitle(PositionTitle positionTitle);
}
