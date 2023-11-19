package com.crossnetcorp.banking.consumerloan.presentation.internal;

import com.crossnetcorp.banking.consumerloan.presentation.views.PrestamoConsumoPignoraticioRequest;
import com.crossnetcorp.banking.consumerloan.presentation.views.ResourceId;
import com.crossnetcorp.banking.consumerloan.presentation.views.SolicitudPrestamoPigniraticioResponse;
import com.crossnetcorp.banking.consumerloan.presentation.views.SolicitudPrestamoPignoraticioRequest;
import com.crossnetcorp.banking.consumerloan.application.ApplicationConsumerLoanService;
import com.crossnetcorp.banking.consumerloan.application.ApplicationException;
import com.crossnetcorp.banking.consumerloan.application.model.ConsumerLoanDTO;
import com.crossnetcorp.banking.consumerloan.presentation.mappers.*;
import com.crossnetcorp.banking.consumerloan.presentation.ConsumerloanfacilitysApiDelegate;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


/**
 *
 * @author ianache
 */
@Slf4j
@Component
public class ConsumerLoanAPIDelegateImpl implements ConsumerloanfacilitysApiDelegate {

    @Autowired
    private ApplicationConsumerLoanService applicationConsumerLoanService;

    @Autowired
    private PresentationConsumerLoanMapper presentationConsumerLoanMapper;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        // TODO Auto-generated method stub
        return ConsumerloanfacilitysApiDelegate.super.getRequest();
    }

    @Override
    public ResponseEntity<SolicitudPrestamoPigniraticioResponse> obtenerSolicitudPrestamoPignoraticio(String loanId,
            String id) {
        log.info("Consulta de Solicitud ");
        SolicitudPrestamoPigniraticioResponse response = new SolicitudPrestamoPigniraticioResponse();
        response.setId("SOL91");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResourceId> registrarPrestamoPignoraticio(
            PrestamoConsumoPignoraticioRequest prestamoConsumoPignoraticioRequest) {
        try {
            ConsumerLoanDTO dto = 
                    applicationConsumerLoanService.registrarConsumerLoan(
                            prestamoConsumoPignoraticioRequest.getClienteId(),
                            prestamoConsumoPignoraticioRequest.getProductoId(),
                            prestamoConsumoPignoraticioRequest.getSolicitudId(),
                            prestamoConsumoPignoraticioRequest.getMonto().doubleValue(),
                            prestamoConsumoPignoraticioRequest.getCuotas().intValue());
            ResourceId result = new ResourceId();
            result.setId(dto.getId());
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (ApplicationException ex) {
            log.error("Error Interno: {}", ex.getMessage());
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }    }

    @Override
    public ResponseEntity<ResourceId> registrarSolicitudPrestamoPignoraticio(
            SolicitudPrestamoPignoraticioRequest solicitudPrestamoPignoraticioRequest) {
        // TODO Auto-generated method stub
        return ConsumerloanfacilitysApiDelegate.super.registrarSolicitudPrestamoPignoraticio(
                solicitudPrestamoPignoraticioRequest);
    }

}
