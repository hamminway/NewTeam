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
const topBar = document.querySelector(".top-bar");
const topBarHeight = topBar.offsetHeight;

window.onscroll = function () {
    const windowTop = window.scrollY;

    if(windowTop > topBarHeight) {
        topBar.classList.add("scrolled");
    } else {
        topBar.classList.remove("scrolled");
    }
};

//스크롤 시 위로 올리면 nav가 뜨게 하고
// 내릴 시 nav가 숨겨짐
const a = document.querySelector('.menu-box-1');

window.addEventListener('wheel',(e)=>{
    if(e.deltaY>=0){
        a.style.display='none';
    } else {
        a.style.display='block';
        a.style.background='transparent';
    }
})


//$(window).scroll(function() {
//    if($(document).scrollTop()> 0) {
//        $(.top-bar).add('scrolled');
//    } else {
//        $(.top-bar).remove('scrolled');
//    }
//});