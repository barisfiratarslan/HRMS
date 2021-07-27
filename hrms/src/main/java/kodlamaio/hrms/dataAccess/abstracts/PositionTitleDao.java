package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.PositionTitle;

public interface PositionTitleDao extends JpaRepository<PositionTitle,Integer> {
	List<PositionTitle> getByName(String name);
}
