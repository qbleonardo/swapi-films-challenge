package com.swapi.challengefilmes.exception.handler;

import com.swapi.challengefilmes.exception.FilmeNotFoundException;
import com.swapi.challengefilmes.exception.SwapiGenericException;
import com.swapi.challengefilmes.exception.response.ErrorData;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorData> handleConstraintViolationException(ConstraintViolationException cVE){
        ErrorData response = ErrorData.builder()
                .code(HttpStatus.BAD_REQUEST.name().concat(" - ").concat(String.valueOf(HttpStatus.BAD_REQUEST.value())))
                .title(String.format("Formato incorreto no %s", cVE.getConstraintViolations().stream().map(ConstraintViolation::getPropertyPath).collect(Collectors.toList())))
                .detail(cVE.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorData> handleMissingServletRequestParameterException(MissingServletRequestParameterException mSR){
        ErrorData response = ErrorData.builder()
                .code(HttpStatus.BAD_REQUEST.name().concat(" - ").concat(String.valueOf(HttpStatus.BAD_REQUEST.value())))
                .title(String.format("Formato incorreto no campo: %s", mSR.getParameterName()))
                .detail(mSR.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorData> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        ErrorData response = ErrorData.builder()
                .code(HttpStatus.BAD_REQUEST.name().concat(" - ").concat(String.valueOf(HttpStatus.BAD_REQUEST.value())))
                .title(String.format("Formato incorreto no campo: %s", methodArgumentNotValidException.getParameter().getParameterName()))
                .detail(Objects.requireNonNull(methodArgumentNotValidException.getBindingResult().getFieldError()).getDefaultMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorData> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException mAt){
        ErrorData response = ErrorData.builder()
                .code(HttpStatus.BAD_REQUEST.name().concat(" - ").concat(String.valueOf(HttpStatus.BAD_REQUEST.value())))
                .title(String.format("Parâmetro [%s] não consta-se correto", mAt.getName()))
                .detail(String.format("Valor: [%s] diverge dos valores esperados para requisição. Validar em contrato!", mAt.getValue().toString()))
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorData> handleMethodArgumentTypeMismatchException(NoResourceFoundException noResourceFoundException){
        ErrorData response = ErrorData.builder()
                .code(HttpStatus.NOT_FOUND.name().concat(" - ").concat(String.valueOf(HttpStatus.NOT_FOUND.value())))
                .title(String.format("Uri [%s] não encontrada", noResourceFoundException.getResourcePath()))
                .detail(String.format("Validar requisição, a URI informada está inválida: [%s] ", noResourceFoundException.getResourcePath()))
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FilmeNotFoundException.class)
    public ResponseEntity<ErrorData> handleFilmeNotFoundException(FilmeNotFoundException filmeNotFoundException){
        ErrorData response = ErrorData.builder()
                .code(HttpStatus.NOT_FOUND.name().concat(" - ").concat(String.valueOf(HttpStatus.NOT_FOUND.value())))
                .title("Filme não encontrado")
                .detail(filmeNotFoundException.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SwapiGenericException.class)
    public ResponseEntity<ErrorData> handleSwapiGenericException(SwapiGenericException swapiGenericException){
        ErrorData response = ErrorData.builder()
                .code(HttpStatus.valueOf(swapiGenericException.getHttpStatusCode().value()).name()
                        .concat(" - ").concat(String.valueOf(HttpStatus.valueOf(swapiGenericException.getHttpStatusCode().value()))))
                .title("Erro à API Swapi")
                .detail(swapiGenericException.getMessage())
                .build();

        return new ResponseEntity<>(response, swapiGenericException.getHttpStatusCode());
    }

}