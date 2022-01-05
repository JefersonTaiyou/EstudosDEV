#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main(){
  int idade=25;
  int *pIdade;
  pIdade = &idade;

  printf("Idade: %d, Memoria: %d", idade, pIdade);

  Incrementar(&idade);
  printf("\nIdade Incrementada: %d, Memoria: %d", idade, pIdade);
  return 0;
}

void Incrementar(int *p){
  *p += 1;
}