/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.agenda_v1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author Nuria e Ismael
 */
public class GenerarInforme {

    public String ficheroEntrada;
    public String ficheroSalida;
    private InputStream fich_jasper;

    public GenerarInforme(String fich_salida, String fich_jasper) {
        this.ficheroEntrada = "/Informes/" + fich_jasper;
        this.fich_jasper = getClass().getResourceAsStream(this.ficheroEntrada);

        this.ficheroSalida = "C:\\Users\\ismae\\Documents\\NetBeansProjects\\Agenda_v1\\src\\main\\resources\\informesGenerados\\" + fich_salida;
    }

    public void generar(Connection conn) {
        System.out.println("Jasper a leer " + this.fich_jasper);
        try {
            System.out.println("Cargando Input Stream Jasper");
            JasperReport jrc = (JasperReport) JRLoader.loadObject(this.fich_jasper);
            System.out.println("Rellenando informe");
            JasperPrint jp = JasperFillManager.fillReport(jrc, null, conn);
            System.out.println("Exportando informe a PDF");

            JRPdfExporter export = new JRPdfExporter();
            export.setExporterInput(new SimpleExporterInput(jp));
            export.setExporterOutput(new SimpleOutputStreamExporterOutput(new File(this.ficheroSalida)));
            SimplePdfExporterConfiguration config = new SimplePdfExporterConfiguration();
            export.setConfiguration(config);
            export.exportReport();
            System.out.println("PDF Generado");
        } catch (JRException ex) {
            ex.printStackTrace();
            System.out.println("GenReport - Cagada al generar el Report");
        }
    }
}
