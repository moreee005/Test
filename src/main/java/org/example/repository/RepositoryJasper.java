package org.example.repository;

import org.example.model.Employee;
import org.example.model.EmployeeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RepositoryJasper extends JpaRepository<Employee, Integer> {

    @Query(nativeQuery = true, value = """
        SELECT 
            e.employee_id AS employee_id, 
            e.name AS name, 
            e.department AS department, 
            e.salary AS salary, 
            j.job_title AS jobTitle, 
            j.promotion_date AS promotion_date, 
            j.previous_salary AS previous_salary, 
            p.year AS evaluation_year, 
            p.rating AS yearly_rating, 
            p.feedback AS feedback, 
            s.year AS salary_year, 
            s.salary AS salary_amount, 
            e.hire_date AS hire_date, 
            j.promotions AS promotions, 
            ds.total_employees AS total_employees
        FROM employees e
        LEFT JOIN job_history j ON e.employee_id = j.employee_id
        LEFT JOIN performance_evaluations p ON e.employee_id = p.employee_id
        LEFT JOIN salary_trends s ON e.employee_id = s.employee_id
        LEFT JOIN department_summary ds ON e.department = ds.department
        WHERE e.department = :department
        AND e.hire_date BETWEEN :startDate AND :endDate
        ORDER BY e.employee_id, p.year DESC, s.year
    """)
    List<EmployeeReport> findEmployeeReports(
            @Param("department") String department,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate);
}
