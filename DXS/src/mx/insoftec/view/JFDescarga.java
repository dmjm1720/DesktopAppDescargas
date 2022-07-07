package mx.insoftec.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import mx.insoftec.dao.LeerXML;
import org.jdom2.JDOMException;

public class JFDescarga extends javax.swing.JFrame {

    private String miRutaXML;
    private String cadenaLink;
    private final String buscarCadena = "AccionCfdi('RecuperaCfdi.aspx?Datos=";
    private final String nuevoLink = "https://portalcfdi.facturaelectronica.sat.gob.mx/RecuperaCfdi.aspx?Datos=";
    private String cfdiE_R;
    private String nuevaCadenaLink;
    private String rfcEmisor;
    private LeerXML leerXml;

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

    public JFDescarga() {
        this.leerXml = new LeerXML();
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        txtRuta = new javax.swing.JTextField();
        btnProcesar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Descarga XML");

        jLabel1.setText("Ruta archivo .TXT");

        btnAbrir.setText("Buscar archivo");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        txtRuta.setToolTipText("");

        btnProcesar.setText("Iniciar descarga");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        jButton1.setText("Procesar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(91, 91, 91)
                        .addComponent(btnProcesar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAbrir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAbrir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRuta, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcesar)
                    .addComponent(jButton1))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("Ruta archivo .TXT");

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
        if (this.miRutaXML != null) {
            try {
                FileReader fr = new FileReader(String.valueOf(this.miRutaXML));
                BufferedReader br = new BufferedReader(fr);
                int contador = 0;

                while ((this.cadenaLink = br.readLine()) != null) {
                    this.nuevaCadenaLink = this.cadenaLink;
                    if (this.cadenaLink.contains("./ConsultaReceptor.aspx")) {
                        this.cfdiE_R = "Recibidos";
                    } else if (this.cadenaLink.contains("./ConsultaEmisor.aspx")) {
                        this.cfdiE_R = "Emitidos";
                    }

                    while (this.cadenaLink.contains(this.buscarCadena)) {
                        this.cadenaLink = this.cadenaLink.substring(this.cadenaLink.indexOf(this.buscarCadena) + this.buscarCadena.length(), this.cadenaLink.length());
                        if (java.awt.Desktop.isDesktopSupported()) {
                            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                                try {
                                    java.net.URI uri = new java.net.URI(this.nuevoLink.concat(this.cadenaLink.substring(0, 492)));
                                    Thread.sleep(300);
                                    desktop.browse(uri);
                                } catch (IOException | InterruptedException | URISyntaxException e) {
                                    System.err.println(e.getMessage());
                                }
                            }
                        }
                        contador++;
                    }
                }
                Thread.sleep(500);
                procesarArchivos(this.cfdiE_R);
                procesarArchivos(this.cfdiE_R);
                JOptionPane.showMessageDialog(null, "Se han descargado: " + contador + " XML " + this.cfdiE_R, "Información", JOptionPane.INFORMATION_MESSAGE);
                procesarArchivos(this.cfdiE_R);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JFDescarga.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | JDOMException | InterruptedException ex) {
                Logger.getLogger(JFDescarga.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona el archivo .txt", "Información", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnProcesarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            procesarArchivos(this.cfdiE_R);
        } catch (JDOMException | IOException ex) {
            Logger.getLogger(JFDescarga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void procesarArchivos(String emitidoRecibido) throws JDOMException, IOException {
        String files;
        String path = "C:\\Users\\Mario Arias\\Downloads\\";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                files = listOfFile.getName();
                if (files.endsWith(".xml") || files.endsWith(".XML")) {
                    leerXml.leerXML(path + files, files, this.cfdiE_R);
                    Path FROM = Paths.get(path + files);
                    //System.out.println(this.dao.getAcuse().getEstado().getValue());
                    Path TO = Paths.get("C:\\sat\\" + leerXml.getRfcEmisor() + "\\" + files);
                    File nuevaRuta = new File("C:\\sat\\" + leerXml.getRfcEmisor());
                    if (!nuevaRuta.exists()) {
                        nuevaRuta.mkdirs();
                    }
                    if (!Files.exists(TO)) {
                        Files.copy(FROM, TO);
                    }
                    File fDelete = new File(path + files);
                    fDelete.delete();
                }
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
