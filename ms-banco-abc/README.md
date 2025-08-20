# ms-banco-abc

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/ms-banco-abc-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- OpenAPI Generator - REST Client Generator ([guide](https://docs.quarkiverse.io/quarkus-openapi-generator/dev/index.html)): Generation of Rest Clients based on OpenAPI specification files
- Camel MapStruct ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/mapstruct.html)): Type Conversion using Mapstruct
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)


### OpenAPI Generator Client Codestart

Start to code with the OpenAPI Generator Client extension.

[Related guide section...](https://docs.quarkiverse.io/quarkus-openapi-generator/dev/client.html)

## Requirements

If you do not have added the `io.quarkus:quarkus-rest-client-jackson` or `io.quarkus:quarkus-rest-client-reactive-jackson` extension in your project, add it first:

Remember, you just need to add one of them, depending on your needs.

### REST Client Jackson:

Quarkus CLI:

```bash
quarkus ext add io.quarkus:quarkus-rest-client-jackson
```

Maven:
```bash
./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-rest-client-jackson"
```

Gradle:

```bash
./gradlew addExtension --extensions="io.quarkus:quarkus-rest-client-jackson"
```

or

### REST Client Reactive Jackson:

Quarkus CLI:

```bash
quarkus ext add io.quarkus:quarkus-rest-client-reactive-jackson
```

Maven:

```bash
./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-rest-client-reactive-jackson"
```

Gradle:

```bash
./gradlew addExtension --extensions="io.quarkus:quarkus-rest-client-reactive-jackson"
```
### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

<hr></hr>

## Configuración de la Base de Datos

Este proyecto utiliza PostgreSQL como base de datos. Para ejecutarlo correctamente en tu entorno local, sigue estos pasos:

1. **Instala PostgreSQL** en tu máquina si no lo tienes instalado.

2. **Crea la base de datos y el usuario** ejecutando los siguientes comandos en tu terminal o herramienta favorita (por ejemplo, `psql` o PgAdmin):

```sql
CREATE DATABASE postgres;
CREATE USER postgres WITH PASSWORD 'admin';
GRANT ALL PRIVILEGES ON DATABASE postgres TO postgres;
```

Si ya tienes un usuario y base de datos con estos datos, puedes omitir este paso.
1. Verifica la configuración en el archivo src/main/resources/application.properties
   Asegúrate de que los parámetros de conexión a la base de datos sean correctos. Deberían verse así:

```properties
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=postgres
quarkus.datasource.password=admin
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/postgres
quarkus.hibernate-orm.database.generation=update
```
1. Opcional: Si necesitas cambiar el usuario, contraseña o nombre de la base de datos, actualiza el archivo application.properties con tus valores.  
2. Ejecuta la aplicación siguiendo las instrucciones anteriores.

<hr></hr> 
Si tienes problemas de conexión, asegúrate de que el servicio de PostgreSQL esté corriendo y que los datos de acceso sean correctos.