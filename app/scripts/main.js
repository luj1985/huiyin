$(function() {
  const $navigator = $('header.resizable');
  const $window = $(window);
  const $jumbotron = $('.jumbotron');

  // $('#fullpage').fullpage({
  //   scrollBar: true,
  //   onLeave : (index, nextIndex, direction) => {
  //     $navigator.toggleClass('smaller', index === 1);
  //   }
  // });
  $jumbotron.height($window.height());

  $window.on('scroll', () => {
    $navigator.toggleClass('smaller', $window.scrollTop() > 300);
  });

  $window.on('resize', () => {
    $jumbotron.height($(window).height());
  })

  $('#home').on('click', (e) => {
    e.preventDefault();
    $.fn.fullpage.moveSectionUp();
  });

  $('#about').on('click', (e) => {
    e.preventDefault();
    $.fn.fullpage.moveSectionDown();
  });
})
