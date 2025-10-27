package com.uth.tarea2_grupo1.beans;

import com.uth.tarea2_grupo1.model.CajeroPOO;
import com.uth.tarea2_grupo1.model.Cliente;
import com.uth.tarea2_grupo1.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("cajeroBean")
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
            System.out.println("Clientes cargados: " + clientes.size());
            cajeroPOO.setMensaje("Clientes cargados correctamente" + clientes.size());
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
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cuenta o PIN inválido"));
            return;
        }
        if(cajeroPOO.getMonto()<=0){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Monto inválido"));
            return;
        }

        cliente.setSaldo(cliente.getSaldo()+ cajeroPOO.getMonto());

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Depósito exitoso",
                        "Saldo actual: " + cliente.getSaldo()));



    }

    //metodo que valida al cliente y al retiro ingresado
    public void retirar(){
        Cliente cliente=validarCliente();
        if(cliente==null){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Cuenta o PIN inválido"));
            return;
        }
        if(cajeroPOO.getMonto()<=0){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Monto inválido"));
            return;
        }
        if(cliente.getSaldo()<cajeroPOO.getMonto()){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Saldo Insuficiente"));
            return;
        }
        cliente.setSaldo(cliente.getSaldo()-cajeroPOO.getMonto());


        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Retiro exitoso",
                        "Saldo actual: " + cliente.getSaldo()));
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