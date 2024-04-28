const page = document.querySelector('.paging');
const totalPage = document.querySelector('.totalPage').value;

const now = document.querySelector('.nowPage');
const prev = document.querySelector('.prevPage');
const next = document.querySelector('.nextPage');

const createA = document.createElement('a');
createA.classList.add('new');

//for문이 돌기 전에 nowPage가 1이면 

for(let i=0; i<totalPage; i++) {
    target = paging.appendChild(createA);
    target.href = 'search/searchingForm?page='+i;
    target.text = i;

        if(nowPage <= 1) {
            prev.href = '/search/searchingForm?page='+ (nowPage-1)<1?nowPage:(nowPage-1);

        } else if(nowPage >= 1) {
            next.href = '/search/searchingForm?page='+ (nowPage+1)>totalPage?totalPage:(nowPage+1);
        }
}