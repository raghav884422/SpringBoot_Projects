# SalesSavvy Backend - AI Coding Guidelines

## Architecture Overview
This is a Spring Boot 3.2.2 application (Java 17) for an e-commerce platform with JWT-based authentication. Key components:
- **Entities**: User, Product, Category, CartItem, ProductImage, JWTToken (in `entiry/` package)
- **Controllers**: REST endpoints in `userControllers/` (AuthController, ProductController, CartController, usercontroller)
- **Services**: Business logic with interfaces in `service/` and implementations in `serviceImplementation/`
- **Repositories**: JPA repositories in `userrepositries/` extending JpaRepository<User, Integer>
- **Security**: Custom AuthenticationFilter for JWT validation, BCrypt password encoding

## Key Conventions
- **Entity IDs**: Use `int`/`Integer` (not `Long`) with `@GeneratedValue(strategy = GenerationType.IDENTITY)`
- **Package Naming**: `entiry` (typo), `userControllers`, `userrepositries` (typos), `serviceImplementation`
- **Class Naming**: Follow existing patterns like `AuthServiceIplementation` (typo), `UserServiceImlementation` (typo)
- **JPA**: `ddl-auto=validate` in application.properties - schema must be pre-created
- **Authentication**: JWT tokens stored in HttpOnly cookies, validated by AuthenticationFilter
- **CORS**: Enabled globally with `@CrossOrigin` on controllers
- **Database**: MySQL with hardcoded credentials (root/Raghav@123) - update for production

## Development Workflow
- **Build**: `mvn clean install` (requires MySQL running on localhost:3306 with 'salessavvy' database)
- **Run**: `mvn spring-boot:run` or `java -jar target/salesavvy-0.0.1-SNAPSHOT.jar`
- **Test**: `mvn test` (JUnit 5 with SpringBootTest)
- **Debug**: Standard Spring Boot debugging; filter excludes `/api/users/register` and `/api/auth/login`

## Code Patterns
- **DTOs**: Simple POJOs like LoginRequestDTO without annotations
- **Services**: Constructor injection, `@Autowired` on setters for config
- **JWT**: HS512 with 64+ byte secret from `${jwt.secret}`, 1-hour expiration
- **Logging**: SLF4J in filters (e.g., AuthenticationFilter)
- **Error Handling**: Try-catch in controllers returning ResponseEntity with Map<String, Object>

## Dependencies & Config
- Spring Web, Data JPA, MySQL Connector, JJWT 0.11.5, Spring Security Crypto
- `application.properties`: `spring.jpa.show-sql=true`, security disabled, JWT config
- DevTools enabled for hot reload

Reference: [User.java](src/main/java/com/salesavvy/app/entiry/User.java) for entity structure, [AuthController.java](src/main/java/com/salesavvy/app/userControllers/AuthController.java) for auth flow.</content>
<parameter name="filePath">c:\Users\HP\Desktop\SpringBoot\salesavvy\.github\copilot-instructions.md