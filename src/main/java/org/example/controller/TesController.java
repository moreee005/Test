package org.example.controller;


import org.example.model.EmployeeReport;
import org.example.service.Tes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tes")
public class TesController {
    @Autowired
    Tes tes;

    @GetMapping("/wan")
    public ResponseEntity<Object> test(
            @RequestParam String department,
            @RequestParam String startDate,
            @RequestParam String endDate) {

        return tes.tes(department, startDate, endDate);
    }
}
