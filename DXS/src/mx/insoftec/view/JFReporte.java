package mx.insoftec.view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import mx.insoftec.dao.*;
import mx.insoftec.model.Cfdi;
import mx.insoftec.model.Detalle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class JFReporte extends javax.swing.JFrame {

    private List<Cfdi> listaCfdi;
    private List<String> listaCliente;
    private List<Detalle> listaDetalle;

    public List<Detalle> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<Detalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
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
        Date fecInicial = jDCInicio.getDate();
        Date fecFinal = jDCFin.getDate();
        SimpleDateFormat fInicial = new SimpleDateFormat(jDCInicio.getDateFormatString());
        SimpleDateFormat fFinal = new SimpleDateFormat(jDCFin.getDateFormatString());
        if (jCBoxEmitidos.isSelected()) {
            listaCfdi = cDao.listaCfdiReceptor(jCBoxRfc.getSelectedItem().toString(), fInicial.format(fecInicial), fFinal.format(fecFinal));
        } else if (jCBoxRecibidos.isSelected()) {
            listaCfdi = cDao.listaCfdiEmisor(jCBoxRfc.getSelectedItem().toString(), fInicial.format(fecInicial), fFinal.format(fecFinal));
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
        return listaCfdi;
    }

    public JFReporte() {
        initComponents();
        setLocationRelativeTo(this);
        llenarCombo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jCBoxRfc = new javax.swing.JComboBox<>();
        jCBoxEmitidos = new javax.swing.JCheckBox();
        jCBoxRecibidos = new javax.swing.JCheckBox();
        JBtnListar = new javax.swing.JButton();
        jDCFin = new com.toedter.calendar.JDateChooser();
        jDCInicio = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes CFDI Recibidos y Emitidos");

        jScrollPane1.setAutoscrolls(true);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Version", "Fecha", "Serie", "Folio", "FormaPago", "SubTotal", "Moneda", "TipoCambio", "Total", "TipoDeComprobante", "MetodoPago", "CondicionesDePago", "Descuento", "LugarExpedicion", "Certificado", "NoCertificado", "Sello", "RfcEmisor", "NombreEmisor", "RegimenFiscal", "RfcReceptor", "NombreReceptor", "ImpuestoRet1", "TipoFactorRet1", "TasaOCuotaRet1", "ImporteRet1", "ImpuestoTras1", "TipoFactorTras1", "TasaOCuotaTras1", "ImporteTras1", "ImpuestoRet2", "TipoFactorRet2", "TasaOCuotaRet2", "ImporteRet2", "ImpuestoTras2", "TipoFactorTras2", "TasaOCuotaTras2", "ImporteTras2", "ImpuestoRet3", "TipoFactorRet3", "TasaOCuotaRet3", "ImporteRet3", "ImpuestoTras3", "TipoFactorTras3", "TasaOCuotaTras3", "ImporteTras3", "UsoCFDI", "VersionTFD", "UUID", "FechaTimbrado", "RfcProvCertif", "SelloCFD", "NoCertificadoSAT", "SelloSAT", "Tipo", "EstatusCfdi", "Detalle"
            }
        ));
        jTable1.setToolTipText("");
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Exportar a Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCBoxRfc.setToolTipText("");

        jCBoxEmitidos.setText("Recibidos");
        jCBoxEmitidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxEmitidosActionPerformed(evt);
            }
        });

        jCBoxRecibidos.setText("Emitidos");
        jCBoxRecibidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoxRecibidosActionPerformed(evt);
            }
        });

        JBtnListar.setText("Listar");
        JBtnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnListarActionPerformed(evt);
            }
        });

        jDCFin.setToolTipText("Fecha final");
        jDCFin.setDateFormatString("yyyy-MM-dd");

        jDCInicio.setToolTipText("Fecha inicial");
        jDCInicio.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCBoxRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBoxRecibidos)
                            .addComponent(jCBoxEmitidos))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jDCInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDCFin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(160, 160, 160)
                        .addComponent(JBtnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(10, 10, 10)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JBtnListar)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCBoxEmitidos)
                            .addComponent(jDCInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCBoxRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCBoxRecibidos))
                            .addComponent(jDCFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            exportarExcel(jTable1);
        } catch (IOException ex) {
            Logger.getLogger(JFReporte.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCBoxRecibidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxRecibidosActionPerformed
        jCBoxEmitidos.setSelected(false);
    }//GEN-LAST:event_jCBoxRecibidosActionPerformed

    private void jCBoxEmitidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoxEmitidosActionPerformed
        jCBoxRecibidos.setSelected(false);
    }//GEN-LAST:event_jCBoxEmitidosActionPerformed

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
                getListaCfdi();
            } catch (ParseException ex) {
                Logger.getLogger(JFReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_JBtnListarActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnListar;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCBoxEmitidos;
    private javax.swing.JCheckBox jCBoxRecibidos;
    private javax.swing.JComboBox<String> jCBoxRfc;
    private com.toedter.calendar.JDateChooser jDCFin;
    private com.toedter.calendar.JDateChooser jDCInicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
