package ch.etmles.tierlistservice.Repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.etmles.tierlistservice.Entities.TierList;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TierListRepository tierListRepository){
        return args->{
            log.info("Preloading " + tierListRepository.save(new TierList("Awesome tier list!")));
            log.info("Preloading " + tierListRepository.save(new TierList("Best vegetables")));
        };
    }
}
