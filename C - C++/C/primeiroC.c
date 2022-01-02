#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <locale.h> //necessário para usar setlocale

int main(){
  setlocale(LC_ALL, "Portuguese");

  printf("Este é Meu Primeiro Programa em C!\n");

  char nome[100] = "Jeff";
  int idade = 20;
  double preco = 3.0;
  const double PI = 3.1415;

  printf("Meu nome é %s e eu tenho %d anos!\n",nome,idade);

  printf("Valor de PI: %.2f.\n", PI);
  printf("Raiz: %.0f Potencia: %.0f\n",sqrt(pow(2,2)),pow(2,2)); //? comentario de uma linha
  /*

    TODO: Comentario
    !     de várias
    *     linhas

  */

  //? Entrada de Dados:

  printf("Digite seu Nome: ");
  gets(nome);

  printf("\n%s", nome);
  return 0;
}
