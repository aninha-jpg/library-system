# 📚 Library System (Java)

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=for-the-badge&logo=github)

## 📌 Sobre o projeto

Este projeto é um sistema simples de gerenciamento de biblioteca desenvolvido em Java.  
Ele simula o controle de livros, empréstimos, devoluções, fila de espera e histórico de navegação do usuário.

O objetivo é aplicar estruturas de dados como **Stack (pilha)** e **Queue (fila)** em um cenário prático.

---

## 🚀 Funcionalidades

* Cadastro de livros
* Listagem de livros disponíveis
* Empréstimo de livros
* Devolução de livros
* Sistema de fila de espera (Queue)
* Histórico de navegação do usuário (Stack)
* Validação de ID de livros
* Menu interativo via console

---

## 🧠 Estruturas de dados utilizadas

### 📦 Queue (Fila)

Utilizada para gerenciar a lista de espera de usuários quando um livro está emprestado.

* Primeiro a entrar → primeiro a ser atendido (FIFO)
* Implementação: `LinkedList<Usuario>`

---

### 📚 Stack (Pilha)

Utilizada para armazenar o histórico de navegação do usuário.

- Última ação → primeiro a ser exibida (LIFO)
- Implementação: `Stack<String>`

---

## 🏗️ Estrutura do projeto

```
src/
├── application/
│   └── Program.java
├── entities/
│   ├── Livro.java
│   ├── Usuario.java
│   └── Historico.java
```


## ▶️ Como executar

### 1. Clonar o repositório
```bash
git clone https://github.com/aninha-jpg/library-system.git
```
### 2. Acesse a pasta do repositório

```
cd library-system/src
```

### 3. Compile 

```
javac application/Program.java
```

### 4. Execute a classe 

```
java application.Program
```

## 🎯 Objetivo educacional

Este projeto foi desenvolvido com foco em:

* Programação Orientada a Objetos (POO)
* Estruturas de dados (Stack e Queue)
* Simulação de sistema real
* Lógica de fluxo com menu interativo

## 👩‍💻 Tecnologias utilizadas
* Java
* Collections Framework
* IDE: VS Code

---

## ⚙️ Conceitos adicionais utilizados

- Expressões lambda
- Stream API (`stream()`, `filter()`, `findFirst()`)
- Programação funcional básica em Java

---

### 📌 Autor

Ana Luiza, Projeto desenvolvido para fins acadêmicos.