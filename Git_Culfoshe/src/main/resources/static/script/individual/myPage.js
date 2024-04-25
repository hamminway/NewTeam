const menuBox = document.querySelector('.menu-box');
const sideWrap = document.querySelector('#side_wrap')


menuBox.addEventListener('mouseover',()=>{
    sideWrap.classList.add('sideHoverAction')
})
menuBox.addEventListener('mouseout',()=>{
    sideWrap.classList.remove('sideHoverAction')
})


const profileWrap = document.querySelector('.profile_wrap');
const editBtn = document.querySelector('.profile_edit_box');
function editPage(){
    let data = {
        method: 'GET',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json; charset=UTF-8'
        }
    }
    const editUrl = '/personalPage/myPage/edit';
    fetch(editUrl, data)
    .then((resp)=>{
        console.log(resp)
        return resp.text();
    }).then((data)=>{
        profileWrap.innerHTML=data;
    })
}


