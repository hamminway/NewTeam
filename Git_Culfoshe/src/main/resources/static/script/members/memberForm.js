
/*
1. 전체 동의버튼 누르면 전체 체크
1-1. 하나라도 체크박스를 해제하면 전체 해제
*/

document.addEventListener('DOMContentLoaded', () => {
  const allcheck = document.getElementById('indickall');
  const evtBtn1 = document.getElementById('indick_a');
  const evtBtn2 = document.getElementById('indick_b');
  const evtBtn3 = document.getElementById('indick_c');
  const evtBtn4 = document.getElementById('indick_d');

  allcheck.addEventListener('click', (event)  => {

    const chckValue = event.currentTarget.checked;
    evtBtn1.checked = chckValue
    evtBtn2.checked = chckValue
    evtBtn3.checked = chckValue
    evtBtn4.checked = chckValue

  })

  evtBtn1.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allcheck.checked = false;
    }
  })

  evtBtn2.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allcheck.checked = false;
    }
  })

  evtBtn3.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allcheck.checked = false;
    }
  })

  evtBtn4.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allcheck.checked = false;
    }
  })
});

document.addEventListener('DOMContentLoaded', () => {
  const allcheck = document.getElementById('partckall');
  const evtBtn1 = document.getElementById('partner_a');
  const evtBtn2 = document.getElementById('partner_b');
  const evtBtn3 = document.getElementById('partner_c');
  const evtBtn4 = document.getElementById('partner_d');


  allcheck.addEventListener('click', (event)  => {

    const chckValue = event.currentTarget.checked;
    evtBtn1.checked = chckValue
    evtBtn2.checked = chckValue
    evtBtn3.checked = chckValue
    evtBtn4.checked = chckValue

  })

  evtBtn1.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allcheck.checked = false;
    }
  })

  evtBtn2.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allcheck.checked = false;
    }
  })

  evtBtn3.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allcheck.checked = false;
    }
  })

  evtBtn4.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allcheck.checked = false;
    }
  })
});

/*
2. 회원유형 선택에 따른 블러처리
*/


$(document).ready(function(){

  $("#indic").click(function(){
    if($('#indic').is(':checked', true)){
      $('#agreebox_indi').find('input').prop('disabled', false);
      $('#agreebox_partner').find('input').prop('disabled', true);
    }
  })

  $("#partner").click(function(){
    if($('#partner').is(':checked', true)){
      $('#agreebox_indi').find('input').prop('disabled', true);
      $('#agreebox_partner').find('input').prop('disabled', false);
    }
  })

});


/*
2. 회원유형에 따른 블럭 올리기
*/


$(document).ready(function() {

  $("#indic").click(function() {

    $("#interestInfor").show();
    $("#indicJoinBtn").show();
    $("#partJoinBtn").hide();
    $(".footer").css({"marginTop": "650px"})

    $("#partnerInfor").css({"position":"relative", "right":"501px", "width": "490px"});
    $("#interestInfor").css({"position":"relative", "top":"350px"});

    $(".indexbox1").hide();
    $(".indexbox2").show();
    $(".indexbox2").css({"width":"500px", "height":"790px"});
    $("#allInfor").css({"width":"1500px", "height":"1400px"});

  });

  $("#partner").click(function() {

    $("#interestInfor").hide();
    $("#indicJoinBtn").hide();
    $("#partJoinBtn").show();
    $(".footer").css({"margin": "0px"})

    $("#partJoinBtn").css({"display": "block", "position": "relative", "right": "764px", "top": "180px"});

    $("#inficInfor").css({"width": "520px"});
    $("#partnerInfor").css({"position":"relative", "right":"1px"});

    $(".indexbox1").show();
    $(".indexbox2").hide();
    $(".indexbox1").css({"width":"500px", "height":"550px"});
    $("#allInfor").css({"width":"1500px", "height":"1400px"});

  });
})


/*
3. 정규식
- 아이디 정규식

let idValue = document.getElementById('idInput')
let idbtn = document.getElementById('idbtn')
let idResult = document.getElementById('idchk')

idValue.addEventListener("blur", function(){
  checkId();
})

function checkId(){
  let idexp=/^[a-zA-Z][0-9a-zA-Z]{6,20}/

  if(idValue.value.length == 0){
    idResult.innerHTML = "* 필수 입력입니다"
  }else if(idexp.test(idValue.value)){
    idResult.innerHTML = " "
  }else{
    idResult.innerHTML = "* 양식에 맞게 입력하세요"
  }
}

*/


/*
3. 정규식
- 이메일 정규식(개인)
*/

let indicemail1 = document.getElementById('indicemail1')
let indicemail2 = document.getElementById('indicemail2')
let emailResult = document.getElementById('indicEmailchk')

indicemail1.addEventListener("blur", function(){
  checklndicemail();
})

function checklndicemail(){
  let emailexp=/^[a-zA-Z0-9+-\_.]/

  if(indicemail1.value.length == 0){
    emailResult.innerHTML = "* 필수 입력입니다"
  }else if(emailexp.test(indicemail1.value)){
    emailResult.innerHTML = " "
  }else{
    emailResult.innerHTML = "* 이메일 주소를 입력하세요"
  }
}

indicemail2.addEventListener("blur", function(){
  checklndicemail1();
})

function checklndicemail1(){
  let emailexp2=/^[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]/

  if(indicemail2.value.length == 0){
    emailResult.innerHTML = "* 필수 입력입니다"
  }else if(emailexp2.test(indicemail2.value)){
    emailResult.innerHTML = " "
  }else{
    emailResult.innerHTML = "* 이메일 주소를 양식에 맞춰 입력하세요"
  }
}

/*
3. 정규식
- 이메일 정규식(파트너)
*/

let partemail1 = document.getElementById('partemail1')
let partemail2 = document.getElementById('partemail2')
let partEmailchk = document.getElementById('partEmailchk')

partemail1.addEventListener("blur", function(){
  checkPartemail2();
})

function checkPartemail2(){
  let emailexp=/^[a-zA-Z0-9+-\_.]/

  if(indicemail1.value.length == 0){
    partEmailchk.innerHTML = "* 필수 입력입니다"
  }else if(emailexp.test(indicemail1.value)){
    partEmailchk.innerHTML = " "
  }else{
    partEmailchk.innerHTML = "* 이메일 주소를 입력하세요"
  }
}

partemail2.addEventListener("blur", function(){
  checkPartemail3();
})

function checkPartemail3(){
  let emailexp2=/^[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]/

  if(indicemail2.value.length == 0){
    partEmailchk.innerHTML = "* 필수 입력입니다"
  }else if(emailexp2.test(indicemail2.value)){
    partEmailchk.innerHTML = " "
  }else{
    partEmailchk.innerHTML = "* 이메일 주소를 양식에 맞춰 입력하세요"
  }
}



/*
3. 정규식
- 비밀번호 정규식(개인)
*/

let indicPwInput = document.getElementById('indicPwInput')
let indicPwdChk = document.getElementById("indicPwdChk")

indicPwInput.addEventListener("blur", function(){
  checkpassword();
})

function checkpassword(){
  let pwdexp=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@!%*#?&])[A-Za-z\d@!%*#?&]{8,20}/

  if(indicPwInput.value.length == 0){
    indicPwdChk.innerHTML = "* 필수 입력입니다"
  }else if(pwdexp.test(indicPwInput.value)){
    indicPwdChk.innerHTML = " "
  }else{
    indicPwdChk.innerHTML = "* 양식에 맞게 입력하세요"
  }
}

/*
3. 정규식
- 비밀번호 정규식(파트너)
*/

let partPwInput = document.getElementById('partPwInput')
let partPwdChk = document.getElementById("partPwdChk")

partPwInput.addEventListener("blur", function(){
  checkpassword1();
})

function checkpassword1(){
  let pwdexp=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@!%*#?&])[A-Za-z\d@!%*#?&]{8,20}/

  if(partPwInput.value.length == 0){
    partPwdChk.innerHTML = "* 필수 입력입니다"
  }else if(pwdexp.test(partPwInput.value)){
    partPwdChk.innerHTML = " "
  }else{
    partPwdChk.innerHTML = "* 양식에 맞게 입력하세요"
  }
}



/*
3. 정규식
- 비밀번호 확인 정규식(개인)
*/

let indicPwInputCheck = document.getElementById('indicPwInputCheck')
let indicPwdDoubleChk = document.getElementById("indicPwdDoubleChk")

indicPwInputCheck.addEventListener("blur", function(){
  passwordCheck();
})

function passwordCheck(){
  let pwdchkexp=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@!%*#?&])[A-Za-z\d@!%*#?&]{8,20}/

  if(indicPwInputCheck.value.length == 0){
    indicPwdDoubleChk.innerHTML = "* 동일한 비밀번호를 입력해주세요"
  }else if(pwdchkexp.test(indicPwInputCheck.value)){
    indicPwdDoubleChk.innerHTML= " "
  }else if(indicPwInput.value == indicPwInputCheck.value){
    indicPwdDoubleChk.innerHTML = " "
  }else{
    indicPwdDoubleChk.innerHTML = "* 동일한 비밀번호를 입력해주세요"
  }
}

/*
3. 정규식
- 비밀번호 확인 정규식(파트너)
*/

let partPwInputCheck = document.getElementById('partPwInputCheck')
let partPwdDoubleChk = document.getElementById("partPwdDoubleChk")

partPwInputCheck.addEventListener("blur", function(){
  passwordCheck1();
})

function passwordCheck1(){
  let pwdchkexp=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@!%*#?&])[A-Za-z\d@!%*#?&]{8,20}/

  if(partPwInputCheck.value.length == 0){
    partPwdDoubleChk.innerHTML = "* 동일한 비밀번호를 입력해주세요"
  }else if(pwdchkexp.test(partPwInputCheck.value)){
    partPwdDoubleChk.innerHTML= " "
  }else if(partPwInput.value == partPwInputCheck.value){
    partPwdDoubleChk.innerHTML = " "
  }else{
    partPwdDoubleChk.innerHTML = "* 동일한 비밀번호를 입력해주세요"
  }
}



/*
3. 정규식
- 개인 휴대폰 번호 정규식(개인)
*/

let indicPhone = document.getElementById('indicPhone')
let indicPhoneChk = document.getElementById('indicPhoneChk')

indicPhone.addEventListener("blur", function(){
  checkNumber();
})
function checkNumber(){
  let phoneexp =/^[0-1]+-[0-9]+-[0-9]/

  if(indicPhone.value.length == 0){
    indicPhoneChk.innerHTML = "* 필수 입력입니다"
  }else if(phoneexp.test(indicPhone.value)){
    indicPhoneChk.innerHTML = " "
  }else{
    indicPhoneChk.innerHTML = "* 010 - 0000 - 0000 양식에 맞춰 입력하세요"
  }
}

/*
3. 정규식
- 개인 휴대폰 번호 정규식(파트너)
*/

let partnerPhone = document.getElementById('partnerPhone')
let partnerPhoneChk = document.getElementById('partnerPhoneChk')

partnerPhone.addEventListener("blur", function(){
  checkNumber1();
})
function checkNumber1(){
  let phoneexp =/^[0-1]+-[0-9]+-[0-9]/

  if(partnerPhone.value.length == 0){
    partnerPhoneChk.innerHTML = "* 필수 입력입니다"
  }else if(phoneexp.test(partnerPhone.value)){
    partnerPhoneChk.innerHTML = " "
  }else{
    partnerPhoneChk.innerHTML = "* 010 - 0000 - 0000 양식에 맞춰 입력하세요"
  }
}



/*
3. 정규식
- 사업자 등록번호 정규식
*/

let storeNum = document.getElementById('storeNum')
let storeNumResult = document.getElementById('numchk')

storeNum.addEventListener("blur", function(){
  checkStoreNum();
})

function checkStoreNum(){
  let partemailexp = /^[0-9]+-[0-9]+-[0-9]/

  if(storeNum.value.length == 0){
    storeNumResult.innerHTML = "* 필수 입력입니다"
  }else if(partemailexp.test(storeNum.value)){
    storeNumResult.innerHTML = " "
  }else{
    storeNumResult.innerHTML = "* 000 - 00 - 0000 양식에 맞춰 입력하세요"
  }
}

/*
4. 이메일 합치기
- 개인
*/

let indicEmailBox = document.getElementById("indicEmailBox");

indicemail1.addEventListener("blur", function(){
  indicEmailBox.value = indicemail1.value + "@" + indicemail2.value;
})

indicemail2.addEventListener("blur", function(){
  indicEmailBox.value = indicemail1.value + "@" + indicemail2.value;
})

/*
4. 이메일 합치기
- 파트너
*/

let partEmailBox = document.getElementById("partEmailBox");
let emailaArr = [];

for(let i = 1; i < 3 ; i++){
  emailaArr.push(document.getElementById('partemail'+i))
}

for(let i = 0 ; i < emailaArr.length ; i++){
  emailaArr[i].addEventListener("blur", function (){
    partEmailBox.value = emailaArr[0].value + "@" + emailaArr[1].value;
  })
}

/*
5. 사업장 소재지의 주소 입력창 후, 가져오기
*/


/*
6. 선택 css 변화 및 제한 두기
*/

// 변수 선언
// let interest1 = document.getElementById('interest1')

let checkNum = 0;
let maxCheck = 3;
let interestList = document.getElementsByClassName("InterestChkBox"); // input태그(체크박스) class명으로 검사(name값 안됨..)
for(let i = 1 ; i < 19 ; i++){
  let eventAdd = document.getElementById('interest'+i);

  eventAdd.addEventListener('click', (e)=>{

    if(interestList[i-1].checked){          // input태그의 체크박스가 체크 여부 검사
      cssChange(e.target, true)             //cssChange(해당label태그, 체크해제요청) - cssChange(e.target, true(checkDeleteAction))
      return true;// 함수 (조기)종료(여기서는 return값 무의미)         //함수 조기 종료 : 코드의 가독성을 높이기 위하여 함수를 조건부에서 종료 시키는 행위.
    }


    if(checkNum >= maxCheck){       //checkNum값 검사
      alert("3개라고");
      e.preventDefault();           //체크박스의 체크 이벤트 해제
      return false;                 //함수 조기 종료 (여기서는 return값 무의미)

    }
                                    //3개 이상이 아니면(함수가 조기 종료 되지 않았으면)
    cssChange(e.target, false);     //cssChange, 녹색으로

  })


}

// 클릭 시, 컬러 변화
// interest1.addEventListener("click", function(){
//   cssChange(interest1);
// })

function cssChange(target, action) { //action이 true 일 때 체크 해제요청, false 일 때 체크 요청

  if(action){               //체크 해제 요청이 들어올 시 (action이 true로 들어올 시)
                            // 선택된 것을 해제할 때 클릭(하얀 배걍 + 검정 글자로 바뀜)

    target.style.color = "black";
    target.style.backgroundColor = "white";
    checkNum--;             //체크 개수 --
    console.log("aaaaa");

  }else{                    //체크 요청이 들어올 시 - 선택 시, 초록 배경 + 하얀 글자로 바뀜

    target.style.color = "white";
    target.style.backgroundColor = "rgb(16, 104, 63)";
    checkNum++;             //체크 개수 ++

  }
}


// 3개로 클릭 제한(관심지역 선택 최대 3곳)
let areaCheckNum = 0;

function selectLimitArea(target) {
  if (target.checked) {
    areaCheckNum++;
  } else {
    areaCheckNum--;
  }

  if (areaCheckNum > maxCheck) {
    alert("관심 지역은 최대 3곳까지 선택이 가능합니다.");
    target.checked = false;
    areaCheckNum--;
  }
}
