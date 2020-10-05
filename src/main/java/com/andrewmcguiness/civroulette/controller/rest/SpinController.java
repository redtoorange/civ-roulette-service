package com.andrewmcguiness.civroulette.controller.rest;

import com.andrewmcguiness.civroulette.controller.vm.SpinCreateVm;
import com.andrewmcguiness.civroulette.controller.vm.SpinVm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/spin")
public class SpinController {
    private static final List<SpinVm> records = new ArrayList<>(List.of(
            new SpinVm(0L, "Andrew  McGuiness 1", ZonedDateTime.now()),
            new SpinVm(1L, "Andrew  McGuiness 2", ZonedDateTime.now()),
            new SpinVm(2L, "Andrew  McGuiness 3", ZonedDateTime.now()),
            new SpinVm(3L, "Andrew  McGuiness 4", ZonedDateTime.now())
    ));

    @GetMapping
    public ResponseEntity<List<SpinVm>> getSpins() {
        return ResponseEntity.ok(records);
    }

    @PostMapping
    public ResponseEntity<Long> postChallenge(@RequestBody SpinCreateVm vm) {
        SpinVm saved = new SpinVm(
                (long) records.size(),
                vm.getName(),
                ZonedDateTime.now()
        );
        records.add(saved);


        return ResponseEntity.status(201)
                .body(saved.getId());
    }
}
