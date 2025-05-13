### Trabalho avaliado com nota: 9.2/10.0

# Gerenciamento de Configuração de Software
**Prof. Daniel Callegari, 2025/1**

# Trabalho 1 – Prática com Git em Times

O trabalho consiste em observar os requisitos do trabalho, implementar uma solução seguindo os conceitos vistos em aula e produzir um relatório final.

O trabalho deverá ser realizado em times compostos por 7 a 9 membros. Cópias ou tentativas de fraude resultarão em nota zero para todos os envolvidos.

**Data de entrega: 02/05/2025**

## Atividades
Cada time deverá:

1. Cada grupo deve criar um único repositório no GitHub. O repositório deve ser público e seu endereço deve ser copiado para o relatório.

2. Definir e descrever claramente o seu processo de branching (fluxo de trabalho), com base em um dos fluxos estudados.

3. Descrever as regras do fluxo de trabalho no relatório e segui-las ao longo da implementação.
    - O professor verificará a participação de cada membro do grupo através do log do git no repositório do time. Cada aluno deverá participar de pelo menos duas features ou correções de bug, com uma contribuição substancial.
    - As submissões ao repositório no GitHub deverão ocorrer via Pull Requests.
    - Os movimentos no repositório deverão acontecer até no máximo a data de entrega. Serão desconsiderados os trabalhos que tiverem movimentos depois da data de entrega.

4. Escrever o software a partir do repositório inicial criado de acordo com os requisitos e com o fluxo de trabalho definido pelo time.

5. Entregar um relatório via Moodle até a data limite. O relatório deverá conter:
    - Folha de rosto com nomes completos dos componentes do time e seus nomes de usuário no GitHub.
    - Link para o repositório público no GitHub.
    - Descrição clara do fluxo de trabalho adotado (pode ser uma variação dos fluxos vistos em aula, adaptado pelo time).
    - Demonstração de que o time seguiu o fluxo definido. Deve conter capturas de tela e descrições que deixem isto claro. (sugere-se capturar o Network graph do GitHub: Insights/Network)
    - Tabela com os nomes dos componentes do grupo e suas contribuições (ex. links para commits ou pull-requests registrados no GitHub).
    - Conclusão do grupo contendo reflexões sobre as dificuldades encontradas, como foram superadas e quais as lições aprendidas. A conclusão deverá conter uma nota de autoavaliação do grupo (0,0 a 10,0)

## Critérios de Avaliação

Avaliação: 30% da nota é resultado da contribuição individual e 70% da nota advém do resultado do grupo.

Cada aluno deverá garantir que seu nome/usuário conste (em bom número de ocorrências) nos commits e linhas de código do histórico do git, confirmando a sua participação no processo de desenvolvimento, seguindo o fluxo de trabalho definido pelo grupo.

**Dica**: utilize o comando abaixo para uma métrica básica por usuário:

```bash
git shortlog -s -n --all --no-merges
```

| Item | Pontos |
|:-----|:------:|
| Descrição clara do fluxo de trabalho adotado pelo grupo -- nomes de branches, regras de uso, comandos utilizados, exemplos, etc. | 3,0 |
| Demonstração de que o grupo seguiu o fluxo de trabalho definido – capturas de tela, descrições, anotações sobre trechos de código, log do git, etc. | 4,0 |
| Qualidade geral do relatório, em atendimento os itens listados no item Atividades. | 2,0 |
| Conclusão com autoavaliação do grupo. | 1,0 |
| **TOTAL** | **10,0** |

## Requisitos Gerais

1. Deseja-se um sistema para gerenciar manutenções de equipamentos em uma empresa.

2. O sistema deverá ser implementado em Java Console /ou/ Web Puro (apenas HTML+CSS+Javascript). Não utilizar frameworks ou outras dependências. A ideia é ter a base de código o mais simples possível. Cuidar para que todos os membros do time conheçam a(s) linguagem(s) escolhida(s).

3. Não implementar um mecanismo de persistência de dados. O sistema deverá manter dados apenas em memória durante a execução.

4. Não implementar um mecanismo de login.

5. O sistema deverá iniciar com dados já preenchidos (em bom número e de boa qualidade), de forma a facilitar os testes.

## Detalhamento

A empresa possui muitos funcionários e registra para cada um o número de matrícula (iniciando em 101), o nome completo e o seu email. A empresa deseja manter um registro de todos os seus equipamentos e suas respectivas manutenções. Cada equipamento tem um identificador único, um nome curto, uma descrição, a data de aquisição, o valor de aquisição e o funcionário responsável pela compra. Os equipamentos também são classificados como equipamentos fixos (como servidores, impressoras e projetores) ou como equipamentos móveis (como notebooks, celulares, tablets etc.).

Eventualmente algum equipamento precisa de manutenção, e é necessário manter um registro de todas as manutenções realizadas. Cada registro de manutenção deve indicar a qual equipamento se refere, a data do pedido de manutenção, uma descrição do problema, o funcionário responsável, a data da efetiva entrada em manutenção, a data do retorno da manutenção, um texto descrevendo a solução. Deve também estar em um destes possíveis estados (manutenção solicitada, manutenção em andamento, manutenção concluída com sucesso ou manutenção cancelada).

## Funcionalidades desejadas

1. O sistema deverá permitir ao usuário cadastrar novos funcionários. Também deverá ser possível editar o nome de um funcionário e seu email. Não deverá ser possível excluir funcionários.

2. O sistema deverá permitir ao usuário cadastrar novos equipamentos. Edições em equipamentos somente deverão ser permitidas no campo de descrição. Não deverá ser possível excluir equipamentos, porém deverá ser possível indicar que um equipamento não está mais disponível (seja por dano, perda, venda ou qualquer outro motivo).

3. O sistema deverá permitir ao usuário localizar funcionários ou equipamentos por qualquer um de seus campos (inclusive parcialmente, ex. “mari” poderia encontrar “Maria”, “Mario” etc).
    - Ao localizar um funcionário, listar também os equipamentos sob sua responsabilidade.
    - Ao localizar um equipamento, listar também a sua manutenção mais recente (se existir).

4. O sistema deverá permitir ao usuário registrar um novo pedido de manutenção. A data do pedido deverá vir preenchida automaticamente.

5. O sistema deverá permitir ao usuário atualizar um pedido de manutenção, mudando de estado. Não deverá ser possível “retroceder” estados de um pedido de manutenção (ex. ir de “em andamento” para “solicitada”).

6. O sistema deverá permitir ao usuário gerar um relatório contendo em cada linha:
    - O nome curto do equipamento
    - O nome do funcionário responsável
    - A quantidade de manutenções que já sofreu (concluídas com sucesso)
    - Se houver uma manutenção em andamento indicar isso também.

7. Duas funcionalidades a mais, à escolha do grupo.

---

**Bom trabalho!**
