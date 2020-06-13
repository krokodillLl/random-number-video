package com.krokodillLl.random.repo;

import com.krokodillLl.random.dbo.RandomNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RandomNumberRepository extends JpaRepository<RandomNumber, Long> {
}
