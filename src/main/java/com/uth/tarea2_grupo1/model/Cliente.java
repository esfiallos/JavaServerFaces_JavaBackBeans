package com.uth.tarea2_grupo1.model;

public class Cliente {
    private String numeroCuenta;
    private String nombre;
    private String correo;
    private String pin;
    private double saldo;

    public Cliente(String numeroCuenta, String nombre, String correo, String pin, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.correo = correo;
        this.pin = pin;
        this.saldo = saldo;
    }

    // Getters y setters
    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    @Override
    public String toString() {
        return "Cliente{" +
                "Cuenta='" + numeroCuenta + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Correo='" + correo + '\'' +
                ", Saldo=" + saldo +
                '}';
    }

    // Método simple para mostrar resumen en la interfaz
    public String resumen() {
        return "Cuenta: " + numeroCuenta + " | Nombre: " + nombre + " | Saldo: " + saldo;
    }
}
