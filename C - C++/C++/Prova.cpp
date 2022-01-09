#include <iostream>
#include <locale.h>
#define TAM 10 // DEFINE UMA CONSTANTE QUE NUNCA MUDA

using namespace std;

int main(int argc, char* argv[]){
setlocale(LC_ALL, "Portuguese");//HABILITA ACENTUA«√O PARA O PORTUGUÍS

// DECLARANDO VARIAVEIS
int idPeca[TAM], Qtde[TAM], pecas,x; // X EH UMA VARIAVEL AUXILIAR DO VETOR
double valor[TAM], soma;
// LOOP WHILE - IRA REPETIR O C”DIGO ENQUANTO A QDTE DE PE«AS N√O FOR PREENCHIDA CORRETA
while(pecas < 1 || pecas > TAM){
    cout << "Digite quantos produtos ser„o compradas(AT… 10): ";
    cin >> pecas; // L  A QTDE DE PE«AS
if (pecas < 1 || pecas > TAM){ // ESSE IF VERIFICA SE A QTDE EH VALIDA OU N√O / SE FOR REINICIA O LOOP SEN√O CONTINUA
    cout << endl; // printf
    cout << "VocÍ sÛ pode comprar atÈ 10 produtos" << endl;
    cout << " --- TENTE NOVAMENTE --- \n" << endl;
    } else {
for(x=0;x<pecas;x++){ // ESSE FOR IRA PEGAR OS DADOS E REGISTRA-LOS NAS VARIAVEIS E VETORES
    cout << "\n\tDigite CÛdigo do produto: ";
    cin >> idPeca[x]; // scanf
    cout << "Digite a qtde desejada: ";
    cin >> Qtde[x];
    cout << "Digite valor unit·rio: ";
    cin >> valor[x];
    soma += (Qtde[x]*valor[x]); // NESTA LINHA ELE FAZ O CALCULO DA QTDE DE PRODUTOS PELO VALOR DE TODO O VETOR
}
    cout << "\nProdutos comprados: " << pecas << endl;
    cout << "\nTOTAL ¿ PAGAR " << soma << endl; // AQUI MOSTRA O VALOR DO CALCULO NO LOOP
}}
return 0;
}
