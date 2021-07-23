package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.PositionTitleService;
import kodlamaio.hrms.entities.concretes.PositionTitle;

@RestController
@RequestMapping("/api/positiontitles")
public class PositionTitleController {
	
	private PositionTitleService positionTitleService;
	
	@Autowired
	public PositionTitleController(PositionTitleService positionTitleService) {
		super();
		this.positionTitleService = positionTitleService;
	}
	
	@GetMapping("/getall")
	public List<PositionTitle> getAll(){
		return this.positionTitleService.getAll();
	}
}
