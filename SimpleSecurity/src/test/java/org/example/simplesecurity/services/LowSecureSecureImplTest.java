package org.example.simplesecurity.services;

import org.example.simplesecurity.services.internal.HighSecureServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LowSecureSecureImplTest {

    @Autowired

    private HighSecureServiceImpl objectUnderTest;


    @Test
    public void getMessageUnauthenticated() {
        assertThrows(AuthenticationCredentialsNotFoundException.class, ()->objectUnderTest.secureServicesMethodFoo());
    }
}