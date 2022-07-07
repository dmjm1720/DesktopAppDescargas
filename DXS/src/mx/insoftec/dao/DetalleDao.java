package mx.insoftec.dao;

import java.util.List;
import mx.insoftec.model.Detalle;

public interface DetalleDao {

    public List<Detalle> listaDetalle(String uuid);

    public void insertDetalle(Detalle detalle);

    public void updateDetalle(Detalle detalle);

    public void deleteDetalle(Detalle detalle);
}
