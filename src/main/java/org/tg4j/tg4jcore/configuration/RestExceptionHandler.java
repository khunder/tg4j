package org.tg4j.tg4jcore.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ServerWebExchange;

import java.util.Date;

@RestControllerAdvice
public class RestExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);


    /**
     * @should return an internal server error response
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(
            Exception ex, ServerWebExchange request
    ) {
        LOGGER.error(ex.getMessage(), ex);
        final ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getRequest().getPath().toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<?> globalRtmExceptionHandler(WebExchangeBindException exc, ServerWebExchange exchange) {
        LOGGER.error(exc.getMessage(), exc);
        final ErrorDetails errorDetails = new ErrorDetails(new Date(), exc.getMessage(), exchange.getRequest().getPath().toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
