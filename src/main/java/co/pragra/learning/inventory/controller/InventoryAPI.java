package co.pragra.learning.inventory.controller;

import co.pragra.learning.inventory.entity.InventoryEntity;
import co.pragra.learning.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class InventoryAPI {
    @Autowired
    InventoryService inventoryService;
    @PostMapping("/add")
    public ResponseEntity<InventoryEntity> addProduct(@RequestBody InventoryEntity inventoryEntity){
        return new ResponseEntity<>(inventoryService.addProduct(inventoryEntity), HttpStatus.OK);
        //return "Prduct Added!";
    }
    @GetMapping("/getAll")
    public List<InventoryEntity> getAllProduct(){
        return inventoryService.getAllProduct();
    }
    @GetMapping("/get/{id}")
    public Optional<InventoryEntity> getProductById(@PathVariable Integer id){
        return inventoryService.getProductById(id);
    }
    @PutMapping("/update")
    public InventoryEntity updateProductById(@RequestBody InventoryEntity inventoryEntity){
        return inventoryService.updateProductById(inventoryEntity);
    }
    @DeleteMapping("/delete/{productName}")
    public Optional<InventoryEntity> deleteProductByName(@PathVariable String productName){
        return inventoryService.deleteProductByName(productName);
    }

    public void check(){
        System.out.println("All good?");
    }


}
