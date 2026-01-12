package com.bitnoises.birthapp.profile;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping("profile")
public class ProfileController {
    private final ProfileService profileService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Profile profile) {
        profileService.create(profile);
    }

    @GetMapping
    public List<Profile> search() {
        return profileService.search();
    }

    @GetMapping(path = "{id}")
    public Profile read(@PathVariable Long id) {
        return profileService.read(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public Profile update(@PathVariable Long id, @RequestBody Profile profile) {
        return profileService.update(id, profile);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id) {
        profileService.delete(id);
    }
}
