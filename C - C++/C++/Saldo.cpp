#include <iostream>
#include <string.h>
#define MAX 10

using namespace std;

class Conta {
public:
	int numero;
	double saldo;
	double depositar(double qtde) {
		if (qtde > 0)
		{
			saldo += qtde;
			return saldo;
		}
	}

	double retirar(double qtde) {
		if (saldo >= qtde)
		{
			saldo -= qtde;
			return saldo;
		}
	}
};

int main(int argc, char* argv[]) {
	Conta c;
	c.numero = 1;
	c.saldo = 100;

	cout << "Saldo: " << c.saldo << endl;
	c.depositar(100);
	cout << "Saldo depois do deposito: " << c.saldo << endl;
	c.retirar(50);
	cout << "Saldo depois do saque: " << c.saldo << endl;


	return 0;
}
