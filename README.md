# API de Soporte Técnico

## 1. Descripción del Proyecto
Esta es una API RESTful desarrollada con Spring Boot para una startup, diseñada para gestionar las solicitudes de soporte técnico de sus empleados. La API permite a los usuarios registrar solicitudes y al equipo técnico visualizar y gestionar la información.

## 2. Funcionalidades Implementadas
Actualmente, la API es capaz de:

* Registrar Solicitudes: Recibe los datos de una solicitud de soporte (nombre del solicitante, tema, descripción) y la almacena en una base de datos.

* Obtener todas las Solicitudes: Permite al equipo técnico obtener una lista completa de todas las solicitudes registradas, ordenadas por su fecha de creación.

* Obtener una Solicitud por ID: Permite buscar y obtener los detalles de una solicitud específica utilizando su identificador único.

## 3. Endpoints de la API
Los siguientes endpoints están completamente implementados y probados:

Método

URL

Descripción

POST

/api/requests

Crea una nueva solicitud de soporte técnico.

GET

/api/requests

Obtiene una lista de todos las solicitudes.

GET

/api/requests/{id}

Obtiene los detalles de una solicitud específica por su ID.

## 4. Tecnologías y Herramientas
* Lenguaje: Java 21 SE

* Framework: Spring & Spring Boot

* Persistencia: Spring Data JPA

* Base de Datos: H2 (base de datos en memoria para desarrollo)

* Herramientas de Prueba: Postman

## 5. Guía de Uso (Con Postman)
Para probar la funcionalidad implementada, sigue estos pasos:

### 5.1 Iniciar la Aplicación
Desde la terminal de tu proyecto, ejecuta el siguiente comando:

mvn spring-boot:run

### 5.2 Crear una Solicitud (POST)
1. En Postman, crea una solicitud POST con la URL http://localhost:8080/api/requests.

2. En la pestaña Body, elige raw y el formato JSON.

3. Usa un JSON como el siguiente:

`{
  "applicantName": "José García",
  "subject": "Mi impresora no enciende",
  "description": "He intentado reiniciar la impresora varias veces, pero sigue sin encender."
}`

4. Envía la solicitud. Verás una respuesta JSON con el incidente creado y su ID asignado.

### 5.3 Obtener todas las Solicitudes (GET)
1. En Postman, crea una solicitud GET con la URL http://localhost:8080/api/requests.

2. Envía la solicitud. La respuesta será un array JSON con todas las solicitudes.

### 5.4 Obtener una Solicitud Específica (GET por ID)
1. En Postman, crea una solicitud GET con la URL http://localhost:8080/api/requests/1.

2. Envía la solicitud. La respuesta será un objeto JSON con los detalles del incidente. Nota: Debes haber creado un incidente con id = 1 previamente en esta misma sesión de la aplicación.


