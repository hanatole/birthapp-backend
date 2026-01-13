package com.bitnoises.birthapp.profile;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(String email);
}
