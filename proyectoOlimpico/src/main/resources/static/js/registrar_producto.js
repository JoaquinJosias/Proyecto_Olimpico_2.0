// Script simple para manejo del formulario de registrar producto
document.addEventListener('DOMContentLoaded', () => {
  // selectors — asegura que estos IDs existan en tu HTML
  const form = document.getElementById('formProducto');
  const mensaje = document.getElementById('mensaje'); // crea un elemento <div id="mensaje"></div> en tu HTML si no existe

  if (!form) {
    console.error('No se encontró el formulario con id "formProducto". Verifica el HTML.');
    return;
  }
  if (!mensaje) {
    console.warn('No se encontró el elemento "mensaje". Crealo para mostrar mensajes al usuario.');
  }

  function mostrarMensaje(text, tipo = 'ok'){
    if (mensaje) {
      mensaje.textContent = text;
      mensaje.style.color = tipo === 'ok' ? '' : 'crimson';
      setTimeout(()=>{ mensaje.textContent = ''; }, 4000);
    } else {
      // fallback a console si no hay elemento mensaje
      console.log(`[${tipo}] ${text}`);
    }
  }

  form.addEventListener('submit', (e) => {
    e.preventDefault();

    // Validaciones básicas
    const aceptaEl = document.getElementById('acepta');
    const acepta = aceptaEl ? aceptaEl.checked : false;
    const nombreInput = document.getElementById('nombre_producto');
    const nombre = nombreInput ? nombreInput.value.trim() : '';

    if(!acepta){
      mostrarMensaje('Debes aceptar los términos y condiciones.', 'error');
      return;
    }

    if(!nombre){
      mostrarMensaje('El nombre del producto es obligatorio.', 'error');
      if (nombreInput) nombreInput.focus();
      return;
    }

    // Recolectar datos
    const payload = {
      id_familia: document.getElementById('id_familia')?.value.trim() || null,
      id_marca: document.getElementById('id_marca')?.value.trim() || null,
      nombre_producto: nombre,
      precio_venta: parseFloat(document.getElementById('precio_venta')?.value) || 0,
      costo_unitario: parseFloat(document.getElementById('costo_unitario')?.value) || 0,
      stock_actual: parseInt(document.getElementById('stock_actual')?.value, 10) || 0,
      unidad_medida: document.getElementById('unidad_medida')?.value.trim() || null,
      estado: document.getElementById('estado')?.value || null
    };

    // Para demo: sólo mostramos el payload en consola y mensaje de éxito
    console.log('Payload producto:', payload);
    mostrarMensaje('Producto registrado correctamente');
    form.reset();
  });
});
