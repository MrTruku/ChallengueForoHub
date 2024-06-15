# Proyecto Challengue de Foro Alura (BackEnd)

Entendemos la función del foro y su interfaz visual, pero ¿conocemos los mecanismos internos? Nos preguntamos, ¿dónde se guardan los datos? ¿Cómo se procesan para vincular un tópico con su respuesta correspondiente, o cómo se asocian los usuarios con las respuestas en un tópico?

Nuestro reto se denomina ForoHub: aquí, emularemos estos procesos en el lado del servidor y, para ello, desarrollaremos una API REST utilizando Spring.

Esta API se enfocará en los tópicos y proporcionará a los usuarios la capacidad de:

- Crear un tópico nuevo.
- Listar todos los tópicos existentes.
- Consultar un tópico en particular.
- Modificar un tópico.
- Borrar un tópico.

Estas operaciones son las que comúnmente se agrupan bajo el acrónimo CRUD (CREATE, READ, UPDATE, DELETE), y son muy parecidas a las que implementamos en LiterAlura. Sin embargo, ahora lo haremos de manera integral, incluyendo las funciones de UPDATE y DELETE, y emplearemos un marco de trabajo que simplificará significativamente nuestra labor.


##Tecnologías Utilizadas

   - Lombok
   - JDK 17.
   -  Maven.
   - Spring Web
   - Spring Boot.
   - MySQL.
   - Spring Data JPA.
   - Flyway Migration.
   - Validation.
   - Spring Security 
     

###Base de datos
La API se enlaza con una base de datos MySQL que alberga diversas tablas, las cuales se describen a continuación:

Tabla course : Almacena los cursos ofrecidos en el foro.
Tabla user : Incluye a los usuarios que generan tópicos y participan con respuestas.
Tabla topic : Constituye el núcleo del desafío, estableciendo el foro o la consulta planteada por un usuario.
Tabla status : Registra el estado actual de los tópicos (Activo, Inactivo).
Tabla profile : Enumera los distintos roles de perfil de usuario (Administrador, Experto, Novato).
Tabla responses : Recoge las respuestas dadas a cada uno de los tópicos planteados en el sistema.
