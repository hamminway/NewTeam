// 스크롤 최상단으로 부드럽게 올리기
function backTop() {
    const position = document.documentElement.scrollTop || document.body.scrollTop;

    if(position) {
        window.requestAnimationFrame(()=> {
            window.scrollTo(0, position - position / 10);
            t.classList.remove("blind");
            backTop();
        });
    }
}