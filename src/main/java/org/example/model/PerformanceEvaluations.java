package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PerformanceEvaluations")
@Table(name = "performance_evaluations", schema = "public")
public class PerformanceEvaluations {

    @Id
    @Column(name = "evaluation_id")
    private Integer evaluationId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "year")
    private Integer year;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "feedback")
    private String feedback;

}
