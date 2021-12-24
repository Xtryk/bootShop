package com.codecademy.boots.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codecademy.boots.entities.Boot;
import com.codecademy.boots.enums.BootType;

public interface BootRepository extends CrudRepository <Boot, Integer> {

    public List <Boot> findBySize(Float size){
        return this.bootRepository.findBySize(size);
    }
    public List <Boot> findByMaterial(String material){
        return this.bootRepository.findByMaterial(material);
    }
    public List <Boot> findByType(Type type){
        return this.personRepository.findByType(type);
    }
    public List <Boot> findByQuantity(Integer quantity){
        return this.personRepository.findByQuantityMoreThan(quantity);
    }
    public List <Boot> findByMaterialAndTypeAndSizeAndQuantityGreaterThan(String material, Type type, Float size, Integer minQuantity)
    return this.bootRepository.findByMaterialAndTypeAndSizeAndQuantityGreaterThan(material, type, size, minQuantity);
}
    public List <Boot> findByMaterialAndSizeAndType(String material, Float size, Type type){
        return this.bootRepository.findByMaterialAndSizeAndType(material, size, type);
    }
    public List <Boot> findByMaterialAndTypeAndQuantityGreaterThan(String material, Type type, Integer minQuantity){
        return this.bootRepository.findByMaterialAndTypeAndQuantityGreaterThan(material, type, minQuantity);
    }
    public List <Boot> findByTypeAndQuantityGreaterThan(Type type, Integer minQuantity){
        return this.bootRepository.findByTypeAndQuantityGreaterThan(type, minQuantity);
    }
    public List <Boot> findBySizeAndQuantityGreaterThan(Float size, Integer minQuantity){
        return this.bootRepository.findBySizeAndQuantityGreaterThan(size, minQuantity);
    }
    public List <Boot> findByMaterialAndType(String material, Type type){
        return this.bootRepository.findByMaterialAndType(material, type);
    }
    public List <Boot> findByTypeAndSizeAndQuantityGreaterThan(Type type, Float size, Integer minQuantity){
        return this.bootRepository.findByTypeAndSizeAndQuantityGreaterThan(type, size, minQuantity);
    }
    public List <Boot> findByTypeAndSize(Type type, Float size){
        return this.bootRepository.findByTypeAndSize(type, size);
    }
    public List <Boot> findTypeAndQuantityGreaterThan(Type type, Integer minQuantity){
        return this.bootRepository.findByTypeAndQuantityGreaterThan(type, minQuantity);
    }
