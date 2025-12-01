
document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('formPedido');
  const mensaje = document.getElementById('mensaje');


  const cantidadEl = document.getElementById('cantidad');
  const precioEl = document.getElementById('precio_unitario');
  const subtotalEl = document.getElementById('subtotal_item');

 
  const igvEl = document.getElementById('igv');
  const totalEl = document.getElementById('total');

  const IGV_RATE = 0.18;

  const nombreProveedor = document.getElementById('proveedor_nombre');
  const emailProveedor = document.getElementById('proveedor_email');


  function formatCurrency(value) {
    const n = Number(value) || 0;
    return 'S/ ' + n.toFixed(2);
  }

  function calcularTotales() {
    const cantidad = parseFloat(cantidadEl.value) || 0;
    const precio = parseFloat(precioEl.value) || 0;
    const subtotal = cantidad * precio;
    subtotalEl.value = formatCurrency(subtotal);

    const igv = subtotal * IGV_RATE;
    const total = subtotal + igv;

    igvEl.value = formatCurrency(igv);
    totalEl.value = formatCurrency(total);

    return { subtotal, igv, total };
  }

  cantidadEl.addEventListener('input', calcularTotales);
  precioEl.addEventListener('input', calcularTotales);


  function validarEmail(email) {
 
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
  }

  function showMessage(text, type = 'error') {
    mensaje.textContent = text;
    mensaje.style.color = type === 'error' ? 'crimson' : 'green';
    if (type !== 'error') {
      setTimeout(() => { mensaje.textContent = ''; }, 3000);
    }
  }

  form.addEventListener('submit', (e) => {
    e.preventDefault();

    
    mensaje.textContent = '';

    
    if (!nombreProveedor.value.trim()) {
      showMessage('El nombre del proveedor es obligatorio.', 'error');
      nombreProveedor.focus();
      return;
    }

    if (!emailProveedor.value.trim() || !validarEmail(emailProveedor.value.trim())) {
      showMessage('Ingrese un correo válido.', 'error');
      emailProveedor.focus();
      return;
    }

   
    const cantidad = parseFloat(cantidadEl.value);
    const precio = parseFloat(precioEl.value);

    if (isNaN(cantidad) || cantidad < 0) {
      showMessage('La cantidad debe ser un número igual o mayor a 0.', 'error');
      cantidadEl.focus();
      return;
    }

    if (isNaN(precio) || precio < 0) {
      showMessage('El precio unitario debe ser un número igual o mayor a 0.', 'error');
      precioEl.focus();
      return;
    }

   
    const { subtotal, igv, total } = calcularTotales();
    const payload = {
      proveedor: {
        nombre: nombreProveedor.value.trim(),
        email: emailProveedor.value.trim()
      },
      detalle: document.getElementById('detalle').value.trim(),
      item: {
        unidad: document.getElementById('unidad').value,
        cantidad: cantidad,
        precio_unitario: precio,
        subtotal: subtotal
      },
      resumen: { igv: igv, total: total }
    };

    
    console.log('Pedido a guardar:', payload);
    showMessage('Pedido guardado correctamente.', 'success');

  
  });


  document.getElementById('btnCancelar').addEventListener('click', () => {
    form.reset();
    calcularTotales();
    mensaje.textContent = '';
  });

  
  calcularTotales();
});
