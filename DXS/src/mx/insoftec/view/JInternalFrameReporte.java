package mx.insoftec.view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import mx.insoftec.dao.CfdiDao;
import mx.insoftec.dao.CfdiDaoImpl;
import mx.insoftec.dao.ClienteDao;
import mx.insoftec.dao.ClienteDaoImpl;
import mx.insoftec.dao.DetalleDao;
import mx.insoftec.dao.DetalleDaoImpl;
import mx.insoftec.model.Cfdi;
import mx.insoftec.model.Detalle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class JInternalFrameReporte extends javax.swing.JInternalFrame {

    private List<Cfdi> listaCfdi;
    private List<String> listaCliente;
    private List<Detalle> listaDetalle;
    private Calendar hoy;
    private int dia;
    private String fechaFinal;
    private int contador;
 

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public JInternalFrameReporte() {
        initComponents();
        llenarCombo();
    }

    public List<Detalle> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<Detalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public Calendar getHoy() {
        return hoy;
    }

    public void setHoy(Calendar hoy) {
        this.hoy = hoy;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    //Llenar lista de clientes RFC
    public void llenarCombo() {
        ClienteDao cDao = new ClienteDaoImpl();
        listaCliente = cDao.listaCliente();
        for (int i = 0; i < listaCliente.size(); i++) {
            jCBoxRfc.addItem(listaCliente.get(i));
        }
    }

    //Borrar listas y tabla
    public void borrar() {
        if (listaCfdi != null) {
            listaCfdi.clear();
        }
        if (listaDetalle != null) {
            listaDetalle.clear();
        }
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            int filas = jTable1.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    public List<Cfdi> getListaCfdi() throws ParseException {

        CfdiDao cDao = new CfdiDaoImpl();
        borrar();
        contador = 0;
        Date fecInicial = jDCInicio.getDate();
        //Date fecFinal = jDCFin.getDate();
        this.hoy = jDCFin.getCalendar();
        System.out.println(this.hoy);
        this.dia = this.hoy.get(Calendar.DAY_OF_WEEK);
        this.hoy.add(Calendar.DATE, 1);
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        fechaFinal = formateador.format(hoy.getTime());
        SimpleDateFormat fInicial = new SimpleDateFormat(jDCInicio.getDateFormatString());
        //SimpleDateFormat fFinal = new SimpleDateFormat(jDCFin.getDateFormatString());
        if (jCBoxEmitidos.isSelected()) {
            listaCfdi = cDao.listaCfdiReceptor(jCBoxRfc.getSelectedItem().toString(), fInicial.format(fecInicial), fechaFinal);
        } else if (jCBoxRecibidos.isSelected()) {
            listaCfdi = cDao.listaCfdiEmisor(jCBoxRfc.getSelectedItem().toString(), fInicial.format(fecInicial), fechaFinal);
        }
        
        
        if (listaCfdi.size() > 0) {
            Iterator iterator = listaCfdi.iterator();
            while (iterator.hasNext()) {
                DefaultTableModel tabla = (DefaultTableModel) jTable1.getModel();
                Cfdi fila = (Cfdi) iterator.next();
                @SuppressWarnings("UseOfObsoleteCollectionType")
                Vector datos = new Vector();
                datos.add(fila.getVersionCfdi());
                datos.add(fila.getFecha());
                datos.add(fila.getSerie());
                datos.add(fila.getFolio());
                datos.add(fila.getFormaPago());
                datos.add(fila.getSubTotal());
                datos.add(fila.getMoneda());
                datos.add(fila.getTipoCambio());
                datos.add(fila.getTotal());
                datos.add(fila.getTipoDeComprobante());
                datos.add(fila.getMetodoPago());
                datos.add(fila.getCondicionesDePago());
                datos.add(fila.getDescuento());
                datos.add(fila.getLugarExpedicion());
                datos.add(fila.getCertificado());
                datos.add(fila.getNoCertificado());
                datos.add(fila.getSello());
                datos.add(fila.getRfcEmisor());
                datos.add(fila.getNombreEmisor());
                datos.add(fila.getRegimenFiscal());
                datos.add(fila.getRfcReceptor());
                datos.add(fila.getNombreReceptor());
                datos.add(fila.getImpLocTrasladado());
                datos.add(fila.getTasadeTraslado());
                datos.add(fila.getImporteTraslado());
                datos.add(fila.getImpuestoRet1());
                datos.add(fila.getTipoFactorRet1());
                datos.add(fila.getTasaOcuotaRet1());
                datos.add(fila.getImporteRet1());
                datos.add(fila.getImpuestoTras1());
                datos.add(fila.getTipoFactorTras1());
                datos.add(fila.getTasaOcuotaTras1());
                datos.add(fila.getImporteTras1());
                datos.add(fila.getImpuestoRet2());
                datos.add(fila.getTipoFactorRet2());
                datos.add(fila.getTasaOcuotaRet2());
                datos.add(fila.getImporteRet2());
                datos.add(fila.getImpuestoTras2());
                datos.add(fila.getTipoFactorTras2());
                datos.add(fila.getTasaOcuotaTras2());
                datos.add(fila.getImporteTras2());
                datos.add(fila.getImpuestoRet3());
                datos.add(fila.getTipoFactorRet3());
                datos.add(fila.getTasaOcuotaRet3());
                datos.add(fila.getImporteRet3());
                datos.add(fila.getImpuestoTras3());
                datos.add(fila.getTipoFactorTras3());
                datos.add(fila.getTasaOcuotaTras3());
                datos.add(fila.getImporteTras3());
                datos.add(fila.getUsoCfdi());
                datos.add(fila.getVersionTfd());
                datos.add(fila.getUuid());
                DetalleDao dDao = new DetalleDaoImpl();
                listaDetalle = dDao.listaDetalle(fila.getUuid());
                datos.add(fila.getFechaTimbrado());
                datos.add(fila.getRfcProvCertif());
                datos.add(fila.getSelloCfd());
                datos.add(fila.getNoCertificadoSat());
                datos.add(fila.getSelloSat());
                datos.add(fila.getTipo());
                datos.add(fila.getEstatusCfdi());
                datos.add(listaDetalle = dDao.listaDetalle(fila.getUuid()));
                tabla.addRow(datos);

            }

        }
        this.jTxtReg.setText(Integer.toString(listaCfdi.size()));
        return listaCfdi;

    }

    public void exportarExcel(JTable t) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xlsx");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                try (FileOutputStream archivo = new FileOutputStream(archivoXLS)) {
                    Sheet hoja = libro.createSheet("Datos");
                    hoja.setDisplayGridlines(true);
                    for (int f = 0; f < t.getRowCount(); f++) {
                        Row fila = hoja.createRow(f);
                        for (int c = 0; c < t.getColumnCount(); c++) {
                            Cell celda = fila.createCell(c);
                            if (f == 0) {
                                celda.setCellValue(t.getColumnName(c));
                            }
                        }
                    }
                    int filaInicio = 1;
                    for (int f = 0; f < t.getRowCount(); f++) {
                        Row fila = hoja.createRow(filaInicio);
                        filaInicio++;
                        for (int c = 0; c < t.getColumnCount(); c++) {
                            Cell celda = fila.createCell(c);
                            if (t.getValueAt(f, c) instanceof Double) {
                                celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                            } else if (t.getValueAt(f, c) instanceof Float) {
                                celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                            } else {
                                celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                            }
                        }
                    }
                    libro.write(archivo);
                }
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCBoxRfc = new javax.swing.JComboBox<>();
        jCBoxEmitidos = new javax.swing.JCheckBox();
        jCBoxRecibidos = new javax.swing.JCheckBox();
        jDCFin = new com.toedter.calendar.JDateChooser();
        jDCInicio = new com.toedter.calendar.JDateChooser();
        JBtnListar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLblRegistro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtReg = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CFDI 3.3 DESCARGA MASIVA XML-SAT. \"REPORTES CFDI'S EMITIDOS Y RECIBIDOS\"");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1060, 480));

        jScrollPane1.setAutoscrolls(true);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Version", "Fecha", "Serie", "Folio", "FormaPago", "SubTotal", "Moneda", "TipoCambio", "Total", "TipoDeComprobante", "MetodoPago", "CondicionesDePago", "Descuento", "LugarExpedicion", "Certificado", "NoCertificado", "Sello", "RfcEmisor", "NombreEmisor", "RegimenFiscal", "RfcReceptor", "NombreReceptor", "ImpLocTrasladado", "TasadeTraslado", "ImporteTraslado", "ImpuestoRet1", "TipoFactorRet1", "TasaOCuotaRet1", "ImporteRet1", "ImpuestoTras1", "TipoFactorTras1", "TasaOCuotaTras1", "ImporteTras1", "ImpuestoRet2", "TipoFactorRet2", "TasaOCuotaRet2", "ImporteRet2", "ImpuestoTras2", "TipoFactorTras2", "TasaOCuotaTras2", "ImporteTras2", "ImpuestoRet3", "TipoFactorRet3", "TasaOCuotaRet3", "ImporteRet3", "ImpuestoTras3", "TipoFactorTras3", "TasaOCuotaTras3", "ImporteTras3", "UsoCFDI", "VersionTFD", "UUID", "FechaTimbrado", "RfcProvCertif", "SelloCFD", "NoCertificadoSAT", "SelloSAT", "Tipo", "EstatusCfdi", "Detalle"
            }
        ));
        jTable1.setToolTipText("");
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jCBoxRfc.setToolTipText("");

        jCBoxEmitidos.setText("Cfdi´s Recibidos");
        jCBoxEmitidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxEmitidosActionPerformed(evt);
            }
        });

        jCBoxRecibidos.setText("Cfdi´s Emitidos");
        jCBoxRecibidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxRecibidosActionPerformed(evt);
            }
        });

        jDCFin.setToolTipText("Fecha final");
        jDCFin.setDateFormatString("yyyy-MM-dd");

        jDCInicio.setToolTipText("Fecha inicial");
        jDCInicio.setDateFormatString("yyyy-MM-dd");

        JBtnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/insoftec/img/buscar2.png"))); // NOI18N
        JBtnListar.setText("Buscar");
        JBtnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnListarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/insoftec/img/excel.png"))); // NOI18N
        jButton1.setText("Exportar a Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha final");

        jLabel4.setText("Fecha inicial");

        jLblRegistro.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLblRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/insoftec/img/database-icon.png"))); // NOI18N
        jLblRegistro.setText("Registros encontrados:");
        jLblRegistro.setToolTipText("");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/insoftec/img/rfc.png"))); // NOI18N
        jLabel2.setText("Lista de RFC");

        jTxtReg.setEditable(false);
        jTxtReg.setBackground(new java.awt.Color(153, 204, 255));
        jTxtReg.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTxtReg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtReg.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblRegistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtReg, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBoxRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCBoxRecibidos)
                    .addComponent(jCBoxEmitidos))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDCInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDCFin, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JBtnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jDCInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDCFin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBoxRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JBtnListar)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBoxEmitidos)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBoxRecibidos)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblRegistro)
                    .addComponent(jTxtReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLblRegistro.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBoxEmitidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxEmitidosActionPerformed
        jCBoxRecibidos.setSelected(false);
    }//GEN-LAST:event_jCBoxEmitidosActionPerformed

    private void jCBoxRecibidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxRecibidosActionPerformed
        jCBoxEmitidos.setSelected(false);
    }//GEN-LAST:event_jCBoxRecibidosActionPerformed

    @SuppressWarnings("SizeReplaceableByIsEmpty")
    private void JBtnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnListarActionPerformed

        if (!jCBoxEmitidos.isSelected() && !jCBoxRecibidos.isSelected()) {
            JOptionPane.showMessageDialog(null, "Favor de seleccionar emitidos o recibidos", "Información", JOptionPane.WARNING_MESSAGE);
        } else if (jCBoxRfc.getSelectedItem().toString().equals("SELECCIONA RFC")) {
            JOptionPane.showMessageDialog(null, "Favor de seleccionar un RFC", "Información", JOptionPane.WARNING_MESSAGE);
        } else if (jDCInicio.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Favor de seleccionar fecha inicial", "Información", JOptionPane.WARNING_MESSAGE);
        } else if (jDCFin.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Favor de seleccionar fecha final", "Información", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                if (getListaCfdi().size() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay regitros para tu búsqueda.", "Información", JOptionPane.WARNING_MESSAGE);
                } else {
                    getListaCfdi();
                }
            } catch (ParseException ex) {
                Logger.getLogger(JFReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JBtnListarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            exportarExcel(jTable1);
        } catch (IOException ex) {
            Logger.getLogger(JFReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnListar;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCBoxEmitidos;
    private javax.swing.JCheckBox jCBoxRecibidos;
    private javax.swing.JComboBox<String> jCBoxRfc;
    private com.toedter.calendar.JDateChooser jDCFin;
    private com.toedter.calendar.JDateChooser jDCInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblRegistro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtReg;
    // End of variables declaration//GEN-END:variables
}
