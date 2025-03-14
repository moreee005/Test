package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SalaryTrends")
@Table(name = "salary_trends", schema = "public")
public class SalaryTrends {

    @Id
    @Column(name = "trend_id")
    private Integer trendId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "year")
    private Integer year;

    @Column(name = "salary")
    private BigDecimal salary;
}
