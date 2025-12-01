const form = document.getElementById('stockForm');
    const mensaje = document.getElementById('mensaje');
    const btnBorrar = document.getElementById('btnBorrar');

    // Validación al enviar
    form.addEventListener('submit', function(e) {
      e.preventDefault();

      const producto = document.getElementById('producto').value.trim();
      const categoria = document.getElementById('categoria').value;
      const marca = document.getElementById('marca').value;
      const precio_venta = document.getElementById('precio_venta').value;
      const cantidad = document.getElementById('cantidad').value;

      // Validación simple
      if (producto !== "" && categoria !== "" && marca > 0 && precio_venta > 0 && cantidad >= 0) {
        mensaje.textContent = "Consulta realizada correctamente";
        mensaje.className = "Se realizo bien";
      } else {
        mensaje.textContent = "Consulta no realizada";
        mensaje.className = "No se a podido encontar el producto intentelo de nuevo";
      }
    });

    // Botón borrar
    btnBorrar.addEventListener('click', function() {
      form.reset(); 
      mensaje.textContent = ""; 
    });
