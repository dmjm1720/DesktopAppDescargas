package mx.insoftec.dao;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class cfdiPdf extends Conexion {

    public void getReporte(String uuid, String ruta) {
        try {
            try {
                this.Conectar();
                JasperReport jr;
                JasperPrint jp;
                Map parameter = new HashMap();
                parameter.put("uuid", uuid);
                parameter.put("ruta", ruta);
                URL in = this.getClass().getResource("/mx/insoftec/report/report1.jasper");
                jr = (JasperReport) JRLoader.loadObject(in);
                jp = JasperFillManager.fillReport(jr, parameter, this.getConn());
                JasperExportManager.exportReportToPdfFile(jp, ruta);

            } catch (JRException ex) {
                System.out.println(uuid);
                Logger.getLogger(cfdiPdf.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.Cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(cfdiPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
