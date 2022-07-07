package mx.insoftec.dao;

import java.util.List;
import mx.insoftec.model.Cfdi;

public interface CfdiDao {

    public List<Cfdi> listaCfdiEmisor(String rfc, String f1, String f2);

    public List<Cfdi> listaCfdiReceptor(String rfc, String f1, String f2);

    public void insertCfdi(Cfdi cfdi);

    public void updateCfdi(Cfdi cfdi);

    public void deleteCfdi(Cfdi cfdi);

    public List<Cfdi> listarUUID(String uuid);

    public List<Cfdi> listarTodo(String d1, String d2);
}
