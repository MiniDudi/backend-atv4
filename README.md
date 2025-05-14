# Integrantes

#### Eduardo Henrique Natividade Pinese - 235182
#### João Vitor Amaral Franzoni - 236279

# Diagrama de Classes

![Imagem do WhatsApp de 2025-05-13 à(s) 20 19 10_b00cd17f](https://github.com/user-attachments/assets/86abbb71-8ba1-4161-817d-9929cf285149)

# Sistema de Gerenciamento Veterinário

## Requisitos Funcionais

### Cadastro de Animais

- Sistema deve permitir cadastro de animais com:
  - Nome do animal
  - Espécie (canino, felino, aviar, outro)
  - Raça
  - Data de nascimento


-  Sistema deve vincular cada animal a um tutor responsável com:
  - Nome completo
  - CPF (único)
  - Telefone
  - Endereço completo



### Agendamento de Consultas

- Sistema deve permitir agendamento de consultas com:
  - Verificação de disponibilidade do veterinário
  - Seleção de data e hora
  - Validação de especialização do veterinário para a espécie do animal


-  Sistema deve impedir agendamento de consultas simultâneas para o mesmo veterinário

### Prontuário e Vacinação

-  Sistema deve permitir que veterinários:
  - Registrem atendimentos
  - Incluam observações
  - Registrem vacinas aplicadas


- Sistema deve manter histórico completo de:
  - Consultas realizadas
  - Vacinas aplicadas
  - Observações médicas



## Requisitos Não Funcionais

### Segurança e Acesso

-  Apenas tutores autorizados podem acessar informações dos seus animais
-  Veterinários só podem atender animais de espécies para as quais estão qualificados
-  Sistema deve garantir integridade dos dados médicos

### Performance e Escalabilidade

-  Sistema deve suportar múltiplos agendamentos simultâneos
-  Sistema deve manter desempenho com grande volume de dados históricos
-  Sistema deve permitir expansão para novas funcionalidades

## Restrições Técnicas

-  Sistema deve ser desenvolvido em Java com Spring Boot
-  Sistema deve utilizar banco de dados relacional
-  Sistema deve seguir padrões de segurança de dados em saúde
-  Sistema deve ser preparado para integração com outros sistemas

## Casos de Uso

### Tutor

-  Cadastrar animal
-  Agendar consulta
-  Visualizar histórico de vacinação
-  Acessar prontuário do animal

### Veterinário

-  Realizar consultas
-  Registrar atendimentos
-  Aplicar e registrar vacinas
-  Emitir prontuário

### Administrador

-  Gerenciar cadastro de veterinários
-  Gerenciar especialidades permitidas
-  Configurar horários de atendimento
