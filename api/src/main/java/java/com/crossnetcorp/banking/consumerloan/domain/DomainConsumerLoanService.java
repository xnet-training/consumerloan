package com.crossnetcorp.banking.consumerloan.domain;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.crossnetcorp.banking.consumerloan.domain.model.ConsumerLoan;

/**
 *
 * @author ianache
 */
@Repository
public interface DomainConsumerLoanService {

    /**
     * Retorna un listado de ConsumerLoans
     *
     * @return listado de ConsumerLoan
     * @see ConsumerLoan
     */
    List<ConsumerLoan> listarConsumerLoan();

    /**
     * Registra una nueva ConsumerLoan
     *
     * @param consumerLoan Datos de ConsumerLoan a registrar
     * @return ConsumerLoan registrada
     * @see ConsumerLoan
     */
    ConsumerLoan registrarConsumerLoan(ConsumerLoan consumerLoan);

}
