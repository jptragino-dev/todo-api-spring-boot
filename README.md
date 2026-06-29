# Todo API - Spring Boot

API REST para gerenciamento de tarefas desenvolvida com Java e Spring Boot.

## Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- Banco H2 (em memória)
- Maven

## Endpoints
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /tasks | Criar tarefa |
| GET | /tasks | Listar todas |
| GET | /tasks/{id} | Buscar por ID |
| PUT | /tasks/{id} | Atualizar tarefa |
| PATCH | /tasks/{id}/concluir | Marcar como concluída |
| DELETE | /tasks/{id} | Deletar tarefa |

## Como rodar
1. Clone o repositório
2. Abra na IDE de sua preferência (Eclipse, IntelliJ)
3. Rode a classe `TodoApiApplication.java`
4. Acesse `http://localhost:8080/tasks`

## Exemplo de requisição
```json
POST /tasks
{
  "titulo": "Estudar Java",
  "descricao": "Terminar curso da FIAP"
}
```
