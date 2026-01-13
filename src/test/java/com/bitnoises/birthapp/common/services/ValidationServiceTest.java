package com.bitnoises.birthapp.common.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ValidationServiceTest {
    @InjectMocks
    ValidationService validationService;

    @Test
    void shouldTestThatPasswordIsValid() {
        String password = "StonGPass234";
        validationService.validatePassword(password);
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsNotValid() {
        String password = "23";

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> validationService.validatePassword(password)
        );

        assertEquals(exception.getMessage(), "Password length should be at least 8 characters");
    }
}