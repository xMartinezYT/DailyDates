


// Permite ver si el elemento de texto esta en pantalla

document.addEventListener('DOMContentLoaded', function() {
  var isInViewport = function(elem) {
    var bounding = elem.getBoundingClientRect();
    return (
        bounding.top >= 0 &&
        bounding.left >= 0 &&
        bounding.bottom <= (window.innerHeight || document.documentElement.clientHeight) 
    );
  };

// Coge el elemento de texto y le aplica la animacion al pasar por delante

    var elem = document.querySelector('.text-containersegundo');

    window.addEventListener('scroll', function(event) {
      if (isInViewport(elem)) {
        elem.classList.add('animate__bounceIn');
      } else {
        elem.classList.remove('animate__bounceIn');
      }
    }, false);
  })


// Permite ver si el elemento de texto esta en pantalla


document.addEventListener('DOMContentLoaded', function() {
    var isInViewport = function(elem) {
      var bounding = elem.getBoundingClientRect();
      return (
          bounding.top >= 0 &&
          bounding.left >= 0 &&
          bounding.bottom <= (window.innerHeight || document.documentElement.clientHeight) 
      );
    };


    
// Coge el elemento de texto y le aplica la animacion al pasar por delante

    var elem = document.querySelector('.text-containerprincipio');

    window.addEventListener('scroll', function(event) {
      if (isInViewport(elem)) {
        elem.classList.add('animate__flash');
      } else {
        elem.classList.remove('animate__flash');
      }
    }, false);
  })
  
// Permite ver si el elemento de texto esta en pantalla

document.addEventListener('DOMContentLoaded', function() {
  var isInViewport = function(elem) {
    var bounding = elem.getBoundingClientRect();
    return (
        bounding.top >= 0 &&
        bounding.left >= 0 &&
        bounding.bottom <= (window.innerHeight || document.documentElement.clientHeight) 
    );
  };





    var elem = document.querySelector('.text-containercontacto');

    window.addEventListener('scroll', function(event) {
      if (isInViewport(elem)) {
        elem.classList.add('animate__flash');
      } else {
        elem.classList.remove('animate__flash');
      }
    }, false);



});

function enviar(){
  
 var  nombreIntroducido = document.getElementById('nombre').value ;


  alert("Datos enviados con exito" + " " + nombreIntroducido );

}



