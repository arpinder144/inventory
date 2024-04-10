package co.pragra.learning.inventory.service;

import co.pragra.learning.inventory.entity.InventoryEntity;
import co.pragra.learning.inventory.repository.InventoryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImp implements InventoryService {
    @Autowired
    InventoryRepo inventoryRepo;

    public InventoryEntity addProduct(InventoryEntity inventoryEntity){
        return inventoryRepo.save(inventoryEntity);
        //return "Product Added!!";
    }

    public List<InventoryEntity> getAllProduct(){
       return inventoryRepo.findAll();
    }

    public Optional<InventoryEntity> getProductById(Integer id){
        return inventoryRepo.getInventoryEntityByProductId(id);
    }

    @Override
    public InventoryEntity updateProductById(InventoryEntity inventoryEntity) {
        InventoryEntity existingInventory = inventoryRepo.getInventoryEntityByProductId(inventoryEntity.getProductId())
                .orElse(null);
        if(existingInventory!=null){
            existingInventory.setProductName(inventoryEntity.getProductName());
            existingInventory.setProductQuantity(inventoryEntity.getProductQuantity());
            existingInventory.setProductPrice(inventoryEntity.getProductPrice());
            return inventoryRepo.save(existingInventory);
        }else {
            return inventoryRepo.save(inventoryEntity);
        }
    }

    @Override
    @Transactional
    public Optional<InventoryEntity> deleteProductByName(String productName) {
        return inventoryRepo.deleteInventoryEntityByProductName(productName);
    }


}
