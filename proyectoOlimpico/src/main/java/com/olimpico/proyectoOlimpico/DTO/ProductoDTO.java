package com.olimpico.proyectoOlimpico.DTO;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductoDTO {

    private String nombreProducto;

    private BigDecimal precioVenta;

    private BigDecimal costoUnitario;

    private Integer stockActual;

    private String estado;
}
