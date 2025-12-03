// PRODUCTOS DE EJEMPLO (simulación de base de datos)
const productos = [
    { producto: "Pescado Lenguado", categoria: "pescados", marca: "Pesquera Sur", precio: 25.00, cantidad: 40 },
    { producto: "Pescado Lisa", categoria: "pescados", marca: "Pesquera Norte", precio: 18.00, cantidad: 30 },
    { producto: "Pulpo", categoria: "mariscos", marca: "MarAzul", precio: 35.00, cantidad: 20 },
    { producto: "Calamar", categoria: "mariscos", marca: "MarAzul", precio: 28.00, cantidad: 25 },
    { producto: "Limón", categoria: "vegetales", marca: "AgroPerú", precio: 2.50, cantidad: 200 },
    { producto: "Cebolla Roja", categoria: "vegetales", marca: "AgroSur", precio: 1.20, cantidad: 150 },
    { producto: "Leche Evaporada", categoria: "lacteos", marca: "Gloria", precio: 4.50, cantidad: 60 },
    { producto: "Aceite Vegetal", categoria: "condimentos", marca: "Primor", precio: 8.50, cantidad: 80 },
    { producto: "Inka Kola 1L", categoria: "bebidas", marca: "Coca Cola", precio: 5.00, cantidad: 50 }
];

const cuerpoTabla = document.getElementById("cuerpoTabla");
const btnConsultar = document.getElementById("btnConsultar");
const btnBorrar = document.getElementById("btnBorrar");

// Mostrar datos iniciales
function cargarTabla(data) {
    cuerpoTabla.innerHTML = ""; // limpiar

    data.forEach(item => {
        const fila = `
            <tr>
                <td>${item.producto}</td>
                <td>${item.categoria}</td>
                <td>${item.marca}</td>
                <td>S/. ${item.precio.toFixed(2)}</td>
                <td>${item.cantidad}</td>
            </tr>
        `;
        cuerpoTabla.innerHTML += fila;
    });
}

// Filtrar la tabla
function filtrarStock() {
    const filtroProducto = document.getElementById("producto").value.toLowerCase();
    const filtroCategoria = document.getElementById("categoria").value;
    const filtroMarca = document.getElementById("marca").value.toLowerCase();

    const resultados = productos.filter(p =>
        p.producto.toLowerCase().includes(filtroProducto) &&
        (filtroCategoria === "" || p.categoria === filtroCategoria) &&
        p.marca.toLowerCase().includes(filtroMarca)
    );

    cargarTabla(resultados);
}

// Evento buscar
btnConsultar.addEventListener("click", filtrarStock);

// Evento borrar
btnBorrar.addEventListener("click", () => {
    document.getElementById("stockForm").reset();
    cargarTabla(productos);
});

// Cargar datos al entrar
cargarTabla(productos);