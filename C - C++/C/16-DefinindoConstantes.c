#include <stdio.h>
#include <stdlib.h>
#define TAM 10 // definindo uma constante que nunca ira mudar no código

void main(){

    printf("%d", TAM);

    int i;
    for(i = 1;i <= TAM;i++){
        printf("\n%d", i);
    }
    system("pause");

}

