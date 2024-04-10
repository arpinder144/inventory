package co.pragra.learning.inventory.repository;

import co.pragra.learning.inventory.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<InventoryEntity,Integer> {
    Optional<InventoryEntity> getInventoryEntityByProductId(Integer id);
    Optional<InventoryEntity> deleteInventoryEntityByProductName(String productName);
}
