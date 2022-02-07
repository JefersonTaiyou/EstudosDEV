/* ============================== Animação Texto ============================ */
var typed = new Typed(".typing",{
    strings:["Desenvolvedor de Games","Game Designer","Level Designer"],
    typeSpeed:100,
    BackSpeed:60,
    loop:true
})

/* ============================== Animação Logo ============================ */

var typed = new Typed(".typinglogo",{
    strings:["eferson"],
    typeSpeed:200,
    BackSpeed:200,
    loop:true
})

/* ============================== Seleção Menu Lateral ============================ */

let toggle = document.querySelector(".nav-toggler");
let aside = document.querySelector(".aside");

toggle.onclick = function() {
    aside.classList.toggle('active');
}

let hashchange_handler = function() {
    let hash = window.location.hash;

    let myTabs = document.getElementById('nav');

    let active;
    while (active = nav.querySelector('#nav > li.active'))
        active.classList.remove("active");

    active = nav.querySelector('#nav > li > a[href="' + hash + '"]')
    active.parentNode.classList.add("active");
}

if (window.location.hash)
    window.addEventListener("load", hashchange_handler)
window.addEventListener("hashchange", hashchange_handler);
