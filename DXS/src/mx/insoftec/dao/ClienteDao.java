package mx.insoftec.dao;

import java.util.List;
import mx.insoftec.model.Cliente;

public interface ClienteDao {

    public List<String> listaCliente();

    public void insertCliente(Cliente cliente);

    public void updateCliente(Cliente cliente);

    public void deleteCliente(Cliente cliente);

    public List<Cliente> listarRFC(String rfc);
}
