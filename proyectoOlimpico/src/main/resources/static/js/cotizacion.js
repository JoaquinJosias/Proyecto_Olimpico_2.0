let contador = 0;

document.getElementById("btnAgregar").addEventListener("click", agregarProducto);
document.getElementById("formCotizacion").addEventListener("submit", registrarCotizacion);

function agregarProducto() {
    contador++;

    const container = document.getElementById("productosContainer");

    const div = document.createElement("div");
    div.classList.add("producto-item");
    div.setAttribute("id", `prod-${contador}`);

    div.innerHTML = `
        <button class="remove-btn" onclick="eliminarProducto('${contador}')">X</button>

        <div class="form-group">
            <label>Producto</label>
            <select class="producto">
                <option value="">Seleccione...</option>
                <option value="P001">Producto 1</option>
                <option value="P002">Producto 2</option>
                <option value="P003">Producto 3</option>
            </select>
        </div>

        <div class="row">
            <div class="form-group">
                <label>Cantidad</label>
                <input type="number" class="cantidad" value="1" min="1">
            </div>

            <div class="form-group">
                <label>Precio unitario</label>
                <input type="number" class="precio" value="0" min="0" step="0.01">
            </div>
        </div>

        <div class="total-item">
            <span>Total:</span>
            <span class="totalProd">S/ 0.00</span>
        </div>
    `;

    container.appendChild(div);

    div.querySelector(".cantidad").addEventListener("input", calcular);
    div.querySelector(".precio").addEventListener("input", calcular);
}

function eliminarProducto(id) {
    document.getElementById(`prod-${id}`).remove();
    calcular();
}

function calcular() {
    let subtotal = 0;

    document.querySelectorAll(".producto-item").forEach(item => {
        const cantidad = parseFloat(item.querySelector(".cantidad").value);
        const precio = parseFloat(item.querySelector(".precio").value);
        const total = cantidad * precio;

        item.querySelector(".totalProd").innerText = `S/ ${total.toFixed(2)}`;
        subtotal += total;
    });

    const igv = subtotal * 0.18;
    const totalFinal = subtotal + igv;

    document.getElementById("lblSubtotal").innerText = `S/ ${subtotal.toFixed(2)}`;
    document.getElementById("lblIGV").innerText = `S/ ${igv.toFixed(2)}`;
    document.getElementById("lblTotal").innerText = `S/ ${totalFinal.toFixed(2)}`;
}

function registrarCotizacion(e) {
    e.preventDefault();

    const proveedor = document.getElementById("proveedor").value;
    const fecha = document.getElementById("fecha").value;
    const vigencia = document.getElementById("vigencia").value;

    if (!proveedor || !fecha || !vigencia) {
        mostrarMensaje("Complete todos los campos obligatorios.", "red");
        return;
    }

    if (document.querySelectorAll(".producto-item").length === 0) {
        mostrarMensaje("Debe agregar al menos un producto.", "red");
        return;
    }

    // MENSAJE EN LA PÁGINA
    mostrarMensaje("Cotización registrada correctamente.", "green");

    // AGREGADO: MOSTRAR LISTA COMPLETA EN CONSOLA
    const productos = [];

    document.querySelectorAll(".producto-item").forEach(item => {
        productos.push({
            producto: item.querySelector(".producto").value,
            cantidad: item.querySelector(".cantidad").value,
            precio: item.querySelector(".precio").value,
            total: item.querySelector(".totalProd").innerText
        });
    });

    const cotizacionCompleta = {
        proveedor,
        fecha,
        vigencia,
        productos
    };

    console.log("==== Cotización registrada ====");
    console.log(cotizacionCompleta);
}

function mostrarMensaje(texto, color) {
    const msg = document.getElementById("mensaje");
    msg.style.color = color;
    msg.innerText = texto;

    setTimeout(() => msg.innerText = "", 3000);
}
