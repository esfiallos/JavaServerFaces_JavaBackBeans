# JavaServerFaces\_JavaBackBeans





\# Modelado de Datos Repositorio Clientes y Clase Cliente



Este módulo contiene la \*\*clase Cliente\*\* y la \*\*lectura de datos desde un CSV\*\*



\## Archivos incluidos



\- `Cliente.java` → Representa un cliente con atributos: número de cuenta, nombre, correo, PIN y saldo.

\- `ClienteRepository.java` → Clase encargada de leer `clientes.csv` y devolver la lista de clientes.

\- `clientes.csv` → Archivo de datos de prueba con 5 clientes.



---



\## Uso



\### 1. Crear una instancia del repositorio



```java

ClienteRepository repo = new ClienteRepository();

```



\### 2. Obtener Clientes



```java

//Crear la lista para obtener cliente

List<Cliente> clientes = null;



try {

&nbsp;	//Usar la función ara obtener los clientes

&nbsp;   clientes = repo.getClientes();



} catch (IOException | NumberFormatException e) {

&nbsp;   FacesContext.getCurrentInstance().addMessage(null,

&nbsp;       new FacesMessage(FacesMessage.SEVERITY\_ERROR, "Error al cargar clientes", e.getMessage()));

}

```

\### 3. Consumir la lista



```java

for (Cliente c : clientes) {

&nbsp;   System.out.println(c.getNumeroCuenta() + " - " + c.getNombre() + " - " + c.getSaldo());

}

```





