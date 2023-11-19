package com.crossnetcorp.banking.consumerloan.application;


import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Application;

import org.springframework.stereotype.Service;

import com.crossnetcorp.banking.consumerloan.application.model.ConsumerLoanDTO;

/**
 *
 * @author ianache
 */
@Service
public interface ApplicationConsumerLoanService {

        /**
         * Retorna un listado de ConsumerLoan
         * @return 
         */
        List<ConsumerLoanDTO> listarConsumerLoan() throws ApplicationException;

        /**
         * Obtiene un crédito de consumo de acuerdo con su código unico de identificacion.
         * @param loanId
         * @return
         * @throws ApplicationException
        
        ConsumerLoadDTO getConsumerLoan(String loanId) throws ApplicationException;

        /**
         * Registra una nueva ConsumerLoan
         * @param id
         * @param description
         * @param estado
         * @param fecha
         * @return 
         */
        /**
         * Registra una nueva Credito de Consumo respaldado en Joyas
         * 
         * @param partyId
         * @param productId
         * @param requestId
         * @param monto
         * @param cuotas
         * @return
         * @throws ApplicationException
         */
        ConsumerLoanDTO registrarConsumerLoan(String partyId,
                String productId,
                String requestId,
                Double monto,
                Integer cuotas)  throws ApplicationException;
}
