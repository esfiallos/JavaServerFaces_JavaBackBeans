package com.uth.tarea2_grupo1.beans;

import com.uth.tarea2_grupo1.model.CajeroPOO;
import com.uth.tarea2_grupo1.model.Cliente;
import com.uth.tarea2_grupo1.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("CajeroBean")
@SessionScoped
public class CajeroBean implements Serializable {
    //atributos
    private CajeroPOO cajeroPOO;
    private List<Cliente> clientes;

    //metodo para cargar los clientes
    @PostConstruct
    public void init(){
         cajeroPOO= new CajeroPOO();
        ClienteRepository clip = new ClienteRepository();
        try{
            clientes=clip.getClientes();
            cajeroPOO.setMensaje("Clientes cargados correctamente");
        }catch (Exception e){
            cajeroPOO.setMensaje("Error al cargar los clientes"+e.getMessage());
        }
    }

    //metodo que recorre la lista de clientes y valida que exista
    private Cliente validarCliente(){
        for(Cliente c:clientes){
            if (c.getNumeroCuenta().equals(cajeroPOO.getCuenta()) && c.getPin().equals(cajeroPOO.getPin())){
                return c;
            }
        }
        return null;
    }

    //metodo que valida al cliente y el monto ingresado
    public void depositar(){
        Cliente cliente=validarCliente();
        if(cliente==null){
            cajeroPOO.setMensaje("Cuenta o PIN invalido");
            return;
        }
        if(cajeroPOO.getMonto()<=0){
            cajeroPOO.setMensaje("Monto invalido");
            return;
        }

        cliente.setSaldo(cliente.getSaldo()+ cajeroPOO.getMonto());
        cajeroPOO.setMensaje("Saldo actual: "+cliente.getSaldo());
    }

    //metodo que valida al cliente y al retiro ingresado
    public void retirar(){
        Cliente cliente=validarCliente();
        if(cliente==null){
            cajeroPOO.setMensaje("Cuenta o PIN invalido");
            return;
        }
        if(cajeroPOO.getMonto()<=0){
            cajeroPOO.setMensaje("Monto invalido");
            return;
        }
        if(cliente.getSaldo()<cajeroPOO.getMonto()){
            cajeroPOO.setMensaje("Saldo insuficiente");
            return;
        }
        cliente.setSaldo(cliente.getSaldo()-cajeroPOO.getMonto());
        cajeroPOO.setMensaje("Saldo actual: "+cliente.getSaldo());
    }


    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public CajeroPOO getCajeroPOO() {
        return cajeroPOO;
    }
    public void setCajeroPOO(CajeroPOO cajeroPOO) {
        this.cajeroPOO = cajeroPOO;
    }
}