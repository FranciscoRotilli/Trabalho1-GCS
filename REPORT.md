
# Gerenciamento de Configuração de Software
**Prof. Daniel Callegari, 2025/1**

# Reporte - Trabalho 1 – Prática com Git em Times

## Membros:
1. Emile Vargas ([GitHub](https://github.com/emivargxs))
1. Felipe Flores ([GitHub](https://github.com/FelipeSF97))
1. Francisco Rotilli ([GitHub](https://github.com/FranciscoRotilli))
1. Guilherme Kindel ([GitHub](https://github.com/Kindelgui))
1. Julian Silveira ([GitHub](https://github.com/jfrvs))
1. Leonardo Silva ([GitHub](https://github.com/LeonardollSilva))
1. Arthur Ramos ([GitHub](https://github.com/kasprzak-k))
1. Diego Schaeffer ([GitHub](https://github.com/szchaeffer))
1. Arthur B. Schultz - +55 51 93668070 ([GitHub](https://github.com/arturbschultz))

## Repositório

[Trabalho 1 - Grupo 1](https://github.com/FranciscoRotilli/Trabalho1-GCS)

## Processo de *branching* utilizado

O processo de branching utilizado foi uma variação do GitFlow, utilizando branches para o desenvolvimento de features e realizando merges frequentes para a branch develop, que, ao final do projeto, seria incorporada a main.

## Descrição do fluxo de trabalho

De início, cada membro realiza um clone do repositório em sua máquina usando `git clone https://github.com/FranciscoRotilli/Trabalho1-GCS`.

Quando for trabalhar em alguma feature ou bugfix, atualiza seu repositório local com `git checkout develop` e `git pull`.

Para começar a desenvolver, faz uma nova branch com `git branch nomeDaFeature` e `git checkout nomeDaFeature`.

Ao finalizar, realiza um push para o Github com `git push -u origin nomeDaFeature` e realiza Pull Request pela interface web do Github, selecionando o destino como `develop`.

Recebido o Pull Request, o responsável (Francisco) realiza um breve code review, deixando comentários para correção posterior, quando necessário.
Quando acontecem conflitos, são discutidos com o grupo quando necessário.

Ao final do projeto, realizamos Pull Request e merge ao `main`.

## Funcionalidades escolhidas

Escolhemos 3 funcionalidades extra para implementar.

1. Função para consultar disponibilidade do equipamento (Opção 5).
1. Função para gerar relatório completo das manutenções de um equipamento (Opção 11)
1. Função para acompanhar manutenções pendentes e atrasadas (Opção 12)


## Relação de Membros e Contribuições

| Membro | Links |
|:-----|:------:|
| Emile Vargas | [](), []() |
| Felipe Flores | [](), []() |
| Francisco Rotilli | []()https://github.com/FranciscoRotilli/Trabalho1-GCS/pulls?q=is%3Apr+is%3Aclosed+author%3AFranciscoRotilli []() |
| Guilherme Kindel | [](), []() |
| Julian Silveira | [](), []() |
| Leonardo Silva | [](), []() |
| Diego Schaeffer | []() https://github.com/FranciscoRotilli/Trabalho1-GCS/pull/30 , https://github.com/FranciscoRotilli/Trabalho1-GCS/pull/12 []() |
| Arthur Ramos Kasprzak | []()https://github.com/FranciscoRotilli/Trabalho1-GCS/pull/11 https://github.com/FranciscoRotilli/Trabalho1-GCS/pull/26 []() |
| (?) | [](), []() |

## Conclusão e Autoavaliação

Durante o trabalho, o grupo teve a experiência de construir um código de maneira colaborativa, principalmente as dificuldades que surgem nesse processo. Apesar das tecnologias sofisticadas de versionamento, existem diversas formas de se trabalhar em equipe no contexto de engenharia de software, e nenhuma é perfeita. Com experiência, é possível identificar quais práticas são mais apropriadas de acordo com a complexidade do projeto, número de integrantes na equipe entre outros fatores.

Apesar do grande número de branches utilizadas, o processo escolhido manteve a main/develop estável, permitindo que o projeto evoluísse de maneira ordenada. Por outro lado, o grande número de branches sobrecarrega o responsável por merge, o que pode ser um problema caso surgam imprevistos.

Além das ferramentas, o principal aspecto para um bom trabalho em equipe é uma comunicação clara e assertiva. Somente assim podem equipes render em alto nível.

| Membro | Avaliação |
|:-----|:------:|
| Emile Vargas |  |
| Felipe Flores |  |
| Francisco Rotilli |  |
| Guilherme Kindel |  |
| Julian Silveira | 8.0/10.0 |
| Leonardo Silva |  |
| Diego Schaeffer | 9.0/10.0 |
| (?) |  |
| (?) |  |
