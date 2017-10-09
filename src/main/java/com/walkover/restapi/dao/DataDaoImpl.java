package com.walkover.restapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.walkover.restapi.model.Employee;

/**
 * Implementation Class for DataDao Interface.
 * @author Abhishek Soni
 */
public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	/**
	 * Creates a entry in Employee table with the JSON Request Body.
	 * @param employee
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean addEntity(Employee employee) throws Exception {
		
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
		return false;
	}

	/**
	 * Gives the details of Employee for Requested Id
	 * @param id
	 * @return Employee Object
	 * @throws Exception
	 */
	@Override
	public Employee getEntityById(int id) throws Exception {
		session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class,
				new Integer(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return employee;
	}

	/**
	 * Returns all the Employees present in table
	 * @return List of Employees
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Employee> employeeList = session.createCriteria(Employee.class)
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	
	/**
	 * Deletes details of Employee for Requested Id
	 * @param id
	 * @return 
	 * @throws Exception
	 */
	@Override
	public boolean deleteEntity(int id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Employee.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
		return false;
	}

	/**
	 * Updates Employee details for the Request Id using JSON Request Body
	 * @param employee
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean updateEntity(Employee employee) 
			throws Exception {
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		session.update(employee);
		tx.commit();
		session.close();
		return false;
	}

}
