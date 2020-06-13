package com.krokodillLl.random.controllers;

import com.krokodillLl.random.dbo.RandomNumber;
import com.krokodillLl.random.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/random")
public class RandomNumberController {

    private RandomNumberService randomNumberService;

    public RandomNumberController(@Qualifier("randomNumberService") RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }


    @GetMapping
    public List<RandomNumber> getAll() {
        return randomNumberService.getAll();
    }

    @PostMapping("/add")
    public RandomNumber addRandomNumber(@RequestBody RandomNumber randomNumber) {
        return randomNumberService.addRandomNumber(randomNumber);
    }

    @PutMapping("/update/{id}")
    public void updateRandomNumber(@RequestBody RandomNumber randomNumber, @PathVariable Long id) {
        randomNumber.setId(id);
        randomNumberService.updateRandomNumber(randomNumber);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRandomNumber(@PathVariable Long id) {
        randomNumberService.deleteRandomNumber(id);
    }

}
