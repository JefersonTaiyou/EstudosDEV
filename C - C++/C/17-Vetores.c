#include <stdio.h>
#include <stdlib.h>
#define TAM 3
void main(){

    int vetor[TAM],cont;
    vetor[0] = 5;
    vetor[1] = 10;
    vetor[2] = 15;

    for(cont = 0; cont < TAM; cont++){
        vetor[cont] =  vetor[cont] + 1;
    }
    printf("\nPosicao 0: %d", vetor[0] );
    printf("\nPosicao 1: %d", vetor[1] );
    printf("\nPosicao 2: %d", vetor[2] );

    for(cont = 0; cont < TAM; cont++){
        printf("\nPosicao %d : %d", cont, vetor[cont] );
    }

    for(cont = 0; cont < TAM; cont++){
        scanf("%d", &vetor[cont]);
    }

    for(cont = 0; cont < TAM; cont++){
        printf("\nPosicao %d : %d", cont, vetor[cont] );
    }
    system("pause");
}

