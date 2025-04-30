<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h1>📚 API REST backend para empréstimo e gerenciamento de livros com Spring Boot e banco de dados relacional</h1>
    <p>Este repositório contém o projeto de um sistema de gerenciamento de livros e empréstimos, utilizando <strong>Spring Boot</strong> para a construção do backend, com um banco de dados relacional (<strong>PostgreSQL</strong>) para armazenar os dados dos usuários, livros, autores e empréstimos. O sistema oferece operações CRUD para gerenciar livros, autores, usuários e empréstimos, além de verificar automaticamente o status dos empréstimos com base na data de devolução.</p>
    <h2>🚀 Tecnologias Utilizadas</h2>
    <ul>
        <li><strong>Java 21</strong></li>
        <li><strong>Spring Boot 3.4.4</strong></li>
        <li><strong>Spring Data JPA</strong></li>
        <li><strong>Banco de Dados Relacional</strong> (PostgreSQL)</li>
        <li><strong>Maven</strong></li>
        <li><strong>Lombok</strong></li>
        <li><strong>Git para versionamento</strong></li>
        <li><strong>Spring Scheduler</strong> (para tarefas agendadas, como verificar empréstimos expirados)</li>
    </ul>
    <h2>📌 Funcionalidades</h2>
    <ul>
        <li><strong>CRUD completo</strong> para livros, autores, usuários e empréstimos.</li>
        <li><strong>Relacionamentos entre entidades.</strong></li>
        <li><strong>Lógica de negócios</strong> para calcular a data de devolução e alterar o status do empréstimo automaticamente quando expirar.</li>
        <li><strong>Controle de exceções</strong> personalizadas para erros de dados.</li>
        <li><strong>DTOs</strong> para controle e validação de dados de entrada.</li>
        <li><strong>Status de Empréstimo</strong> (Válido, Expirado, Inválido).</li>
    </ul>
    <h2>🛠 Como Executar o Projeto</h2>
    <ol>
        <li><strong>Clone o repositório</strong><br>
            Clone o repositório para sua máquina local:
            <pre><code>git clone https://github.com/MatheusSButh/library-api.git</code></pre>
        </li>
        <li><strong>Configure o banco de dados</strong><br>
            Certifique-se de que o banco de dados relacional (MySQL ou PostgreSQL) está em execução localmente ou em um servidor. Crie o banco de dados conforme necessário. No arquivo <code>application.properties</code>, configure as credenciais do banco de dados:
            <pre><code>spring.datasource.url=jdbc:postgresql://localhost:5432/nomedobanco
            
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update</code></pre>
        </li>
        <li><strong>Execute o projeto</strong><br>
            Você pode executar o projeto utilizando o Maven. Na raiz do projeto, execute o comando:
            <pre><code>mvn spring-boot:run</code></pre>
        </li>
        <li><strong>Teste a API</strong><br>
            Com o projeto em execução, você pode testar as operações CRUD utilizando ferramentas como <strong>Postman</strong> ou <strong>Insomnia</strong>.</li>
    </ol>
    <h2>📝 Autor</h2>
    <p><strong>Matheus de Souza Buth</strong><br>
    <a href="https://www.linkedin.com/in/matheusbuth/">LinkedIn</a></p>

</body>
</html>
