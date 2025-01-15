Leonardo Vergara Ibañez..

# Proyecto Alura

Este proyecto es una API REST construida con Spring Boot que maneja la autenticación JWT, operaciones CRUD y una gestión de tópicos. Utiliza Spring Security para proteger las rutas y la autenticación basada en tokens JWT.

## Tecnologías

- **Spring Boot**: Framework para el desarrollo de aplicaciones Java basadas en Spring.
- **Spring Security**: Para la gestión de seguridad y autenticación.
- **JWT**: Para la autenticación sin estado mediante tokens JWT.
- **Spring Data JPA**: Para la gestión de bases de datos.
- **PostgreSQL**: Base de datos relacional utilizada para persistencia.
- **Maven**: Herramienta de gestión de dependencias y construcción de proyectos.

## Requisitos

- **Java 17 o superior**.
- **Maven 3.8.1 o superior**.
- **PostgreSQL 13 o superior** (u otro sistema de base de datos compatible).

## Configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/alura-project.git
cd alura-project
2. Configuración de la base de datos
Asegúrate de tener PostgreSQL instalado y crea una base de datos para la aplicación:

sql

CREATE DATABASE alurahub;
Configura la conexión a la base de datos en src/main/resources/application.properties:

properties

spring.datasource.url=jdbc:postgresql://localhost:5432/alurahub
spring.datasource.username=tu-usuario
spring.datasource.password=tu-contraseña
spring.jpa.hibernate.ddl-auto=update
3. Configuración de JWT
Asegúrate de tener las claves secretas configuradas para el servicio de autenticación JWT. En application.properties:

properties

api.security.secret=mi-clave-secreta
api.security.expiration=3600
4. Ejecutar la aplicación
Puedes ejecutar la aplicación con el siguiente comando:

bash

mvn spring-boot:run
Esto arrancará el servidor en el puerto 8080 por defecto. Puedes cambiar el puerto editando application.properties:

properties

server.port=8081
Rutas
POST /api/auth/login: Genera un token JWT para autenticación.
GET /api/topics: Obtiene todos los tópicos (requiere autenticación).
GET /api/topics/{id}: Obtiene un tópico por su ID (requiere autenticación).
POST /api/topics: Crea un nuevo tópico (requiere autenticación).
PUT /api/topics/{id}: Actualiza un tópico existente (requiere autenticación).
DELETE /api/topics/{id}: Elimina un tópico por su ID (requiere autenticación).
Seguridad
El sistema utiliza autenticación basada en JWT. Para acceder a las rutas protegidas, es necesario enviar un token JWT en el encabezado Authorization de la solicitud. El formato es:

css

Authorization: Bearer {token}
Login
Para obtener un token, realiza una solicitud POST a /api/auth/login con un cuerpo como el siguiente:

json

{
  "username": "usuario",
  "password": "contraseña"
}
En caso de que las credenciales sean correctas, recibirás un token JWT como respuesta.

Pruebas con Insomnia
Para probar las rutas de la API con Insomnia:

Login: Haz una solicitud POST a /api/auth/login con las credenciales de un usuario válido. Copia el token JWT que obtienes en la respuesta.
Rutas protegidas: Añade el token JWT en el encabezado Authorization de las solicitudes a las rutas protegidas, de esta forma:
css

Authorization: Bearer {tu-token-jwt}
Contribución
Si deseas contribuir, por favor, sigue estos pasos:

Haz un fork del repositorio.
Crea una nueva rama (git checkout -b feature/nueva-caracteristica).
Realiza tus cambios y haz commit de los mismos (git commit -am 'Añadir nueva característica').
Haz push de tu rama (git push origin feature/nueva-caracteristica).
Crea un pull request.
Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.


