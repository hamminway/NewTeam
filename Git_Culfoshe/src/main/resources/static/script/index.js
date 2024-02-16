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

//hover
//const icon = document.querySelector("#tar");
//const search = document.querySelectorAll(".main-search");
//
//
//icon.addEventListener('click', ()>= {
//  search.style.color = "#9acd32";
//})

function iconColor() {
    document.querySelectorAll(".tar").style.color="#9acd32";
}

//지역 추천
$('#slider-div').slick({
        infinite: true,
        speed: 300,
        slidesToShow: 3,
        slidesToScroll: 3,
        dots: true
    });
})

  //지도





