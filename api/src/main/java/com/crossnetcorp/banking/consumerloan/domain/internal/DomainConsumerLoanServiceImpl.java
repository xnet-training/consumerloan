/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossnetcorp.banking.consumerloan.domain.internal;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.crossnetcorp.banking.consumerloan.domain.DomainConsumerLoanRepository;
import com.crossnetcorp.banking.consumerloan.domain.DomainConsumerLoanService;
import com.crossnetcorp.banking.consumerloan.domain.model.ConsumerLoan;

/**
 *
 * @author ianache
 */
@Slf4j
@Service
public class DomainConsumerLoanServiceImpl implements DomainConsumerLoanService {

    @Autowired
    @Qualifier("MYSQL")
    private DomainConsumerLoanRepository domainConsumerLoanRepositoryMYSQL;
    
    /**
     * Retorna un listado de ConsumerLoans
     *
     * @return listado de ConsumerLoan
     * @see DomainConsumerLoanService#listarConsumerLoan
     */
    @Override
    public List<ConsumerLoan> listarConsumerLoan() {
        log.debug("INICIO PROCESAMIENTO DE LISTAR ConsumerLoan");
        List<ConsumerLoan> consumerLoans = domainConsumerLoanRepositoryMYSQL.listarConsumerLoan();
        log.debug("FIN PROCESAMIENTO DE LISTAR ConsumerLoan");
        return consumerLoans;
    }

    /**
     * Registra una nueva ConsumerLoan
     *
     * @param ConsumerLoan Datos de ConsumerLoan a registrar
     * @return ConsumerLoan registrada
     * @see DomainConsumerLoanService#registrarConsumerLoan
     */
    @Override
    public ConsumerLoan registrarConsumerLoan(ConsumerLoan consumerLoan) {
        log.debug("INICIO PROCESAMIENTO DE REGISTRAR ConsumerLoan");
        log.debug(consumerLoan.toString());
        consumerLoan = domainConsumerLoanRepositoryMYSQL.registrarConsumerLoan(consumerLoan);
        log.debug("FIN PROCESAMIENTO DE REGISTRAR ConsumerLoan");
        return consumerLoan;
    }

}
