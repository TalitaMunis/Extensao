## 📋 Requisitos do Sistema

### ✅ Requisitos Funcionais

#### Gerenciamento de Usuário
- Cadastrar usuário  
- Editar usuário  
- Ver usuário  
- Perfis de acesso: usuário

#### Fluxo processual
- Usuário se cadastra na plataforma
- Usuário loga na plataforma
- Usuário é direcionado para preencher os dados de cadastro
- Usuário visualiza área para preencher as informações diárias dado o caso de já não forem preenchidas no dia atual
- Usuário visualiza gráficos e seus dados ao longo dos dias que estão registrados no banco de dados
- (Extra) Usuário recebe dados informátivos a respeito de sua saúde do sono em comparação com a contida no banco de dados


#### Coleta de Dados do Usuário
- Informar nome;
- Informar e-mail
- idade
- sexo
- cargo/Trabalho
- Categoria de IMC

#### Coleta de Dados por inserção diária
- Duração (em horas) da noite de sono
- Nível de atividade física média 
- Nível de estresse
- Pressão arterial (última verificação)
- Batimento cardíaco média
- Passos diários
- Possui ou não disturbio de sono

---

### ⚙️ Requisitos Não Funcionais
 
- Código modular e limpo com boas práticas de Java  
- Banco de dados relacional com integridade referencial (PostgreSQL)  

---

### 🎨 Requisitos de Usabilidade

- Interface intuitiva para visualização dos dados

---

## 🔗 Endpoints RESTful 

| Método | Endpoint                  | Descrição                                      |
|--------|---------------------------|------------------------------------------------|
| POST   | /usuarios                 | Cadastrar novo usuário                         |
| PUT    | /usuarios/{id}            | Editar dados do usuário                        |
| GET    | /usuarios/{id}            | Ver dados do usuário                           |
| POST   | /usuarios/{id}/sonoDiario       | Registrar dados de sono                        |
| GET    | /usuarios/{id}/sonoDiario       | Ver histórico de sonogeral                        |

---

#### 💡 Recursos extras

- Página do administrador
- Calculadora de IMC
- Avaliar qualidade do sono com base em multiplos fatores
- Analisar correlação entre estilo de vida e qualidade de sono
- Notificar usuário sobre padrões preocupantes