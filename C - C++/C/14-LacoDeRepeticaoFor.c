#include <stdio.h>
#include <stdlib.h>

//Função principal do programa
void main(){

    //Definir Variáveis
    int cont;

        printf("\nTabuada do 5:");
    //Tabuada do 5
    for(cont = 1; cont <= 10; cont++){
        printf("\n 5 X %d = %d",cont, 5 * cont);
    }
        printf("\n\nNumeros pares entre 0 e 10:");
    //Contando de 2 em 2
    for(cont = 0; cont <= 10; cont = cont + 2){
        printf("\n%d",cont);
    }
        printf("\n\nContagem regressiva (10 ao 0):");
    //Contagem regressiva
    for(cont = 10; cont > 0; cont--){
        printf("\n%d", cont);
    }
        printf("\n\n");

    //Pausa o programa após executar
    system("pause");

}

