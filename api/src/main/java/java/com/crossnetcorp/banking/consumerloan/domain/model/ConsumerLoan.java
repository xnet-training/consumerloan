package com.crossnetcorp.banking.consumerloan.domain.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ianache
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerLoan implements Serializable {
    private String id;
    private String clienteId;
    private String productoId;
    private String solicitudId;
    /**
     * Capital solicitado por el cliente
     */
    private Double ammount;
    /**
     * Cantidad de cuotas a pagar
     */
    private Integer cuotas;
    /**
     * Tasa de interés efectiva anual (se encuentra en el producto definido productId)
     */
    private Double tasaEfectivaAnual;
    /**
     * Monto de los intereses
     */
    private Double intereses;
    /**
     * Monto de la cuota
     */
    private Double montoCuota;
}

