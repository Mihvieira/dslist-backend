# DSLIST

O objetivo do projeto DSLIST é criar uma aplicação backend para gerenciar uma lista de jogos, utilizando diversas tecnologias.

## Aprendizados

Durante o desenvolvimento do projeto, foram abordados os seguintes tópicos:

- **Conceitos de Sistemas Web e Recursos**: Entendimento sobre como funcionam os sistemas web e os recursos que eles oferecem.
- **Cliente/Servidor, HTTP, JSON, Padrão Rest para API Web**: Compreensão do modelo cliente/servidor, protocolo HTTP, formato de dados JSON e o padrão REST para construção de APIs.
- **Estruturação de Projeto Spring Rest**: Organização de um projeto utilizando o framework Spring para criar APIs RESTful.
- **Entidades e ORM**: Mapeamento objeto-relacional utilizando JPA e Hibernate.
- **Database Seeding**: População inicial do banco de dados com dados de exemplo.
- **Padrão de Arquitetura em Camadas**: Separação do projeto em camadas (Controller, Service, Repository) para melhor organização e manutenção, além do uso de Data Transfer Objects (DTOs) para transferência de dados.
- **Relacionamentos N-N**: Modelagem de relacionamentos muitos-para-muitos entre entidades.
- **Classe de Associação, Embedded Id**: Utilização de classes de associação e IDs embutidos para modelar relacionamentos complexos.
- **Consultas SQL no Spring Data JPA**: Execução de consultas SQL utilizando o Spring Data JPA.
- **Projections**: Uso de projeções para otimizar consultas e retornar apenas os dados necessários.
- **Perfis de Projeto**: Configuração de diferentes perfis de execução para o projeto, tais como testes e produção.
- **Ambiente Local com Docker Compose**: Configuração do ambiente de desenvolvimento local utilizando Docker Compose.
- **Processo de Homologação Local**: Validação do funcionamento do projeto em ambiente local antes do deploy.
- **Processo de Deploy com CI/CD utilizando o Railway**: Automação do processo de deploy utilizando integração contínua e entrega contínua (CI/CD) com a plataforma Railway.
- **Configuração de CORS**: Configuração do Cross-Origin Resource Sharing (CORS) para permitir requisições de diferentes origens.
- **Design e Implementação de Endpoint Especial**: Criação de endpoints específicos para funcionalidades avançadas.
- **Operação de Atualização no Spring**: Implementação de operações de atualização de dados.
- **Operações com List**: Manipulação de listas de dados.
- **Verbo HTTP e Idempotência**: Uso correto dos verbos HTTP e conceito de idempotência nas operações.

## Endpoints

### GameController

- `GET /games`: Retorna a lista de todos os jogos.
- `GET /games/{id}`: Retorna os detalhes de um jogo específico pelo ID.
- `POST /games`: Adiciona um novo jogo.
- `PUT /games/{id}`: Atualiza as informações de um jogo existente pelo ID.
- `DELETE /games/{id}`: Remove um jogo pelo ID.

### GameListController

- `GET /gamelists`: Retorna a lista de todas as listas de jogos.
- `GET /gamelists/{id}`: Retorna os detalhes de uma lista de jogos específica pelo ID.
- `POST /gamelists`: Adiciona uma nova lista de jogos.
- `PUT /gamelists/{id}`: Atualiza as informações de uma lista de jogos existente pelo ID.
- `DELETE /gamelists/{id}`: Remove uma lista de jogos pelo ID.

Este README fornece uma visão geral do projeto DSLIST e dos principais conceitos e tecnologias abordados durante o curso Intensivão Java Spring da DevSuperior.
