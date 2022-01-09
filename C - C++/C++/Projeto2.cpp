#include <iostream>
using namespace std;

// cria uma funcao
bool par(int num){
    if (num % 2 == 0){
        return true;
    }else{
    return false;
    }
}

int main

int main(int argc, char *argv[]){

    int n;

    cout << "Digite um numero: ";
    cin >> n;
        if (par(n)){
            cout << "Numero " << n << " eh Par" << endl;
        } else {
            cout << "Numero " << n << " eh Impar" << endl;
        }
        return 0;
}
