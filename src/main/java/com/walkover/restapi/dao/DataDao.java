package com.walkover.restapi.dao;

import java.util.List;

import com.walkover.restapi.model.Employee;

/**
 * @author Abhishek Soni
 */
public interface DataDao {

	
	public boolean addEntity(Employee employee) throws Exception;
	public Employee getEntityById(int id) throws Exception;
	public List<Employee> getEntityList() throws Exception;
	public boolean deleteEntity(int id) throws Exception;
	public boolean updateEntity(Employee employee) throws Exception;
}
