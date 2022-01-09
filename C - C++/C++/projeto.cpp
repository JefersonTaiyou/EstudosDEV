#include <iostream>

using namespace std;

int main(int argc, char *argv[])
{
    int idade, opcao;
    cout << "Estudando C++" << endl;
    cout << "Digite sua idade e ENTER: ";
    cin >> idade;
    if (idade < 18) {
        cout << "Voce eh menor de idade" << endl;
    } else {
        cout << "Voce eh maior de idade" << endl;
    }

    while(opcao < 1 || opcao > 4){
    cout << "\n";
    cout << "/////// Menu de Opcoes ///////" << endl;
    cout << "// Opcao 1 = Agua           //" << endl;
    cout << "// Opcao 2 = Cafe           //" << endl;
    cout << "// Opcao 3 = Suco           //" << endl;
    cout << "// Opcao 4 = Refrigerante   //" << endl;
    cout << "//////////////////////////////" << endl;
    cout << "Digite a opcao desejada: ";
    cin >> opcao;
    cout << "\n";

    switch (opcao){
    case 1:
         cout << "Voce escolheu Agua." << endl;
         break;
    case 2:
         cout << "Voce escolheu Cafe." << endl;
         break;
    case 3:
         cout << "Voce escolheu Suco." << endl;
         break;
    case 4:
         cout << "Voce escolheu Refrigerante." << endl;
         break;
    default:
         cout << " ---- Opcao invalida! ---- " << endl;

    }
    }
    /*
    cout << escreve na tela
    cin >> lê o que sera escrito
    endl; pular linha não precisa mais do \n
    */
    return 0;
}
