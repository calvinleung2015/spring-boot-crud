package springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.cruddemo.dao.EmployeeDAO;
import springboot.cruddemo.dao.EmployeeRepository;
import springboot.cruddemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
//	private EmployeeDAO employeeDAO;
//	
//	@Autowired          //@Qualifier tell the spring which bean to use "EmployeeDAOHibernateImpl" or "EmployeeDAOJpaImpl"
//	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl")EmployeeDAO theEmployeeDAO) {
//		employeeDAO = theEmployeeDAO;
//	}
//	
//
//	@Override
//	@Transactional    //Handles transaction management so we don't have to manually start and commit transaction.
//	public List<Employee> findAll() {
//		return employeeDAO.findAll();
//	}
//
//	@Override
//	@Transactional    //Handles transaction management so we don't have to manually start and commit transaction.
//	public Employee findById(int theId) {
//		return employeeDAO.findById(theId);
//	}
//	
//	@Override
//	@Transactional    //Handles transaction management so we don't have to manually start and commit transaction.
//	public void save(Employee theEmployee) {
//		employeeDAO.save(theEmployee);
//	}
//
//	@Override
//	@Transactional    //Handles transaction management so we don't have to manually start and commit transaction.
//	public void deleteById(int theId) {
//		employeeDAO.deleteById(theId);
//	}
	
	
	private EmployeeRepository employeeRepository;
	
	@Autowired         
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	

	@Override
	//@Transactional    remove since JpaRepository provides this functionality
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	//@Transactional    remove since JpaRepository provides this functionality
	public Employee findById(int theId) {
		
		// Different pattern instead of having to check for nulls.
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return theEmployee;
	}
	
	@Override
	//@Transactional    remove since JpaRepository provides this functionality
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	//@Transactional    remove since JpaRepository provides this functionality
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
	
	

}
