const wrap = document.querySelector(".menu-box");

window.addEventListener('wheel',(e)=>{
    if(e.deltaY >= 0) {
        wrap.classList.add("scrolled");
    } else {
        wrap.classList.remove("scrolled");
    }
})

const getRow = document.querySelector("#target");
const reList = document.querySelectorAll(".relative");
const menuText = document.querySelectorAll(".menu-text");

 for(let i=0; i<reList.length; i++) {
     getRow.addEventListener('mouseover', ()=>{
        reList[i].style.height = "260px";
        menuText[i].classList.remove("blind");
        reList[i].classList.add("disable");
    })
    getRow.addEventListener('mouseout', ()=>{
        reList[i].style.height = "0px";
        menuText[i].classList.add("blind");
        reList[i].classList.remove("disable");
    })
 }

