package com.michaeldavidis.assignment.repos;

import com.michaeldavidis.assignment.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    List<Trainer> findAll();

    Trainer getOne(Long id);

    void delete(Trainer trainer);

}
