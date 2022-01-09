#include <iostream>
#include <string.h>
using namespace std;
// struct >> agrupamento de dados/variaveis
typedef struct pessoa {
    char nome[100];
    int idade;
}t_pessoa;
int main(){
    int qtde;
    int i = 0;
    while(qtde < 1 || qtde > 5){
    cout << "Digite quantas pessoas deseja registrar(MAX 5): ";
    cin >> qtde;
    if (qtde > 5){
        cout << endl;
        cout << "So podem ser registradas ATE 5 pessoas." << endl;
        cout << " --- TENTE NOVAMENTE --- \n" << endl;
    } else {
        // Cria um loop do código pela qtde digitada pelo usuario de pessoas que deseja cadastrar
         for(i = 0; i < qtde; i++){
            t_pessoa p;
            char n[100];
            int year;
                cout << endl;
                cout << "//////////////////////////////" << endl;
                cout << "/* Digite seu Nome: ";
                cin >> n;
                cout << "/* Digite sua idade: ";
                cin >> year;
                /* para chamar à struct utiliza o '.'
                vincula os dados digitados para a struct */
                strcpy(p.nome, n);
                p.idade = year;
                cout << "/*" << endl;
                cout << "/* Voce se chama " << p.nome << " e tem " << p.idade << " anos."<< endl;
                cout << "/*" << endl;
         }
    }
    }
    return 0;
}

