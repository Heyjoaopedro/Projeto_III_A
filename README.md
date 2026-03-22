# Sistema Escolar (Console) — Java (POO + Estruturas de Dados)

Aplicação desktop simples (executada no **console**) desenvolvida em **Java**, utilizando **Programação Orientada a Objetos (POO)** e **Estruturas de Dados**, para apoiar a organização básica de uma escola.

O sistema permite cadastrar **alunos** e **turmas**, realizar **matrículas** e executar **consultas/relatórios** diretamente pelo menu no terminal.

## Funcionalidades

### Cadastros
- **Cadastrar Aluno**
  - Nome
  - CPF
  - Endereço
  - Data de nascimento (idade calculada automaticamente)
- **Cadastrar Turma**
  - Código
  - Etapa de ensino
  - Ano
  - Limite de vagas
  - Controle de número de matriculados

### Operações e Consultas
- Listar **alunos em ordem alfabética** (com idade)
- Listar **turmas cadastradas**
- **Matricular** aluno em turma (somente se houver vaga)
- Listar **alunos matriculados em uma turma** (por código)
- Mostrar, para uma etapa de ensino, o total de alunos **fora da idade prevista**

## Regras de Negócio — Faixa Etária por Etapa

- **Infantil:** idade < 6  
- **Fundamental Anos Iniciais:** 6 a 11  
- **Fundamental Anos Finais:** 11 a 15  
- **Médio:** 15 a 18  

A idade é calculada com base na **data de nascimento** e na **data atual**.

## Estruturas de Dados Utilizadas

- **Turmas:** armazenadas em `ArrayList<Turma>` (API Java)
- **Alunos:** armazenados em uma estrutura implementada pelo grupo:
  - `ListaDeAlunos` (baseada em **array**)

## Estrutura do Projeto (Classes)

- `Aluno`
  - Dados do aluno e cálculo de idade
- `Turma`
  - Dados da turma, matrícula e contagem de alunos fora da idade
- `ListaDeAlunos`
  - Lista implementada pelo grupo usando array  
  - Métodos:
    - `incluirNoInicio(Aluno)`
    - `incluirNoFim(Aluno)`
    - `ordenar()`
    - `removerDoFim()`
    - `tamanho()`
    - `get(int)`
- `TurmaService`
  - Cadastro, busca e listagens/relatórios sobre turmas
- `Main`
  - Menu e interação via console

## Menu do Sistema

1. Cadastrar Aluno  
2. Cadastrar Turma  
3. Matricular Aluno em Turma  
4. Listar Alunos (Ordem Alfabética)  
5. Listar Turmas  
6. Alunos Fora da Idade por Etapa  
7. Listar Alunos de uma Turma  
0. Sair  

## Como Executar

### Pré-requisitos
- **Java 17+** (ou versão compatível com o projeto)
- **Maven** (se estiver utilizando `pom.xml`)

### Executar pela IDE
- Abra o projeto na IDE (IntelliJ/Eclipse/VS Code)
- Execute a classe `Main`

### Executar via Maven (opcional)
- Caso o Maven não esteja configurado para executar diretamente, utilize a execução pela IDE.
- Se o projeto estiver configurado com plugin de execução:
```bash
mvn clean compile exec:java
