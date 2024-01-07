package mx.insoftec.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Boolean.TRUE;
import java.net.URISyntaxException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import mx.insoftec.dao.ClienteDao;
import mx.insoftec.dao.ClienteDaoImpl;
import mx.insoftec.dao.Conexion;
import mx.insoftec.dao.LeerXML;
import mx.insoftec.dao.cfdiPdf;
import mx.insoftec.model.Cliente;
import net.sf.jasperreports.engine.JRException;
import org.jdom2.JDOMException;

public class JInternalFrameDescarga extends javax.swing.JInternalFrame implements Runnable {

    private String miRutaXML;
    private String cadenaLink;
    private final String buscarCadena = "AccionCfdi('RecuperaCfdi.aspx?Datos=";
    private final String nuevoLink = "https://portalcfdi.facturaelectronica.sat.gob.mx/RecuperaCfdi.aspx?Datos=";
    private String cfdiE_R;
    private String nuevaCadenaLink;
    private String rfcEmisor;
    private LeerXML leerXml;
    private cfdiPdf cfdiRep;
    private String cadenaRfc;
    private List<Cliente> listarRFC;
    private Thread proceso1;
    private Thread proceso2;
    private Thread proceso3;
    private Boolean terminar = TRUE;
    private Boolean terminar2 = TRUE;
    private Boolean terminar3 = TRUE;
    private Conexion conexion;
    private String uuid;
    private String rfc_e;
    private String fecha_recepcion;
    private String nombreArchivo;
    private String año;
    private String mes;
    private String valorTipo;

    public JInternalFrameDescarga() {
        initComponents();
        this.leerXml = new LeerXML();
        this.cfdiRep = new cfdiPdf();
    }

    public String getRfcEmisor() {
        return rfcEmisor;
    }

    public LeerXML getLeerXml() {
        return leerXml;
    }

    public void setLeerXml(LeerXML leerXml) {
        this.leerXml = leerXml;
    }

    public void setRfcEmisor(String rfcEmisor) {
        this.rfcEmisor = rfcEmisor;
    }

    public String getMiRutaXML() {
        return miRutaXML;
    }

    public void setMiRutaXML(String miRutaXML) {
        this.miRutaXML = miRutaXML;
    }

    public String getCadenaLink() {
        return cadenaLink;
    }

    public void setCadenaLink(String cadenaLink) {
        this.cadenaLink = cadenaLink;
    }

    public String getCfdiE_R() {
        return cfdiE_R;
    }

    public void setCfdiE_R(String cfdiE_R) {
        this.cfdiE_R = cfdiE_R;
    }

    public String getNuevaCadenaLink() {
        return nuevaCadenaLink;
    }

    public void setNuevaCadenaLink(String nuevaCadenaLink) {
        this.nuevaCadenaLink = nuevaCadenaLink;
    }

    public cfdiPdf getCfdiRep() {
        return cfdiRep;
    }

    public void setCfdiRep(cfdiPdf cfdiRep) {
        this.cfdiRep = cfdiRep;
    }

    public String getCadenaRfc() {
        return cadenaRfc;
    }

    public void setCadenaRfc(String cadenaRfc) {
        this.cadenaRfc = cadenaRfc;
    }

    public List<Cliente> getListarRFC() {
        return listarRFC;
    }

    public Thread getProceso1() {
        return proceso1;
    }

    public void setProceso1(Thread proceso1) {
        this.proceso1 = proceso1;
    }

    public Thread getProceso2() {
        return proceso2;
    }

    public void setProceso2(Thread proceso2) {
        this.proceso2 = proceso2;
    }

    public Boolean getTerminar() {
        return terminar;
    }

    public void setTerminar(Boolean terminar) {
        this.terminar = terminar;
    }

    public Boolean getTerminar2() {
        return terminar2;
    }

    public void setTerminar2(Boolean terminar2) {
        this.terminar2 = terminar2;
    }

    public Boolean getTerminar3() {
        return terminar3;
    }

    public void setTerminar3(Boolean terminar3) {
        this.terminar3 = terminar3;
    }

    public Thread getProceso3() {
        return proceso3;
    }

    public void setProceso3(Thread proceso3) {
        this.proceso3 = proceso3;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRfc_e() {
        return rfc_e;
    }

    public void setRfc_e(String rfc_e) {
        this.rfc_e = rfc_e;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(String fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getValorTipo() {
        return valorTipo;
    }

    public void setValorTipo(String valorTipo) {
        this.valorTipo = valorTipo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRuta = new javax.swing.JTextField();
        btnAbrir = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CFDI 3.3 DESCARGA MASIVA XML-SAT. \"BUSCAR ARCHIVO .TXT\"");
        setToolTipText("Descarga");
        setPreferredSize(new java.awt.Dimension(562, 180));
        setRequestFocusEnabled(false);

        txtRuta.setEditable(false);
        txtRuta.setToolTipText("");

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/insoftec/img/buscar2.png"))); // NOI18N
        btnAbrir.setText("Buscar archivo .txt");
        btnAbrir.setToolTipText("Buscar en mi PC el achivo .txt");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnProcesar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/insoftec/img/download.png"))); // NOI18N
        btnProcesar.setText("Descargar XML");
        btnProcesar.setToolTipText("Iniciar la descarga masiva.");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            this.txtRuta.setText(String.valueOf(file));
            this.miRutaXML = this.txtRuta.getText();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAbrirActionPerformed

    @SuppressWarnings("SleepWhileInLoop")
    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        try {
            procesar();
//        proceso1 = new Thread(this);
//        proceso2 = new Thread(this);
//        proceso3 = new Thread(this);
//        proceso1.start();
//        proceso2.start();
//        proceso3.start();
//        run();
        } catch (JDOMException | JRException | SQLException ex) {
            Logger.getLogger(JInternalFrameDescarga.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnProcesarActionPerformed
    @SuppressWarnings("SleepWhileInLoop")
    public void procesarArchivos() throws JDOMException, IOException, JRException, SQLException, InterruptedException {

        String files;
        //String path = "C:\\Users\\Mario Arias\\Downloads\\";
        //String path = "/home/aigm/Descargas/";
        String path = "C:\\descargas_xml\\";
        //String path = "Z:\\descargas_xml\\";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                if (listOfFile.length() > 0) {
                    files = listOfFile.getName();
                    if (files.endsWith(".xml") || files.endsWith(".XML")) {
                        leerXml.leerXML(path + files, files, this.cfdiE_R);
                        Path FROM = Paths.get(path + files);
                        String fecha[] = leerXml.getFechaFac().split("-");
                        String year = fecha[0];
                        String day = fecha[1];

//                        if (leerXml.getBandera().equals(true)) {
//                            Path TO = Paths.get("C:\\SAT\\" + this.cfdiE_R + "\\" + year + "\\" + leerXml.getRfcEmisor() + "\\" + day + "\\"
//                                    + files.replace(".xml", "").concat("---").concat(leerXml.getRfcEmisor()).concat("---$")
//                                            .concat(leerXml.getMonto().toString()).concat(".xml"));
//                            File nuevaRuta = new File("C:\\SAT\\" + this.cfdiE_R + "\\" + year + "\\" + leerXml.getRfcEmisor() + "\\" + day);
//                            if (!nuevaRuta.exists()) {
//                                nuevaRuta.mkdirs();
//                            }
//                            CopyOption[] options = new CopyOption[]{
//                                StandardCopyOption.REPLACE_EXISTING,
//                                StandardCopyOption.COPY_ATTRIBUTES
//                            };
//                            this.getCfdiRep().getReporte(files.replace(".xml", ""), "C:\\SAT\\" + this.cfdiE_R + "\\" + year + "\\" + leerXml.getRfcEmisor() + "\\" + day + "\\"
//                                    + files.replace(".xml", "").concat("---").concat(leerXml.getRfcEmisor()).concat("---$")
//                                            .concat(leerXml.getMonto().toString()).concat(".pdf"));
//                            if (!Files.exists(TO)) {
//                                Files.copy(FROM, TO, options);
//                            }
//                        }
                        //**MEISA**//
//                    if (leerXml.getBandera().equals(true)) {
//                        Path TO = Paths.get("Z:\\SAT\\" + this.cfdiE_R + "\\" + year + "\\" + leerXml.getRfcEmisor() + "\\" + day + "\\"
//                                + files.replace(".xml", "").concat("---").concat(leerXml.getRfcEmisor()).concat("---$")
//                                        .concat(leerXml.getMonto().toString()).concat(".xml"));
//                        File nuevaRuta = new File("Z:\\SAT\\" + this.cfdiE_R + "\\" + year + "\\" + leerXml.getRfcEmisor() + "\\" + day);
//                        if (!nuevaRuta.exists()) {
//                            nuevaRuta.mkdirs();
//                        }
//                        CopyOption[] options = new CopyOption[]{
//                            StandardCopyOption.REPLACE_EXISTING,
//                            StandardCopyOption.COPY_ATTRIBUTES
//                        };
//                        this.getCfdiRep().getReporte(files.replace(".xml", ""), "Z:\\SAT\\" + this.cfdiE_R + "\\" + year + "\\" + leerXml.getRfcEmisor() + "\\" + day + "\\"
//                                + files.replace(".xml", "").concat("---").concat(leerXml.getRfcEmisor()).concat("---$")
//                                        .concat(leerXml.getMonto().toString()).concat(".pdf"));
//                        if (!Files.exists(TO)) {
//                            Files.copy(FROM, TO, options);
//                        }
//                    }
//**MEISA**//
                        //**AROMITALIA**//
                        //C:\SAT\Recibidos\NME031127CH3\2020\07\RFC 
                        if (leerXml.getBandera().equals(true)) {
                            Path TO = Paths.get("C:\\SAT\\" + this.cfdiE_R + "\\" + leerXml.getRfcReceptor() + "\\" + year + "\\" + day + "\\" + leerXml.getRfcEmisor() + "\\"
                                    + files.replace(".xml", "").concat("---").concat(leerXml.getRfcEmisor()).concat("---$")
                                            .concat(leerXml.getMonto().toString()).concat(".xml"));
                            File nuevaRuta = new File("C:\\SAT\\" + this.cfdiE_R + "\\" + leerXml.getRfcReceptor() + "\\" + year + "\\" + day + "\\" + leerXml.getRfcEmisor());
                            if (!nuevaRuta.exists()) {
                                nuevaRuta.mkdirs();
                            }
                            CopyOption[] options = new CopyOption[]{
                                StandardCopyOption.REPLACE_EXISTING,
                                StandardCopyOption.COPY_ATTRIBUTES
                            };
                            this.getCfdiRep().getReporte(files.replace(".xml", ""), "C:\\SAT\\" + this.cfdiE_R + "\\" + leerXml.getRfcReceptor() + "\\" + year + "\\" + day + "\\" + leerXml.getRfcEmisor() + "\\"
                                    + files.replace(".xml", "").concat("---").concat(leerXml.getRfcEmisor()).concat("---$")
                                            .concat(leerXml.getMonto().toString()).concat(".pdf"));
                            if (!Files.exists(TO)) {
                                Files.copy(FROM, TO, options);
                            }
                        }
                        //**AROMITALIA**//
                        
                        
//                    if (leerXml.getBandera().equals(true)) {
//                        Path TO = Paths.get("C:\\SAT\\" + this.cfdiE_R + "\\" + leerXml.getRfcReceptor()+ "\\" + year + "\\" + day + "\\" + leerXml.getRfcEmisor() + "\\"
//                                + files.replace(".xml", "").concat("---").concat(leerXml.getRfcEmisor()).concat("---$")
//                                        .concat(leerXml.getMonto().toString()).concat(".xml"));
//                        File nuevaRuta = new File("C:\\SAT\\" + this.cfdiE_R + "\\" + leerXml.getRfcReceptor() + "\\" + year + "\\" + day + "\\" + leerXml.getRfcEmisor());
//                        if (!nuevaRuta.exists()) {
//                            nuevaRuta.mkdirs();
//                        }
//                        CopyOption[] options = new CopyOption[]{
//                            StandardCopyOption.REPLACE_EXISTING,
//                            StandardCopyOption.COPY_ATTRIBUTES
//                        };
//                        this.getCfdiRep().getReporte(files.replace(".xml", ""), "C:\\SAT\\" + this.cfdiE_R + "\\" + leerXml.getRfcReceptor() + "\\" + year + "\\" + day + "\\" + leerXml.getRfcEmisor() + "\\"
//                                + files.replace(".xml", "").concat("---").concat(leerXml.getRfcEmisor()).concat("---$")
//                                        .concat(leerXml.getMonto().toString()).concat(".pdf"));
//                        if (!Files.exists(TO)) {
//                            Files.copy(FROM, TO, options);
//                        }
//                    }
                        File fDelete = new File(path + files);
                        fDelete.delete();
                    }
                }
            }
        }

    }

    public void mostrarMensaje() {
        JFrameMensaje jfMensaje = new JFrameMensaje();
        jfMensaje.setVisible(true);
    }

    @SuppressWarnings("SleepWhileInLoop")
    public void procesar() throws JDOMException, JRException, SQLException {
        if (this.miRutaXML != null) {
            try {
                FileReader fr = new FileReader(String.valueOf(this.miRutaXML));
                BufferedReader br = new BufferedReader(fr);
                int contador = 0;
                while ((this.cadenaLink = br.readLine()) != null) {
                    if (this.cadenaLink.contains("./ConsultaReceptor.aspx")) {
                        this.cfdiE_R = "Recibidos";
                    } else if (this.cadenaLink.contains("./ConsultaEmisor.aspx")) {
                        this.cfdiE_R = "Emitidos";
                    }

                    if (this.cadenaLink.contains("<span id=\"ctl00_LblRfcAutenticado\" class=\"signin\">RFC Autenticado:")) {
                        this.nuevaCadenaLink = cadenaLink;
                        this.nuevaCadenaLink = this.nuevaCadenaLink.replace("<span id=\"ctl00_LblRfcAutenticado\" class=\"signin\">RFC Autenticado: ", "");
                        this.nuevaCadenaLink = this.nuevaCadenaLink.replace("</span>", "");
                        //System.out.println(this.nuevaCadenaLink);
                        ClienteDao cDao = new ClienteDaoImpl();
                        listarRFC = cDao.listarRFC(this.nuevaCadenaLink.trim());
                    }

                    while (this.cadenaLink.contains(this.buscarCadena)) {
                        this.cadenaLink = this.cadenaLink.substring(this.cadenaLink.indexOf(this.buscarCadena) + this.buscarCadena.length(), this.cadenaLink.length());
                        if (!listarRFC.isEmpty()) {
                            if (java.awt.Desktop.isDesktopSupported()) {
                                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                                if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                                    try {
                                        java.net.URI uri = new java.net.URI(this.nuevoLink.concat(this.cadenaLink.substring(0, 620)));
                                        //java.net.URI uri2 = new java.net.URI(this.nuevoLink.concat(this.cadenaLink.substring(0, 640)));
                                        System.out.println(uri);
                                        Thread.sleep(500);
                                        desktop.browse(uri);
                                    } catch (IOException | InterruptedException | URISyntaxException e) {
                                        System.err.println(e.getMessage());
                                    }
                                }
                            }

                            contador++;
                        } else if (listarRFC.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "RFC inválido", "Información", JOptionPane.INFORMATION_MESSAGE);
                            break;

                        }
                    }

                }
                if (!listarRFC.isEmpty()) {
                    Thread.sleep(300);
                    procesarArchivos();
                    procesarArchivos();
                    JOptionPane.showMessageDialog(null, "Se han descargado: " + contador + " XML " + this.cfdiE_R, "Información", JOptionPane.INFORMATION_MESSAGE);
                    procesarArchivos();
                    procesarArchivos();
                    //this.terminar3 = FALSE;
                    //this.dispose();

                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JFDescarga.class
                        .getName()).log(Level.SEVERE, null, ex);

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(JFDescarga.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona el archivo .txt", "Información", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables

    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
        Thread hilos = Thread.currentThread();
        while (hilos == proceso3 && Objects.equals(terminar3, TRUE)) {
            try {
                procesar();

            } catch (JDOMException | JRException | SQLException ex) {
                Logger.getLogger(JInternalFrameDescarga.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        while (hilos == proceso1 && Objects.equals(terminar3, TRUE)) {
            try {
                procesarArchivos();

            } catch (JDOMException | IOException | JRException | SQLException | InterruptedException ex) {
                Logger.getLogger(JInternalFrameDescarga.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        while (hilos == proceso2 && Objects.equals(terminar3, TRUE)) {
            try {
                Thread.sleep(10000);

            } catch (InterruptedException ex) {
                Logger.getLogger(JInternalFrameDescarga.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            mostrarMensaje();
        }
    }

}
