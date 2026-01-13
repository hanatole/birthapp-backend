package com.bitnoises.birthapp.profile;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class IProfileRepositoryTest {
    @Autowired
    private IProfileRepository profileRepository;

    @BeforeEach
    void setUp() {
        profileRepository.saveAll(
                List.of(Profile.builder().email("john@gmail.com").build(),
                        Profile.builder().email("abc@gmail.com").build())
        );
    }

    @AfterEach
    void tearDown() {
        profileRepository.deleteAll();
    }

    @Test
    void shouldReturnAllProfiles() {
        List<Profile> profiles = profileRepository.findAll();

        assertEquals(2, profiles.size());
    }

    @Test
    void shouldReturnProfileWhenFoundByEmail() {
        Optional<Profile> profile = profileRepository.findByEmail("abc@gmail.com");

        assertTrue(profile.isPresent());
        assertEquals("abc@gmail.com", profile.get().getEmail());
    }

    @Test
    void shouldReturnEmptyWhenProfileNotFoundByEmail() {
        Optional<Profile> profile = profileRepository.findByEmail("doc@gmail.com");
        assertTrue(profile.isEmpty());
    }

}