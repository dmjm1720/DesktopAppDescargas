package mx.insoftec.dao;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import mx.insoftec.model.Cfdi;
import mx.insoftec.model.Detalle;
import mx.insoftec.model.Impuesto;
import org.datacontract.schemas._2004._07.sat_cfdi_negocio_consultacfdi.Acuse;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.tempuri.ConsultaCFDIService;
import org.tempuri.IConsultaCFDIService;

public class LeerXML {

    private Impuesto impuesto;
    private Cfdi cfdi;
    private Detalle det;
    private String rfcEmisor;
    private String rfcReceptor;
    private String id;
    private final String vacio = "0";
    private List<String> lista;
    private List<String> listaImpRet;
    private List<String> listaImpTras;
    private int listaIT = 0;
    private int listaIR = 0;
    private ConsultaCFDIService consulta;
    private IConsultaCFDIService respuesta;
    private Acuse acuse;
    private String fechaFac;
    private BigDecimal monto;
    private List<Cfdi> listarUUID;
    private Boolean bandera;
    private Boolean banderaImpTras = false;
    private Double ieps = 0.0;
    private Double iva = 0.0;
    private Double isr = 0.0;
    private String conceptoIeps;
    private String conceptoIva;
    private String conceptoIsr;
    private String conceptoFactIeps;
    private String conceptoFactIva;
    private String conceptoFactIsr;
    private String tasaIeps;
    private String tasaIva;
    private String tasaIsr;
    private Double miVal = 0.0;
    private Double midescuento = 0.0;
    private String descCfdi;

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public int getListaIT() {
        return listaIT;
    }

    public void setListaIT(int listaIT) {
        this.listaIT = listaIT;
    }

    public int getListaIR() {
        return listaIR;
    }

    public void setListaIR(int listaIR) {
        this.listaIR = listaIR;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    public List<String> getListaImpRet() {
        return listaImpRet;
    }

    public void setListaImpRet(List<String> listaImpRet) {
        this.listaImpRet = listaImpRet;
    }

    public List<String> getListaImpTras() {
        return listaImpTras;
    }

    public void setListaImpTras(List<String> listaImpTras) {
        this.listaImpTras = listaImpTras;
    }

    public Detalle getDet() {
        return det;
    }

    public void setDet(Detalle det) {
        this.det = det;
    }

    public Cfdi getCfdi() {
        return cfdi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRfcReceptor() {
        return rfcReceptor;
    }

    public void setRfcReceptor(String rfcReceptor) {
        this.rfcReceptor = rfcReceptor;
    }

    public String getRfcEmisor() {
        return rfcEmisor;
    }

    public void setRfcEmisor(String rfcEmisor) {
        this.rfcEmisor = rfcEmisor;
    }

    public void setCfdi(Cfdi cfdi) {
        this.cfdi = cfdi;
    }

    public String getFechaFac() {
        return fechaFac;
    }

    public void setFechaFac(String fechaFac) {
        this.fechaFac = fechaFac;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public List<Cfdi> getListarUUID() {
        return listarUUID;
    }

    public Boolean getBandera() {
        return bandera;
    }

    public void setBandera(Boolean bandera) {
        this.bandera = bandera;
    }

    public Boolean getBanderaImpTras() {
        return banderaImpTras;
    }

    public void setBanderaImpTras(Boolean banderaImpTras) {
        this.banderaImpTras = banderaImpTras;
    }

    public Double getIeps() {
        return ieps;
    }

    public void setIeps(Double ieps) {
        this.ieps = ieps;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getIsr() {
        return isr;
    }

    public void setIsr(Double isr) {
        this.isr = isr;
    }

    public String getConceptoIeps() {
        return conceptoIeps;
    }

    public void setConceptoIeps(String conceptoIeps) {
        this.conceptoIeps = conceptoIeps;
    }

    public String getConceptoIva() {
        return conceptoIva;
    }

    public void setConceptoIva(String conceptoIva) {
        this.conceptoIva = conceptoIva;
    }

    public String getConceptoIsr() {
        return conceptoIsr;
    }

    public void setConceptoIsr(String conceptoIsr) {
        this.conceptoIsr = conceptoIsr;
    }

    public String getTasaIeps() {
        return tasaIeps;
    }

    public void setTasaIeps(String tasaIeps) {
        this.tasaIeps = tasaIeps;
    }

    public String getTasaIva() {
        return tasaIva;
    }

    public void setTasaIva(String tasaIva) {
        this.tasaIva = tasaIva;
    }

    public String getTasaIsr() {
        return tasaIsr;
    }

    public void setTasaIsr(String tasaIsr) {
        this.tasaIsr = tasaIsr;
    }

    public String getConceptoFactIeps() {
        return conceptoFactIeps;
    }

    public void setConceptoFactIeps(String conceptoFactIeps) {
        this.conceptoFactIeps = conceptoFactIeps;
    }

    public String getConceptoFactIva() {
        return conceptoFactIva;
    }

    public void setConceptoFactIva(String conceptoFactIva) {
        this.conceptoFactIva = conceptoFactIva;
    }

    public String getConceptoFactIsr() {
        return conceptoFactIsr;
    }

    public void setConceptoFactIsr(String conceptoFactIsr) {
        this.conceptoFactIsr = conceptoFactIsr;
    }

    public Double getMiVal() {
        return miVal;
    }

    public void setMiVal(Double miVal) {
        this.miVal = miVal;
    }

    public Double getMidescuento() {
        return midescuento;
    }

    public void setMidescuento(Double midescuento) {
        this.midescuento = midescuento;
    }

    public String getDescCfdi() {
        return descCfdi;
    }

    public void setDescCfdi(String descCfdi) {
        this.descCfdi = descCfdi;
    }

    public LeerXML() {
        cfdi = new Cfdi();
        det = new Detalle();
        impuesto = new Impuesto();
        this.lista = new ArrayList<>();
        this.listaImpRet = new ArrayList<>();
        this.listaImpTras = new ArrayList<>();
    }

    public void leerXML(String ruta, String nombreArchivo, String tipo) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(ruta);
        Document document = (Document) builder.build(xmlFile);
        Element rootNode = document.getRootElement();
        cfdi.setSerie(rootNode.getAttributeValue("serie"));
        if (cfdi.getSerie() == null) {
            cfdi.setSerie(rootNode.getAttributeValue("Serie"));
        }
        cfdi.setFolio(rootNode.getAttributeValue("folio"));
        if (cfdi.getFolio() == null) {
            cfdi.setFolio(rootNode.getAttributeValue("Folio"));
        }
        cfdi.setFecha(rootNode.getAttributeValue("fecha"));
        if (cfdi.getFecha() == null) {
            cfdi.setFecha(rootNode.getAttributeValue("Fecha"));
        }
        cfdi.setSello(rootNode.getAttributeValue("sello"));
        if (cfdi.getSello() == null) {
            cfdi.setSello(rootNode.getAttributeValue("Sello"));
        }
        cfdi.setFormaPago(rootNode.getAttributeValue("formaDePago"));
        if (cfdi.getFormaPago() == null) {
            cfdi.setFormaPago(rootNode.getAttributeValue("FormaPago"));
        }
        cfdi.setNoCertificado(rootNode.getAttributeValue("noCertificado"));
        if (cfdi.getNoCertificado() == null) {
            cfdi.setNoCertificado(rootNode.getAttributeValue("NoCertificado"));
        }
        cfdi.setCertificado(rootNode.getAttributeValue("certificado"));
        if (cfdi.getCertificado() == null) {
            cfdi.setCertificado(rootNode.getAttributeValue("Certificado"));
        }
        if (rootNode.getAttributeValue("subTotal") != null) {
            cfdi.setSubTotal(new BigDecimal(rootNode.getAttributeValue("subTotal")));
        } else if (rootNode.getAttributeValue("SubTotal") != null) {
            cfdi.setSubTotal(new BigDecimal(rootNode.getAttributeValue("SubTotal")));
        }

        if (rootNode.getAttributeValue("tipoCambio") != null) {
            cfdi.setTipoCambio(new BigDecimal(rootNode.getAttributeValue("tipoCambio")));
        } else if (rootNode.getAttributeValue("TipoCambio") != null) {
            cfdi.setTipoCambio(new BigDecimal(rootNode.getAttributeValue("TipoCambio")));
        }

        cfdi.setMoneda(rootNode.getAttributeValue("moneda"));
        if (cfdi.getMoneda() == null) {
            cfdi.setMoneda(rootNode.getAttributeValue("Moneda"));
        }
        if (rootNode.getAttributeValue("total") != null) {
            cfdi.setTotal(new BigDecimal(rootNode.getAttributeValue("total")));
        } else if (rootNode.getAttributeValue("Total") != null) {
            cfdi.setTotal(new BigDecimal(rootNode.getAttributeValue("Total")));
        }
        cfdi.setTipoDeComprobante(rootNode.getAttributeValue("tipoDeComprobante"));
        if (cfdi.getTipoDeComprobante() == null) {
            cfdi.setTipoDeComprobante(rootNode.getAttributeValue("TipoDeComprobante"));
        }
        cfdi.setMetodoPago(rootNode.getAttributeValue("metodoDePago"));
        if (cfdi.getMetodoPago() == null) {
            cfdi.setMetodoPago(rootNode.getAttributeValue("MetodoPago"));
        }
        cfdi.setLugarExpedicion(rootNode.getAttributeValue("LugarExpedicion"));
        if (cfdi.getLugarExpedicion() == null) {
            cfdi.setLugarExpedicion(rootNode.getAttributeValue("LugarExpedicion"));
        }
        cfdi.setVersionCfdi(rootNode.getAttributeValue("version"));
        if (cfdi.getVersionCfdi() == null) {
            cfdi.setVersionCfdi(rootNode.getAttributeValue("Version"));
        }
        List list = rootNode.getChildren();
        for (int i = 0; i < list.size(); i++) {
            Element elementoCFDI = (Element) list.get(i);
            String valor = elementoCFDI.getName();
            if (valor.equals("Emisor")) {
                cfdi.setRfcEmisor(elementoCFDI.getAttributeValue("rfc"));
                if (cfdi.getRfcEmisor() == null) {
                    cfdi.setRfcEmisor(elementoCFDI.getAttributeValue("Rfc"));
                }
                cfdi.setNombreEmisor(elementoCFDI.getAttributeValue("nombre"));
                if (cfdi.getNombreEmisor() == null) {
                    cfdi.setNombreEmisor(elementoCFDI.getAttributeValue("Nombre"));
                }
                cfdi.setRegimenFiscal(elementoCFDI.getAttributeValue("RegimenFiscal"));
                rfcEmisor = cfdi.getRfcEmisor();
            }
            if (valor.equals("Receptor")) {
                cfdi.setRfcReceptor(elementoCFDI.getAttributeValue("rfc"));
                if (cfdi.getRfcReceptor() == null) {
                    cfdi.setRfcReceptor(elementoCFDI.getAttributeValue("Rfc"));
                }
                cfdi.setNombreReceptor(elementoCFDI.getAttributeValue("nombre"));
                if (cfdi.getNombreReceptor() == null) {
                    cfdi.setNombreReceptor(elementoCFDI.getAttributeValue("Nombre"));
                }
                cfdi.setUsoCfdi(elementoCFDI.getAttributeValue("UsoCFDI"));
                rfcReceptor = cfdi.getRfcReceptor();
            }

            List listaCampos = elementoCFDI.getChildren();

            for (int j = 0; j < listaCampos.size(); j++) {
                Element campo = (Element) listaCampos.get(j);
                String valor2 = campo.getName();

                if (valor2.equals("RegimenFiscal")) {
                    cfdi.setRegimenFiscal(campo.getAttributeValue("Regimen"));
                }

                if (valor2.equals("TimbreFiscalDigital")) {
                    cfdi.setRfcProvCertif(campo.getAttributeValue("RfcProvCertif"));
                    cfdi.setVersionTfd(campo.getAttributeValue("version"));
                    if (cfdi.getVersionTfd() == null) {
                        cfdi.setVersionTfd(campo.getAttributeValue("Version"));
                    }
                    cfdi.setUuid(campo.getAttributeValue("uuid"));
                    if (cfdi.getUuid() == null) {
                        cfdi.setUuid(campo.getAttributeValue("UUID"));
                    }
                    this.id = cfdi.getUuid();
                    cfdi.setFechaTimbrado(campo.getAttributeValue("fechaTimbrado"));
                    if (cfdi.getFechaTimbrado() == null) {
                        cfdi.setFechaTimbrado(campo.getAttributeValue("FechaTimbrado"));
                    }
                    cfdi.setSelloCfd(campo.getAttributeValue("selloCFD"));
                    if (cfdi.getSelloCfd() == null) {
                        cfdi.setSelloCfd(campo.getAttributeValue("SelloCFD"));
                    }
                    cfdi.setNoCertificadoSat(campo.getAttributeValue("noCertificadoSAT"));
                    if (cfdi.getNoCertificadoSat() == null) {
                        cfdi.setNoCertificadoSat(campo.getAttributeValue("NoCertificadoSAT"));
                    }
                    cfdi.setSelloSat(campo.getAttributeValue("selloSAT"));
                    if (cfdi.getSelloSat() == null) {
                        cfdi.setSelloSat(campo.getAttributeValue("SelloSAT"));
                    }
                }
                if (valor2.equals("Concepto")) {
                    det.setCantidad(campo.getAttributeValue("cantidad"));
                    if (det.getCantidad() == null) {
                        det.setCantidad(campo.getAttributeValue("Cantidad"));
                    }
                    det.setUnidad(campo.getAttributeValue("unidad"));
                    if (det.getUnidad() == null) {
                        det.setUnidad(campo.getAttributeValue("Unidad"));
                    }

                    det.setClaveUnidad(campo.getAttributeValue("ClaveUnidad"));

                    det.setDescripcion(campo.getAttributeValue("descripcion"));
                    if (det.getDescripcion() == null) {
                        det.setDescripcion(campo.getAttributeValue("Descripcion"));//
                    }
                    if (campo.getAttributeValue("valorUnitario") != null) {
                        det.setValorUnitario(new BigDecimal(campo.getAttributeValue("valorUnitario")));//
                    } else if (campo.getAttributeValue("ValorUnitario") != null) {
                        det.setValorUnitario(new BigDecimal(campo.getAttributeValue("ValorUnitario")));
                    }
                    if (campo.getAttributeValue("importe") != null) {
                        det.setImporte(new BigDecimal(campo.getAttributeValue("importe")));
                    } else if (campo.getAttributeValue("Importe") != null) {
                        det.setImporte(new BigDecimal(campo.getAttributeValue("Importe")));
                    }
                    det.setClaveProdServ(campo.getAttributeValue("ClaveProdServ"));

                    if (campo.getAttributeValue("Descuento") != null) {
                        det.setMiDescuento(new BigDecimal(campo.getAttributeValue("Descuento")));
                        this.midescuento += det.getMiDescuento().doubleValue();
                    } else {
                        det.setMiDescuento(new BigDecimal("0.0"));
                    }

                    lista.add(det.getCantidad());
                    lista.add(det.getUnidad());
                    lista.add(det.getDescripcion());
                    lista.add(det.getValorUnitario().toString());
                    lista.add(det.getImporte().toString());
                    lista.add(det.getClaveProdServ());
                    lista.add(det.getClaveUnidad());
                    lista.add(det.getMiDescuento().toString());

                    //Para almacenar los datos del concepto en una lista
                    List ImpRetTras = campo.getChildren();
                    for (int e = 0; e < ImpRetTras.size(); e++) {
                        Element val = (Element) ImpRetTras.get(e);
                        List ImpuestoRetTras = val.getChildren();
                        for (int u = 0; u < ImpuestoRetTras.size(); u++) {
                            Element val2 = (Element) ImpuestoRetTras.get(u);
                            List OtrosImpRT = val2.getChildren();
                            for (int w = 0; w < OtrosImpRT.size(); w++) {
                                Element val3 = (Element) OtrosImpRT.get(w);
                                String var = val3.getName();
                                if (var.equals("Traslado")) {

                                    impuesto.setImpuestoTras(val3.getAttributeValue("impuesto"));
                                    if (impuesto.getImpuestoTras() == null) {
                                        impuesto.setImpuestoTras(val3.getAttributeValue("Impuesto"));
                                    }
                                    impuesto.setTipoFactorTras(val3.getAttributeValue("TipoFactor"));
                                    if (impuesto.getTipoFactorTras() == null) {
                                        impuesto.setTipoFactorTras(val3.getAttributeValue("TipoFactor"));
                                    }
                                    impuesto.setTasaOCuotaTras(val3.getAttributeValue("tasa"));
                                    if (impuesto.getTasaOCuotaTras() == null) {
                                        impuesto.setTasaOCuotaTras(val3.getAttributeValue("Tasa"));
                                    }
                                    if (impuesto.getTasaOCuotaTras() == null) {
                                        impuesto.setTasaOCuotaTras(val3.getAttributeValue("TasaOCuota"));
                                    }
                                    impuesto.setImporteTras(val3.getAttributeValue("importe"));
                                    if (impuesto.getImporteTras() == null) {
                                        impuesto.setImporteTras(val3.getAttributeValue("Importe"));
                                    }
                                    this.miVal = 0.0;
                                    if (impuesto.getImporteTras() != null) {
                                        this.miVal = (new Double(impuesto.getImporteTras()));
                                    }

                                    if (this.miVal > 0.0) {
                                        switch (impuesto.getImpuestoTras()) {
                                            case "001":
                                                this.isr += new Double(impuesto.getImporteTras());
                                                this.conceptoIsr = impuesto.getImpuestoTras();
                                                this.conceptoFactIsr = impuesto.getTipoFactorTras();
                                                this.tasaIsr = impuesto.getTasaOCuotaTras();
                                                break;
                                            case "002":
                                                this.iva += new Double(impuesto.getImporteTras());
                                                this.conceptoIva = impuesto.getImpuestoTras();
                                                this.conceptoFactIva = impuesto.getTipoFactorTras();
                                                this.tasaIva = impuesto.getTasaOCuotaTras();
                                                break;
                                            case "003":
                                                this.ieps += new Double(impuesto.getImporteTras());
                                                this.conceptoIeps = impuesto.getImpuestoTras();
                                                this.conceptoFactIeps = impuesto.getTipoFactorTras();
                                                this.tasaIeps = impuesto.getTasaOCuotaTras();
                                                break;
                                            default:
                                                break;
                                        }

                                    }

                                }

                                if (var.equals("Retencion")) {
                                    impuesto.setImpuestoRet(val3.getAttributeValue("impuesto"));
                                    if (impuesto.getImpuestoRet() == null) {
                                        impuesto.setImpuestoRet(val3.getAttributeValue("Impuesto"));
                                    }
                                    impuesto.setTipoFactorRet(val3.getAttributeValue("TipoFactor"));
                                    if (impuesto.getTipoFactorRet() == null) {
                                        impuesto.setTipoFactorRet(val3.getAttributeValue("TipoFactor"));
                                    }
                                    impuesto.setTasaOCuotaRet(val3.getAttributeValue("tasa"));
                                    if (impuesto.getTasaOCuotaRet() == null) {
                                        impuesto.setTasaOCuotaRet(val3.getAttributeValue("Tasa"));
                                    }
                                    if (impuesto.getTasaOCuotaRet() == null) {
                                        impuesto.setTasaOCuotaRet(val3.getAttributeValue("TasaOCuota"));
                                    }
                                    impuesto.setImporteRet(val3.getAttributeValue("importe"));
                                    if (impuesto.getImporteRet() == null) {
                                        impuesto.setImporteRet(val3.getAttributeValue("Importe"));
                                    }
                                    listaImpRet.add(impuesto.getImpuestoRet());
                                    listaImpRet.add(impuesto.getTipoFactorRet());
                                    listaImpRet.add(impuesto.getTasaOCuotaRet());
                                    listaImpRet.add(impuesto.getImporteRet());
                                }
                            }

                        }

                    }

                }

                List impLocales = campo.getChildren();
                for (int r = 0; r < impLocales.size(); r++) {
                    Element campoImpLoc = (Element) impLocales.get(r);
                    String dato = campoImpLoc.getName();
                    if (dato.equals("TrasladosLocales")) {
                        cfdi.setImpLocTrasladado(campoImpLoc.getAttributeValue("ImpLocTrasladado"));
                        cfdi.setTasadeTraslado(campoImpLoc.getAttributeValue("TasadeTraslado"));
                        cfdi.setImporteTraslado(campoImpLoc.getAttributeValue("Importe"));
                    }
                }

            }

        }

        if (this.isr > 0) {
            listaImpTras.add(this.conceptoIsr);
            listaImpTras.add(this.conceptoFactIsr);
            listaImpTras.add(this.tasaIsr);
            listaImpTras.add(this.isr.toString());
        }
        if (this.iva > 0) {
            listaImpTras.add(this.conceptoIva);
            listaImpTras.add(this.conceptoFactIva);
            listaImpTras.add(this.tasaIva);
            listaImpTras.add(this.iva.toString());
        }
        if (this.ieps > 0) {
            listaImpTras.add(this.conceptoIeps);
            listaImpTras.add(this.conceptoFactIeps);
            listaImpTras.add(this.tasaIeps);
            listaImpTras.add(this.ieps.toString());
        }

        int a1 = 0, a2 = 0;
        int b1 = 1, b2 = 1;
        int c1 = 2, c2 = 2;
        int d1 = 3, d2 = 3;
        int e1 = 4, e2 = 4;
        int f1 = 5, f2 = 5;
        int g1 = 6, g2 = 6;
        int h1 = 7, h2 = 7;
        int i1 = 8, i2 = 8;
        int j1 = 9, j2 = 9;
        int k1 = 10, k2 = 10;
        int l1 = 11, l2 = 11;
        if (listaImpRet.size() > 0) {
            listaIR = listaImpRet.size() / listaImpRet.size();
        }
        if (listaImpTras.size() > 0) {
            listaIT = listaImpTras.size() / listaImpTras.size();
        }

        switch (listaImpTras.size()) {
            case 0:
                cfdi.setImpuestoTras1(vacio);
                cfdi.setTipoFactorTras1(vacio);
                cfdi.setTasaOcuotaTras1(vacio);
                cfdi.setImporteTras1(new BigDecimal(vacio));
                cfdi.setImpuestoTras2(vacio);
                cfdi.setTipoFactorTras2(vacio);
                cfdi.setTasaOcuotaTras2(vacio);
                cfdi.setImporteTras2(new BigDecimal(vacio));
                cfdi.setImpuestoTras3(vacio);
                cfdi.setTipoFactorTras3(vacio);
                cfdi.setTasaOcuotaTras3(vacio);
                cfdi.setImporteTras3(new BigDecimal(vacio));
                break;
            case 4:
                while (listaIT > 0) {
                    cfdi.setImpuestoTras1(listaImpTras.get(a1));
                    cfdi.setTipoFactorTras1(listaImpTras.get(b1));
                    cfdi.setTasaOcuotaTras1(listaImpTras.get(c1));
                    cfdi.setImporteTras1(new BigDecimal(listaImpTras.get(d1)));
                    cfdi.setImpuestoTras2(vacio);
                    cfdi.setTipoFactorTras2(vacio);
                    cfdi.setTasaOcuotaTras2(vacio);
                    cfdi.setImporteTras2(new BigDecimal(vacio));
                    cfdi.setImpuestoTras3(vacio);
                    cfdi.setTipoFactorTras3(vacio);
                    cfdi.setTasaOcuotaTras3(vacio);
                    cfdi.setImporteTras3(new BigDecimal(vacio));
                    listaIT = listaIT - 1;
                }
                break;
            case 8:
                while (listaIT > 0) {
                    cfdi.setImpuestoTras1(listaImpTras.get(a1));
                    cfdi.setTipoFactorTras1(listaImpTras.get(b1));
                    cfdi.setTasaOcuotaTras1(listaImpTras.get(c1));
                    cfdi.setImporteTras1(new BigDecimal(listaImpTras.get(d1)));
                    cfdi.setImpuestoTras2(listaImpTras.get(e1));
                    cfdi.setTipoFactorTras2(listaImpTras.get(f1));
                    cfdi.setTasaOcuotaTras2(listaImpTras.get(g1));
                    cfdi.setImporteTras2(new BigDecimal(listaImpTras.get(h1)));
                    cfdi.setImpuestoTras3(vacio);
                    cfdi.setTipoFactorTras3(vacio);
                    cfdi.setTasaOcuotaTras3(vacio);
                    cfdi.setImporteTras3(new BigDecimal(vacio));
                    listaIT = listaIT - 1;

                }
                break;
            case 12:
                while (listaIT > 0) {
                    cfdi.setImpuestoTras1(listaImpTras.get(a1));
                    cfdi.setTipoFactorTras1(listaImpTras.get(b1));
                    cfdi.setTasaOcuotaTras1(listaImpTras.get(c1));
                    cfdi.setImporteTras1(new BigDecimal(listaImpTras.get(d1)));
                    cfdi.setImpuestoTras2(listaImpTras.get(e1));
                    cfdi.setTipoFactorTras2(listaImpTras.get(f1));
                    cfdi.setTasaOcuotaTras2(listaImpTras.get(g1));
                    cfdi.setImporteTras2(new BigDecimal(listaImpTras.get(h1)));
                    cfdi.setImpuestoTras3(listaImpTras.get(i1));
                    cfdi.setTipoFactorTras3(listaImpTras.get(j1));
                    cfdi.setTasaOcuotaTras3(listaImpTras.get(k1));
                    cfdi.setImporteTras3(new BigDecimal(listaImpTras.get(l1)));
                    listaIT = listaIT - 1;
                }
                break;
            default:
                break;
        }
        switch (listaImpRet.size()) {
            case 0:
                cfdi.setImpuestoRet1(vacio);
                cfdi.setTipoFactorRet1(vacio);
                cfdi.setTasaOcuotaRet1(vacio);
                cfdi.setImporteRet1(new BigDecimal(vacio));
                cfdi.setImpuestoRet2(vacio);
                cfdi.setTipoFactorRet2(vacio);
                cfdi.setTasaOcuotaRet2(vacio);
                cfdi.setImporteRet2(new BigDecimal(vacio));
                cfdi.setImpuestoRet3(vacio);
                cfdi.setTipoFactorRet3(vacio);
                cfdi.setTasaOcuotaRet3(vacio);
                cfdi.setImporteRet3(new BigDecimal(vacio));
                break;
            case 4:
                while (listaIR > 0) {
                    cfdi.setImpuestoRet1(listaImpRet.get(a2));
                    cfdi.setTipoFactorRet1(listaImpRet.get(b2));
                    cfdi.setTasaOcuotaRet1(listaImpRet.get(c2));
                    cfdi.setImporteRet1(new BigDecimal(listaImpRet.get(d2)));
                    cfdi.setImpuestoRet2(vacio);
                    cfdi.setTipoFactorRet2(vacio);
                    cfdi.setTasaOcuotaRet2(vacio);
                    cfdi.setImporteRet2(new BigDecimal(vacio));
                    cfdi.setImpuestoRet3(vacio);
                    cfdi.setTipoFactorRet3(vacio);
                    cfdi.setTasaOcuotaRet3(vacio);
                    cfdi.setImporteRet3(new BigDecimal(vacio));
                    listaIR = listaIR - 1;

                }
                break;
            case 8:
                while (listaIR > 0) {
                    cfdi.setImpuestoRet1(listaImpRet.get(a2));
                    cfdi.setTipoFactorRet1(listaImpRet.get(b2));
                    cfdi.setTasaOcuotaRet1(listaImpRet.get(c2));
                    cfdi.setImporteRet1(new BigDecimal(listaImpRet.get(d2)));
                    cfdi.setImpuestoRet2(listaImpRet.get(e2));
                    cfdi.setTipoFactorRet2(listaImpRet.get(f2));
                    cfdi.setTasaOcuotaRet2(listaImpRet.get(g2));
                    cfdi.setImporteRet2(new BigDecimal(listaImpRet.get(h2)));
                    cfdi.setImpuestoRet3(vacio);
                    cfdi.setTipoFactorRet3(vacio);
                    cfdi.setTasaOcuotaRet3(vacio);
                    cfdi.setImporteRet3(new BigDecimal(vacio));
                    listaIR = listaIR - 1;
                }
                break;
            case 12:
                while (listaIR > 0) {
                    cfdi.setImpuestoRet1(listaImpRet.get(a2));
                    cfdi.setTipoFactorRet1(listaImpRet.get(b2));
                    cfdi.setTasaOcuotaRet1(listaImpRet.get(c2));
                    cfdi.setImporteRet1(new BigDecimal(listaImpRet.get(d2)));
                    cfdi.setImpuestoRet2(listaImpRet.get(e2));
                    cfdi.setTipoFactorRet2(listaImpRet.get(f2));
                    cfdi.setTasaOcuotaRet2(listaImpRet.get(g2));
                    cfdi.setImporteRet2(new BigDecimal(listaImpRet.get(h2)));
                    cfdi.setImpuestoRet3(listaImpRet.get(i2));
                    cfdi.setTipoFactorRet3(listaImpRet.get(j2));
                    cfdi.setTasaOcuotaRet3(listaImpRet.get(k2));
                    cfdi.setImporteRet3(new BigDecimal(listaImpRet.get(l2)));
                    listaIR = listaIR - 1;
                }
                break;
            default:
                break;
        }
        //consulta = new ConsultaCFDIService(); // Colocar nuevo web service
        //respuesta = consulta.getBasicHttpBindingIConsultaCFDIService();// Colocar nuevo web service
        //acuse = respuesta.consulta("?re=" + this.cfdi.getRfcEmisor() + "&rr=" + this.cfdi.getRfcReceptor() + "&tt=" + this.cfdi.getTotal() + "&id=" + this.id); //Colocar nuevo web service
        System.out.println("RFC Emisor" + this.getRfcReceptor() + "//" + this.id);
        CfdiDao cDao = new CfdiDaoImpl();
        cfdi.setNombreArchivo(nombreArchivo);
        cfdi.setTipo(tipo);
        //cfdi.setEstatusCfdi(acuse.getEstado().getValue());//Colocar nuevo web service
        cfdi.setEstatusCfdi("Vigente");
        this.fechaFac = cfdi.getFecha();
        this.monto = cfdi.getTotal();
        this.descCfdi = midescuento.toString();
        cfdi.setDescuento(new BigDecimal(this.descCfdi));
        CfdiDao lDao = new CfdiDaoImpl();
        listarUUID = lDao.listarUUID(cfdi.getUuid());
        if (listarUUID.isEmpty()) {
            this.bandera = true;
            cDao.insertCfdi(cfdi);
            cfdi = new Cfdi();
            int a = 0;//cantidad lista.add(det.getCantidad());
            int b = 1;//unidad lista.add(det.getUnidad());
            int c = 2;//descripcion lista.add(det.getDescripcion());
            int d = 3;//valorUnitario lista.add(det.getValorUnitario().toString());
            int e = 4;//importe lista.add(det.getImporte().toString());
            int f = 5;//CPS lista.add(det.getClaveProdServ());
            int g = 6;//ClaveUnidad lista.add(det.getClaveUnidad());
            int h = 7;//Descuento lista.add(det.getDescuento());

            int tamaño = lista.size() / 8;
            for (String ap : lista) {
                while (tamaño > 0) {
                    DetalleDao dDao = new DetalleDaoImpl();
                    det.setCantidad(lista.get(a));
                    det.setUnidad(lista.get(b));
                    det.setDescripcion(lista.get(c));
                    if (lista.get(d) != null) {
                        det.setValorUnitario(new BigDecimal(lista.get(d)));
                    }
                    if (lista.get(e) != null) {
                        det.setImporte(new BigDecimal(lista.get(e)));
                    }
                    det.setClaveProdServ(lista.get(f));
                    det.setClaveUnidad(lista.get(g));
                    det.setMiDescuento(new BigDecimal(lista.get(h)));
                    det.setUuid(id);
                    dDao.insertDetalle(det);

                    det = new Detalle();
                    a = a + 8;
                    b = b + 8;
                    c = c + 8;
                    d = d + 8;
                    e = e + 8;
                    f = f + 8;
                    g = g + 8;
                    h = h + 8;
                    tamaño = tamaño - 1;

                }
            }
            lista.clear();
            listaImpRet.clear();
            listaImpTras.clear();
            listarUUID.clear();
            listaIR = 0;
            listaIT = 0;
            this.banderaImpTras = false;
            this.isr = 0.0;
            this.iva = 0.0;
            this.ieps = 0.0;
            this.miVal = 0.0;
            this.conceptoIeps = "";
            this.conceptoIva = "";
            this.conceptoIsr = "";
            this.conceptoFactIeps = "";
            this.conceptoFactIva = "";
            this.conceptoFactIsr = "";
            this.tasaIeps = "";
            this.tasaIva = "";
            this.tasaIsr = "";
            this.midescuento = 0.0;
            this.descCfdi = "";
        } else {
            this.bandera = false;
        }
        lista.clear();
        listaImpRet.clear();
        listaImpTras.clear();
        listarUUID.clear();
        listaIR = 0;
        listaIT = 0;
        this.banderaImpTras = false;
        this.isr = 0.0;
        this.iva = 0.0;
        this.ieps = 0.0;
        this.miVal = 0.0;
        this.conceptoIeps = "";
        this.conceptoIva = "";
        this.conceptoIsr = "";
        this.conceptoFactIeps = "";
        this.conceptoFactIva = "";
        this.conceptoFactIsr = "";
        this.tasaIeps = "";
        this.tasaIva = "";
        this.tasaIsr = "";
        this.midescuento = 0.0;
        this.descCfdi = "";
    }

}
