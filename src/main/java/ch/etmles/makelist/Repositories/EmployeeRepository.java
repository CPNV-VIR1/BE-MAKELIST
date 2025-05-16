package ch.etmles.makelist.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.etmles.makelist.Entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
