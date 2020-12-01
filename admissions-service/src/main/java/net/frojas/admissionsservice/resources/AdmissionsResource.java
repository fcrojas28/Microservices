package net.frojas.admissionsservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.frojas.admissionsservice.models.EmployeesList;
import net.frojas.admissionsservice.models.Patient;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	List<Patient> patients = Arrays.asList(
		new Patient("P1", "John", "American"),
		new Patient("P2", "Bryan", "American")
	);
	
	@RequestMapping("/physicians")
	public EmployeesList getPhysicians() {
		return restTemplate
			.getForObject("http://localhost:8082/hr/employees", EmployeesList.class);
	}
	
	@RequestMapping("/patients")
	public List<Patient> getPatients() {
		return patients;
	}
	
	@RequestMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable("id") String id) {
		Patient p = patients.stream()
				.filter(patient -> id.equals(patient.getId()))
				.findAny()
				.orElse(null);
		
		return p;
	}
}
