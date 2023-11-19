package com.crossnetcorp.banking.consumerloan.infrastructure.model.mysql;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author ccolome
 */
@Entity
@Table(name = "tb_consumerloan")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerLoanTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private Integer estado;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", updatable = false)
    private Date fecha;
}
