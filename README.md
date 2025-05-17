
# ⚡ mongoDb-spring-lab-votação

Projeto didático desenvolvido com Java 17, Spring Boot 3.4.5 e MongoDB, simulando um sistema de votação online. O objetivo principal é estudar a persistência com MongoDB e aplicar uma arquitetura em camadas com DTO, Service, Repository, Controller e documentação via Swagger.

---

## 📚 Objetivo

Permitir o registro de votos em candidatos previamente cadastrados, com apuração automática da eleição. O sistema garante que cada CPF vote apenas uma vez, com regras de negócio centralizadas no backend.

---

## 🚀 Tecnologias Utilizadas

- Java 17  
- Spring Boot 3.4.5  
- Spring Data MongoDB  
- MongoDB  
- Springdoc OpenAPI (Swagger UI)  
- Maven  
- Postman  
- MongoDB Compass  
- IntelliJ IDEA  
- Git & GitHub  

---

## 💾 Como Instalar o MongoDB e o Compass

### 1. Instale o MongoDB Community Server:
- [https://www.mongodb.com/try/download/community](https://www.mongodb.com/try/download/community)
- Escolha a versão "Current", sistema operacional Windows, tipo MSI.
- Siga com instalação padrão.

### 2. Instale o MongoDB Compass:
- [https://www.mongodb.com/try/download/compass](https://www.mongodb.com/try/download/compass)
- Execute e conecte-se em: `mongodb://localhost:27017`

---

## 🗂️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br/wesley/mongo_spring_lab/votacao/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── service/
│   │       └── VotacaoApplication.java
│   └── resources/
│       └── application.properties
```

---

## 🛠️ Banco de Dados

- Banco: `votacao_db`
- Coleções criadas automaticamente: `candidatos`, `votos`

> Nenhum script é necessário. Tudo é criado via Spring Data MongoDB.

---

## ▶️ Como Executar o Projeto

```bash
mvn clean install
mvn spring-boot:run
```

Acesse o Swagger em:
```
http://localhost:8080/swagger-ui.html
```

---

## 📌 Testando com Swagger

1. Acesse `http://localhost:8080/swagger-ui.html`
2. Explore todos os endpoints:
   - POST /api/candidatos
   - GET /api/candidatos
   - POST /api/votos
   - GET /api/votos
   - GET /api/votos/resultado
   - GET /api/votos/resultado-extenso

### 📸 Print do Swagger UI
![Swagger](Prints/swagger.png)

---

## 📥 Testando com Postman

### Requisição POST para /api/votos
```json
{
  "cpf": "12345678901",
  "candidatoId": "64828f766d5164d56dd6da5"
}
```

### 📸 Print dos Testes no Postman
![Postman Testes](prints/postman-testes.png)

---

## 📲 Execução da Aplicação

### Build com sucesso via terminal:
```bash
mvn clean install
```

### Execução com IntelliJ:
Clique em "Run" e aguarde o Tomcat subir na porta 8080.

### 📸 Print da Build
![Build](prints/build-ok.png)

### 📸 Print da Execução
![Run](prints/run-ok.png)

---

## 📂 Visualização no MongoDB Compass

- Verifique os documentos persistidos em `votacao_db`
- Confira as coleções `candidatos` e `votos`

### 📸 Print do Compass
![Compass](prints/compass-votacao.png)

---

## ✅ Funcionalidades

- Cadastrar candidato
- Registrar voto único por CPF
- Apurar votos com percentual
- Visualização por extenso ordenada
- Documentação com Swagger
- Visualização no MongoDB Compass

---

## 🧠 Conceitos Trabalhados

- Spring Boot com MongoDB
- Persistência orientada a documentos
- DTOs desacoplados das entidades
- Regras de negócio em `Service`
- Validação com Jakarta Validation
- OpenAPI com Springdoc
- Testes com Postman e Swagger

---

## ✅ Considerações Finais

Este projeto oferece um ambiente ideal para entender, testar e dominar o uso de MongoDB com Spring Boot. Foi estruturado com foco didático, clareza no código e facilidade de testes utilizando Postman e Swagger.

Ao explorar um sistema de votação simples, você mergulha em conceitos essenciais de persistência orientada a documentos, camadas bem definidas e integração com ferramentas modernas de desenvolvimento.

Essa abordagem também é altamente recomendada em ambientes de produção quando combinada com práticas de validação, autenticação e controle transacional adequados.

Sinta-se à vontade para clonar, modificar e adaptar conforme sua necessidade de estudo!

---

## 👤 Autor

**Wesley Martins Rosa**  
Email: wesleymrosa@gmail.com  
GitHub: [github.com/wesleymrosa](https://github.com/wesleymrosa)  
LinkedIn: [linkedin.com/in/wesley-martins-rosa-5118aa15a](https://linkedin.com/in/wesley-martins-rosa-5118aa15a)

---

## 📅 Licença

Projeto com fins educacionais. Sinta-se à vontade para estudar, adaptar e aprimorar.

