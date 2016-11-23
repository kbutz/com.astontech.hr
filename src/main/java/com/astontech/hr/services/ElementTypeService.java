package com.astontech.hr.services;

import com.astontech.hr.domain.ElementType;

import java.util.List;

public interface ElementTypeService {

    Iterable<ElementType> listAllElementTypes();

    ElementType getElementTypeById(Integer id);

    ElementType saveElementType(ElementType elementType);

    Iterable<ElementType> saveElementList(Iterable<ElementType> elementIterable);

    void deleteElementType(Integer id);

    // custom repo methods
    ElementType findByElementTypeName(String elementTypeName);
    ElementType findByElementTypeNameIgnoreCase(String elementTypeName);

    List<ElementType> findAllByElementTypeName(String elementTypeName);
    Integer countByElementTypeName(String elementTypeNameName);

}
