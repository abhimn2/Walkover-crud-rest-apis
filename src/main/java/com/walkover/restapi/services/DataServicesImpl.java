package com.walkover.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.walkover.restapi.dao.DataDao;
import com.walkover.restapi.model.Employee;


/**
 * Implementation class for DataServices Interface. 
 * @author Abhishek Soni
 */
public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addEntity(Employee employee) throws Exception {
		return dataDao.addEntity(employee);
	}

	@Override
	public Employee getEntityById(int id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Employee> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(int id) throws Exception {
		return dataDao.deleteEntity(id);
	}

	@Override
	public boolean updateEntity(Employee employee) throws Exception{
		return dataDao.updateEntity(employee);
	}

}
