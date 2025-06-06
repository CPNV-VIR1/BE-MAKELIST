package ch.etmles.tierlistservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.etmles.tierlistservice.Entities.TierList;

public interface TierListRepository extends JpaRepository<TierList, Long>{

}
