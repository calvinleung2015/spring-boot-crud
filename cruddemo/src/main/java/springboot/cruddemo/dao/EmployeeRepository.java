package springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.cruddemo.entity.Employee;
														//Entity type, Primary Key
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
 // no need to write any code.
}
