package mx.insoftec.view;

import static java.lang.Boolean.TRUE;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import mx.insoftec.dao.CfdiDao;
import mx.insoftec.dao.CfdiDaoImpl;
import mx.insoftec.dao.Conexion;

import mx.insoftec.model.Cfdi;
import org.datacontract.schemas._2004._07.sat_cfdi_negocio_consultacfdi.Acuse;
import org.tempuri.ConsultaCFDIService;
import org.tempuri.IConsultaCFDIService;

public class JInternalFrameValidador extends javax.swing.JInternalFrame implements Runnable {

    private ConsultaCFDIService consulta;
    private IConsultaCFDIService respuesta;
    private Acuse acuse;
    private List<Cfdi> listarCfdi;
    private Thread proceso1;
    private Thread proceso2;
    private Boolean bandera = TRUE;
    volatile boolean ejecutar = true;
    private Conexion conexion;
    private Calendar hoy;
    private int dia;
    private String fechaFinal;

    public JInternalFrameValidador() {
        initComponents();
    }

    public ConsultaCFDIService getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaCFDIService consulta) {
        this.consulta = consulta;
    }

    public IConsultaCFDIService getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(IConsultaCFDIService respuesta) {
        this.respuesta = respuesta;
    }

    public Acuse getAcuse() {
        return acuse;
    }

    public void setAcuse(Acuse acuse) {
        this.acuse = acuse;
    }

    public List<Cfdi> getListarCfdi() {
        return listarCfdi;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
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

    public Boolean getBandera() {
        return bandera;
    }

    public void setBandera(Boolean bandera) {
        this.bandera = bandera;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        btnValidar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CFDI 3.3 DESCARGA MASIVA XML-SAT. \"VALIDADOR CFDI'S\"");

        btnValidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/insoftec/img/refresh.png"))); // NOI18N
        btnValidar.setText("Actualizar");
        btnValidar.setToolTipText("Actualizar estatus CFDI");
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Total archivos procesados: 0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CFDI´s vigentes:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CFDI´s cancelados:");

        jDateChooser1.setToolTipText("Fecha inicial");
        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jDateChooser2.setToolTipText("Fecha final");
        jDateChooser2.setDateFormatString("yyyy-MM-dd");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fecha final");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fecha inicial");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel2)
                                    .addGap(37, 37, 37)
                                    .addComponent(jLabel3)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel4)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnValidar, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValidar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
@SuppressWarnings({"SleepWhileInLoop", "CallToThreadStopSuspendOrResumeManager"})
    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
    if (jDateChooser1.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Favor de seleccionar fecha inicial", "Información", JOptionPane.WARNING_MESSAGE);
    } else if (jDateChooser2.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Favor de seleccionar fecha final", "Información", JOptionPane.WARNING_MESSAGE);
    } else {

        proceso1 = new Thread(this);
        proceso2 = new Thread(this);
        proceso2.start();
        proceso1.start();
    }


    }//GEN-LAST:event_btnValidarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnValidar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    @Override
    @SuppressWarnings({"SleepWhileInLoop", "CallToThreadStopSuspendOrResumeManager"})
    public void run() {
        Thread hilos = Thread.currentThread();

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(JInternalFrameValidador.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (hilos == proceso2 && ejecutar == true) {
            jTextArea1.append("Por favor espere...\n");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(JInternalFrameValidador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        while (hilos == proceso1 && ejecutar == true) {
            Date fecInicial = jDateChooser1.getDate();
            this.hoy = jDateChooser2.getCalendar();
            System.out.println(this.hoy);
            this.dia = this.hoy.get(Calendar.DAY_OF_WEEK);
            this.hoy.add(Calendar.DATE, 1);
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            fechaFinal = formateador.format(hoy.getTime());
            SimpleDateFormat fInicial = new SimpleDateFormat(jDateChooser1.getDateFormatString());
            CfdiDao cDao = new CfdiDaoImpl();
            listarCfdi = cDao.listarTodo(fInicial.format(fecInicial), this.fechaFinal);
            int contador = 0;
            int contador2 = 0;
            for (Cfdi p : listarCfdi) {
                consulta = new ConsultaCFDIService();
                respuesta = consulta.getBasicHttpBindingIConsultaCFDIService();
                acuse = respuesta.consulta("?re=" + p.getRfcEmisor() + "&rr=" + p.getRfcReceptor() + "&tt=" + p.getTotal() + "&id=" + p.getUuid());
                contador++;
                jLabel1.setText("Total archivos procesados: " + contador);

                if (acuse.getEstado().getValue().equals("Cancelado")) {
                    jTextArea1.append(contador + " : " + p.getUuid() + " : " + p.getRfcEmisor() + " : " + acuse.getEstado().getValue() + " : " + acuse.getCodigoEstatus().getValue() + "\n");
                    contador2++;
                    try {
                        actualizarEstadoCfdi(p.getUuid());
                    } catch (SQLException ex) {
                        Logger.getLogger(JInternalFrameValidador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jLabel3.setText("CFDI´s cancelados: " + contador2);
                } else {
                    jLabel2.setText("CFDI´s vigentes: " + contador);
                }

            }
            jTextArea1.setText("");
            jTextArea1.append("Proceso terminado...\n");
            JOptionPane.showMessageDialog(null, "Se ha terminado el proceso de valiación de XML en el SAT", "Información", JOptionPane.INFORMATION_MESSAGE);
            ejecutar = false;
        }
    }

    public void actualizarEstadoCfdi(String uuid) throws SQLException {
        this.conexion = new Conexion();
        this.conexion.Conectar();
        Statement st = this.conexion.getConn().createStatement();
        st.execute("UPDATE cfdi SET EstatusCfdi='Cancelado' WHERE UUID='" + uuid + "'");
        this.conexion.Cerrar();
    }

}
