#!/bin/bash
# Indique au système que l'argument qui suit est le programme utilisé pour exécuter ce fichier
# En règle générale, les "#" servent à mettre en commentaire le texte qui suit comme ici
echo Mon premier script
echo Execution de la generation de données :
for ((i=1; i<=$1; i++));
do
octave generation_data.m
javac Main.java > /dev/null
java Main
octave ex1_kmean.m
done
rm *.class
rm *.txt
