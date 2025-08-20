# ms-banco-abc

## Requisitos previos

- [Docker](https://www.docker.com/products/docker-desktop) y [Docker Compose](https://docs.docker.com/compose/) instalados
- Java 21 y Maven (solo si deseas construir el proyecto manualmente)

## Levantar el microservicio y la base de datos

1. **Clona el repositorio:**
```sh
git clone https://github.com/CristopherBedon/ms-banco-abc.git
```

2. **Construye el proyecto**  
```
./mvnw package
```

3. **Levanta los servicios con Docker Compose**
```
docker-compose up --build
```
Esto iniciará:  
* La base de datos PostgreSQL en el puerto 5432
* El microservicio en el puerto 8080

4. **Verifica que el microservicio está corriendo**
Prueba la Colección de Postman adjunta en la repo

## Acceso a la base de datos
Puedes conectarte a la base de datos con un cliente PostgreSQL usando
* Host: localhost
* Puerto: 5432
* Usuario: postgres
* Contraseña: admin
* Base de datos: postgres

O bien, accede desde el contenedor:
Abre Docker Desktop.
Selecciona el contenedor db y haz clic en EXEC.

Ejecuta:
```
psql -U postgres -d postgres
```

## Comandos útiles en PostgreSQL

Listar tablas:
```
\dt
```

Consultar una tabla:
```
SELECT * FROM tipocambiodolares;
```

Limpiar la consola de psql:
En Linux/Mac:
```
\! clear
```
En Windows:
```
\! cls
```

## Detener los servicios
```
docker-compose down
```









