#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <locale.h>
#include <stdbool.h>

#define PI = 3.14;

struct Pessoas //? funciona como um Object/Class
{
  char nome[50]; //? atributos do Object/Class
  int idade;
  char cpf[14];
};


float somar(float a, float b){
  return a+b;
}
float subt(float a, float b){
  return a-b;
}
float mult(float a, float b){
  return a*b;
}
float divi(float a, float b){
  return a/b;
}

int main(){
  setlocale(LC_ALL, "");

  float val1, val2;
  char opc;
  bool a;

    printf("Digite a Operacao desejada:\n");
    scanf("%c", &opc);

      if(opc=='+'){
        printf("\nEntre com os valores: ");
        scanf("%f %f", &val1, &val2);
        printf("\n%.2f\n", somar(val1, val2));
      } else if(opc=='-'){
        printf("\nEntre com os valores: ");
        scanf("%f %f", &val1, &val2);
        printf("\n%.2f\n", subt(val1, val2));
      } else if(opc=='*'){
        printf("\nEntre com os valores: ");
        scanf("%f %f", &val1, &val2);
        printf("\n%.2f\n", mult(val1, val2));
      } else if(opc=='/'){
        printf("\nEntre com os valores: ");
        scanf("%f %f", &val1, &val2);
        printf("\n%.2f\n", divi(val1, val2));
      }

  struct Pessoas pessoa;
  strcpy(pessoa.nome, "Jeferson Sabino");
  pessoa.idade = 25;
  strcpy(pessoa.cpf, "448.121.308-67");

  printf("0xx%p\n", pessoa.nome);
  printf("0xx%p\n", pessoa.idade);
  printf("0xx%p\n", pessoa.cpf);
  
  return 0;

}

