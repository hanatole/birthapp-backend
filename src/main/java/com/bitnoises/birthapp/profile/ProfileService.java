package com.bitnoises.birthapp.profile;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public Profile read(@PathVariable Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.orElse(null);
    }

    public Profile update(Long id, Profile profile) {
        Profile profileToUpdate = read(id);
        if (profileToUpdate != null) {
            profileToUpdate.setEmail(profile.getEmail());
            profileToUpdate.setFirstname(profile.getFirstname());
            profileToUpdate.setLastname(profile.getLastname());
            profileToUpdate.setPassword(profile.getPassword());
            profileRepository.save(profileToUpdate);
        }
        return profileToUpdate;
    }

    public void delete(Long id) {
        profileRepository.deleteById(id);
    }
}
