let nome, sobrenome;
let nomeComposto = nome + sobrenome;
const pi = 3.1415;

// Comentarios

/* 
 * Documentação
 * 
 *  Tab => espaço pra frente
 *  Shift Tab => espaço pra tras
 * 
 *  typeof => verifica o tipo de dado da variavel
 * 
 *  Estrutura de Dados: é o que organiza e da estrutura aos dados do sistema/ 
 *                                          administra e da regras para os dados se comportarem
 *  => FIFO: Primeiro a Entrar/Primeiro a Sair(Fila) 
 *  => LIFO: Ultimo a Entrar/Primeiro a Sair(Pilha) 
 * 
 */
let count = 0;
let valores = [undefined];
let errado = false;
let qtdeTotal = 0;

function texto(error = false) {
    document.getElementById("count-enter-fifo").innerText = count;
    document.getElementById("count-all-fifo").innerText = qtdeTotal;
    if (valores[0] == undefined && valores.length == 1) {
        document.getElementById("count-fifo").innerText = "0";
    } else {
        document.getElementById("count-fifo").innerText = valores.length;
    }

    if (error != true) {
        msg("normal");
    } else {
        msg("erro");
    }
}

function msg(arg = "normal") {
    if (arg == "erro") {
        document.getElementById("count-enter-fifo").setAttribute('class', 'animation');
        document.getElementById("count-enter-fifo").style.color = "#ff0000";
    } else if (arg == "normal") {
        document.getElementById("count-enter-fifo").setAttribute('class', 'no-animation');
        document.getElementById("count-enter-fifo").style.color = "#000000";
    }
}

function filaAction(arg = 0) {
    if (arg == 1) {
        count += 1;
        errado = false;
        texto(errado);
    } else if (arg == 0) {
        if (count > 0) {
            count -= 1;
        }
        texto(errado);
    }
}

function removeList() {
    console.log(valores);
    //let filaEl = document.getElementById("fila-el");
    delete valores[0];
    if (valores[0] == undefined && valores.length == 1) {
        for (let i = 0; i < valores.length; i++) {
            valores[i] = valores[i + 1];
            delete valores[i + 1];
        }
    }
    if (valores[0] == undefined && valores[1] != undefined || valores[1] != null) {
        for (let i = 0; i < valores.length; i++) {
            valores[i] = valores[i + 1];
            delete valores[i + 1];
        }
        valores.pop();
        //filaEl.innerText = "Fila Atual: " + valores;
    } else if (valores[0] == null && valores.length == 1) {
        //filaEl.innerText = "Fila Atual: ";
    }
    console.log(valores);
    texto(errado);
}

function save() {
    let pos = valores.includes(count);
    //let filaEl = document.getElementById("fila-el");
    if (valores[0] == undefined || valores[0] == null) {
        for (let i = 1; i <= count; i++) {
            valores.push(i);
            console.log(valores);
        }
        valores.shift();
    } else {
        let ultimo = valores.slice(-1)[0] + 1;
        let complemento = (ultimo - 1) + count;
        for (let i = ultimo; i <= complemento; i++) {
            valores.push(i);
            console.log(valores);
        }
    }
    qtdeTotal += count;
    //filaEl.innerText = "Fila Atual: " + valores;
    errado = false;
    texto(errado);
    /*
            if (pos != true && count != 0) {
                if (valores[0] == undefined && valores.length == 1) {
                    valores[0] = count;
                } else {
                    valores.push(count);
                }
                filaEl.innerText = "Fila Atual: " + valores;
                count = 0;
                errado = false;
                texto(errado);
            } else {
                errado = true;
                texto(errado);
            }
    */
}

/*
let myAge = 1
let humanDogRatio = 7
myDogAge = myAge*humanDogRatio
console.log("My Age: " + myAge + "\nMy Dog Age: " + myDogAge)
console.clear()
*/

if (nome != undefined) {
    console.log(nome);
    console.log(sobrenome);
    console.log(nomeComposto);
} else {
    console.log("Sem Dados");
}

console.log(nomeComposto || "Sem Dados");

let nam = `oieeee`;
//console.log(Number.isInteger(pi));
console.log(typeof(nam));
console.log(nam.charAt(0));
console.log(nam.charCodeAt(1));
console.log(nam.indexOf('e'));
console.log(nam.substring(2));

const template = `Meu nome é ${nome}`;
const up = texto => texto.toUpperCase();; //função em template

console.log(`Função: ${up(template)}`);

const lista = [];

if (lista[0] == undefined) {
    lista[0] = "Primeiro Valor";
    lista.push("Segundo Valor", "terceiro", "quarto", "quinto");
}

console.log(lista[0], lista, lista.length);
lista.pop();
console.log(lista);
console.log(lista);
console.log(lista[0]);
//lista.shift();

//trabalhando com estrutura de dados:
/*
 * lista.pop() => remove o ultimo item adicionado na lista
 * util para trabalhar com conceito de LIFO/PILHA
 * delete lista[0] => remove o primeiro item da lista
 * deixa o primeiro item vazio - util para conceito de FIFO/FILA
 *
 */

//FIFO
delete lista[0];
if (lista[0] == undefined && lista[1] != undefined) {
    console.log(lista[0], lista[1]);
    for (var i = 0; i < lista.length; i++) {
        lista[i] = lista[i + 1];
        delete lista[i + 1];
    }
    lista.pop();
}

console.log(lista);

function objProduto(nome, preco) {
    this.nome = nome;
    this.preco = preco;
}

const produto = new objProduto( // => objeto
    'Arroz', 5.90
);

const produto2 = new objProduto( // => objeto
    'Feijão', 3.70
);
const produto3 = new objProduto( // => objeto
    'Batata', 2.90
);

const {
    nome: n = "Padrão",
    preco: p = 0.0
} = produto3; //destructuring object

console.log(n, p);
const ref = produto2;
let val = 3;
let valRef = val;

console.log(produto2);
console.log(ref);
console.log(val);
console.log(valRef);

ref.nome = 'Batata';
valRef = 5;

console.log(produto2);
console.log(ref);
console.log(val);
console.log(valRef);

{
    function soma(a = 0, b = 0) {
        console.log(a + b);
    }
    soma();
    soma(2, 2);

    function somar(a = 0, b = 0) {
        return a + b;
    }
    console.log(somar());

    const imprimirSoma = (a = 0, b = 0) => console.log(a + b)
    imprimirSoma(5, 8);
}

const [a, , b, c, , e = 10] = [1, 2, 3, 4, 5, 6] // destructuring array
console.log(a, b, c, e)

function rand({ min = 0, max = 1000 }) {
    const valor = Math.random() * (max - min) + min;
    return Math.floor(valor);
} // destructuring function object

console.log(rand({ min: 500, max: 800 }));

function randomico([min = 0, max = 1000]) {
    if (min > max)[min, max] = [max, min]
    const valor = Math.random() * (max - min) + min;
    return Math.floor(valor);
} // destructuring function array

console.log(randomico([50, 40]));

const result = nota => {
        return nota >= 7 ? 'Aprovado' : 'Reprovado';
    } //arrow functions

console.log(result(7));
console.log(result(9));

const obj = { nome: 'Jeff' }

function tratarErro(erro) {
    throw 'error';
}

function mostrar(obj) {
    try {
        console.log(obj.nome.toUpperCase() + '!!!')
    } catch (e) {
        tratarErro(e);
    } finally {
        console.log("Fim do Try/Catch"); //pode gerar um hash para devolver ao user
    }

}

mostrar(obj);

//funções
/*
 * //TODO: 1-Literal/ 2-Em variavel/ 3-Em Array/
 * //TODO: 4-Em objeto/ 5-Como Parametro/ 6-fun que retorna outra fun
 * 
 * //? 1-function fun1(){}
 * 
 * //? 2-const fun2 = function (){}
 * 
 * //? 3-const array = [function (a,b) {return a+b}]
 *
 * //? 4-const obj ={}
 * obj.falar = function (){return 'ola'}
 * console.log(obj.falar())
 * 
 * //? 5-function run(fun){
 *       fun()
 * }
 * run(function(){console.log('executando...')})
 * 
 * //? 6-function soma(a,b){
 *      return function(c){
 *          console.log(a+b+c)
 *      }
 * }
 * 
 * soma(2,3)(4)
 * 
 */


/*
 *  //todo: definição de valores padrão para funções
 *
 * function soma(a,b,c){
 *      a = a || 1
 *      b = b || 1
 *      c = c || 1
 *      return a + b + c
 * }
 *  
 * function soma(a=1,b=1,c=1){
 *      return a+b+c
 * }
 * 
 */


/*
 * //TODO: Atribuição por valor X Atribuição por referência
 * //! e.g:
 * //? const produto recebe a referência de um endereço de memória do objeto
 * //? const ref não recebe o valor do objeto e sim o mesmo endereço de memória
 * //? ou seja, se o objeto que está na memória mudar seu valor, tanto a const produto
 * //? quanto a const ref irão ter a mesma alteração que houve no objeto, já que ambas
 * //? referenciam o endereço de memória
 * 
 * //? já a const val recebe um valor em especifico/primitivo e não uma
 * //? referencia de memória, o que significa que o valor de val
 * //? é exatamente o que está sendo atribuido à ele
 * //? portanto a valRef quando recebe val, cria uma cópia do valor
 * //? de val e ambas contêm valores independentes, ou seja, caso
 * //? o valor de val mudar, o valor de valRef, permanece o mesmo
 * 
 * 
 * //TODO: por este motivo que qdo alterado o valor do objeto nome, ref e produto
 * //TODO: sofreram alterações iguais e qdo alterado valor de valRef, val permaneceu como estava
 * 
 */