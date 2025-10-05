# COMPARANDOLISTA
Comparando Implementações de Listas em Java
Integrantes

Renata Fiuza


Descrição da atividade

Este trabalho tem como objetivo comparar o desempenho de três implementações diferentes de listas em Java: ArrayList, LinkedList e Vector.
Foram cadastrados 350.000 alunos em cada estrutura. Cada aluno possui nome, matrícula (gerada aleatoriamente) e data de nascimento.

Após o cadastro, as listas são ordenadas pelo nome e exportadas para arquivos CSV, medindo o tempo total das seguintes etapas:

Cadastro dos alunos

Ordenação por nome

Exportação para arquivo CSV

Os arquivos gerados são:

alunos_arraylist.csv

alunos_linkedlist.csv

alunos_vector.csv

Como executar o programa

Abra o terminal na pasta onde está o arquivo ComparandoListas.java.

Compile o código:

javac ComparandoListas.java


Execute o programa:

java ComparandoListas


Ao final da execução, será exibida uma tabela com o tempo gasto (em milissegundos) em cada operação para as três estruturas.




Resultados obtidos (exemplo de tabela)
Operação	ArrayList (ms)	LinkedList (ms)	Vector (ms)


| Operação   | ArrayList (ms) | LinkedList (ms) | Vector (ms) |
| ---------- | -------------- | --------------- | ----------- |
| Cadastro   | xxxx           | xxxx            | xxxx        |
| Ordenação  | xxxx           | xxxx            | xxxx        |
| Exportação | xxxx           | xxxx            | xxxx        |

Cadastro	xxxx	xxxx	xxxx
Ordenação	xxxx	xxxx	xxxx
Exportação	xxxx	xxxx	xxxx
