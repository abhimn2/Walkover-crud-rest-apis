package com.walkover.restapi.controller;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.walkover.restapi.model.Employee;
import com.walkover.restapi.model.Status;
import com.walkover.restapi.services.DataServices;

import javassist.NotFoundException;

/**
 * The RestController class takes the http request and routes it 
 * to appropriate service method. 
 *
 * @author  Abhishek Soni
 */

@Controller
@RequestMapping("/employee")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);


	/**
	 * Routes /employee/create POST requests to create Employee with the given JSON request.
	 * @param employee
	 * @return Status code for add operation
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addEmployee(@RequestBody Employee employee) {
		try {
			dataServices.addEntity(employee);
			return new Status(HttpStatus.OK, "Employee added Successfully !");
		} catch (Exception e) {
			return new Status(HttpStatus.NOT_FOUND, "Employee couldn't be Added !");
		}
	}

	/**
	 * Routes requests with /employee/{id} to fetch the Employee for the given Id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Employee getEmployee(@PathVariable("id") int id) throws Exception{
		Employee employee = null;
		System.out.println("Calling getEmployee!!!!");
		employee = dataServices.getEntityById(id);
		if (employee.toString().isEmpty() || employee == null){
			throw new ObjectNotFoundException("Employee not found for Requested Id", "EMPLOYEE_OBJECT_NULL");
		}	

		System.out.println("After ");
		return employee;
	}



	/**
	 * Routes /employee/update/{id} requests to update Employee for given Id
	 * @param employee
	 * @return Status code for operation
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status updateEmployee(@RequestBody Employee employee) {
		try {
			dataServices.updateEntity(employee);
			return new Status(HttpStatus.OK, "Employee updated Successfully !");
		} catch (Exception e) {
			return new Status(HttpStatus.NOT_FOUND, "Employee couldn't be Updated !");
		}
	}

	/**
	 * Routes /employee/list request to fetch all the Employees available
	 * @return List of Employees
	 * @throws NotFoundException 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Employee> getEmployee() throws Exception {
		List<Employee> employeeList = null;
		employeeList = dataServices.getEntityList();
		return employeeList;
	}

	/**
	 * Routes /employee/delete/{id} request to delete Employee for Id Variable
	 * @param id
	 * @return Status code for Operation
	 * @throws Exception 
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteEmployee(@PathVariable("id") int id) {
		try {
			dataServices.deleteEntity(id);
			return new Status(HttpStatus.OK, "Employee deleted Successfully");
		}
		catch (Exception e){
			e.printStackTrace();
			return new Status(HttpStatus.NOT_FOUND, "Employee could not be deleted");
		}	
	}

	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
	public Status exceptionHandler(){
		System.out.println("Calling Exception handler");
		return new Status(HttpStatus.NOT_FOUND, "Employee not found for Requested Id");
	}
}
