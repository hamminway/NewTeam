let full_bool = false;

window.addEventListener('load', ()=>{
    console.log("123")
    let btnFull = document.querySelector(".btn-fullscreen");

    const wrap = document.querySelector(".individual_wrap");

    btnFull.addEventListener('click',()=>{
        console.log("123")
        console.log(full_bool)
        full_bool = !full_bool;
        if(full_bool){
            wrap.classList.add("hide");
        }else{
            wrap.classList.remove("hide")
        }
    })
})