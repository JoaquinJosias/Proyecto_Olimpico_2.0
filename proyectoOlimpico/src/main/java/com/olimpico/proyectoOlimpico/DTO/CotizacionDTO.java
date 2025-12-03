package com.olimpico.proyectoOlimpico.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CotizacionDTO {
    private Long idCotizacion;
    // código del proveedor tal como lo envía el cliente (ej: "PR001")
    private String idProveedor;
    private Date fecha;
    private Date vigencia;
    private BigDecimal subtotal;
    private BigDecimal igv;
    private BigDecimal total;
}
