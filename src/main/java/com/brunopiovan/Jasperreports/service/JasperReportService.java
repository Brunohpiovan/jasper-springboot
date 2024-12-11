package com.brunopiovan.Jasperreports.service;


import com.brunopiovan.Jasperreports.model.Aluno;
import com.brunopiovan.Jasperreports.model.AlunoDTO;
import com.brunopiovan.Jasperreports.repositories.AlunoRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperReportService {

    public static final String CERTIFICADOS = "classpath:jasper/certificados/";
    public static final String ARQUIVOJRXML = "relatorio.jrxml";
    public static final Logger LOGGER = LoggerFactory.getLogger(JasperReportService.class);

    @Autowired
    private AlunoRepository alunoRepository;

    public byte[] gerar() throws IOException {


        List<AlunoDTO> alunos = alunoRepository.findAlunosWithCursos();

        String pathAbsoluto = getAbsolutPath();

        Map<String, Object> params = new HashMap<>();

        try{
            JasperReport report = JasperCompileManager.compileReport(pathAbsoluto);
            LOGGER.info("report compilado: {} ", pathAbsoluto);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(alunos);
            JasperPrint print = JasperFillManager.fillReport(report,params,dataSource);
            LOGGER.info("Relatorio preenchico com sucesso");

            // Exportar o relatório para um arquivo PDF
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(print, outputStream);
            LOGGER.info("PDF gerado");

            return outputStream.toByteArray();

        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }


    private String getAbsolutPath() throws FileNotFoundException {
        return ResourceUtils.getFile(CERTIFICADOS+ARQUIVOJRXML).getAbsolutePath();
    }
}
