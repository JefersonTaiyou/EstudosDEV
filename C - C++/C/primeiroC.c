#include <stdio.h>
#include <stdlib.h>

int main(){
  setlocale(LC_ALL, "Portuguese");
  printf("Meu Primeiro Programa em C!\n");
  char string[100];
  printf ("Digite uma string: ");
  gets (string);
  printf ("\n\nVoce digitou %s",string);
  return 0;
}
