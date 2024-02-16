const topBar = document.querySelector(".top-bar");
const dum = document.querySelector('.top-bar-dum');

window.addEventListener('wheel',(e)=>{
    if(e.deltaY>=0){
        topBar.classList.add("blind");
        dum.classList.remove("blind");
    } else {
        topBar.classList.remove("blind");
        dum.classList.add("blind");
    }
})

const targetRow = document.querySelector("#target");
const relativeList = document.querySelectorAll(".relative");

for(let i = 0 ; i < relativeList.length ; i++){
    targetRow.addEventListener('mouseover', ()=>{
        relativeList[i].style.height = "260px"
    })
    targetRow.addEventListener('mouseout', ()=>{
        relativeList[i].style.height = "0px"
    })
}

//스크롤 내릴 시 top-bar가 줄게 하기
/*const topBarHeight = topBar.offsetHeight;

window.onscroll = function () {
    const windowTop = window.scrollY;

    if(windowTop > topBarHeight) {
        topBar.classList.add("scrolled");
    } else {
        topBar.classList.remove("scrolled");
    }
};*/

//$(window).scroll(function() {
//    if($(document).scrollTop()> 0) {
//        $(.top-bar).add('scrolled');
//    } else {
//        $(.top-bar).remove('scrolled');
//    }
//});