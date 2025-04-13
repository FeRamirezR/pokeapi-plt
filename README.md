# 🧪 PokéAPI - Prueba Técnica Java Spring Boot

Este proyecto es una **prueba técnica** para validar conocimientos en **Java con Spring Boot**, arquitectura en capas, 
consumo de APIs REST, exposición de servicios SOAP, persistencia en base de datos, diseño con patrones.

---

## 📌 Requerimientos de la prueba

1. Consumir la API RESTful de PokéAPI:
   - `https://pokeapi.co/api/v2/pokemon?limit=150&offset=0`
   - `https://pokeapi.co/api/v2/pokemon/{id}`

2. Persistir los datos en una base de datos PostgreSQL.

3. Crear un modelo de base de datos que permita:
   - Almacenar la información de los pokémones.
   - Consultar pokémones filtrados por nombre, tipo o habilidad.

4. Aplicar una **arquitectura de 3 capas**:
   - **Controlador**: Entrada y salida de la app.
   - **Servicio**: Lógica del negocio.
   - **Repositorio**: Acceso a datos con JPA.

5. Exponer los datos mediante un **servicio SOAP** consumible por herramientas como **SOAP UI**.

6. Aplicar al menos **2 patrones de diseño**

---

## 🚀 Tecnologías y herramientas usadas

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- PostgreSQL
- Flyway
- SOAP (JAX-WS / Spring Web Services)
- JAXB + XSD
- Maven
- Lombok

---

## 🗂 Estructura del proyecto
poketest/ │ ├── src/ │ ├── main/ │ │ ├── java/com/pokeapi/poketest/... │ │ ├── resources/ │ │ ├── application.yml │ │ └── xsd/ (esquemas para JAXB) │ └── test/ │ ├── target/ │ ├── pom.xml ├── README.md


---

## ⚙️ Cómo correr el proyecto localmente

### 1. Clonar el repositorio



## Ejecutar migraciones con flyway o hacerlo a mano 

mvn flyway:migrate

## Compilar y ejecutar

mvn clean install
mvn spring-boot:run

## Generar las clases JXB desde XSD

mvn generate-sources

## WSDL:
http://localhost:8080/ws/pokemons.wsdl

## 📐 Patrones de diseño aplicados
Builder Pattern: Usado para crear objetos Pokemon desde la API.

Repository Pattern: Implementado mediante interfaces JPA para acceso a datos.

## 📌 Pendientes / Posibles mejoras
Cachear resultados del API para evitar múltiples llamadas innecesarias.
Implementar autenticación básica o token para exponer los servicios.
Añadir paginación también al servicio SOAP.

## 👨‍💻 Autor
- Desarrollado por Luisa Ramirez
- Contacto: lframirezr4@gmail.com
- LinkedIn: https://www.linkedin.com/in/luisa-ram%C3%ADrez-3a6156b0?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=ios_app

