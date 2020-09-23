package biz.gsign.controller;

import biz.gsign.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employers")
public class EmployerController {
    private final EmployerRepository employerRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public long check(@RequestBody String username, String password) {
        return employerRepository.check(username, password);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@RequestBody String username, String password) {
        return employerRepository.create(username, password);
    }

}