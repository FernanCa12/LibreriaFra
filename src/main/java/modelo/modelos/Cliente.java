package modelo.modelos;

import controlador.dto.ClienteDto;
import db.Connectiondb;
import modelo.dao.ClienteDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements ClienteDao {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Override
    public List<ClienteDto> getAll() {
        List<ClienteDto> listaClientes = new ArrayList<>();
        connection = Connectiondb.conectar();
        try {
            String sql = "SELECT * FROM clientes";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                ClienteDto cliente = new ClienteDto();
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setGenero(resultSet.getString("genero"));
                cliente.setCedula(resultSet.getInt("cedula"));
                cliente.setIdCliente(resultSet.getInt("idclientes"));
                listaClientes.add(cliente);
            }
            connection.close();
            statement.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return listaClientes;
    }
}
