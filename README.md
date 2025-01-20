<h1 align="center"> Challenge BackEnd N°2: LiterAlura</h1>

Este proyecto utiliza la API de Gutendex para buscar libros, almacenar los resultados en una base de datos PostgreSQL y permitir consultas sobre los libros y sus autores.  La app cuenta con un menú con diferentes opciones para que el usuario pueda interactura.

## :computer:Funcionalidades de la Aplicación

- `1-Búsqueda libro por título`: Encuentra libros por su título.
- `2-Listar libros registrados`: Muestra todos los libros registrados en la base de datos.
- `3-Listar autores registrados`: Muestra todos los autores registrados en la base de datos.
- `4-Listar autores vivos en un determinado año`: Encuentra autores que estaban vivos en un año específico.
- `5-Listar libros por idioma`: Filtra libros por su idioma.
- `0-Salir`: Permite al usuario salir de la aplicación.


## :computer:Tecnologías utilizadas

* Java 17
* Maven
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Hibernate
* API de [Gutendex](https://gutendex.com/?ref=public_apis&utm_medium=websitei)


##  :computer:Instalación  

_Sigue estos pasos para configurar y ejecutar el proyecto en tu máquina local._

**Dependencias** 

Asegúrate de agregar las dependencias necesarias en tu archivo pom.xml para la base de datos que deseas usar.

**Configurar tu base de datos en el archivo application.properties** 

```
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```


**Nota adicional**

Asegúrate que el usuario de la BD tenga los permisos y/o privilegios necesarios para que puedas crear los objetos de Base de Datos desde el IDE que utilices.


##  :computer:Ejecucion de la Aplicación  

Para ejecutar la aplicación, sigue los siguientes pasos:


```
1. Clonar el repositorio.
2. Importar el proyecto en tu IDE de preferencia.
3. Configurar la base de datos PostgreSQL y actualizar el archivo application.properties con las credenciales de la base de datos.
4. Ejecutar el proyecto.
5. Seguir las instrucciones en la consola para interactuar con la aplicación.
```

**Eejcuta la aplicación en tu IDE**
_Al ejecutar la aplicación, se mostrará un menú en la consola con las siguientes opciones:



```
Menú de opciones:
1 - Buscar libro por título
2 - Listar libros registrados
3 - Listar autores registrados
4 - Listar autores vivos en un determinado año
5 - Listar libros por idioma
0 - Salir
```

_Finaliza con un ejemplo de cómo obtener datos del sistema o como usarlos para una pequeña demo_

##  :computer:Pruebas 

_Pruebas realizadas del funcionamiento de la aplicación_

![1](https://github.com/user-attachments/assets/1dfb5351-456a-4801-bc95-a7f229a1421a)



![2](https://github.com/user-attachments/assets/953e58c1-42b1-43bf-9cf0-534dcd3e430c)



![3](https://github.com/user-attachments/assets/030a9766-8dca-4b0d-a8bc-a3a955bed5bc)



![4](https://github.com/user-attachments/assets/be5ea5b1-e447-4e81-9692-34572fe01a16)



![5](https://github.com/user-attachments/assets/8922c438-a2e8-47c2-8d74-700c128c95b3)



![6-1](https://github.com/user-attachments/assets/cfb247c1-d905-45f8-b5bb-6150bca1505e)



![6-2](https://github.com/user-attachments/assets/10b2bc28-fdf1-406b-aded-6549dda1bd3b)




---
Realizado por :hearts: Sheyla Marin :hearts: (https://github.com/sheylaing) :blush:
