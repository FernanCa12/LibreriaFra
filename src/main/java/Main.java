import modelo.dao.ClienteDao;
import modelo.modelos.Cliente;

public class Main {
    public static void main(String[] args) {
        ClienteDao cliente = new Cliente();

        cliente.getAll().forEach(System.out::println);
    }
}
