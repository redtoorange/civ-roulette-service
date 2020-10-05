package com.andrewmcguiness.civroulette.controller.rest;

import com.andrewmcguiness.civroulette.controller.vm.ChallengeCreateVm;
import com.andrewmcguiness.civroulette.controller.vm.ChallengeVm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {
    private static final List<ChallengeVm> records = new ArrayList<>(List.of(
            new ChallengeVm(0L, "Test Challenge 1", "Test Challenge Body", 0, "EASY", ZonedDateTime.now()),
            new ChallengeVm(1L, "Test Challenge 2", "Test Challenge Body", 0, "EASY", ZonedDateTime.now()),
            new ChallengeVm(2L, "Test Challenge 3", "Test Challenge Body", 0, "EASY", ZonedDateTime.now()),
            new ChallengeVm(3L, "Test Challenge 4", "Test Challenge Body", 0, "EASY", ZonedDateTime.now())
    ));

    @GetMapping
    public ResponseEntity<List<ChallengeVm>> getChallenges() {
        return ResponseEntity.ok(records);
    }

    @PostMapping
    public ResponseEntity<Long> postChallenge(@RequestBody ChallengeCreateVm vm) {
        ChallengeVm saved = new ChallengeVm(
                (long) records.size(),
                vm.getTitle(),
                vm.getBody(),
                vm.getPoints(),
                vm.getDifficulty(),
                ZonedDateTime.now()
        );
        records.add(saved);

        return ResponseEntity.status(201)
                .body(saved.getId());
    }
}
