package org.example.service;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.coyote.Response;
import org.example.model.DepartmentSummary;
import org.example.model.EmployeeReport;
import org.example.repository.RepositoryDepartmentSummary;
import org.example.repository.RepositoryJasper;
import org.example.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class Tes {

    @Autowired
    RepositoryDepartmentSummary repositoryDepartmentSummary;

   private final RepositoryJasper repositoryJasper;

    public Tes(RepositoryJasper repositoryJasper) {
        this.repositoryJasper = repositoryJasper;
    }

    public ResponseEntity<Object> tes(String department, String startDate, String endDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date start = null;
            Date end = null;

            try {
                start = dateFormat.parse(startDate);
                end = dateFormat.parse(endDate);
            } catch (ParseException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            List <EmployeeReport> employeeReports = repositoryJasper.findEmployeeReports(department, start, end);
            JRDataSource dataSource = new JRBeanCollectionDataSource(employeeReports);
            File reportFile = ResourceUtils.getFile("src/main/resources/test_jasper1.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile.getPath(), null, dataSource);

            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\lenovo\\Downloads\\Documents\\employee_report.pdf");

            return ResponseEntity.ok(employeeReports);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + e.getMessage());
        }
    }

}
