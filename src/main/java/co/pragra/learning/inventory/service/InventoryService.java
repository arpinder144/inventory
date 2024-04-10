package co.pragra.learning.inventory.service;

import co.pragra.learning.inventory.entity.InventoryEntity;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    public InventoryEntity addProduct(InventoryEntity inventoryEntity);
    public List<InventoryEntity> getAllProduct();
    public Optional<InventoryEntity> getProductById(Integer id);
    public InventoryEntity updateProductById(InventoryEntity inventoryEntity);
    public Optional<InventoryEntity> deleteProductByName(String productName);
}
