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
Estructura del Proyecto
1. entity (Entidades)
Descripción: Contiene las clases que representan las tablas de la base de datos.
Ejemplo:
Pokemon.java: Representa la tabla pokemon.
Campos: idPokemon, name, height, weight, etc.
Type.java: Representa la tabla type.
Campos: idType, name, etc.
Ability.java: Representa la tabla ability.
Campos: idAbility, name, etc.
PokemonType.java: Representa la relación entre Pokémon y tipos (pokemon_type).
Campos: idPokemonType, idPokenom, idType, slot.
2. dao (Data Access Objects)
Descripción: Contiene las interfaces que extienden CrudRepository o JpaRepository para interactuar con la base de datos.
Ejemplo:
PokemonDao.java: DAO para la tabla pokemon.
TypeDao.java: DAO para la tabla type.
AbilityDao.java: DAO para la tabla ability.
3. service (Servicios)
Descripción: Contiene la lógica de negocio del proyecto.
Ejemplo:
PokemonService.java: Define métodos como savePokemonData, findAll, etc.
TypeService.java: Define métodos para manejar los tipos de Pokémon.
AbilityService.java: Define métodos para manejar las habilidades de Pokémon.
4. service.impl (Implementaciones de Servicios)
Descripción: Implementa las interfaces de los servicios.
Ejemplo:
PokemonServiceImpl.java: Implementa la lógica para manejar datos de Pokémon.
Métodos: savePokemonData, findAll, findById, etc.
TypeServiceImpl.java: Implementa la lógica para manejar datos de tipos.
Métodos: saveTypesData, findAll, etc.
AbilityServiceImpl.java: Implementa la lógica para manejar datos de habilidades.
Métodos: saveAbilitiesData, findAll, etc.
5. initializer (Inicializadores de Datos)
Descripción: Contiene clases que inicializan datos en la base de datos al arrancar la aplicación.
Ejemplo:
PokemonDataInitializer.java: Inicializa datos de Pokémon.
TypeDataInitializer.java: Inicializa datos de tipos.
AbilityDataInitializer.java: Inicializa datos de habilidades.
6. client (Clientes REST)
Descripción: Contiene clases para consumir APIs externas.
Ejemplo:
PokemonRestClient.java: Cliente para consumir datos de una API externa de Pokémon.
7. dto (Data Transfer Objects)
Descripción: Contiene clases que se utilizan para transferir datos entre capas.
Ejemplo:
PokemonDto.java: DTO para representar datos de Pokémon.
TypeDto.java: DTO para representar datos de tipos.
AbilityDto.java: DTO para representar datos de habilidades.
8. resources/db/migration (Migraciones de Base de Datos)
Descripción: Contiene scripts de migración para Flyway.
Ejemplo:
V1__create_tables.sql: Crea las tablas iniciales.
V4__add_triggers.sql: Añade triggers para auditoría.
9. audit_log (Auditoría)
Descripción: Implementa funciones y triggers para registrar cambios en las tablas.
Ejemplo:
Funciones como log_pokemon_changes, log_type_changes, log_ability_changes.
Triggers como trg_audit_pokemon, trg_audit_type, trg_audit_ability.
Flujo de Funcionalidad
Inicialización de Datos:

Al arrancar la aplicación, los inicializadores (PokemonDataInitializer, TypeDataInitializer, etc.) llaman a los servicios para cargar datos desde una API externa y guardarlos en la base de datos.
Consumo de API Externa:

PokemonRestClient consume datos de una API externa (como la API de Pokémon) y devuelve resultados en forma de DTOs.
Guardado en la Base de Datos:

Los servicios (PokemonServiceImpl, TypeServiceImpl, etc.) procesan los datos y los guardan en la base de datos utilizando los DAOs.
Auditoría:

Los triggers definidos en V4__add_triggers.sql registran automáticamente los cambios (INSERT, UPDATE, DELETE) en las tablas en la tabla audit_log.
Consulta de Datos:

Los servicios permiten consultar datos de las tablas mediante métodos como findAll, findById, etc.
Resumen de Funcionalidad
Carga de Datos: Inicializa datos desde una API externa.
Persistencia: Guarda datos en la base de datos utilizando DAOs.
Auditoría: Registra automáticamente los cambios en las tablas.
Consulta: Proporciona métodos para consultar datos desde la base de datos.

---

## ⚙️ Cómo correr el proyecto localmente

1. Clonar el repositorio
https://github.com/FeRamirezR/pokeapi-plt.git

2. Ejecutar migraciones con flyway o hacerlo a mano 
mvn flyway:clean
mvn flyway:migrate

3. Compilar y ejecutar

mvn clean install
mvn spring-boot:run

## WSDL:
http://localhost:8080/ws/pokemons.wsdl(no esta funcional)

## 📐 Patrones de diseño aplicados
1. Data Access Object (DAO)
Descripción:
Este patrón se utiliza para abstraer y encapsular el acceso a la base de datos.
En tu proyecto, las interfaces como PokemonDao, TypeDao y AbilityDao extienden CrudRepository o JpaRepository, lo que proporciona métodos predefinidos para operaciones CRUD.
Ventaja:
Facilita el acceso a la base de datos y desacopla la lógica de negocio de la lógica de persistencia.
2. Service Layer
Descripción:
Este patrón organiza la lógica de negocio en una capa de servicios (PokemonService, TypeService, AbilityService) y sus implementaciones (PokemonServiceImpl, TypeServiceImpl, AbilityServiceImpl).
Los servicios actúan como intermediarios entre los controladores (o inicializadores) y los DAOs.
Ventaja:
Promueve la separación de responsabilidades y facilita el mantenimiento y la prueba de la lógica de negocio.
3. Dependency Injection (DI)
Descripción:
Spring Boot utiliza este patrón para inyectar dependencias en las clases, como los DAOs y los servicios.
Por ejemplo, en PokemonDataInitializer, el servicio PokemonService se inyecta a través del constructor.
Ventaja:
Reduce el acoplamiento entre las clases y facilita la configuración y prueba del proyecto.
4. Singleton
Descripción:
Spring Boot gestiona los beans como singletons por defecto, lo que significa que cada componente como PokemonServiceImpl o PokemonDao tiene una única instancia en el contexto de la aplicación.
Ventaja:
Ahorra recursos al reutilizar instancias y asegura un estado consistente en toda la aplicación.
5. Factory Method (a través de Spring Data Repositories)
Descripción:
Spring Data utiliza el patrón Factory Method para crear instancias de repositorios como PokemonDao, TypeDao, etc., en tiempo de ejecución.
Ventaja:
Simplifica la creación de repositorios y elimina la necesidad de implementarlos manualmente.
6. Observer (Triggers en la Base de Datos)
Descripción:
Los triggers definidos en V4__add_triggers.sql actúan como observadores que reaccionan automáticamente a eventos (INSERT, UPDATE, DELETE) en las tablas.
Ventaja:
Permite registrar cambios en las tablas sin modificar la lógica de la aplicación.
7. DTO (Data Transfer Object)
Descripción:
Las clases como PokemonDto, TypeDto y AbilityDto se utilizan para transferir datos entre capas (por ejemplo, entre el cliente REST y los servicios).
Ventaja:
Reduce el acoplamiento entre las capas y permite controlar qué datos se exponen.
8. Client (REST Client)
Descripción:
El cliente REST (PokemonRestClient) implementa un patrón de cliente para consumir datos de una API externa.
Ventaja:
Centraliza la lógica de comunicación con la API externa y facilita su reutilización.
9. Initialization (Data Initializer)
Descripción:
Clases como PokemonDataInitializer, TypeDataInitializer y AbilityDataInitializer implementan un patrón de inicialización para cargar datos al arrancar la aplicación.
Ventaja:
Automatiza la carga inicial de datos y asegura que la base de datos esté preparada para su uso.
10. Active Record (Triggers y Auditoría)
Descripción:
Los triggers en la base de datos implementan un patrón similar al Active Record, donde las tablas "se observan a sí mismas" y registran cambios automáticamente en la tabla audit_log.
Ventaja:
Simplifica la auditoría y asegura que los cambios se registren sin intervención manual.

## 📌 Pendientes / Posibles mejoras
Cachear resultados del API para evitar múltiples llamadas innecesarias.
Implementar autenticación básica o token para exponer los servicios.
Añadir la respuesta de servicios SOAP.
Añadir paginación también al servicio SOAP.
Reporteria.

## 👨‍💻 Autor
- Desarrollado por Luisa Ramirez
- Contacto: lframirezr4@gmail.com
- LinkedIn: https://www.linkedin.com/in/luisa-ram%C3%ADrez-3a6156b0?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=ios_app

