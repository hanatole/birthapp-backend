package com.bitnoises.birthapp.profile;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {
    @Mock
    IProfileRepository profileRepository;

    @InjectMocks
    ProfileService profileService;

    @Test
    void shouldReturnProfiles() {
        when(profileRepository.findAll()).thenReturn(List.of(Profile.builder().build()));
        List<Profile> profiles = profileService.search();

        assertEquals(1, profiles.size());
    }
}