package net.frojas.pathologyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.frojas.pathologyservice.models.Diseases;
import net.frojas.pathologyservice.models.DiseasesList;

@RestController
@RequestMapping("/pathology")
public class PathologyResources {

	List<Diseases> diseases = Arrays.asList(
		new Diseases("D1", "Ashma", "Warm water bath"),
		new Diseases("D2", "Thyphoid", "Ampicilin capsule")
	);
	
	@RequestMapping("/diseases")
	public DiseasesList getDiseases() {
		DiseasesList diseasesList = new DiseasesList();
		diseasesList.setDiseases(diseases); 
		return diseasesList;
	}
	
	@RequestMapping("/diseases/{id}")
	public Diseases getEmployeeById(@PathVariable("id") String id) {
		Diseases d = diseases.stream()
			.filter(disease -> id.equals(disease.getId()))
			.findAny()
			.orElse(null);
		
		return d;
	}
}
