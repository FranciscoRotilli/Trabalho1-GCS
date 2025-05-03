
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
| Emile Vargas | []()https://github.com/FranciscoRotilli/Trabalho1-GCS/issues?q=is%3Apr+author%3Aemivargxs []() |
| Felipe Flores | []()https://github.com/FranciscoRotilli/Trabalho1-GCS/issues?q=state%3Aclosed%20is%3Apr%20author%3A%40me []() |
| Francisco Rotilli | []()https://github.com/FranciscoRotilli/Trabalho1-GCS/pulls?q=is%3Apr+is%3Aclosed+author%3AFranciscoRotilli []() |
| Guilherme Kindel | []()https://github.com/FranciscoRotilli/Trabalho1-GCS/pulls?q=is%3Apr+is%3Aclosed+author%3AKindelgui []() |
| Julian Silveira | []()https://github.com/FranciscoRotilli/Trabalho1-GCS/pulls?q=is%3Apr+is%3Aclosed+author%3Ajfrvs []() |
| Leonardo Silva | []()https://github.com/FranciscoRotilli/Trabalho1-GCS/pulls?q=is%3Apr+author%3ALeonardollSilva+is%3Aclosed []() |
| Diego Schaeffer | []() https://github.com/FranciscoRotilli/Trabalho1-GCS/pull/30 , https://github.com/FranciscoRotilli/Trabalho1-GCS/pull/12 []() |
| Arthur Ramos Kasprzak | []()https://github.com/FranciscoRotilli/Trabalho1-GCS/pull/11 https://github.com/FranciscoRotilli/Trabalho1-GCS/pull/26 []() |
| Arthur Schultz | []()https://github.com/FranciscoRotilli/Trabalho1-GCS/pulls?q=is%3Apr+is%3Aclosed+author%3Aarturbschultz []() |

## Conclusão e Autoavaliação

Ao longo do trabalho, o grupo vivenciou na prática os desafios e aprendizados envolvidos na construção colaborativa de um projeto de software. Trabalhar em equipe, mesmo com o apoio de ferramentas avançadas de versionamento como o Git, exige organização, alinhamento constante e flexibilidade para lidar com imprevistos.

Julgamos ter realizado um bom trabalho, apesar das dificuldades enfrentadas, principalmente relacionadas à padronização do código e ao entendimento inicial sobre como as funcionalidades deveriam ser implementadas. Também encontramos dificuldades com o uso do GitHub, principalmente no processo de Pull Request e Merge. Ainda assim, conseguimos manter os ramos main e develop estáveis, o que permitiu que o projeto evoluísse de maneira estruturada.

Reconhecemos, porém, que a comunicação e o planejamento — especialmente na divisão de tarefas — foram pontos que poderiam ter sido melhor conduzidos. Esses aspectos terão atenção redobrada em projetos futuros, pois ficou claro para o grupo que o sucesso do trabalho coletivo depende tanto da técnica quanto da clareza na colaboração.


| Membro | Avaliação |
|:-----|:------:|
| Emile Vargas | 9.0/10.0 |
| Felipe Flores | 9.0/10.0 |
| Francisco Rotilli | 9.8/10.0 |
| Guilherme Kindel | 8.0/10.0 |
| Julian Silveira | - |
| Leonardo Silva | 8.5/10.0 |
| Diego Schaeffer | 9.0/10.0 |
| Arthur Ramos | 9.0/10.0 |
| Arthur Schultz | 8.5/10.0 |
