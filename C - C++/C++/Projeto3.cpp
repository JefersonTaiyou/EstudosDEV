#include<iostream>
using namespace std;

int main(int argc, char *argv[]){

    int array[] = {1,2,3,4,5};
    int* parray = &array[0];
    cout << *(parray+1) << endl;

return 0;
}
