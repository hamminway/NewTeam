

const cateList = document.querySelector('.cateList');//사용자의 카테고리 리스트가 나올 div
const action = document.querySelector('.action');//사용자의 카테고리 삭제의 경고창
const plus = document.querySelector('.cateAddBox');//사용자의 카테고리를 추가할 아이콘박스
const minusSample = document.querySelector('.minusBox');//사용자의 카테고리를 제거할 아이콘 박스
const side_bottom = document.querySelector('.side_bottom');//카테고리의 바텀 - 완료버튼과 +아이콘이 있음

var eventNode = null;

function sideEdit(element){
    const sideInputUrl = '';

}
function resetFocus(){
    let eachLists = document.querySelectorAll('.eachList');
    let eachList_contents = document.querySelectorAll('.eachList_content');
    if(eachLists.length>=30){
        alert("stop!");
        return;
    }
    toggleClassListByNodeList(eachLists, 'focusCate', true);
    toggleClassListByNodeList(eachList_contents, 'focusCate', true);
}

function addCate(element){
    resetFocus();
    let newP = document.createElement('p');
    let newInput = document.createElement('input');
    let minusClone = minusSample.cloneNode(true);
    newP.className = 'eachList';
    newP.classList.add('focusCate');
    newInput.className= 'eachList_content';
    newInput.value='제목 없음';
    newInput.classList.add('focusCate');
    minusClone.classList.remove('blind');
    

    let createdP = cateList.appendChild(newP);
    createdP.appendChild(newInput);
    createdP.appendChild(minusClone);
    createdP.addEventListener('click',(e)=>{
        resetFocus();
        createdP.classList.add('focusCate');
        // if(createdP.querySelector('input').value==='제목 없음'){
        //     createdP.querySelector('input').value = '';
        // }
    })
}
function deleteTag(this){
    eventNode = this;
}
function deleteTagConfirm(element, bool){
    let alertScreen = element.closest('.alertDelete');
    if(bool){
        eventNode.remove();
    }
    alertScreen.classList.add('blind');
    eventNode = null;
}
function cancelAction(){

}
function deleteCate(element){

    
}

function toggleClassListByNodeList(list, className, boolean){
    if(list==null){
        return;
    }
    if(boolean){
        for(let i = 0 ; i< list.length ; i++){
            list[i].classList.remove(className);
        }
    }else{
        for(let i = 0 ; i< list.length ; i++){
            list[i].classList.add(className);
        }
    }
}






