🎓 Sistema de Registro Universitario - Backend API
Este proyecto consiste en el desarrollo de un sistema backend para la gestión académica de una universidad, implementado con Spring Boot. El sistema permite registrar, consultar, actualizar y eliminar datos relacionados a estudiantes, materias, inscripciones y usuarios, cumpliendo con estándares modernos de desarrollo y seguridad.

✅ Funcionalidades implementadas
🔐 Autenticación y Autorización con JWT y manejo de roles.

👨‍🎓 CRUD de Estudiantes con validaciones, búsqueda por nombre, baja lógica y control de errores.

📚 CRUD de Materias, validación de requisitos y asignación de docentes.

📝 CRUD de Inscripciones, permitiendo inscribir estudiantes a materias con control de duplicados.

⚠️ Manejo de excepciones globales con @RestControllerAdvice.

🛡️ Protección de endpoints mediante tokens JWT.

📄 Documentación interactiva de endpoints usando Swagger UI.

🧠 Caché con Redis para mejorar el rendimiento de las consultas.

🗃️ Persistencia con PostgreSQL, configurada mediante application.properties.

📂 Estructura del Proyecto
bash
Copiar
Editar
src/
├── config/         # Configuraciones de seguridad y JWT
├── controller/     # Controladores REST
├── dto/            # Objetos de transferencia de datos
├── model/          # Entidades del sistema
├── repository/     # Interfaces JPA
├── service/        # Lógica de negocio
├── validation/     # Validaciones y manejo de errores
└── resources/      # application.properties y configuración general
🧪 Pruebas y Documentación
Todos los endpoints han sido probados mediante herramientas como Postman.

Se incluye documentación técnica con capturas de pruebas, base de datos de ejemplo y manual de uso.

El código está listo para ser desplegado en entornos locales o en servidores compatibles con Spring Boot.
