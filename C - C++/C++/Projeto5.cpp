#include <iostream>
#include <string.h>
using namespace std;

class PessoaFisica{
public:
    char nome[100];
    char cpf[20];
    int idade;
};

int getIdade(PessoaFisica pessoas[], const char* nome)
{
	int tam = sizeof(pessoas);

	for(int i = 0; i < tam; i++)
	{
		if(strcmp(nome, pessoas[i].nome) == 0)
			return pessoas[i].idade;
	}
	return -1;
}

int main(int argc, char* argv[]){
    PessoaFisica pessoas[5] = {
    {"Jeferson", "44812130867", 23},
    {"Emilly", "44812130868", 18},
    {"Guilherme", "44812130869", 18},
    };

    cout << "Nome: " << pessoas[0].nome << endl;
    cout << "Nome: " << pessoas[1].nome << endl;
    cout << "Nome: " << pessoas[2].nome << endl;

    int idade = getIdade(pessoas, "Guilherme");
    if(idade != -1){
        cout << "Idade do Guilherme eh " << idade << endl;
    }else{
        cout << "Resultado nao encontrado" << endl;
    }
return 0;
}

