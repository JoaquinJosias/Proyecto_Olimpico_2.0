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