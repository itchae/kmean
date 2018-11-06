## Author: Tom <tom@tom-HP-ProBook-450-G0>
## Created: 2018-11-06

function ex1_kmean
    load results.txt -ascii;
    x= results([1;2], :);
    load oracle.txt -ascii;
    clas2=results(3,:);
    clas2=clas2+ones(1,256);
    nb=erreur_classif(oracle,clas2);
    printf("Nombre d'erreur : %d \n",nb);
endfunction
               