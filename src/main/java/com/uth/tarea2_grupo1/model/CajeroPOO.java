package com.uth.tarea2_grupo1.model;



public class CajeroPOO implements java.io.Serializable {
    private  String cuenta;
    private String pin;
    private double monto;
    private String mensaje;




    public CajeroPOO() {
        this.cuenta = "";
        this.pin = "";
        this.monto = 0;
        this.mensaje = "";
    }

    public CajeroPOO(String cuenta, String pin, double monto, String mensaje) {
        this.cuenta = cuenta;
        this.pin = pin;
        this.monto = monto;
        this.mensaje = mensaje;
    }
    public String getCuenta() {
        return cuenta;
    }
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}

