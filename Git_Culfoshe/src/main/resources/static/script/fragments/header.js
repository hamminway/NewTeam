//스크롤 내릴 시 설정
const wrap = document.querySelector(".header_wrap");
const box = document.querySelector(".menu-box");

window.addEventListener('wheel',(e)=>{
    if(e.deltaY >= 0) {
        wrap.classList.add("scrolled");
        box.classList.add("scrolled");
    } else {
        wrap.classList.remove("scrolled");
        box.classList.remove("scrolled");
    }
})

//세부 카테고리 나오게 하기
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


