package com.krokodillLl.random.service;

import com.krokodillLl.random.dbo.RandomNumber;
import com.krokodillLl.random.repo.RandomNumberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RandomNumberService {
    private final RandomNumberRepository randomNumberRepository;

    public RandomNumberService(@Qualifier("randomNumberRepository") RandomNumberRepository randomNumberRepository) {
        this.randomNumberRepository = randomNumberRepository;
    }


    public List<RandomNumber> getAll() {
        return randomNumberRepository.findAll().stream().sorted((o1, o2) -> (int) (o2.getCreateDate().getTime() - o1.getCreateDate()
                .getTime())).limit(5).collect(Collectors.toList());
    }

    public RandomNumber addRandomNumber(RandomNumber randomNumber) {
        randomNumberRepository.save(randomNumber);
        return randomNumber;
    }

    public void updateRandomNumber(RandomNumber randomNumber) {
        randomNumberRepository.save(randomNumber);
    }

    public void deleteRandomNumber(Long id) {
        if(randomNumberRepository.findById(id).isPresent())
            randomNumberRepository.deleteById(id);
    }
}
