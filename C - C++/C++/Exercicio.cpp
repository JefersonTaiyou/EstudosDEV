#include <iostream>
#include <locale.h>
#define TAM 5
using namespace std;
int main(int argc, char* argv[]){
setlocale(LC_ALL, "");
int vet[TAM], x, valores;
        cout << "\n**** SISTEMA QUE COLOCA NÚMEROS EM ORDEM OPOSTA AO DIGITADO ****\n\n";
while (valores<0 || valores > TAM){
        cout << "\nQuantos valores deseja informar(MÁX 5)? ";
        cin >> valores;
if (valores<0 || valores > TAM){
    cout << "Valor invalido";
} else{
    for (x=0;x<valores;x++){
        cout << "Digite o valor desejado: ";
        cin >> vet[x];

        }
        cout << "\nORDEM INVERSA: " << endl;
    for (x=(valores-1);x>=0;x--){
        cout << vet[x] << endl;
        }
    }
}
return 0;
}
