package com.uth.tarea2_grupo1.repository;

import com.uth.tarea2_grupo1.model.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private static final String FILE_NAME = "clientes.csv"; // debe estar en src/main/resources

    public List<Cliente> getClientes() throws IOException, NumberFormatException {
        List<Cliente> clientes = new ArrayList<>();

        // Leer el archivo desde el classpath
        InputStream is = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
        if (is == null) {
            throw new IOException("No se encontró el archivo " + FILE_NAME + " en resources");
        }

        BufferedReader lector = new BufferedReader(new InputStreamReader(is));
        String linea;
        boolean primeraLinea = true;

        while ((linea = lector.readLine()) != null) {
            if (primeraLinea) {
                primeraLinea = false; // ignorar encabezado
                continue;
            }

            String[] datos = linea.split(",");
            if (datos.length == 5) {
                String numeroCuenta = datos[0].trim();
                String nombre = datos[1].trim();
                String correo = datos[2].trim();
                String pin = datos[3].trim();
                double saldo = Double.parseDouble(datos[4].trim());

                Cliente nuevo = new Cliente(numeroCuenta, nombre, correo, pin, saldo);
                clientes.add(nuevo);
            }
        }

        lector.close();
        return clientes;
    }
}
