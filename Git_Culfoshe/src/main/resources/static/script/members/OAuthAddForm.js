
/* 휴대폰 번호 정규식 */

    let oauthPhoneNum = document.getElementById('oauthPhoneNum')
    let phoneNumChk = document.getElementById('phoneNumChk')

    oauthPhoneNum.addEventListener("blur", function(){
        checkNumber();
    })
    function checkNumber(){
        let phoneExp =/^[0-1]+-[0-9]+-[0-9]/

        if(oauthPhoneNum.value.length == 0){
            phoneNumChk.innerHTML = "* 필수 입력입니다"
        }else if(phoneExp.test(oauthPhoneNum.value)){
            phoneNumChk.innerHTML = " "
        }else{
            phoneNumChk.innerHTML = "* 010 - 0000 - 0000 양식에 맞춰 입력하세요"
        }
    }

/* 홈페이지 주소 중복확인 정규식(이건 이메일 앞 부분 따오기를 하지 않을 예정
    : 카카오에서 이메일을 제대로 된 형태로 제공하지 않기 때문) */

    const oauthDomain = document.querySelector(".oauthDomain");
    const oauthDomainBtn = document.querySelector(".oauthDomainBtn");
    const oauthDomainChk = document.getElementById("oauthDomainChk");

    let domainCheckMsg = "";

    oauthDomainBtn.addEventListener("click", function (){

        let oauthDomainUrl = "/members/checkDomain?domain=" + oauthDomain.value;

        validateCheckDomain(oauthDomainChk, oauthDomainUrl);
    })

    function validateCheckDomain(target, domain){

        fetch(domain).then(resp => {

            if(resp.status == 200){

                target.style.color = "green";
                domainCheckMsg = "* 사용 가능한 도메인입니다.";

            }else{

                target.style.color = "red";
                domainCheckMsg = "* 중복된 도메인입니다. 다른 값을 입력해주세요.";

            }
        })
    }

/* 관심사 3개 선택하기(컬러 변환 + 선택 수 제한(3개) */

    let checkNum = 0;
    let inputArr = document.getElementsByClassName("InterestChkBox");

    for(let i= 1; i < 19; i++){
        let eventAdd = document.getElementById("interest" + i);

        eventAdd.addEventListener("click", (e) => {

            if(inputArr[i-1].checked) {
                colorChange(e.target, false);

                return;
            }


            if(checkNum >= 3){
                alert("나의 관심사는 3개까지 선택 가능합니다.");
                e.preventDefault();

                return;
            }

            colorChange(e.target, true);

        })
    }

    function colorChange(target, action){

        if(action){

            target.style.color = "white";
            target.style.backgroundColor = "rgb(16, 104, 63)";
            checkNum++;

        } else {

            target.style.color = "black";
            target.style.backgroundColor = "white";
            checkNum--;

        }
    }

/* 관심 지역 3개 선택 제한하기 */
    let areaCheckNum = 0;

    function selectLimitArea(target) {
        if (target.checked) {
            areaCheckNum++;
        } else {
            areaCheckNum--;
        }

        if (areaCheckNum > 3) {
            alert("관심 지역은 최대 3곳까지 선택이 가능합니다.");
            target.checked = false;
            areaCheckNum--;
        }
    }


