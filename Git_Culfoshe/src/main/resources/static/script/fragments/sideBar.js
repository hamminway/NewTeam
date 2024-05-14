// 스크롤 최상단으로 부드럽게 올리기
function backTop(Y) {
    if(Y>1) {
        window.requestAnimationFrame(()=> {
            window.scrollTo(0, Y - 300);
            t.classList.remove("scrolled");
            backTop(Y - 300);
        });
    }
}
    document.querySelector('.up-btn').addEventListener('click', (e)=>{
        const Y = e.pageY;
        backTop(Y);
    })