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
