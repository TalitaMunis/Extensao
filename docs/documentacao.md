## 📋 Requisitos do Sistema

### ✅ Requisitos Funcionais

#### Gerenciamento de Usuário
- Cadastrar usuário  
- Editar usuário  
- Ver usuário  
- Autenticação via JWT  
- Perfis de acesso: usuário, pesquisador, administrador

#### Coleta e Análise de Dados
- Informar quantidade de horas de sono  
- Registrar dados diários de sono, atividade física e estresse  
- Calcular IMC  
- Calcular média de sono por semana/mês/período personalizado  
- Avaliar qualidade do sono com base em múltiplos fatores  
- Analisar correlação entre estilo de vida e qualidade do sono  
- Notificar usuário sobre padrões preocupantes

#### Visualização e Relatórios
- Retornar média de sono da população  
- Exibir dicas para sono de qualidade  
- Gerar relatório personalizado de saúde  
- Consultar histórico de sono por período  
- Filtrar usuários por faixa etária, sexo ou ocupação   
- Painel com resumo de saúde e estilo de vida  
- Aba de ajuda para o usuário  

---

### ⚙️ Requisitos Não Funcionais

- Tempo de resposta inferior a 2 segundos para consultas simples  
- Suporte a pelo menos 100 usuários simultâneos  
- Documentação interativa via Swagger  
- Código modular e limpo com boas práticas de Java  
- Banco de dados relacional com integridade referencial (PostgreSQL)  
- Logs de acesso e erros para auditoria  
- Testes automatizados para endpoints críticos

---

### 🔐 Requisitos de Segurança

- Autenticação via token JWT  
- Criptografia de dados sensíveis (ex: pressão arterial, IMC)  
- Controle de acesso por perfil  
- Proteção contra ataques (SQL Injection, XSS)  
- Conformidade com a LGPD (Lei Geral de Proteção de Dados)

---

### 🎨 Requisitos de Usabilidade

- Interface intuitiva para visualização dos dados  
- Feedback claro em caso de erro ou sucesso  
- Sugestões automáticas de melhoria de sono com base nos dados  
- Design responsivo para dispositivos móveis

---

## 🔗 Endpoints RESTful (Exemplos)

| Método | Endpoint                  | Descrição                                      |
|--------|---------------------------|------------------------------------------------|
| POST   | /usuarios                 | Cadastrar novo usuário                         |
| PUT    | /usuarios/{id}            | Editar dados do usuário                        |
| GET    | /usuarios/{id}            | Ver dados do usuário                           |
| POST   | /usuarios/{id}/sono       | Registrar dados de sono                        |
| GET    | /usuarios/{id}/sono       | Ver histórico de sono                          |
| GET    | /usuarios/{id}/relatorio  | Gerar relatório personalizado                  |
| GET    | /dicas-sono               | Listar dicas para melhorar o sono              |
| GET    | /estatisticas/media-sono | Retornar média de sono da população            |
| GET    | /disturbios               | Consultar tipos de distúrbios registrados      |
| GET    | /painel                   | Visualizar painel geral                        |

---


São apenas sugestões abertas a discussão sobre o que é desnecessário e o que poderia ser adicionado.
