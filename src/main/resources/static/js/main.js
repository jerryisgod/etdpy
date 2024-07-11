/**PY放大 */
document.addEventListener('DOMContentLoaded', (event) => {
  const loginImage = document.getElementById('loginImage');

  loginImage.addEventListener('mouseover', function() {
    loginImage.src = 'images/PY.png';
    loginImage.classList.add('hovered');
  });

  loginImage.addEventListener('mouseout', function() {
    loginImage.src = 'images/ANAL.jpg';
    loginImage.classList.remove('hovered');
  });
});
/** */
document.addEventListener('DOMContentLoaded', function() {
    var images = [
        "images/AV02.gif",
        "images/AV03.gif",
        "images/messageImage_1711887769690.jpg",
        "images/AV01.gif"
    ];

    var currentIndex = 0;
    var slideshow = document.getElementById("slideshow");

    function changeImage() {
        if (slideshow) { // 检查 slideshow 是否存在
            slideshow.src = images[currentIndex];
            currentIndex = (currentIndex + 1) % images.length;
        }
    }

    setInterval(changeImage, 3000);
});
