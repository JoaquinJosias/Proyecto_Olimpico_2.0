document.addEventListener('DOMContentLoaded',()=>{
    const platos = document.querySelectorAll('.plato');
    platos.forEach(plato => {
        
        const sumarBtn =  plato.querySelector('.agregar');
        const restarBtn = plato.querySelector('.eliminar');
        const cantidadSpan = plato.querySelector('.cantidad');
        let cantidad = 0;

        sumarBtn.addEventListener('click', () =>{
            cantidad++;
            cantidadSpan.textContent = cantidad;

        });

        restarBtn.addEventListener('click',() =>{
            if(cantidad > 0){
            cantidad--;
            cantidadSpan.textContent = cantidad;
            }
        });
        
        
    });
});