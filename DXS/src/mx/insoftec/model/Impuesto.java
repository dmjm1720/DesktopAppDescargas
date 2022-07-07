package mx.insoftec.model;

public class Impuesto {

    private String ImpuestoRet;
    private String TipoFactorRet;
    private String TasaOCuotaRet;
    private String ImporteRet;
    private String ImpuestoTras;
    private String TipoFactorTras;
    private String TasaOCuotaTras;
    private String ImporteTras;

    public Impuesto() {
        this.ImporteRet = "";
        this.TipoFactorRet = "";
        this.TasaOCuotaRet = "";
        this.ImporteRet = "";
        this.ImporteTras = "";
        this.TipoFactorTras = "";
        this.TasaOCuotaTras = "";
        this.ImporteTras = "";

    }

    public String getImpuestoRet() {
        return ImpuestoRet;
    }

    public void setImpuestoRet(String ImpuestoRet) {
        this.ImpuestoRet = ImpuestoRet;
    }

    public String getTipoFactorRet() {
        return TipoFactorRet;
    }

    public void setTipoFactorRet(String TipoFactorRet) {
        this.TipoFactorRet = TipoFactorRet;
    }

    public String getTasaOCuotaRet() {
        return TasaOCuotaRet;
    }

    public void setTasaOCuotaRet(String TasaOCuotaRet) {
        this.TasaOCuotaRet = TasaOCuotaRet;
    }

    public String getImporteRet() {
        return ImporteRet;
    }

    public void setImporteRet(String ImporteRet) {
        this.ImporteRet = ImporteRet;
    }

    public String getImpuestoTras() {
        return ImpuestoTras;
    }

    public void setImpuestoTras(String ImpuestoTras) {
        this.ImpuestoTras = ImpuestoTras;
    }

    public String getTipoFactorTras() {
        return TipoFactorTras;
    }

    public void setTipoFactorTras(String TipoFactorTras) {
        this.TipoFactorTras = TipoFactorTras;
    }

    public String getTasaOCuotaTras() {
        return TasaOCuotaTras;
    }

    public void setTasaOCuotaTras(String TasaOCuotaTras) {
        this.TasaOCuotaTras = TasaOCuotaTras;
    }

    public String getImporteTras() {
        return ImporteTras;
    }

    public void setImporteTras(String ImporteTras) {
        this.ImporteTras = ImporteTras;
    }

}
