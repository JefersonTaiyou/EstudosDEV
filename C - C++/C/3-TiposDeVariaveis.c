#include <stdlib.h>

#include <stdio.h>

#include<stdbool.h>


void main(){

    //Definindo Variáveis

    int a;

    float b; // Ocupa duas vezes mais memoria que o inteiro

    char c;

    bool d;


    //Passando Valores

    a = 5;

    b = 2.3;

    c = 'a';

    d = true;


    //Escrevendo na Tela

    printf("\n O valor de a: %d.",a);

    printf("\n O valor de b: %.2f.",b);

    printf("\n O valor de c: %c.",c);

    printf("\n O valor de d: %d.\n",d);


    //Lendo Valores

    printf("\n\nDigite um novo valor para A: ");

    scanf("%d", &a);

    printf("\n\nDigite um novo valor para B: ");

    scanf("%f", &b);

    printf("\n\nDigite um novo valor para C: ");

    scanf(" %c", &c); //Aqui adicionei um espaço antes do %C para limpar o buffer

    printf("\n\nDigite um novo valor para D: ");

    scanf("%d", &d);


    printf("\n O valor de a: %d.",a);

    printf("\n O valor de b: %.2f.",b);

    printf("\n O valor de c: %c.",c);

    printf("\n O valor de d: %d.",d);

}
