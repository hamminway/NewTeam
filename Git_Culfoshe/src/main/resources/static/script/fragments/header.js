//스크롤 내릴 시 top-bar 설정 하기
const t = document.querySelector(".top-bar");

window.addEventListener('wheel',(e)=>{
    if(e.deltaY >= 0){
       t.classList.add("scrolled");
    }else{
       t.classList.remove("scrolled");
    }
})

//세부 카테고리 나오게 하기
const targetRow = document.querySelector("#target");
const relativeList = document.querySelectorAll(".relative");
const text = document.querySelectorAll(".menu-text");

for(let i = 0 ; i < relativeList.length ; i++){
    targetRow.addEventListener('mouseover', ()=>{
        relativeList[i].style.height = "260px"
        text[i].classList.remove("blind");
        relativeList[i].setTimeout(() => {
            relativeList[i].classList.add("disable");
        }, 700);
    })
    targetRow.addEventListener('mouseout', ()=>{
        relativeList[i].style.height = "0px";
        text[i].classList.add("blind");
        relativeList[i].classList.remove("disable");
    })
}

const menu = document.querySelectorAll(".menu-box")

// for문인데 배열을 안 추가해줘서 안댐
for(let i=0; i<menu.length; i++) {
    menu[i].addEventListener('mouseover', ()=>{
        t.classList.add("addHeight");
    })
    menu[i].addEventListener('mouseout', ()=>{
        t.classList.remove("addHeight");
    })
}
