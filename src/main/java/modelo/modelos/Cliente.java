package modelo.modelos;

import controlador.dto.ClienteDto;
import db.Connectiondb;
import modelo.dao.ClienteDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements ClienteDao {

    @Override
    public List<ClienteDto> getAll() {
        List<ClienteDto> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTES";

        try(Connection conn = Connectiondb.conectar();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()){
                listaClientes.add(crearCliente(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;
    }

    @Override
    public ClienteDto findById(int idclientes) {
        String sql = "SELECT clientes.idclientes, clientes.nombre, clientes.genero, clientes.cedula " +
                "FROM clientes " +
                "WHERE idclientes = ?";
        ClienteDto cliente = new ClienteDto();
        try(Connection conn = Connectiondb.conectar();
            PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, idclientes);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                cliente = crearCliente(resultSet);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public void insertCliente(ClienteDto cliente) {
        String sql = "INSERT INTO clientes(nombre, genero, cedula) values (?,?,?)";
        try(Connection conn = Connectiondb.conectar();
            PreparedStatement statement = conn.prepareStatement(sql)){

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getGenero());
            statement.setInt(3, cliente.getCedula());

            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCliente(ClienteDto cliente) {
        String sql = "UPDATE clientes SET nombre = ?, genero = ?, cedula = ? WHERE idclientes = ?";
        try(Connection conn = Connectiondb.conectar();
            PreparedStatement statement = conn.prepareStatement(sql)){

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getGenero());
            statement.setInt(3, cliente.getCedula());
            statement.setInt(4, cliente.getIdCliente());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteCliente(int idclientes) {
        String sql = "DELETE FROM clientes WHERE idclientes = ?";

        try(Connection conn = Connectiondb.conectar();
            PreparedStatement statement = conn.prepareStatement(sql)){

            statement.setInt(1, idclientes);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ClienteDto crearCliente(ResultSet resultSet) throws SQLException {
        ClienteDto cliente = new ClienteDto();
        cliente.setIdCliente(resultSet.getInt("idclientes"));
        cliente.setCedula(resultSet.getInt("cedula"));
        cliente.setNombre(resultSet.getString("nombre"));
        cliente.setGenero(resultSet.getString("genero"));
        return cliente;
    }
}
