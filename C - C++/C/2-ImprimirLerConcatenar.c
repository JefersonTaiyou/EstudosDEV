#include <stdio.h>
#include <stdlib.h>

void main(){

    int a = 5, b;
    char c = 'b';

    // %d é inteiro / %c caracter

    printf("Definindo variavel:");

    printf("\nO valor da variavel a: %d %c", a, c);

    a = 15;

    printf("\nO valor da modificada: %d ", a);

    printf("\n\nDigite um valor qualquer:");

    scanf("%d", &b);

    printf("\nO valor digitado foi: %d", b);

    printf("\n\nA soma dos valores seria: %d", a+b);

    printf("\n");

    system("pause");



}
