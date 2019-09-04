* Desafio realizado pela empresa Stefanini

# Regras:

* Implementar um jogo de duelos entre heróis a partir da base de dados e do projeto Java disponibilizado.

* A base de dados é composta por 610 heróis, todos na memória do Java. Está localizada na controller, arquivo chamado * charcters_stats.csv.
* Cada herói possui os seguintes atributos:
* - alinhamento (bom, mal e neutro)
* - inteligência
* - força
* - destreza
* - defesa
* - poder
* - combate

# Quests

* Randomizar dois heróis - 10 pts
* Randomizar uma habilidade para cada herói - 10 pts
* Duelo entre os dois heróis - 10 pts
* Duelos devem ser entre bem e mal ou contra um neutro
* Vence quem tiver mais vitórias no número de habilidades
* O heroi vencedor permanece no duelo
* O herói perdedor é substituído por outro
* No caso de empate a jogada é invalidada e é feito um novo duelo - 10 pts

* Criar uma partida de 10 jogadas - 10 pts
* Decrementar -2 pontos da habilidade do herói perdedor na jogada - 20 pts
* Incrementar +2 pontos da habilidade do herói vencedor na jogada - 20 pts
* Ao completar as jogadas finalizar a partida mostrar o vencedor - 10 pts
* Criar um herói mutante - 100 pts
* Os dois heróis que mais venceram nas 10 partidas serão selecionado
* Dentre os maiores valores de cada habilidade forma um heroi mutante
* O herói mutante só pode ser implementado quando atingir 70 pts