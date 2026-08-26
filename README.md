# E-commerce API (Spring Boot)

API REST para um sistema de e-commerce, desenvolvida em **Java 25** com **Spring Boot**. O projeto cobre o fluxo básico de uma loja virtual: cadastro e autenticação de usuários, catálogo de produtos e categorias, pedidos e pagamentos — com autenticação via JWT e controle de acesso por papéis.

O projeto foi criado como prática de arquitetura backend, aplicando separação em camadas, autenticação stateless com JWT e boas práticas de API REST.

---

## Sobre o projeto

O sistema permite que usuários se cadastrem, façam login e realizem pedidos de produtos organizados por categoria, com o pagamento sendo registrado por pedido. Administradores têm acesso a operações de gestão que usuários comuns não têm (como listar ou remover usuários).

---

## Tecnologias utilizadas

- **Java 25**
- **Spring Boot 4** (Web MVC)
- **Spring Security** — autenticação e autorização
- **JWT (JJWT)** — geração e validação de token
- **Spring Data JPA** — persistência de dados
- **MySQL** — banco de dados relacional
- **Flyway** — migrações de banco de dados
- **Lombok** — redução de código boilerplate
- **Bean Validation (`@Valid`)** — validação de dados de entrada
- **Maven** — gerenciamento de dependências

---

## Arquitetura

O projeto segue uma arquitetura em camadas:

```
Controller → Service (Interface + Implementação) → Repository → Banco de Dados
```

- **Controllers**: expõem os endpoints REST e tratam requisições HTTP
- **Services**: contêm a lógica de negócio, separados por domínio (usuário, produto, categoria, pedido, pagamento)
- **Repositories**: interfaces Spring Data JPA para acesso ao banco
- **DTOs**: usados para entrada e saída de dados, mantendo as entidades JPA isoladas da camada de API
- **Exceptions**: tratamento centralizado de erros com `@ControllerAdvice`, retornando respostas padronizadas (`StandardError`)

---

## Funcionalidades

### Autenticação
- Login com email e senha, retornando um token JWT
- Filtro (`JwtAuthenticationFilter`) que valida o token em cada requisição e autentica o usuário no contexto do Spring Security
- Senhas armazenadas com hash **BCrypt**

### Usuários
- Cadastro público de usuário, com upload de foto de perfil
- Listagem de todos os usuários (somente ADMIN)
- Consulta e atualização de um usuário (USER ou ADMIN)
- Remoção de usuário (somente ADMIN)

### Produtos
- Cadastro de produto com upload de imagem (multipart)
- Listagem e consulta pública de produtos
- Atualização e remoção de produtos

### Categorias
- Cadastro, listagem e consulta pública de categorias
- Produtos podem pertencer a várias categorias (relação muitos-para-muitos)

### Pedidos
- Criação, listagem, consulta, atualização e remoção de pedidos
- Cada pedido está vinculado a um cliente (`@ManyToOne`) e pode ter um pagamento associado (`@OneToOne`)
- Status do pedido controlado por enum (`AWAITING_PAYMENT`, `PAID`, `SHIPPED`, `DELIVERED`, `CANCELLED`)

### Pagamentos
- Criação, listagem, consulta, atualização e remoção de pagamentos vinculados a um pedido

---

## Regras de acesso (Spring Security)

| Rota | Acesso |
|---|---|
| `POST /auth/login` | Público |
| `POST /users/register` | Público |
| `GET /products/**` | Público |
| `GET /categories/**` | Público |
| `GET /users` | Somente ADMIN |
| `DELETE /users/**` | Somente ADMIN |
| `GET /users/**`, `PUT /users/**` | USER ou ADMIN |
| Demais rotas | Requer autenticação (token JWT válido) |

---

## Estrutura do projeto

```
src/main/java/com/projeto/ecommerce/
├── config/          # Configuração de segurança e filtro JWT
├── controllers/     # Endpoints REST (auth, user, product, category, order, payment)
├── dto/             # Objetos de transferência de dados
├── entities/         # Entidades JPA
├── enums/           # Enums (papéis de usuário, status do pedido)
├── exceptions/      # Tratamento centralizado de exceções
├── repositories/    # Interfaces Spring Data JPA
└── services/        # Regras de negócio (interface + implementação por domínio)
```

---

## Como rodar o projeto

Pré-requisitos: Java 25, Maven e um banco MySQL rodando localmente.

Clone o repositório:
```
git clone https://github.com/Bh0Eri/ecommerse-the-new-ecommerce.git
cd ecommerse-the-new-ecommerce
```

Configure o acesso ao banco de dados em `src/main/resources/application.properties` (URL, usuário e senha do MySQL).

Execute o projeto:
```
./mvnw spring-boot:run
```

A API sobe por padrão em `http://localhost:8080`.

---

## Possíveis melhorias futuras

- Criar os scripts de migração do Flyway (`src/main/resources/db/migration`)
- Restringir a criação/edição/remoção de produtos e categorias apenas para o papel ADMIN
- Adicionar testes automatizados (unitários e de integração) para services e controllers
- Documentar a API com Swagger/OpenAPI
- Adicionar paginação nas listagens (produtos, pedidos, pagamentos)
- Dockerizar a aplicação e o banco de dados

---

## Autor

Desenvolvido por **Eric Moreira**.

GitHub: [@Bh0Eri](https://github.com/Bh0Eri)
