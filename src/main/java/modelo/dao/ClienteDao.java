package modelo.dao;

import controlador.dto.ClienteDto;

import java.util.List;


public interface ClienteDao {
    List<ClienteDto> getAll();
    ClienteDto findById(int idclientes);
    void insertCliente(ClienteDto cliente);
    void updateCliente(ClienteDto cliente);
    void deleteCliente(int idclientes);
}
