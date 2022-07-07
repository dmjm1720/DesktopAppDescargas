package mx.insoftec.model;
// Generated 14/06/2018 10:15:38 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Cfdi generated by hbm2java
 */
public class Cfdi  implements java.io.Serializable {


     private int id;
     private String versionCfdi;
     private String fecha;
     private String serie;
     private String folio;
     private String formaPago;
     private BigDecimal subTotal;
     private String moneda;
     private BigDecimal tipoCambio;
     private BigDecimal total;
     private String tipoDeComprobante;
     private String metodoPago;
     private String condicionesDePago;
     private BigDecimal descuento;
     private String lugarExpedicion;
     private String certificado;
     private String noCertificado;
     private String sello;
     private String rfcEmisor;
     private String nombreEmisor;
     private String regimenFiscal;
     private String rfcReceptor;
     private String nombreReceptor;
     private String impLocTrasladado;
     private String tasadeTraslado;
     private String importeTraslado;
     private String impuestoRet1;
     private String tipoFactorRet1;
     private String tasaOcuotaRet1;
     private BigDecimal importeRet1;
     private String impuestoTras1;
     private String tipoFactorTras1;
     private String tasaOcuotaTras1;
     private BigDecimal importeTras1;
     private String impuestoRet2;
     private String tipoFactorRet2;
     private String tasaOcuotaRet2;
     private BigDecimal importeRet2;
     private String impuestoTras2;
     private String tipoFactorTras2;
     private String tasaOcuotaTras2;
     private BigDecimal importeTras2;
     private String impuestoRet3;
     private String tipoFactorRet3;
     private String tasaOcuotaRet3;
     private BigDecimal importeRet3;
     private String impuestoTras3;
     private String tipoFactorTras3;
     private String tasaOcuotaTras3;
     private BigDecimal importeTras3;
     private String usoCfdi;
     private String versionTfd;
     private String uuid;
     private String fechaTimbrado;
     private String rfcProvCertif;
     private String selloCfd;
     private String noCertificadoSat;
     private String selloSat;
     private String nombreArchivo;
     private String tipo;
     private String estatusCfdi;

    public Cfdi() {
    }

	
    public Cfdi(int id) {
        this.id = id;
    }
    public Cfdi(int id, String versionCfdi, String fecha, String serie, String folio, String formaPago, BigDecimal subTotal, String moneda, BigDecimal tipoCambio, BigDecimal total, String tipoDeComprobante, String metodoPago, String condicionesDePago, BigDecimal descuento, String lugarExpedicion, String certificado, String noCertificado, String sello, String rfcEmisor, String nombreEmisor, String regimenFiscal, String rfcReceptor, String nombreReceptor, String impLocTrasladado, String tasadeTraslado, String importeTraslado, String impuestoRet1, String tipoFactorRet1, String tasaOcuotaRet1, BigDecimal importeRet1, String impuestoTras1, String tipoFactorTras1, String tasaOcuotaTras1, BigDecimal importeTras1, String impuestoRet2, String tipoFactorRet2, String tasaOcuotaRet2, BigDecimal importeRet2, String impuestoTras2, String tipoFactorTras2, String tasaOcuotaTras2, BigDecimal importeTras2, String impuestoRet3, String tipoFactorRet3, String tasaOcuotaRet3, BigDecimal importeRet3, String impuestoTras3, String tipoFactorTras3, String tasaOcuotaTras3, BigDecimal importeTras3, String usoCfdi, String versionTfd, String uuid, String fechaTimbrado, String rfcProvCertif, String selloCfd, String noCertificadoSat, String selloSat, String nombreArchivo, String tipo, String estatusCfdi) {
       this.id = id;
       this.versionCfdi = versionCfdi;
       this.fecha = fecha;
       this.serie = serie;
       this.folio = folio;
       this.formaPago = formaPago;
       this.subTotal = subTotal;
       this.moneda = moneda;
       this.tipoCambio = tipoCambio;
       this.total = total;
       this.tipoDeComprobante = tipoDeComprobante;
       this.metodoPago = metodoPago;
       this.condicionesDePago = condicionesDePago;
       this.descuento = descuento;
       this.lugarExpedicion = lugarExpedicion;
       this.certificado = certificado;
       this.noCertificado = noCertificado;
       this.sello = sello;
       this.rfcEmisor = rfcEmisor;
       this.nombreEmisor = nombreEmisor;
       this.regimenFiscal = regimenFiscal;
       this.rfcReceptor = rfcReceptor;
       this.nombreReceptor = nombreReceptor;
       this.impLocTrasladado = impLocTrasladado;
       this.tasadeTraslado = tasadeTraslado;
       this.importeTraslado = importeTraslado;
       this.impuestoRet1 = impuestoRet1;
       this.tipoFactorRet1 = tipoFactorRet1;
       this.tasaOcuotaRet1 = tasaOcuotaRet1;
       this.importeRet1 = importeRet1;
       this.impuestoTras1 = impuestoTras1;
       this.tipoFactorTras1 = tipoFactorTras1;
       this.tasaOcuotaTras1 = tasaOcuotaTras1;
       this.importeTras1 = importeTras1;
       this.impuestoRet2 = impuestoRet2;
       this.tipoFactorRet2 = tipoFactorRet2;
       this.tasaOcuotaRet2 = tasaOcuotaRet2;
       this.importeRet2 = importeRet2;
       this.impuestoTras2 = impuestoTras2;
       this.tipoFactorTras2 = tipoFactorTras2;
       this.tasaOcuotaTras2 = tasaOcuotaTras2;
       this.importeTras2 = importeTras2;
       this.impuestoRet3 = impuestoRet3;
       this.tipoFactorRet3 = tipoFactorRet3;
       this.tasaOcuotaRet3 = tasaOcuotaRet3;
       this.importeRet3 = importeRet3;
       this.impuestoTras3 = impuestoTras3;
       this.tipoFactorTras3 = tipoFactorTras3;
       this.tasaOcuotaTras3 = tasaOcuotaTras3;
       this.importeTras3 = importeTras3;
       this.usoCfdi = usoCfdi;
       this.versionTfd = versionTfd;
       this.uuid = uuid;
       this.fechaTimbrado = fechaTimbrado;
       this.rfcProvCertif = rfcProvCertif;
       this.selloCfd = selloCfd;
       this.noCertificadoSat = noCertificadoSat;
       this.selloSat = selloSat;
       this.nombreArchivo = nombreArchivo;
       this.tipo = tipo;
       this.estatusCfdi = estatusCfdi;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getVersionCfdi() {
        return this.versionCfdi;
    }
    
    public void setVersionCfdi(String versionCfdi) {
        this.versionCfdi = versionCfdi;
    }
    public String getFecha() {
        return this.fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getSerie() {
        return this.serie;
    }
    
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public String getFolio() {
        return this.folio;
    }
    
    public void setFolio(String folio) {
        this.folio = folio;
    }
    public String getFormaPago() {
        return this.formaPago;
    }
    
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    public BigDecimal getSubTotal() {
        return this.subTotal;
    }
    
    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
    public String getMoneda() {
        return this.moneda;
    }
    
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    public BigDecimal getTipoCambio() {
        return this.tipoCambio;
    }
    
    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
    public BigDecimal getTotal() {
        return this.total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public String getTipoDeComprobante() {
        return this.tipoDeComprobante;
    }
    
    public void setTipoDeComprobante(String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }
    public String getMetodoPago() {
        return this.metodoPago;
    }
    
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    public String getCondicionesDePago() {
        return this.condicionesDePago;
    }
    
    public void setCondicionesDePago(String condicionesDePago) {
        this.condicionesDePago = condicionesDePago;
    }
    public BigDecimal getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }
    public String getLugarExpedicion() {
        return this.lugarExpedicion;
    }
    
    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }
    public String getCertificado() {
        return this.certificado;
    }
    
    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }
    public String getNoCertificado() {
        return this.noCertificado;
    }
    
    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }
    public String getSello() {
        return this.sello;
    }
    
    public void setSello(String sello) {
        this.sello = sello;
    }
    public String getRfcEmisor() {
        return this.rfcEmisor;
    }
    
    public void setRfcEmisor(String rfcEmisor) {
        this.rfcEmisor = rfcEmisor;
    }
    public String getNombreEmisor() {
        return this.nombreEmisor;
    }
    
    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }
    public String getRegimenFiscal() {
        return this.regimenFiscal;
    }
    
    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }
    public String getRfcReceptor() {
        return this.rfcReceptor;
    }
    
    public void setRfcReceptor(String rfcReceptor) {
        this.rfcReceptor = rfcReceptor;
    }
    public String getNombreReceptor() {
        return this.nombreReceptor;
    }
    
    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }
    public String getImpLocTrasladado() {
        return this.impLocTrasladado;
    }
    
    public void setImpLocTrasladado(String impLocTrasladado) {
        this.impLocTrasladado = impLocTrasladado;
    }
    public String getTasadeTraslado() {
        return this.tasadeTraslado;
    }
    
    public void setTasadeTraslado(String tasadeTraslado) {
        this.tasadeTraslado = tasadeTraslado;
    }
    public String getImporteTraslado() {
        return this.importeTraslado;
    }
    
    public void setImporteTraslado(String importeTraslado) {
        this.importeTraslado = importeTraslado;
    }
    public String getImpuestoRet1() {
        return this.impuestoRet1;
    }
    
    public void setImpuestoRet1(String impuestoRet1) {
        this.impuestoRet1 = impuestoRet1;
    }
    public String getTipoFactorRet1() {
        return this.tipoFactorRet1;
    }
    
    public void setTipoFactorRet1(String tipoFactorRet1) {
        this.tipoFactorRet1 = tipoFactorRet1;
    }
    public String getTasaOcuotaRet1() {
        return this.tasaOcuotaRet1;
    }
    
    public void setTasaOcuotaRet1(String tasaOcuotaRet1) {
        this.tasaOcuotaRet1 = tasaOcuotaRet1;
    }
    public BigDecimal getImporteRet1() {
        return this.importeRet1;
    }
    
    public void setImporteRet1(BigDecimal importeRet1) {
        this.importeRet1 = importeRet1;
    }
    public String getImpuestoTras1() {
        return this.impuestoTras1;
    }
    
    public void setImpuestoTras1(String impuestoTras1) {
        this.impuestoTras1 = impuestoTras1;
    }
    public String getTipoFactorTras1() {
        return this.tipoFactorTras1;
    }
    
    public void setTipoFactorTras1(String tipoFactorTras1) {
        this.tipoFactorTras1 = tipoFactorTras1;
    }
    public String getTasaOcuotaTras1() {
        return this.tasaOcuotaTras1;
    }
    
    public void setTasaOcuotaTras1(String tasaOcuotaTras1) {
        this.tasaOcuotaTras1 = tasaOcuotaTras1;
    }
    public BigDecimal getImporteTras1() {
        return this.importeTras1;
    }
    
    public void setImporteTras1(BigDecimal importeTras1) {
        this.importeTras1 = importeTras1;
    }
    public String getImpuestoRet2() {
        return this.impuestoRet2;
    }
    
    public void setImpuestoRet2(String impuestoRet2) {
        this.impuestoRet2 = impuestoRet2;
    }
    public String getTipoFactorRet2() {
        return this.tipoFactorRet2;
    }
    
    public void setTipoFactorRet2(String tipoFactorRet2) {
        this.tipoFactorRet2 = tipoFactorRet2;
    }
    public String getTasaOcuotaRet2() {
        return this.tasaOcuotaRet2;
    }
    
    public void setTasaOcuotaRet2(String tasaOcuotaRet2) {
        this.tasaOcuotaRet2 = tasaOcuotaRet2;
    }
    public BigDecimal getImporteRet2() {
        return this.importeRet2;
    }
    
    public void setImporteRet2(BigDecimal importeRet2) {
        this.importeRet2 = importeRet2;
    }
    public String getImpuestoTras2() {
        return this.impuestoTras2;
    }
    
    public void setImpuestoTras2(String impuestoTras2) {
        this.impuestoTras2 = impuestoTras2;
    }
    public String getTipoFactorTras2() {
        return this.tipoFactorTras2;
    }
    
    public void setTipoFactorTras2(String tipoFactorTras2) {
        this.tipoFactorTras2 = tipoFactorTras2;
    }
    public String getTasaOcuotaTras2() {
        return this.tasaOcuotaTras2;
    }
    
    public void setTasaOcuotaTras2(String tasaOcuotaTras2) {
        this.tasaOcuotaTras2 = tasaOcuotaTras2;
    }
    public BigDecimal getImporteTras2() {
        return this.importeTras2;
    }
    
    public void setImporteTras2(BigDecimal importeTras2) {
        this.importeTras2 = importeTras2;
    }
    public String getImpuestoRet3() {
        return this.impuestoRet3;
    }
    
    public void setImpuestoRet3(String impuestoRet3) {
        this.impuestoRet3 = impuestoRet3;
    }
    public String getTipoFactorRet3() {
        return this.tipoFactorRet3;
    }
    
    public void setTipoFactorRet3(String tipoFactorRet3) {
        this.tipoFactorRet3 = tipoFactorRet3;
    }
    public String getTasaOcuotaRet3() {
        return this.tasaOcuotaRet3;
    }
    
    public void setTasaOcuotaRet3(String tasaOcuotaRet3) {
        this.tasaOcuotaRet3 = tasaOcuotaRet3;
    }
    public BigDecimal getImporteRet3() {
        return this.importeRet3;
    }
    
    public void setImporteRet3(BigDecimal importeRet3) {
        this.importeRet3 = importeRet3;
    }
    public String getImpuestoTras3() {
        return this.impuestoTras3;
    }
    
    public void setImpuestoTras3(String impuestoTras3) {
        this.impuestoTras3 = impuestoTras3;
    }
    public String getTipoFactorTras3() {
        return this.tipoFactorTras3;
    }
    
    public void setTipoFactorTras3(String tipoFactorTras3) {
        this.tipoFactorTras3 = tipoFactorTras3;
    }
    public String getTasaOcuotaTras3() {
        return this.tasaOcuotaTras3;
    }
    
    public void setTasaOcuotaTras3(String tasaOcuotaTras3) {
        this.tasaOcuotaTras3 = tasaOcuotaTras3;
    }
    public BigDecimal getImporteTras3() {
        return this.importeTras3;
    }
    
    public void setImporteTras3(BigDecimal importeTras3) {
        this.importeTras3 = importeTras3;
    }
    public String getUsoCfdi() {
        return this.usoCfdi;
    }
    
    public void setUsoCfdi(String usoCfdi) {
        this.usoCfdi = usoCfdi;
    }
    public String getVersionTfd() {
        return this.versionTfd;
    }
    
    public void setVersionTfd(String versionTfd) {
        this.versionTfd = versionTfd;
    }
    public String getUuid() {
        return this.uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getFechaTimbrado() {
        return this.fechaTimbrado;
    }
    
    public void setFechaTimbrado(String fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }
    public String getRfcProvCertif() {
        return this.rfcProvCertif;
    }
    
    public void setRfcProvCertif(String rfcProvCertif) {
        this.rfcProvCertif = rfcProvCertif;
    }
    public String getSelloCfd() {
        return this.selloCfd;
    }
    
    public void setSelloCfd(String selloCfd) {
        this.selloCfd = selloCfd;
    }
    public String getNoCertificadoSat() {
        return this.noCertificadoSat;
    }
    
    public void setNoCertificadoSat(String noCertificadoSat) {
        this.noCertificadoSat = noCertificadoSat;
    }
    public String getSelloSat() {
        return this.selloSat;
    }
    
    public void setSelloSat(String selloSat) {
        this.selloSat = selloSat;
    }
    public String getNombreArchivo() {
        return this.nombreArchivo;
    }
    
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getEstatusCfdi() {
        return this.estatusCfdi;
    }
    
    public void setEstatusCfdi(String estatusCfdi) {
        this.estatusCfdi = estatusCfdi;
    }




}

