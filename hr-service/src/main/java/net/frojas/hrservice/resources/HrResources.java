package net.frojas.hrservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.frojas.hrservice.models.Employee;


@RestController
@RequestMapping("/hr")
public class HrResources {

	List<Employee> employees = Arrays.asList(
			new Employee("E1", "Carlos", "Rodriguez", "Dermatologo"),
			new Employee("E2", "Daniel", "Flores", "Anestesiología")
		);
		
		@RequestMapping("/employees")
		public List<Employee> getEmployees() {
			return employees;
		}
		
		@RequestMapping("/employees/{id}")
		public Employee getEmployeeById(@PathVariable("id") String id) {
			Employee e = employees.stream()
					.filter(employee -> id.equals(employee.getId()))
					.findAny()
					.orElse(null);
			
			return e;
		}
}
