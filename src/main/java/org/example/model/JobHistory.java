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
@Entity(name = "JobHistory")
@Table(name = "job_history", schema = "public")
public class JobHistory {

    @Id
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "promotion_date")
    private Date promotionDate;

    @Column(name = "previous_salary")
    private BigDecimal previousSalary;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "promotions")
    private String promotions;

}
