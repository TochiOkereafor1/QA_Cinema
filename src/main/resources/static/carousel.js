const track = document.querySelector('.carousel_track');
const slides = Array.from(track.children);
const nextButton = document.querySelector('.carousel_button--right');
const previousButton = document.querySelector('.carousel_button--left');
const dotsNav = document.querySelector('.carousel_nav');
const dots = Array.from(dotsNav.children);

const slideWidth = slides[0].getBoundingClientRect().width;

//get slides to be next to each other

const setSlidePosition = (slide, index) => {
    slide.style.left = slideWidth * index + 'px';

};
slides.forEach(setSlidePosition);

// const moveToSlide = (track, currentSlide, targetSlide) => {
//     track.style.transform = 'translateX(-' + targetSlide.style.left + ')';
//     currentSlide.classList.remove('current-slide');
//     targetSlide.classList.add('current-slide');

// }

// previousButton.addEventListener('click', e => {
//     const currentSlide = track.querySelector('.current-slide');
//     const previousSlide = currentSlide.previousElementSibling;
    
//     moveToSlide(track, currentSlide, previousSlide);
// })


//slides move to the right when right arrow clicked
nextButton.addEventListener('click', e => {
    const currentSlide = track.querySelector('.current-slide');
   console.log(currentSlide);
    // const nextSlide = currentSlide.nextElementSibling;
    
    // moveToSlide(track, currentSlide, nextSlide);
})
