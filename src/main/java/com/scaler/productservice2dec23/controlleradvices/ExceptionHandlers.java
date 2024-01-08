package com.scaler.productservice2dec23.controlleradvices;

import com.scaler.productservice2dec23.dtos.ArithmeticExceptionDto;
import com.scaler.productservice2dec23.dtos.ExceptionDto;
import com.scaler.productservice2dec23.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    ResponseEntity<ArithmeticExceptionDto> handleArithmeticException()
    {
        ArithmeticExceptionDto arithmeticExceptionDto = new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("some arithmetic error");

        ResponseEntity<ArithmeticExceptionDto> response
                = new ResponseEntity<>(
                arithmeticExceptionDto,
                HttpStatus.OK
        );

        return  response;
    }


    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    ResponseEntity<Void> handleArrayOutOfBond()
    {
        return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException ex)
    {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(ex.getMessage());

        return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.OK);
    }

}
