// Obtén los botones del carrusel y los elementos del carrusel
var prevButton = document.querySelector('.carousel-control-prev');
var nextButton = document.querySelector('.carousel-control-next');
var carouselItems = document.querySelectorAll('.carousel-item');

// Inicia el índice en 0
var currentIndex = 0;

// Agrega un event listener al botón "prev"
prevButton.addEventListener('click', function() {
    // Calcula el índice del elemento que está entrando y el que está saliendo
    var exitingIndex = currentIndex;
    currentIndex = (currentIndex - 1 + carouselItems.length) % carouselItems.length;
    var enteringIndex = currentIndex;
    
    // Obtén el elemento del carrusel que está entrando y el que está saliendo
    var enteringItem = carouselItems[enteringIndex];
    var exitingItem = carouselItems[exitingIndex];
    
    // Cambia las clases de los elementos
    enteringItem.classList.remove('inactive');
    enteringItem.classList.add('active');
    exitingItem.classList.remove('active');
    exitingItem.classList.add('inactive');
});

// Agrega un event listener al botón "next"
nextButton.addEventListener('click', function() {
    // Calcula el índice del elemento que está entrando y el que está saliendo
    var exitingIndex = currentIndex;
    currentIndex = (currentIndex + 1) % carouselItems.length;
    var enteringIndex = currentIndex;
    
    // Obtén el elemento del carrusel que está entrando y el que está saliendo
    var enteringItem = carouselItems[enteringIndex];
    var exitingItem = carouselItems[exitingIndex];
    
    // Cambia las clases de los elementos
    enteringItem.classList.remove('inactive');
    enteringItem.classList.add('active');
    exitingItem.classList.remove('active');
    exitingItem.classList.add('inactive');
});