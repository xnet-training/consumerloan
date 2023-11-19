package com.crossnetcorp.banking.consumerloan.infrastructure.internal.mysql;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.crossnetcorp.banking.consumerloan.domain.DomainConsumerLoanRepository;
import com.crossnetcorp.banking.consumerloan.domain.model.ConsumerLoan;
import com.crossnetcorp.banking.consumerloan.infrastructure.mappers.InfrastructureConsumerLoanMapper;
import com.crossnetcorp.banking.consumerloan.infrastructure.model.mysql.ConsumerLoanTable;

/**
 *
 * @author ccolome
 */
@Slf4j
@Service
@Qualifier("MYSQL")
public class InfrastructureConsumerLoanRepositoryMSQLImpl implements DomainConsumerLoanRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private InfrastructureConsumerLoanMapper infrastructureConsumerLoanMapper;

     /**
     * Retorna un listado de ConsumerLoans de la base de datos
     * 
     * @return listado de ConsumerLoan
     * @see DomainConsumerLoanRepository#listarConsumerLoan 
     */
    @Override
    public List<ConsumerLoan> listarConsumerLoan() {
        List<ConsumerLoan> ConsumerLoans = new ArrayList<>();
        try {

            List<ConsumerLoanTable> ConsumerLoansTable = entityManager.createQuery(
                    "FROM ConsumerLoanTable tb",
                    ConsumerLoanTable.class
            ).getResultList();

            ConsumerLoans = infrastructureConsumerLoanMapper.translateConsumerLoansTableToConsumerLoans(ConsumerLoansTable);
            log.debug("SE OBTUVO LISTA DE ROOTENTITIES");
        } catch (Exception e) {
            log.error("OCURRIO UN ERROR AL LISTAR ROOTENTITIES: {}", e.getMessage());
        }
        return ConsumerLoans;
    }

    /**
     * Registra una nueva ConsumerLoan en la base da datps
     *
     * @param objeto Datos de ConsumerLoan a registrar
     * @return ConsumerLoan registrada
     * @see DomainConsumerLoanRepository#registrarConsumerLoan
     */
    @Override
    public ConsumerLoan registrarConsumerLoan(ConsumerLoan objeto) {

        ConsumerLoan ConsumerLoan = new ConsumerLoan();

        try {

            ConsumerLoanTable ConsumerLoanTable = infrastructureConsumerLoanMapper.translateConsumerLoanToConsumerLoanTable(
                    objeto
            );

            entityManager.persist(ConsumerLoanTable);
            entityManager.flush();

            ConsumerLoan = infrastructureConsumerLoanMapper.translateConsumerLoanTableToConsumerLoan(ConsumerLoanTable);
            log.debug("SE REGISTRO CORRECTAMENTE LA ConsumerLoan");
        } catch (Exception e) {
            log.error("OCURRIO UN ERROR AL REGISTRAR LA ConsumerLoan: {}", e.getMessage());
        }
        return ConsumerLoan;

    }

}
