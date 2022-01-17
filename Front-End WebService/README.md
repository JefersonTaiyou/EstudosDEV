# Minhas Anotações dos Estudos

- <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg" alt="HTML5" title="HTML5" style="max-width: 100%;" width="40" height="40" align="center"> Linguagem de Marcação para criar páginas WEB

<h2>Protocolos:</h2>

Conjuntos de regras para comunicação em rede<br>

- **<i>HTTP</i>**: &nbsp;Protocolo usado pelos servidores para transmitir documentos HTML na internet
- **<i>FTP</i>**: &nbsp;Protocolo usado para transmitir arquivos
- **<i>TCP</i>**: &nbsp;Protocolos para transmissão de informações pela web, verificando se os dados são transferidos corretamente
- **<i>IP</i>**: &nbsp;Protocolo de endereçamento dos computadores na rede

##

- **Efeitos**:
  - **Negrito**;
  - <i>Italico</i>;
  - <ins>Sublinhado</ins>;

- **Alinhamento**:
  - **align=Left**: Alinhado a Esquerda;
  - **align=Right**: Alinhado a Direita;
  - **align=Center**: Alinhado ao Centro;
  - **align=Justify**: Justificado;
  
- **Fonte**:
  - **< Font face="nome da fonte">**: Altera o tipo da fonte;
  - **< Font size="tamanho">**: Altera o tamanho da fonte;
  - **< Font color="código rgb ou hexa da fonte">**: Altera a cor da fonte;

- **Listas**:
  - **OL**: Lista ordenada;
  - **UL**: Lista Não Ordenada;
    - **LI**: Item da Lista;

- **Tabelas**: < Table>

    1ª Linha < TR> 1ª Coluna < TD> | 2ª Coluna < TD> |
    :---------: | :------: | 
    2ª Linha < TR> 1ª Coluna < TD> | 2ª Coluna < TD> |
    3ª Linha < TR> 1ª Coluna < TD> | 2ª Coluna < TD> |

    - **Border**: Muda a cor da borda;
    - **Bgcolor**: Muda a cor de fundo;
    - **Cellspacing**: espaço entre a borda e celulas;
    - **Cellpadding**: espaço entre os dados e a borda;
    - **Alinhamento das Células**:
      - **align**: alinhamento horizontal;
      - **valign**: alinhamento vertical;
      - **colspan**: mescla colunas; **ex**: < td colspan="2">
      - **rowspan**: mescla linhas; **ex**: < td rowspan="2">

- **Form**:  Cria um formulario HTML; **sintaxe:** < Form>< /form>
- **Action="URL"**: Especifica qual script processará os dados deste formulario;
- **Method="post ou get"**: maneira que os dados serão enviados;
	- **post** = Utilizado para transmissão de muitos dados para o servidor - **[Recomendado]**
	- **get** = Utilizado para transmissão de dados únicos
- **Input**: Utilizado para criar os campos do Form
    - **type**: utilizado para definir o tipo dos campos, podendo ser definidos como:
      - **file**: campo de seleção de arquivos;
      - **reset**: botão para limpar os campos;
      - **button**: botão de ação;
      - **submit**: botão de enviar;
      - **password**: campo de senha;
      - **radio**: campo de escolha única;
      - **text**: campo de texto;
      - **checkbox**: campo de multipla escolha;
		
    - **value**: valor inicial do campo;
    - **maxlenght**: tamanho máximo de caracteres;
    - **checked**: define se o campo("radio" ou "checkbox") está selecionado;
    - **name**: nome do campo para facilitar a manipulação do script;
    - **size**: tamanho do campo;
- **Textarea**: cria um campo de texto para descrições maiores; **Sintaxe:** < textarea rows="num" cols="num">< /textarea>
	- **rows**: define a qtde de linhas;
	- **cols**: define a qtde de colunas;


- <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg" alt="CSS" title="CSS3" style="max-width: 100%;" width="40" height="40" align="middle"> Linguagem de Formatação para estilizar páginas WEB
