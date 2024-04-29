const page = document.querySelector('.paging');
const totalPage = document.querySelector('.totalPage').value;

const createA = document.createElement('a');
createA.classList.add('new');

//for문이 돌기 전에 nowPage가 1이면 

window.addEventListener('load',()=>{
    for(let i=0; i<totalPage; i++) {
        target = paging.appendChild(createA);
        target.href = 'search/searchingForm?page='+i;
        target.text = i;
    }
})
