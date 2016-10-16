$(function() {
  const $navigator = $('header.resizable');
  const $window = $(window);
  const $jumbotron = $('.jumbotron');


  $jumbotron.height($window.height());

  $window.on('scroll', () => {
    $navigator.toggleClass('smaller', $window.scrollTop() > 300);
  });

  $window.on('resize', () => {
    $jumbotron.height($(window).height());
  })

  // smooth anchor scroll
  $('a[href*="#"]:not([href="#"])').click(function() {
    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
      if (target.length) {
        $('html, body').animate({
          scrollTop: target.offset().top
        }, 500);
        return false;
      }
    }
  });
})
