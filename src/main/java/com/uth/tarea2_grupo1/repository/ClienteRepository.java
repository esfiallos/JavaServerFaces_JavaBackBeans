package com.uth.tarea2_grupo1.repository;

import com.uth.tarea2_grupo1.model.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private static final String FILE_PATH = "src/main/resources/clientes.csv";

    public List<Cliente> getClientes() throws IOException, NumberFormatException {
        List<Cliente> clientes = new ArrayList<>();
        BufferedReader lector = null;

        try {
            lector = new BufferedReader(new FileReader(FILE_PATH));
            String linea;
            boolean primeraLinea = true;

            while ((linea = lector.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false; // ignorar encabezado
                    continue;
                }

                String[] datos = linea.split(",");
                if (datos.length == 5) {
                                        //numero de cuenta
                    String numeroCuenta = datos[0].trim();
                                    //nombre
                    String nombre = datos[1].trim();
                                    //correo
                    String correo = datos[2].trim();
                                    //pin
                                //saldo
                    String pin = datos[3].trim();
                    double saldo = Double.parseDouble(datos[4].trim());


                    Cliente nuevo = new Cliente(numeroCuenta, nombre, correo, pin, saldo);
                    clientes.add(nuevo);
                }
            }

        } finally {
            if (lector != null) {
                lector.close();
            }
        }

        return clientes;
    }
}
