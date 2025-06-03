# 📊 Sistema de Gestão de Espaços

API desenvolvida em **Java com Spring Boot** para gerenciamento de reservas e solicitações de uso de espaços físicos, como auditórios, salas de reunião e ginásios. A aplicação utiliza **PostgreSQL** como banco de dados relacional, com integração via **Spring Data JPA**.

## 📚 Tecnologias Utilizadas

- ✅ Java 21  
- ✅ Spring Boot  
- ✅ Spring Data JPA  
- ✅ PostgreSQL  
- ✅ Lombok  
- ✅ Maven  

## 🗂️ Estrutura do Projeto

- `src/main/java/system/gestao/api/` → Controllers, Services, Models, Repositories e DTOs.
- `src/main/resources/application.properties` → Configuração de conexão com banco e propriedades da aplicação.

## 🖥️ Banco de Dados

O projeto usa **PostgreSQL**. Estrutura das tabelas:

- **usuario**
- **espaco_fisico**
- **solicitacao**
- **historico_avaliacao**
- **auditoria**

## 📦 Scripts de Banco de Dados

Os scripts SQL utilizados para criação e popularização do banco de dados PostgreSQL estão na pasta [`/sql`](./sql):

- `create_tables.sql` — Criação das tabelas
- `insert_data.sql` — Inserts de dados iniciais
- `dql_queries.sql` — Consultas diretas no banco

