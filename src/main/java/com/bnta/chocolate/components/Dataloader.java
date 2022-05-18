package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.hibernate.engine.transaction.jta.platform.internal.JRun4JtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    ChocolateRepository chocolateRepository;
    @Autowired
    EstateRepository estateRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Estate estate1 = new Estate("choco factory", "US");
        estateRepository.save(estate1);

        Estate estate2 = new Estate("choco house", "UK");
        estateRepository.save(estate2);

        Chocolate chocolate1 = new Chocolate("Milkyway", 87, estate2);
        chocolateRepository.save(chocolate1);

        Chocolate chocolate2 = new Chocolate("Mars", 43, estate1);
        chocolateRepository.save(chocolate2);

    }
}
