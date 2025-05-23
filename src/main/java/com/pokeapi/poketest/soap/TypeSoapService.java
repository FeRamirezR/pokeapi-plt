package com.pokeapi.poketest.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokeapi.poketest.dto.TypeDto;
import com.pokeapi.poketest.service.TypeService;

@WebService(serviceName = "TypeSoapService")
@Service
public class TypeSoapService {

    @Autowired
    private TypeService typeService;

    @WebMethod
    public List<TypeDto> getAllTypes() {
        return typeService.findAll();
    }

    @WebMethod
    public TypeDto getTypeById(Integer id) {
        return typeService.findById(id);
    }

    @WebMethod
    public TypeDto createType(TypeDto typeDto) {
        return typeService.save(typeDto);
    }

    @WebMethod
    public void deleteType(Integer id) {
        typeService.delete(id);
    }
}