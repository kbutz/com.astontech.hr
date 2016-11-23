package com.astontech.hr.services;

import com.astontech.hr.domain.Element;

import java.util.List;

public interface ElementService {

    Iterable<Element> listAllElements();

    Element getElementById(Integer id);

    Element saveElement(Element element);

    Iterable<Element> saveElementList(Iterable<Element> elementIterable);

    void deleteElement(Integer id);

    // Custom repo methods
    Element findByElementName(String elementName);
    Element findByElementNameIgnoreCase(String elementName);
    List<Element> findAllByElementName(String elementName);
    List<Element> findAllByElementNameIgnoreCase(String elementName);
    List<Element> findTop3ByElementName(String elementName);

}
