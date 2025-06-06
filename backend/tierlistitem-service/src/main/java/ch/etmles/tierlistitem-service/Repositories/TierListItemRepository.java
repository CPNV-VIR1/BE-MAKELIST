package ch.etmles.tierlistitemservice.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.etmles.tierlistitemservice.Entities.TierListItem;

public interface TierListItemRepository extends JpaRepository<TierListItem, Long>{
    List<TierListItem> findByTierListId(Long tierListId);
}
