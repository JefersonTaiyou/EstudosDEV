    @import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css");
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');
     :root {
        --font-atual: "Poppins", sans-serif;
        --cor-1: #100e31;
        --cor-2: #263baf;
        --cor-3: #777;
        --cor-hover: var(--cor-1);
        --cor-body: #fefefe;
        --cor-card: #fff;
        --cor-modal: #fff;
        --cor-bg-transparent: rgba(0, 0, 0, 0.1);
        --cor-transparent: var(--cor-bg-transparent);
        --cor-bg-transparent: rgba(106, 89, 209, 0.1);
        --cor-linha: #d7d7d7;
        --cor-filtro: invert(1);
        --box-shadow: 0 0 20px rgb(0 0 0 / 10%);
        /*! font size */
        --font-pequeno: .9em;
        --font-normal: 1em;
        /*! scrollbar */
        --scrollbar-cor: #c6dfc5;
        --scroll-thumb-cor: #718a70;
        --scroll-thumb-cor-hover: #536b45;
    }
    
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: var(--font-atual);
    }
    
    html {
        scroll-behavior: smooth;
    }
    
    body {
        color: var(--cor-1);
        background-color: var(--cor-body);
        margin: 2rem 0 0;
        transition: .5s ease;
    }
    
    a {
        text-decoration: none;
    }
    
    li {
        list-style: none;
    }
    
     ::-webkit-scrollbar {
        width: 10px;
        background: var(--scrollbar-cor);
    }
    
     ::-webkit-scrollbar-thumb {
        background: var(--scroll-thumb-cor);
        border-radius: 2em;
    }
    
     ::-webkit-scrollbar-thumb:hover {
        background: var(--scroll-thumb-cor-hover);
    }
    
    header {
        z-index: 99999;
        width: 100%;
        position: fixed;
        top: 0;
        left: 0;
        backdrop-filter: blur(20px);
        transition: .6s ease;
    }
    
    header.sticky {
        background: rgba(255, 255, 255, 0.1);
        box-shadow: var(--box-shadow);
    }
    
    .nav-bar {
        position: relative;
        height: calc(4rem + 1rem);
        max-width: 1250px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-left: auto;
        margin-right: auto;
        padding: 0 20px;
        transition: .6s ease;
    }
    
    header.sticky .nav-bar {
        height: calc(2.5rem + 1rem);
    }
    
    .nav-bar .logo {
        color: var(--cor-1);
        font-size: 1.3em;
        font-weight: 600;
    }
    
    .nav-items a {
        color: var(--cor-1);
        font-size: var(--font-normal);
        font-weight: 500;
    }
    
    .nav-items a:not(:last-child) {
        margin-right: 50px;
    }
    
    .nav-items a:hover {
        color: var(--cor-2);
    }
    
    .home {
        position: relative;
        max-width: 1250px;
        min-height: 100vh;
        margin-left: auto;
        margin-right: auto;
        padding: 4rem 2rem;
        flex-direction: column;
    }
    
    .home .home-container {
        display: flex;
        justify-content: space-between;
        align-items: center;
        width: 100%;
    }
    
    .home-container .media-icons {
        display: flex;
        flex-direction: column;
        margin-right: 40px;
    }
    
    .home-container .media-icons a {
        color: var(--cor-2);
        font-size: 1.5em;
        margin: 10px 0;
    }
    
    .home-container .media-icons a:hover {
        color: var(--cor-1);
    }
    
    .home-container .info h2 {
        font-size: 4em;
        font-weight: 600;
        line-height: 70px;
    }
    
    .home-container .info h3 {
        color: var(--cor-3);
        font-feature-settings: 1.3em;
        font-weight: 600;
        line-height: 50px;
    }
    
    .home-container .info p {
        color: var(--cor-3);
        font-size: var(--font-normal);
        max-width: 350px;
    }
    
    .botao {
        background: var(--cor-2);
        color: #fff;
        font-size: var(--font-normal);
        font-weight: 500;
        display: inline-block;
        margin-top: 25px;
        padding: 20px 30px;
        letter-spacing: 1px;
        border-radius: 10px;
    }
    
    .botao:hover {
        background: var(--cor-hover);
    }
    
    .home-container .home-img {
        position: relative;
    }
    
    .home-container .home-img img {
        width: 90%;
        transform: translate(0, 0);
    }
    
    .home .scroll-down {
        color: var(--cor-2);
        font-size: var(--font-normal);
        font-weight: 500;
        margin-top: 20px;
    }
    
    .home .scroll-down i {
        color: var(--cor-1);
        font-size: 1.2em;
        animation: arrow-down ease 1s infinite;
    }
    
    @keyframes arrow-down {
        0% {
            transform: translateY(0);
        }
        30% {
            transform: translateY(10px);
        }
    }
    
    .flex-center {
        display: flex;
        justify-content: center;
        align-items: center;
    }
    
    .secao {
        position: relative;
        width: 1150px;
        margin-left: auto;
        margin-right: auto;
        padding: 6rem 2rem 2rem;
    }
    
    .subsecao {
        position: relative;
        width: 1150px;
        margin-left: auto;
        margin-right: auto;
        padding: 6rem 0;
    }
    
    .titulo-1 {
        font-size: 4.5em;
        font-weight: 800;
        margin-bottom: 2rem;
        background: linear-gradient(to top, transparent 0%, var(--cor-1) 70%);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
        opacity: .2;
    }
    
    .titulo-2 {
        font-size: 2.5em;
        font-weight: 700;
        transform: translateY(-80px);
    }
    
    .titulo-2:before {
        content: '';
        position: absolute;
        width: 70px;
        height: 5px;
        right: 0;
        bottom: 0;
        background: var(--cor-2);
    }
    
    .container {
        position: relative;
        flex-direction: column;
    }
    
    .sobre .container .conteudo {
        column-gap: 40px;
        width: 100%;
    }
    
    .img-sobre {
        position: relative;
    }
    
    .img-sobre img {
        max-width: 100%;
        min-width: 350px;
        border-radius: 10px;
    }
    
    .sobre-info .descricao {
        max-width: 600px;
    }
    
    .sobre-info .descricao h3 {
        font-size: 2em;
        font-weight: 600;
        margin-bottom: 10px;
    }
    
    .sobre-info .descricao h4 {
        font-size: 1.3em;
        font-weight: 600;
        margin-bottom: 10px;
    }
    
    .sobre-info .descricao h4 span {
        color: var(--cor-2);
    }
    
    .sobre-info .descricao p {
        color: var(--cor-3);
        font-size: var(--font-normal);
        margin-bottom: 15px;
        padding-bottom: 25px;
        border-bottom: 2px solid var(--cor-linha);
    }
    
    .sobre-info .descricao p b {
        color: var(--cor-2);
    }
    
    .sobre-info .lista-profissional {
        display: flex;
        column-gap: 30px;
    }
    
    .sobre-info .lista-profissional .items-lista h3 {
        font-size: 1.5em;
        font-weight: 700;
    }
    
    .sobre-info .lista-profissional .items-lista span {
        color: var(--cor-3);
        font-size: var(--font-pequeno);
    }
    
    .skills .container .conteudo {
        width: 100%;
    }
    
    .skills .descricao {
        max-width: 700px;
        margin-bottom: 50px;
    }
    
    .skills .descricao h3 {
        font-size: 2em;
        margin-bottom: 5px;
    }
    
    .skills-info {
        max-width: 100%;
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
        gap: 20px;
        margin: 0 auto;
    }
    
    .skills-info h4 {
        margin-bottom: 20px;
    }
    
    .skills-info h4 label {
        background: var(--cor-2);
        color: #fff;
        font-size: var(--font-normal);
        font-weight: 400;
        padding: 5px 15px;
        border-radius: 5px;
    }
    
    .educacao {
        margin-bottom: 80px;
    }
    
    .edu-list .item {
        background: var(--cor-card);
        box-shadow: var(--box-shadow);
        border-bottom: 3px solid var(--cor-2);
        padding: 20px;
        margin-top: 15px;
        border-radius: 6px;
        transition: .3s ease;
    }
    
    .edu-list .item .ano {
        font-size: var(--font-pequeno);
        margin-bottom: 5px;
    }
    
    .edu-list .item p {
        font-size: var(--font-pequeno);
        color: var(--cor-3);
    }
    
    .edu-list .item p span {
        font-size: var(--font-normal);
        color: #000000;
        font-weight: 500;
    }
    
    .barra {
        background-color: var(--cor-card);
        box-shadow: var(--box-shadow);
        border-bottom: 2px solid var(--cor-1);
        margin-bottom: 10px;
        padding: 20px;
        border-radius: 6px;
        transition: .3s ease;
    }
    
    .barra .info {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 5px;
        font-size: var(--font-pequeno);
    }
    
    .barra .info {
        font-weight: 500;
    }
    
    .barra .linha {
        position: relative;
        width: 100%;
        height: 7px;
        background: #c5cadf;
        border-radius: 2px;
    }
    
    .barra .linha::before {
        content: '';
        position: absolute;
        height: 100%;
        top: 0;
        left: 0;
        background: var(--cor-2);
        border-radius: 2px;
    }
    
    .barra .html::before {
        width: 65%;
    }
    
    .barra .css::before {
        width: 60%;
    }
    
    .barra .js::before {
        width: 48%;
    }
    
    .barra .c::before {
        width: 72%;
    }
    
    .barra .csharp::before {
        width: 60%;
    }
    
    .barra .sql::before {
        width: 76%;
    }
    
    .barra .python::before {
        width: 52%;
    }
    
    .barra .ps::before {
        width: 62%;
    }
    
    .barra .ai::before {
        width: 71%;
    }
    
    .barra .ae::before {
        width: 49%;
    }
    
    .experiencia {
        background: var(--cor-card);
        border-bottom: 3px solid var(--cor-2);
        padding: 35px;
        border-radius: 6px;
        box-shadow: var(--box-shadow);
        transition: .3s ease;
    }
    
    .experiencia .upper {
        line-height: 30px;
    }
    
    .experiencia h3 {
        font-size: 1.3em;
        font-weight: 700;
    }
    
    .experiencia span {
        color: var(--cor-3);
    }
    
    .experiencia .hr {
        width: 100%;
        height: 2px;
        background-color: var(--cor-linha);
        margin: 10px 0 22px;
    }
    
    .edu-list .item:hover,
    .experiencia:hover {
        transform: scale(1.03);
    }
    
    .barra:hover {
        transform: scale(1.03);
        padding-bottom: 80px;
    }
    
    .esconde {
        display: none;
        padding-left: 40px;
        padding-top: 30px;
        margin-bottom: 0;
        transition: .5s;
    }
    
    li:hover .esconde {
        display: grid;
    }
    
    span.red {
        color: red;
        font-weight: 600;
        transition: .3s;
    }
    
    span.red:hover {
        padding-left: 10px;
        color: white;
        background-color: red;
        border-radius: 20px;
    }
    
    span.azul {
        color: blue;
        font-weight: 700;
        transition: .3s;
    }
    
    span.azul:hover {
        padding-left: 10px;
        color: white;
        background-color: blue;
        border-radius: 20px;
    }
    
    span.verde {
        color: green;
        font-weight: 800;
        transition: .3s;
    }
    
    span.verde:hover {
        padding-left: 10px;
        color: white;
        background-color: green;
        border-radius: 20px;
    }
