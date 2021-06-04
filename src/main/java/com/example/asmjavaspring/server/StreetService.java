package com.example.asmjavaspring.server;

import com.example.asmjavaspring.entity.Street;
import com.example.asmjavaspring.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Configurable
public class StreetService {
    @Autowired
    public StreetRepository streetRepository;
    public Street create(Street street){
        return streetRepository.save(street);
    }

    public List<Street> list() {
        return streetRepository.findAll();
    }

    public List<Street> findStreetByNameContainsAndDistrictId( String streetName,int districtId){
        return streetRepository.findStreetByNameContainsAndDistrictId(streetName,districtId);
    }

    public List<Street> findStreetByNameContains( String streetName){
        return streetRepository.findStreetByNameContains(streetName);
    }

    public List<Street> findStreetByDistrictId(int districtId){
        return streetRepository.findStreetByDistrictId(districtId);
    }
}
