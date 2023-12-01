package modelo.dao;

import controlador.dto.ClienteDto;

import java.util.List;


public interface ClienteDao {
    List<ClienteDto> getAll();
}
