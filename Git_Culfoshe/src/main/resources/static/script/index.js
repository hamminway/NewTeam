//메인 슬라이더
$(document).ready(function() {

    $('.center').slick({
        dots: true,
        centerMode: true,
        centerPadding: '60px',
        slidesToShow: 1,
        responsive: [
          {
            breakpoint: 768,
            settings: {
              arrows: false,
              centerMode: true,
              centerPadding: '40px',
              slidesToShow: 1
            }
          },
          {
            breakpoint: 480,
            settings: {
              arrows: false,
              centerMode: true,
              centerPadding: '40px',
              slidesToShow: 1
            }
          }
        ]
      });

//delete 검색창 내용 삭제
const pull = document.getElementsByClassName('main-search-int');
const deleteBtn = document.getElementById('deleteBtn');

deleteBtn.addEventListener('click', (e)=>{
    pull[0].value='';
})



//지역 추천
$('#slider-div').slick({
        infinite: true,
        speed: 300,
        slidesToShow: 3,
        slidesToScroll: 3,
        dots: true
    });
})

//지역 선택 시 해당 게시글로
const reg = document.getElementsByClassName('commend-header');
const commend = document.getElementById('reg-box');


//지도





