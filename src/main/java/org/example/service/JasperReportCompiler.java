package org.example.service;

import net.sf.jasperreports.engine.JasperCompileManager;
import java.io.File;

public class JasperReportCompiler {

    public static void compileReport(String jrxmlPath) throws Exception {
        JasperCompileManager.compileReportToFile(jrxmlPath);
    }

    public static void main(String[] args) throws Exception {
        compileReport("src/main/resources/jasper.jrxml");
    }
}
