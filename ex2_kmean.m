function ex2_kmean
    load results_ex2.txt -ascii;
    x= results_ex2([1;2], :);
    load oracle.txt -ascii;
    clas2=results_ex2(3,:);
    clas2=clas2+ones(1,255);
    affiche_classe(x,clas2);
endfunction