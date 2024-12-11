package com.brunopiovan.Jasperreports.controller;

import com.brunopiovan.Jasperreports.model.Aluno;
import com.brunopiovan.Jasperreports.service.JasperReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/jasper")
public class JasperReportController {

    private final JasperReportService jasperReportService;

    public JasperReportController(JasperReportService jasperReportService) {
        this.jasperReportService = jasperReportService;
    }

    @PostMapping("/gerar-certificado")
    public void gerar() throws IOException {
        this.jasperReportService.gerar();
    }
}
