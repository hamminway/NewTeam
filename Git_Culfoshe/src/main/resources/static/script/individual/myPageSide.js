
const cateList = document.querySelector('.cateList');
const action = document.querySelector('.action');
const plus = document.querySelector('.cateAddBox');
const minusSample = document.querySelector('.minusBox');
const side_bottom = document.querySelector('.side_bottom');

function sideEdit(element){
    side_bottom.classList.remove('blind');
    element.classList.add('blind');
    let minusBoxList = document.querySelectorAll('.minusBox');
    toggleClassListByNodeList(minusBoxList, 'blind', true);
    minusBoxList[0].classList.add('blind');
    minusBoxList[1].classList.add('blind');
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
function deleteYes(element){

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






