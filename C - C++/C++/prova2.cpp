#include <iostream>

using namespace std;

int main(int argc, char* argv[]){

    double a,b,c,delta,x1,x2;

cout << "Digite valor de A: ";
cin >> a;
cout << "Digite valor de B: ";
cin >> b;
cout << "Digite valor de C: ";
cin >> c;

if(a==0){
    cout << "Impossivel calcular";
}else{
    delta=((b*b)-4*a*c);
    if(delta<0){
    cout << "Impossivel calcular";
    }else{

        x1 = (((-b)+delta)/2*a);
        x2 = (((-b)-delta)/2*a);

    cout << "O Valor de X1: " << x1 << endl;
    cout << "O Valor de X2: " << x2 << endl;

    }

}

return 0;
}
