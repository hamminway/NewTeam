
/*
1. 전체 동의버튼 누르면 전체 체크
1-1. 하나라도 체크박스를 해제하면 전체 해제
*/

const allIndiccheck = document.getElementById('indickall');
const indicBtn1 = document.getElementById('indick_a');
const indicBtn2 = document.getElementById('indick_b');
const indicBtn3 = document.getElementById('indick_c');
const indicBtn4 = document.getElementById('indick_d');

document.addEventListener('DOMContentLoaded', () => {

  allIndiccheck.addEventListener('click', (event)  => {

    const chkValue = event.currentTarget.checked;
    indicBtn1.checked = chkValue
    indicBtn2.checked = chkValue
    indicBtn3.checked = chkValue
    indicBtn4.checked = chkValue

  })

  indicBtn1.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allIndiccheck.checked = false;
    }
  })

  indicBtn2.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allIndiccheck.checked = false;
    }
  })

  indicBtn3.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allIndiccheck.checked = false;
    }
  })

  indicBtn4.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allIndiccheck.checked = false;
    }
  })

});


const allPartcheck = document.getElementById('partckall');
const partBtn1 = document.getElementById('partner_a');
const partBtn2 = document.getElementById('partner_b');
const partBtn3 = document.getElementById('partner_c');
const partBtn4 = document.getElementById('partner_d');

document.addEventListener('DOMContentLoaded', () => {

  allPartcheck.addEventListener('click', (event)  => {

    const chkValue = event.currentTarget.checked;
    partBtn1.checked = chkValue
    partBtn2.checked = chkValue
    partBtn3.checked = chkValue
    partBtn4.checked = chkValue

  })

  partBtn1.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allPartcheck.checked = false;
    }
  })

  partBtn2.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allPartcheck.checked = false;
    }
  })

  partBtn3.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allPartcheck.checked = false;
    }
  })

  partBtn4.addEventListener('click', (event) => {
    if(event.currentTarget.checked == false){
      allPartcheck.checked = false;
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
    $(".footer").css({"marginTop": "770px"})

    $("#partnerInfor").css({"position":"relative", "right":"501px", "width": "490px"});
    $("#interestInfor").css({"position":"relative", "top":"420px"});

    $(".indexbox1").hide();
    $(".indexbox2").show();
    $(".indexbox2").css({"width":"500px", "height":"875px"});
    $("#allInfor").css({"width":"1500px", "height":"1450px"});

  });

  $("#partner").click(function() {

    $("#interestInfor").hide();
    $("#indicJoinBtn").hide();
    $("#partJoinBtn").show();
    $(".footer").css({"marginTop": "250px"})

    $("#partJoinBtn").css({"display": "block", "position": "relative", "right": "764px", "top": "180px"});

    $("#inficInfor").css({"width": "520px"});
    $("#partnerInfor").css({"position":"relative", "right":"1px"});

    $(".indexbox1").show();
    $(".indexbox2").hide();
    $(".indexbox1").css({"width":"500px", "height":"550px"});
    $("#allInfor").css({"width":"1500px", "height":"1450px"});

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


let indicemail1 = document.getElementById('indicemail1')
let indicemail2 = document.getElementById('indicemail2')
let indicEmailchk = document.getElementById('indicEmailchk')

let partemail1 = document.getElementById('partemail1')
let partemail2 = document.getElementById('partemail2')
let partEmailchk = document.getElementById('partEmailchk')

/*
3. 정규식
- 이메일 정규식(개인)

indicemail1.addEventListener("blur", function(){
  checklndicemail();
})

function checklndicemail(){
  let emailexp=/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

  if(indicEmailBox.value.length == 0){
    indicEmailchk.innerHTML = "* 필수 입력입니다"
  }else if(emailexp.test(indicEmailBox.value)){
    indicEmailchk.innerHTML = " "
  }else{
    indicEmailchk.innerHTML = "* 이메일 주소를 입력하세요"
  }
}

indicemail2.addEventListener("blur", function(){
  checklndicemail1();
})

function checklndicemail1(){
  let emailexp2=/^[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]/

  if(indicemail2.value.length == 0){
    indicEmailchk.innerHTML = "* 필수 입력입니다"
  }else if(emailexp2.test(indicemail2.value)){
    indicEmailchk.innerHTML = " "
  }else{
    indicEmailchk.innerHTML = "* 이메일 주소를 양식에 맞춰 입력하세요"
  }
}

3. 정규식
- 이메일 정규식(파트너)

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
*/


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
    indicPwInput.focus();
  }else if(pwdexp.test(indicPwInput.value)){
    indicPwdChk.innerHTML = " "
  }else{
    indicPwdChk.innerHTML = "* 양식에 맞게 입력하세요"
    indicPwInput.focus();
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
    partPwInput.focus();
  }else if(pwdexp.test(partPwInput.value)){
    partPwdChk.innerHTML = " "
  }else{
    partPwdChk.innerHTML = "* 양식에 맞게 입력하세요"
    partPwInput.focus();
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
  }else if(pwdchkexp.test(indicPwInputCheck.value) && indicPwInput.value == indicPwInputCheck.value){
    indicPwdDoubleChk.innerHTML= " "
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
  }else if(pwdchkexp.test(partPwInputCheck.value) && partPwInput.value == partPwInputCheck.value){
    partPwdDoubleChk.innerHTML= " "
  }else{
    partPwdDoubleChk.innerHTML = "* 동일한 비밀번호를 입력해주세요"
  }
}



/*
3. 정규식
- 휴대폰 번호 정규식(개인)
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
- 휴대폰 번호 정규식(파트너)
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
4. 이메일 합치기
- 개인
*/

let indicEmailBox = document.getElementById("indicEmailBox");

indicemail1.addEventListener("blur", function(){
  indicEmailBox.value = indicemail1.value + "@" + indicemail2.value;

  let indicUrl = "/members/checkUser?email=" + indicEmailBox.value;

  let emailexp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

  if(emailexp.test(indicEmailBox.value)) {
    validateCheckEmail(indicEmailchk, indicUrl, indicDomain, indicemail1);

  } else {
    indicEmailchk.innerHTML = "* 이메일 양식에 맞춰 입력해주세요"
    indicEmailchk.style.color = "red"
  }

})

indicemail2.addEventListener("blur", function(){
  indicEmailBox.value = indicemail1.value + "@" + indicemail2.value;

  let indicUrl = "/members/checkUser?email=" + indicEmailBox.value;

  let emailexp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

  if(emailexp.test(indicEmailBox.value)) {
    validateCheckEmail(indicEmailchk, indicUrl, indicDomain, indicemail1);

  } else {
    indicEmailchk.innerHTML = "* 이메일 양식에 맞춰 입력해주세요"
    indicEmailchk.style.color = "red"
  }

})

/*
4. 이메일 합치기
- 파트너
*/

let partEmailBox = document.getElementById("partEmailBox");
let emailaArr = [];

let emailCheckMsg = "";

for(let i = 1; i < 3 ; i++){
  emailaArr.push(document.getElementById('partemail'+i))
}

for(let i = 0 ; i < emailaArr.length ; i++){
  emailaArr[i].addEventListener("blur", (e) => {
    partEmailBox.value = emailaArr[0].value + "@" + emailaArr[1].value;

    let PartnerUrl = "/members/checkUser?email=" + partEmailBox.value;

    let emailexp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if(emailexp.test(partEmailBox.value)) {
      validateCheckEmail(partEmailchk, PartnerUrl, partDomain, partemail1);

    } else {
      partEmailchk.innerHTML = "* 이메일 양식에 맞춰 입력해주세요"
      partEmailchk.style.color = "red"
    }

  })
}


function validateCheckEmail(target, url, element1, element2){

  fetch(url)
      .then(resp => {

        if(resp.status == 200){ //가입이 가능한 상태

          target.style.color = "green";
          emailCheckMsg = "* 사용 가능한 이메일입니다."

          element1.value = element2.value;
        } else {

          target.style.color = "red";
          emailCheckMsg = "* 중복된 이메일입니다. 다른 값을 입력해주세요."
        }

        target.innerHTML = emailCheckMsg;
      })

}


/*
4. 사업장 도로명 주소 + 상세 주소 합치기
*/

let storePlace = document.getElementById("storePlace");
let storePlaceDetails = document.getElementById("storePlaceDetails");
let storePlaceBox = document.getElementById("storePlaceBox");

storePlace.addEventListener("blur", () => {
  storePlaceBox.value = storePlace.value + " " + storePlaceDetails.value;
})

storePlaceDetails.addEventListener("blur", () => {
  storePlaceBox.value = storePlace.value + " " + storePlaceDetails.value;
})

/*
5. 중복확인 버튼 누르면 중복 검사
- 개인(도메인)
*/


let indicDomain = document.getElementById("indicDomain");
let indicDomainBtn = document.getElementById("indicDomainBtn");
let indicDomainChk = document.getElementById("indicDomainChk");

let domainCheckMsg = "";

indicDomainBtn.addEventListener("click", function (e){
  e.preventDefault();

  let indicDomainUrl = "/members/checkDomain?domain=" + indicDomain.value;

  validateCheckDomain(indicDomainChk, indicDomainUrl);
})

/*
5. 중복확인 버튼 누르면 중복 검사
- 파트너(도메인)
*/

let partDomain = document.getElementById("partDomain");
let partDomainBtn = document.getElementById("partDomainBtn");
let partDomainChk = document.getElementById("partDomainChk");

partDomainBtn.addEventListener("click", function (e){
  e.preventDefault();

  let partDomainUrl = "/members/checkDomain?domain=" + partDomain.value;

  validateCheckDomain(partDomainChk, partDomainUrl);
})

function validateCheckDomain(target, domain) {

  fetch(domain)
      .then(resp => {

        if (resp.status == 200) { //가입이 가능한 상태

          target.style.color = "green";
          domainCheckMsg = "* 사용 가능한 도메인입니다."
        } else {

          target.style.color = "red";
          domainCheckMsg = "* 중복된 도메인입니다. 다른 값을 입력해주세요."
        }

        target.innerHTML = domainCheckMsg;
      })
  }


/*
5. 정규식 + API를 통한 유효성 검사 + 중복확인 버튼 누르면 중복 검사
- 파트너(사업자 등록 번호)
*/

let storeNum = document.getElementById('storeNum');
let storeNumResult = document.getElementById('storeNumChk')


storeNum.addEventListener("blur", function () {

  let partemailexp = /^[0-9]{10}/

  if(partemailexp.test(storeNum.value)){

    let data = {
      "b_no": [storeNum.value] // 사업자번호 "xxxxxxx" 로 조회 시,
    };

    fetch("https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=uKPbZloC9gAvd0Q7bZT6YbeFoc3coVy1AOuez5RdZ2pCuGdGeM%2FKKGW5kwbhddw%2Fl1xTBVU7F9kwGydMPRn9aA%3D%3D", {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(data)
    })
        .then((resp) => resp.json())
        .then(data => {

          if(data.data[0].b_stt_cd == ''){
            storeNumResult.innerHTML = "국세청에 등록되지 않은 사업자입니다.";
            storeNumResult.style.color = "red";

          } else {

            if(data.data[0].b_stt_cd == '01'){
              storeNumResult.innerHTML = "가입 가능합니다. 중복확인을 눌러주세요.";
              storeNumResult.style.color = "green";
            } else if(data.data[0].b_stt_cd === '02' || data.data[0].b_stt_cd === '03') {
              storeNumResult.innerHTML = "현재 휴업하거나 폐업한 사업자입니다.";
              storeNumResult.style.color = "red";
            }
          }
        })

  } else {
    storeNumResult.innerHTML = "* 양식에 맞춰 10개의 숫자를 입력하세요"
  }
})


let storeNumChkBtn = document.getElementById("storeNumChkBtn");
let storeNumCheckMsg = "";

storeNumChkBtn.addEventListener("click", function (e) {

  let storeNumUrl = "/members/checkStoreNum?storeNum=" + storeNum.value;

  duplicateCheckStoreNum(storeNumResult, storeNumUrl);

})


  function duplicateCheckStoreNum(target, num) {

    fetch(num)
        .then(resp => {

          if (resp.status == 200) { //가입이 가능한 상태

            target.style.color = "green";
            storeNumCheckMsg = "* 가입 이력이 없는 사업자 번호입니다."
          } else {

            target.style.color = "red";
            storeNumCheckMsg = "* 이미 가입된 사업자 번호입니다. 재확인 부탁드립니다."
          }

          target.innerHTML = storeNumCheckMsg;
        })
  }

    /*
    7. 선택할 때 css 변화 및 개수 제한 두기
    */

// 변수 선언) let interest1 = document.getElementById('interest1')

    let checkNum = 0;
    let maxCheck = 3;
    let inputArr = document.getElementsByClassName("InterestChkBox");

    for (let i = 1; i < 19; i++) {
      let eventAdd = document.getElementById('interest' + i);

      eventAdd.addEventListener('click', (e) => {

        if (inputArr[i - 1].checked) { // 체크박스가 체크 되어 있을 시
          cssChange(e.target, true)

          return true;
        }

        if (checkNum >= maxCheck) { //3개 이상 체크 되었을때
          alert("나의 관심사는 3개까지 선택 가능합니다.");
          e.preventDefault();

          return false;
        }

        //체크된 것이 3개 이상이 아닐 경우
        cssChange(e.target, false);

      })


    }

// 클릭 시, 컬러 변화
// interest1.addEventListener("click", function(){
//   cssChange(interest1);
// })

    function cssChange(target, action) { //action 으로 하얀색으로 바꿀지 초록색으로 바꿀지 선택

      if (action) { //action이 true로 들어올 시
        // 선택된 것을 해제할 때 클릭함을 의미함. (하얀 배걍 + 검정 글자로 바뀜)

        target.style.color = "black";
        target.style.backgroundColor = "white";
        checkNum--;

      } else { //action이 false,로 들어올 시, 선택하겠다는 것을 의미함. (초록 배경 + 하얀 글자로 바뀜)

        target.style.color = "white";
        target.style.backgroundColor = "rgb(16, 104, 63)";
        checkNum++;

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

    /*
    8. 회원가입 버튼을 클릭했을 때
    중복확인 등이 이뤄지지 않거나 빈칸이 존재할 때 넘어가지 않게 하도록 검사하기(개인)
    */

    let indicJoinBtn = document.getElementById("indicJoinBtn");

    let indicInputList = document.getElementsByClassName("checkIndicInput");
    // inputList는 이미 배열 형태로 만들어짐.

    indicJoinBtn.addEventListener("click", function (e) {

      if(!(indicBtn1.checked && indicBtn2.checked && indicBtn3.checked)) {

        e.preventDefault();
        alert("개인) 필수 동의항목을 모두 체크해주세요")

      } else {

        let inputNum = checkNullInput(indicInputList);

        console.log(inputNum);

        switch (inputNum) {

          case 0 :
            e.preventDefault();
            alert("개인 정보) 성명을 입력해주세요");
            break;

          case 1 :
            e.preventDefault();
            alert("개인 정보) 이메일을 입력해주세요");
            break;

          case 2 :
            e.preventDefault();
            alert("개인 정보) 비밀번호를 입력해주세요");
            break;

          case 3 :
            e.preventDefault();
            alert("개인 정보) 비밀번호 확인란을 입력해주세요");
            break;

          case 4 :
            e.preventDefault();
            alert("개인 정보) 통신사를 선택해주세요");
            break;

          case 5 :
            e.preventDefault();
            alert("개인 정보) 휴대폰 번호를 입력해주세요");
            break;

          case 6 :
            e.preventDefault();
            alert("개인 정보) 홈페이지 주소를 입력해주세요");
            break;
        }
      }
    })

      function checkNullInput(target){

        for(let i= 0; i<target.length; i++){

          if(target[i].value === ''){
            return i;
          }

        }

        return -1;
      }

    /*
    8. 회원가입 버튼을 클릭했을 때
    중복확인 등이 이뤄지지 않거나 빈칸이 존재할 때 넘어가지 않게 하도록 검사하기(파트너)
    */

    let partJoinBtn = document.getElementById("partJoinBtn");
    let partInputList = document.getElementsByClassName("checkpartInput");

    partJoinBtn.addEventListener("click", function (e) {

      if(!(partBtn1.checked && partBtn2.checked && partBtn3.checked)) {

        e.preventDefault();
        alert("파트너) 필수 동의항목을 모두 체크해주세요")

      } else {

        let inputNum = checkNullInput(partInputList);

        switch (inputNum) {

          case 0 :
            e.preventDefault();
            alert("파트너 정보) 이메일을 입력해주세요");
            break;

          case 1 :
            e.preventDefault();
            alert("파트너 정보) 비밀번호를 입력해주세요");
            break;

          case 2 :
            e.preventDefault();
            alert("파트너 정보) 비밀번호 확인란을 입력해주세요");
            break;

          case 3 :
            e.preventDefault();
            alert("파트너 정보) 가게명(법인명)을 입력해주세요");
            break;

          case 4 :
            e.preventDefault();
            alert("파트너 정보) 사업자 등록번호를 선택해주세요");
            break;

          case 5 :
            e.preventDefault();
            alert("파트너 정보) 사업장 소재지를 입력해주세요");
            break;

          case 6 :
            e.preventDefault();
            alert("파트너 정보) 대표자명을 입력해주세요");
            break;

          case 7 :
            e.preventDefault();
            alert("파트너 정보) 담당자명 입력해주세요");
            break;

          case 8 :
            e.preventDefault();
            alert("파트너 정보) 담당자 전화번호를 입력해주세요");
            break;

          case 9 :
            e.preventDefault();
            alert("파트너 정보) 홈페이지 주소를 입력해주세요");
            break;
        }
      }
    })