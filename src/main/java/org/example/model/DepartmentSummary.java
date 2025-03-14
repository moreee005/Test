package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DepartmentSummary")
@Table(name = "department_summary", schema = "public")
public class DepartmentSummary {
    @Id
    @Column(name = "department")
    private String department;

    @Column(name = "total_employees")
    private int totalEmployees;
}
