#!/bin/bash
# Indique au système que l'argument qui suit est le programme utilisé pour exécuter ce fichier
# En règle générale, les "#" servent à mettre en commentaire le texte qui suit comme ici
echo Mon premier script
javac Main.java -Xlint:unchecked
java Main
octave ex2_kmean.m
rm *.class
