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
    })
    targetRow.addEventListener('mouseout', ()=>{
        relativeList[i].style.height = "0px";
        text[i].classList.add("blind");
    })
}
