$(function() {
  const $navigator = $('header.resizable');

  $('#fullpage').fullpage({
    scrollBar: true,
    onLeave : (index, nextIndex, direction) => {
      $navigator.toggleClass('smaller', index === 1);
    }
  });

  $('#home').on('click', (e) => {
    e.preventDefault();
    $.fn.fullpage.moveSectionUp();
  });

  $('#about').on('click', (e) => {
    e.preventDefault();
    $.fn.fullpage.moveSectionDown();
  });
})
