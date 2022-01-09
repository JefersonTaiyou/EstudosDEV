/*
let list = document.querySelectorAll('.navigation li');

function activeLink() {
    list.forEach((item) =>
        item.classList.remove('hovered'));
    this.classList.add('hovered');
}
list.forEach((item) => item.addEventListener('mouseover', activeLink));
*/

let toggle = document.querySelector(".toggle");
let navigation = document.querySelector(".navigation");
let principal = document.querySelector(".principal");

toggle.onclick = function() {
    navigation.classList.toggle('active');
    principal.classList.toggle('active');
}


let hashchange_handler = function() {
    let hash = window.location.hash;

    let myTabs = document.getElementById('myTab');

    let active;
    while (active = myTab.querySelector('#myTab > li.active'))
        active.classList.remove("active");

    active = myTab.querySelector('#myTab > li > a[href="' + hash + '"]')
    active.parentNode.classList.add("active");
}

if (window.location.hash)
    window.addEventListener("load", hashchange_handler)
window.addEventListener("hashchange", hashchange_handler);