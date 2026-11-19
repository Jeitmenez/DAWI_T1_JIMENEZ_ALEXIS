# API REST - Gestión de Empleados (`DAWI_T1_JIMENEZ_ALEXIS`)

Servicio REST desarrollado con **Spring Boot** para registrar, consultar, actualizar y eliminar empleados, siguiendo la especificación definida en `swagger.yaml`.

## Tecnologías utilizadas
- **Java** y **Spring Boot** (Web, Data JPA, Validation)
- **MySQL** como base de datos relacional
- **Lombok** para reducir código repetitivo

## Configuración de base de datos
1. Asegúrate de tener **MySQL** en ejecución.
2. Revisa o ajusta las credenciales en `src/main/resources/application.properties` (la base de datos `bd_empleados` se crea automáticamente si el parámetro `createDatabaseIfNotExist=true` está activo).

## Ejecución del proyecto
Desde la raíz del proyecto:

**Windows (PowerShell / CMD):**
```powershell
.\mvnw.cmd spring-boot:run
