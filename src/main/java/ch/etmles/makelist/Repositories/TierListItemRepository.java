package ch.etmles.makelist.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.etmles.makelist.Entities.TierListItem;

public interface TierListItemRepository extends JpaRepository<TierListItem, Long>{
    List<TierListItem> findByTierListId(Long tierListId);
}
