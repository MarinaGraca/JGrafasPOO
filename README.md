# JGrafasPOO
### POO Project - Object-Oriented Programming
### 2º Year, 2º Semester | 2018-2019

Usage:
1. click on the button of the graph you want (*histograma* - histogram, *dispersao* - scatter plot, *linhas* - line)
2. on the *ficheiro* field, write the name of the csv file you want, eg. **POO-Notas.csv**
3. on the *escala* file, write the desired graph scale, eg. **1**

Graphs:
* histogram to see the **POO-Notas.csv**
* scatter plot to see **PCD-Assid.csv**
* line graph to see **POO-Aprov.csv**

Color Scheme (*esquemaCores*):
* default - black&white
* red&green - red for negative marks and green for positive ones (>=50%)
* yellow - tuples x >= 50 && y < 50

Filters:
* *negativasPOO* - remove negative marks from the graph (histogram, line graph)
* *assiduidadePCD* - remove x < 20 tuples from the graph (scatter plot)
* *notaFinalPCD* - remove y < 50 tuples from the graph (scatter plot)
