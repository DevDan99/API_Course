# API Curso Java

API RESTful desenvolvida em Java com Spring Boot para gerenciamento de cursos. Permite criar, listar, atualizar, ativar/desativar e remover cursos de forma simples e eficiente.

## Funcionalidades

- Cadastro de cursos
- Listagem de todos os cursos
- Filtro por nome e categoria
- Atualização total (PUT) e parcial (PATCH/toggle)
- Ativação/desativação de cursos
- Remoção de cursos

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok

## Como executar o projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/api_curso.git
   cd api_curso
   ```
2. **Configure o banco de dados:**
   - Altere o arquivo `src/main/resources/application.properties` com as credenciais do seu banco PostgreSQL.
3. **Suba o banco com Docker (opcional):**
   ```bash
   docker-compose up -d
   ```
4. **Execute a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```
   ou
   ```bash
   mvn spring-boot:run
   ```

## Exemplos de uso

### Criar curso

```http
POST /cursos
Content-Type: application/json
{
  "name": "Java Básico",
  "category": "Backend",
  "teacher": "João Silva"
}
```

### Listar todos os cursos

```http
GET /cursos
```

### Filtrar por nome e categoria

```http
GET /cursos?name=Java&category=Backend
```

### Atualizar curso (PUT)

```http
PUT /cursos/{id}
Content-Type: application/json
{
  "name": "Java Avançado",
  "category": "Backend",
  "teacher": "Maria Souza",
}
```

### Ativar/Desativar curso (toggle)

```http
PATCH /cursos/{id}/active
```

### Remover curso

```http
DELETE /cursos/{id}
```

## Estrutura do Projeto

```
api_curso/
├── src/
│   ├── main/
│   │   ├── java/com/danielcosta/api_curso/
│   │   │   ├── modules/course/
│   │   │   │   ├── controller/
│   │   │   │   ├── dto/
│   │   │   │   ├── entities/
│   │   │   │   ├── repositories/
│   │   │   │   └── useCases/
│   │   └── resources/
│   └── test/
├── pom.xml
└── docker-compose.yml
```

## Licença

[MIT](LICENSE)

---

> Projeto desenvolvido para fins de estudo e demonstração de arquitetura limpa com Spring Boot.
