#include <stdio.h>
#include <stdlib.h>

void main(){
    int a = 1, b = 10;

    printf("\nOrdem Crescente(1 ao 10):\n");
    while(a <= 10){
        printf("\n%d", a);
        a++;
    }

    printf("\n\nOrdem Decrescente (10 a 1):\n");
    while(b >= 1){
        printf("\n%d", b);
        b--;
    }

    printf("\n\n");
    system("pause");

}

