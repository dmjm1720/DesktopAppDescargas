package mx.insoftec.model;

import java.math.BigDecimal;

public class Detalle implements java.io.Serializable {

    private int id;
    private String cantidad;
    private String unidad;
    private String descripcion;
    private BigDecimal valorUnitario;
    private BigDecimal importe;
    private String claveProdServ;
    private String claveUnidad;
    private String uuid;
    private BigDecimal miDescuento;

    public Detalle() {
    }

    public Detalle(int id) {
        this.id = id;
    }

    public Detalle(int id, String cantidad, String unidad, String descripcion, BigDecimal valorUnitario, BigDecimal importe, String claveProdServ, String claveUnidad, String uuid, BigDecimal miDescuento) {
        this.id = id;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.importe = importe;
        this.claveProdServ = claveProdServ;
        this.claveUnidad = claveUnidad;
        this.uuid = uuid;
        this.miDescuento = miDescuento;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return this.unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValorUnitario() {
        return this.valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getImporte() {
        return this.importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getClaveProdServ() {
        return this.claveProdServ;
    }

    public void setClaveProdServ(String claveProdServ) {
        this.claveProdServ = claveProdServ;
    }

    public String getClaveUnidad() {
        return this.claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BigDecimal getMiDescuento() {
        return this.miDescuento;
    }

    public void setMiDescuento(BigDecimal miDescuento) {
        this.miDescuento = miDescuento;
    }

}
