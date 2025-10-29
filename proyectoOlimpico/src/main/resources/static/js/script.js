const contenedor = document.querySelector(".contenedor");
const loginLink = document.querySelector(".login-link");
const registerLink = document.querySelector(".register-link");
const btn = document.querySelector(".btnLogin");
const iconoCerrar = document.querySelector(".icono-cerrar");

registerLink.addEventListener("click", () => {
    contenedor.classList.add("active");
});

loginLink.addEventListener("click", () => {
    contenedor.classList.remove("active");
});

btn.addEventListener("click", () => {
    contenedor.classList.add("active-popup");
});

iconoCerrar.addEventListener("click", () => {
    contenedor.classList.remove("active-popup");
});

/*----------------------------------------------------------
--------------------------------------------------------------*/

/* ---------- Carrusel de promociones (vanilla JS) ---------- */
(function () {
  const container = document.getElementById('promotionsCarousel');
  if (!container) return; // no existe el carousel en esta página

  const track = container.querySelector('.carousel-track');
  const slides = Array.from(track.children);
  const prevBtn = container.querySelector('.carousel-btn.left');
  const nextBtn = container.querySelector('.carousel-btn.right');
  const indicatorsContainer = container.querySelector('.carousel-indicators');

  let currentIndex = 0;
  let isDragging = false;
  let startPos = 0;
  let currentTranslate = 0;
  let prevTranslate = 0;
  let animationID = 0;

  // Crear indicadores dinámicamente
  slides.forEach((_, i) => {
    const btn = document.createElement('button');
    btn.classList.toggle('active', i === 0);
    btn.setAttribute('aria-label', `Ir a promoción ${i+1}`);
    btn.addEventListener('click', () => goToSlide(i));
    indicatorsContainer.appendChild(btn);
  });
  const indicators = Array.from(indicatorsContainer.children);

  function update() {
    const translateX = -currentIndex * 100;
    track.style.transform = `translateX(${translateX}%)`;
    indicators.forEach((b, i) => b.classList.toggle('active', i === currentIndex));
  }

  function prev() {
    currentIndex = (currentIndex - 1 + slides.length) % slides.length;
    update();
  }
  function next() {
    currentIndex = (currentIndex + 1) % slides.length;
    update();
  }
  function goToSlide(i) {
    currentIndex = i;
    update();
  }

  // Botones
  prevBtn.addEventListener('click', prev);
  nextBtn.addEventListener('click', next);

  // Teclado
  window.addEventListener('keydown', (e) => {
    if (e.key === 'ArrowLeft') prev();
    if (e.key === 'ArrowRight') next();
  });

  // Touch / Mouse drag (simple)
  track.addEventListener('pointerdown', pointerDown);
  track.addEventListener('pointerup', pointerUp);
  track.addEventListener('pointerleave', pointerUp);
  track.addEventListener('pointermove', pointerMove);

  function pointerDown(e) {
    isDragging = true;
    startPos = e.clientX;
    track.style.transition = 'none';
  }
  function pointerMove(e) {
    if (!isDragging) return;
    const currentPosition = e.clientX;
    const diff = currentPosition - startPos;
    const percent = (diff / container.clientWidth) * 100;
    track.style.transform = `translateX(${ -currentIndex * 100 + percent }%)`;
  }
  function pointerUp(e) {
    if (!isDragging) return;
    isDragging = false;
    track.style.transition = ''; // restaurar transición
    const endPos = e.clientX;
    const diff = endPos - startPos;
    const threshold = container.clientWidth * 0.12; // 12% de ancho para cambiar
    if (diff > threshold) {
      prev();
    } else if (diff < -threshold) {
      next();
    } else {
      update(); // vuelve a la posición actual
    }
  }

  // Si el usuario quiere reemplazar imágenes dinámicamente: observador simple de atributos
  // (puedes eliminar esta parte si no la necesitas)
  const imgs = container.querySelectorAll('img');
  imgs.forEach(img => {
    img.addEventListener('error', () => {
      // si falla la carga, mostrar una marca neutra
      img.src = '/img/banner-1.png';
    });
  });

  // inicializa vista
  update();
})();

