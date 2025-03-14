package org.example.model;

import java.math.BigDecimal;
import java.util.Date;

// Projection Interface
public interface EmployeeReport {

    Integer getEmployee_id();

    String getName();

    String getDepartment();

    BigDecimal getSalary();

    String getPast_position();

    Date getPromotion_date();

    BigDecimal getPrevious_salary();

    Integer getEvaluation_year();

    Integer getYearly_rating();

    String getFeedback();

    Integer getSalary_year();

    BigDecimal getSalary_amount();

    Date getHire_date();

    String getPromotions();

    Integer getTotal_employees();
}
