package com.crossnetcorp.banking.consumerloan.application.internal;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossnetcorp.banking.consumerloan.application.ApplicationConsumerLoanService;
import com.crossnetcorp.banking.consumerloan.application.ApplicationException;
import com.crossnetcorp.banking.consumerloan.application.mappers.ApplicationConsumerLoanMapper;
import com.crossnetcorp.banking.consumerloan.application.model.ConsumerLoanDTO;
import com.crossnetcorp.banking.consumerloan.domain.DomainConsumerLoanService;
import com.crossnetcorp.banking.consumerloan.domain.model.ConsumerLoan;


/**
 *
 * @author ianache
 */
@Slf4j
@Service
@Transactional
public class ApplicationConsumerLoanServiceImpl implements ApplicationConsumerLoanService {

    @Autowired
    private DomainConsumerLoanService domainConsumerLoanService;

    @Autowired
    private ApplicationConsumerLoanMapper applicationConsumerLoanMapper;

    @Override
    public ConsumerLoanDTO registrarConsumerLoan(String partyId,
        String productId,
        String requestId,
        Double monto,
        Integer cuotas) throws ApplicationException {
        try {
            ConsumerLoan newConsumerLoan = domainConsumerLoanService.registrarConsumerLoan(
                    ConsumerLoan.builder()
                            .id(null)
                            .ammount(monto)
                            .clienteId(partyId)
                            .solicitudId(requestId)
                            .productoId(productId)
                            .cuotas(cuotas)
                            .build()
            );

            return applicationConsumerLoanMapper.toConsumerLoanDTO(newConsumerLoan);
        } catch (Exception e) {
            log.error("OCURRIO UN ERROR EN REQUEST REGISTRO ConsumerLoan: {}", e.getMessage());
            throw new ApplicationException(e.getMessage());
        }
    }

    @Override
    public List<ConsumerLoanDTO> listarConsumerLoan() throws ApplicationException {
        log.debug("INICIO REQUEST LISTAR ConsumerLoans");
        List<ConsumerLoanDTO> ConsumerLoans = 
                applicationConsumerLoanMapper.toConsumerLoanDTO(domainConsumerLoanService.listarConsumerLoan());
        return ConsumerLoans;
    }


}
