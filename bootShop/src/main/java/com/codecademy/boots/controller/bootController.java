package com.codecademy.boots.controllers;

import java.lang.Iterable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.codecademy.boots.entities.Boot;
import com.codecademy.boots.enums.BootType;
import com.codecademy.boots.exceptions.QueryNotSupportedException;
import com.codecademy.boots.exceptions.NotImplementedException;

import com.codecademy.boots.repositories.BootsRepository;

@RestController
@RequestMapping("/api/v1/boots")
public class BootController {

    private BootRepository bootRepository;

    public BootController(BootRepository bootRepository){
        this.bootRepository = bootrepository;
    }

    @GetMapping("/search")
    public Iterable<Boot> getAllBoots() {
        return this.bootRepository.findAll();
    }

    @GetMapping("/types")
    public List<BootType> getBootTypes() {
        return Arrays.asList(BootType.values());
    }

    @PostMapping("/")
    public Boot addBoot(@RequestBody Boot boot) {
        this.bootRepository.save(boot);
        return boot;
    }

    @DeleteMapping("/{id}")
    public Boot deleteBoot(@PathVariable("id") Integer id) {
        Optional <boot> bootToDeleteOptional = this.bootRepository.findById(id);
        if (!bootToDeleteOptional.isPresent()){
            return null;
        }
        Boot bootToDelete = bootToDeleteOptional.get();
        this.bootRepository.delete(bootToDelete);
        return bootToDelete;
    }

    @PutMapping("/{id}/quantity/increment")
    public Boot incrementQuantity(@PathVariable("id") Integer id) {
        Optional <Boot> bootToIncrementOptional = this.bootRepository.findById(id);
        if( !bootToIncrementOptional.isPresent()){
            return null;
        }
        Boot bootToIncrement = bootToIncrementOptional.get();
        bootToIncrement.setQuantity(bootToIncrement.getQuantity() + 1)
        this.bootRepository.save(bootToIncrement);
        return bootToIncrement;
    }

    @PutMapping("/{id}/quantity/decrement")
    public Boot decrementQuantity(@PathVariable("id") Integer id) {
        Optional <Boot> bootToDecrementOptional = this.bootRepository.findById(id);
        if (!bootToDecrementOptional.isPresent()){
            return null
        }
        Boot bootToIncrement = bootToIncrementOptional.get();
        bootToIncrement.setQuantity(bootToIncrement.getQuantity() + 1)
        bootRepository.save(bootToIncrement);
        return bootToIncrement;
    }

    @GetMapping("/search")
    public List<Boot> searchBoots(@RequestParam(required = false) String material,
                                  @RequestParam(required = false) BootType type, @RequestParam(required = false) Float size,
                                  @RequestParam(required = false, name = "quantity") Integer minQuantity) {
        if (Objects.nonNull(material)) {
            if (Objects.nonNull(type) && Objects.nonNull(size) && Objects.nonNull(minQuantity)) {
                // call the repository method that accepts a material, type, size, and minimum
                // quantity
                findByMaterialAndTypeAndSizeAndQuantityGreaterThan(material, type, size, minQuantity);
            } else if (Objects.nonNull(type) && Objects.nonNull(size)) {
                // call the repository method that accepts a material, size, and type
                findByMaterialAndSizeAndType(material, size, type);
            } else if (Objects.nonNull(type) && Objects.nonNull(minQuantity)) {
                // call the repository method that accepts a material, a type, and a minimum
                // quantity
                findByMaterialAndTypeAndQuantityGreaterThan(material, type, minQuantity);
            } else if (Objects.nonNull(type)) {
                // call the repository method that accepts a material and a type
                findByMaterialAndType(material, type);
            } else {
                // call the repository method that accepts only a material
                findByMaterial(material);
            }
        } else if (Objects.nonNull(type)) {
            if (Objects.nonNull(size) && Objects.nonNull(minQuantity)) {
                // call the repository method that accepts a type, size, and minimum quantity
                findByTypeAndSizeAndQuantityGreaterThan;
            } else if (Objects.nonNull(size)) {
                // call the repository method that accepts a type and a size
                findByTypeAndSize(type, size);
            } else if (Objects.nonNull(minQuantity)) {
                // call the repository method that accepts a type and a minimum quantity
                findByTypeAndQuantityGreaterThan(type, minQuantity);
            } else {
                // call the repository method that accept only a type
                findByType(type);
            }
        } else if (Objects.nonNull(size)) {
            if (Objects.nonNull(minQuantity)) {
                // call the repository method that accepts a size and a minimum quantity
                findBySizeAndQuantityGreaterThan(size, minQuantity);
            } else {
                // call the repository method that accepts only a size
                findBySize(size);
            }
        } else if (Objects.nonNull(minQuantity)) {
            // call the repository method that accepts only a minimum quantity
            findByQuantity(minQuantity);
        } else {
            throw new QueryNotSupportedException("This query is not supported! Try a different combination of search parameters.");
        }
    }

}