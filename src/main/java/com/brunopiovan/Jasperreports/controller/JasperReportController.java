package com.brunopiovan.Jasperreports.controller;

import com.brunopiovan.Jasperreports.model.Aluno;
import com.brunopiovan.Jasperreports.service.JasperReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/jasper")
public class JasperReportController {

    private final JasperReportService jasperReportService;

    public JasperReportController(JasperReportService jasperReportService) {
        this.jasperReportService = jasperReportService;
    }

    @GetMapping("/relatorio")
    public ResponseEntity<byte[]> gerarRelatorio() throws IOException {
        byte[] relatorioBytes = jasperReportService.gerar();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorio.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(relatorioBytes);
    }
}
