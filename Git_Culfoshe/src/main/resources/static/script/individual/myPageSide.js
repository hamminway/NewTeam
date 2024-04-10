
const cateList = document.querySelector('.cateList');
const action = document.querySelector('.action');
const plus = document.querySelector('.cateAddBox');

function sideEdit(element){
    plus.classList.remove('blind');
    element.classList.add('blind');
}
function resetFocus(){
    let eachLists = document.querySelectorAll('.eachList');
    let eachList_contents = document.querySelectorAll('.eachList_content');
    if(eachLists.length>=30){
        alert("stop!");
        return;
    }
    for(let i = 0 ; i < eachLists.length ; i++){
        eachLists[i].classList.remove('focusCate');
    }
    for(let i = 0 ; i < eachList_contents.length ; i++){
        eachList_contents[i].classList.remove('focusCate');
    }
}

function addCate(element){
    resetFocus();
    let newP = document.createElement('p');
    let newInput = document.createElement('input');
    newP.className = 'eachList';
    newP.classList.add('focusCate');
    newInput.className= 'eachList_content';
    newInput.value='제목 없음';
    newInput.classList.add('focusCate');
    
    let createdP = cateList.appendChild(newP);
    createdP.appendChild(newInput);
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








