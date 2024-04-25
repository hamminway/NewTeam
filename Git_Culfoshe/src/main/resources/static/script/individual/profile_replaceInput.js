
const cancel = document.querySelector('.cancel_box');


function closeBtn(){
    const closeURL = "/personalPage/myPage/edit/close";
    fetch(closeURL)
    .then((resp)=>{
        console.log(resp);
        return resp.text();
    })
    .then((data)=>{
        profileWrap.innerHTML=data;
    })

}

function submitBtn(){
    
    const submitURL = "/personalPage/myPage/edit"
    const formData = new FormData(document.querySelector('.profile_wrap'));
    console.log(document.querySelector('.profile_wrap'))
    console.log(formData)
    console.log(JSON.stringify(formData))
    let data = {
        method : "POST",
        cache: 'no-cache',
        body : formData
    }
    fetch(submitURL, data)
    .then((resp)=>{
        console.log(resp);
        return resp.text();
    })
    .then((data)=>{
        profileWrap.innerHTML=data;
    })
}