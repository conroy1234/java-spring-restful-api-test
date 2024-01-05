package uk.co.huntersix.spring.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uk.co.huntersix.spring.rest.exception.PersonBadRequestException;
import uk.co.huntersix.spring.rest.exception.PersonNotFoundException;
import uk.co.huntersix.spring.rest.model.PersonExceptionBean;

import java.time.LocalDateTime;

@ControllerAdvice
public class PersonExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PersonNotFoundException.class)
    public final ResponseEntity<PersonExceptionBean> handlePersonNotFoundException(
            Exception ex, WebRequest request) {
        PersonExceptionBean personExceptionBean = new PersonExceptionBean();
        personExceptionBean.setNow(LocalDateTime.now());
        personExceptionBean.setMessage(ex.getMessage());
        personExceptionBean.setDescription(request.getDescription(false));

        return new ResponseEntity<>(personExceptionBean, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonBadRequestException.class)
    public final ResponseEntity<PersonExceptionBean> handleUBadRequestException(
            Exception ex, WebRequest request) {
        PersonExceptionBean personExceptionBean = new PersonExceptionBean();
        personExceptionBean.setNow(LocalDateTime.now());
        personExceptionBean.setMessage(ex.getMessage());
        personExceptionBean.setDescription(request.getDescription(false));

        return new ResponseEntity<>(personExceptionBean, HttpStatus.BAD_REQUEST);
    }
}
