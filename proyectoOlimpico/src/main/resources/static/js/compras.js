// script.js - validaciones simples para Registro de Facturas de Compra
document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('formFactura');
  const mensaje = document.getElementById('mensaje');

  const fechaEl = document.getElementById('fecha_emision');
  const tipoEl = document.getElementById('tipo_comprobante');
  const numeroEl = document.getElementById('numero_factura');
  const rucEl = document.getElementById('ruc_factura');

  // util: mostrar mensajes (error | success)
  function showMessage(text, type = 'error') {
    mensaje.textContent = text;
    mensaje.style.color = type === 'error' ? 'crimson' : 'green';
    if (type === 'success') {
      setTimeout(() => { mensaje.textContent = ''; }, 3000);
    }
  }

  // valida RUC peruano simple: 11 dígitos numéricos
  function validarRUC(ruc) {
    return /^\d{11}$/.test(ruc);
  }

  // valida número factura (no vacío)
  function validarNumeroFactura(num) {
    return String(num).trim().length > 0;
  }

  // convierte la fecha (input type=date) a dd/mm/aaaa para mostrar en payload
  function formatDateToDDMMYYYY(dateValue) {
    if (!dateValue) return '';
    // dateValue por lo general es 'YYYY-MM-DD'
    const parts = dateValue.split('-');
    if (parts.length !== 3) return dateValue;
    return `${parts[2]}/${parts[1]}/${parts[0]}`;
  }

  form.addEventListener('submit', (e) => {
    e.preventDefault();
    mensaje.textContent = '';

    // Validaciones
    if (!fechaEl.value) {
      showMessage('La fecha de emisión es obligatoria.', 'error');
      fechaEl.focus();
      return;
    }

    if (!tipoEl.value) {
      showMessage('Seleccione un tipo de comprobante.', 'error');
      tipoEl.focus();
      return;
    }

    if (!validarNumeroFactura(numeroEl.value)) {
      showMessage('Ingrese el número de factura.', 'error');
      numeroEl.focus();
      return;
    }

    if (!validarRUC(rucEl.value)) {
      showMessage('Ingrese un RUC válido (11 dígitos).', 'error');
      rucEl.focus();
      return;
    }

    // Si pasa validación, preparamos payload
    const payload = {
      fecha_emision: formatDateToDDMMYYYY(fechaEl.value),
      tipo_comprobante: tipoEl.value,
      numero_factura: numeroEl.value.trim(),
      ruc_factura: rucEl.value.trim()
    };

    console.log('Factura a registrar:', payload);
    showMessage('Factura registrada correctamente.', 'success');

    // Opcional: limpiar formulario después de un registro exitoso
    // form.reset();
  });

  // Botón Limpiar
  document.getElementById('btnLimpiar').addEventListener('click', () => {
    form.reset();
    mensaje.textContent = '';
  });
});
