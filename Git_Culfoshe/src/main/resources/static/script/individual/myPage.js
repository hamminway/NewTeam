const menuBox = document.querySelector('.menu-box');
const sideWrap = document.querySelector('#side_wrap')


menuBox.addEventListener('mouseover',()=>{
    sideWrap.classList.add('sideHoverAction')
})
menuBox.addEventListener('mouseout',()=>{
    sideWrap.classList.remove('sideHoverAction')
})

