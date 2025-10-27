# **# 💻 JavaServerFaces\_JavaBackBeans**  

# **\*\*Segundo Parcial – Cajero Automático\*\***  

# **\*\*Grupo #1 – UTH\*\***

# 

# ---



\##**Integrantes**



| Cuenta         | Nombre                                       |

|----------------|----------------------------------------------|

| 202410060972   | Emerson Barrientos Fiallos                   |

| 20241083029    | Juan Carlos López Rodríguez                  |

| 202330060138   | Daniel de Jesús Montoya Rodríguez            |

| 202310040339   | Ingrid Lisbeth Garay Velásquez               |

| 202210030176   | Jonathan Josué Ortiz Martínez                |

# 



## \#  Módulo: Modelado de Datos – Cliente y Repositorio





Este módulo contiene la \*\*clase Cliente\*\* y la \*\*lectura de datos desde un CSV\*\*



### \## Archivos incluidos



| Archivo                  | Descripción                                                                                |

|--------------------------|--------------------------------------------------------------------------------------------|

| `Cliente.java`           | Modelo que representa un cliente con número de cuenta, nombre, correo, PIN y saldo.        |

| `ClienteRepository.java` | Clase encargada de leer el archivo `clientes.csv` y devolver una lista de objetos `Cliente`|

| `clientes.csv`           | Archivo de datos de prueba con 5 clientes registrados.                                     |



---



### \## Uso de Repositorio



* Crear una instancia del repositorio



```java

ClienteRepository repo = new ClienteRepository();

```



* Obtener Clientes



```java

//Crear la lista para obtener cliente

List<Cliente> clientes = null;



try {

	//Usar la función ara obtener los clientes

   clientes = repo.getClientes();



} catch (IOException | NumberFormatException e) {

  FacesContext.getCurrentInstance().addMessage(null,

     new FacesMessage(FacesMessage.SEVERITY\\\_ERROR, "Error al cargar clientes", e.getMessage()));

}

```

* Consumir la lista



```java

for (Cliente c : clientes) {

	// Este es un print directo pero se etiende, con sus getters puede usar los datos

  System.out.println(c.getNumeroCuenta() + " - " + c.getNombre() + " - " + c.getSaldo());

}

```

