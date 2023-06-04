/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Modelo.Participacion;
import Modelo.Persona;
import Modelo.Proyecto;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.sun.istack.ByteArrayDataSource;
import java.io.BufferedReader;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author aleja
 */
@WebService(serviceName = "ToPDF")
public class ToPDF {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "toPDF")
    @XmlMimeType("application/pdf")
    public DataHandler toPDF(@WebParam(name = "persona") Persona persona) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try (InputStream htmlInputStream = getClass().getResourceAsStream("template.html")) {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(htmlInputStream, StandardCharsets.UTF_8));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            String htmlTemplate = stringBuilder.toString();
            // Reemplazar los marcadores de posición con los valores de la factura
            htmlTemplate = htmlTemplate.replace("{{nombre}}", persona.getNombre())
                    .replace("{{apellidos}}", persona.getApellidos());

            String proyectos = "";
            int valor = 0;
            Proyecto proyecto;
            List<Participacion> listaParticipacion = (List<Participacion>) persona.getParticipacions();
            for (Participacion p : listaParticipacion) {
                proyecto = p.getProyecto();
                valor += p.getCuota();
                proyectos += "<p>Proyecto: " + proyecto.getNombre() + ", Numero de tareas en las que participa: " + p.getTareas().size() + "</p><br/>";
            }

            htmlTemplate = htmlTemplate.replace("{{proyecto}}", proyectos);

            ConverterProperties converterProperties = new ConverterProperties();
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdfDocument = new PdfDocument(writer);
            HtmlConverter.convertToPdf(htmlTemplate, pdfDocument, converterProperties);

            System.out.println("PDF generado exitosamente.");

            byte[] pdfBytes = outputStream.toByteArray();
            return new DataHandler(new ByteArrayDataSource(pdfBytes, "application/pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
