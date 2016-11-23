package com.astontech.hr.services.impl;


import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import com.astontech.hr.services.ElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementTypeServiceImpl implements ElementTypeService{

    @Autowired
    ElementTypeRepository elementTypeRepository;

    @Override
    public Iterable<ElementType> listAllElementTypes() {
        return elementTypeRepository.findAll();
    }

    @Override
    public ElementType getElementTypeById(Integer id) {
        return elementTypeRepository.findOne(id);
    }

    @Override
    public ElementType saveElementType(ElementType elementType) {
        return elementTypeRepository.save(elementType);
    }

    @Override
    public Iterable<ElementType> saveElementList(Iterable<ElementType> elementIterable) {
        return elementTypeRepository.save(elementIterable);
    }

    @Override
    public void deleteElementType(Integer id) {
        elementTypeRepository.delete(id);
    }

    @Override
    public ElementType findByElementTypeName(String elementTypeName) {
        return elementTypeRepository.findByElementTypeName(elementTypeName);
    }

    @Override
    public ElementType findByElementTypeNameIgnoreCase(String elementTypeName) {
        return elementTypeRepository.findByElementTypeNameIgnoreCase(elementTypeName);
    }

    @Override
    public List<ElementType> findAllByElementTypeName(String elementTypeName) {
        return elementTypeRepository.findAllByElementTypeName(elementTypeName);
    }

    @Override
    public Integer countByElementTypeName(String elementTypeName) {
        return elementTypeRepository.countByElementTypeName(elementTypeName);
    }
}
