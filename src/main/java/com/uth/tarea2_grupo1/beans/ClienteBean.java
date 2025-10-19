package com.uth.tarea2_grupo1.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("clienteBean")
@ApplicationScoped
public class ClienteBean implements Serializable {
    // TODO: lista de clientes con número de cuenta, saldo y pin
}