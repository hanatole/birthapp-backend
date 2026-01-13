package com.bitnoises.birthapp.profile;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ProfileService {
    private final IProfileRepository profileRepository;

    public void create(Profile profile) {
        log.info("Creating new profile for {}.", profile.getEmail());
        profileRepository.save(profile);
    }

    public List<Profile> search() {
        return profileRepository.findAll();
    }

    public Profile read(Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.orElseThrow(() -> new EntityNotFoundException(String.format("Profile with id %d not found.", id)));
    }

    public Profile update(Long id, Profile profile) {
        Profile profileToUpdate = read(id);
        if (profileToUpdate != null) {
            profileToUpdate.setEmail(profile.getEmail());
            profileToUpdate.setFirstname(profile.getFirstname());
            profileToUpdate.setLastname(profile.getLastname());
            profileToUpdate.setPassword(profile.getPassword());
            profileToUpdate.setCivility(profile.getCivility());
            profileRepository.save(profileToUpdate);
            return profileToUpdate;
        }
        throw new EntityNotFoundException(String.format("Profile with id %d not found.", id));
    }

    public void delete(Long id) {
        profileRepository.deleteById(id);
    }
}
