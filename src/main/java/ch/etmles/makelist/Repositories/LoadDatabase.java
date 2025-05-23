package ch.etmles.makelist.Repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.etmles.makelist.Entities.TierList;
import ch.etmles.makelist.Entities.TierListItem;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TierListRepository tierListRepository, TierListItemRepository tierListItemRepository){
        return args->{
            log.info("Preloading " + tierListRepository.save(new TierList("Awesome tier list!")));
            log.info("Preloading " + tierListRepository.save(new TierList("Best vegetables")));
            log.info("Preloading " + tierListItemRepository.save(new TierListItem("Radish", 2L, (short) 1)));
            log.info("Preloading " + tierListItemRepository.save(new TierListItem("Carrot", 2L, (short) 4)));
        };
    }
}
