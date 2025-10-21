
import com.uth.tarea2_grupo1.model.Cliente;
import com.uth.tarea2_grupo1.repository.ClienteRepository;

import java.io.IOException;
import java.util.List;



public class PruebaClientes {
    public static void main(String[] args) {

        // Crear instancia del repositorio
        ClienteRepository repo = new ClienteRepository();

        // Obtener la lista de clientes
        List<Cliente> clientes = null;
        try {
            clientes = repo.getClientes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Mostrar los clientes en consola
        System.out.println("Clientes cargados desde CSV:");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // buscar un cliente por cuenta
        String cuentaABuscar = "1003";
        Cliente clienteEncontrado = null;
        for (Cliente c : clientes) {
            if (c.getNumeroCuenta().equals(cuentaABuscar)) {
                clienteEncontrado = c;
                break;
            }
        }

        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado);
        } else {
            System.out.println("Cliente con cuenta " + cuentaABuscar + " no encontrado");
        }
    }
}