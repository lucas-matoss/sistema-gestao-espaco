# 📊 Sistema de Gestão de Espaços

API desenvolvida em **Java com Spring Boot** para gerenciamento de reservas e solicitações de uso de espaços físicos, como auditórios, salas de reunião e ginásios. A aplicação utiliza **PostgreSQL** como banco de dados relacional, com integração via **Spring Data JPA**.

## Descrição

A API permite que usuários possam:
- Cadastrar e consultar espaços físicos
- Realizar solicitações de reserva
- Consultar e avaliar solicitações
- Registrar ações de auditoria

## Tecnologias Utilizadas

- Java 21  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Lombok  
- Maven

## Testes de API com Insomnia

O Insomnia foi utilizado para disparar as requisições e testar os endpoints da API durante o desenvolvimento.

## 📡 Endpoints Disponíveis

### Usuários
- `GET /usuario` — Listar todos os usuários
- `POST /usuario` — Cadastrar um novo usuário

### Solicitação
- `GET /solicitacao` — Consultar solicitações
- `POST /solicitacao` — Criar nova solicitação

### Histórico de Avaliação
- `GET /historicoAvaliacao` — Consultar histórico de avaliações
- `POST /historicoAvaliacao` — Aprovar ou Rejeitar uma solicitação (Apenas gestores)

### Auditoria
- `GET /auditoria` — Listar registros de auditoria


## Estrutura do Projeto

- `src/main/java/system/gestao/api/` → Controllers, Services, Models, Repositories e DTOs.
- `src/main/resources/application.properties` → Configuração de conexão com banco e propriedades da aplicação.

## Banco de Dados

As tabelas estão estruturadas com **chaves primárias e estrangeiras**, garantindo a integridade entre os relacionamentos.
O projeto usa **PostgreSQL**. Estrutura das tabelas:

- **usuario**
- **espaco_fisico**
- **solicitacao**
- **historico_avaliacao**
- **auditoria**

## Scripts de Banco de Dados

Os scripts SQL utilizados para criação e popularização do banco de dados PostgreSQL estão na pasta [`/database`](./sql):

- `create_tables.sql` — Criação das tabelas
- `insert_data.sql` — Inserts de dados iniciais
- `dql_queries.sql` — Consultas diretas no banco

## Autor

Lucas Matos Azevedo Cruz
