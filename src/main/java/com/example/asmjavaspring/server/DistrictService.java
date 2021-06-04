package com.example.asmjavaspring.server;

import com.example.asmjavaspring.entity.District;
import com.example.asmjavaspring.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Configurable
public class DistrictService {
    @Autowired
    public DistrictRepository districtRepository;

    public List<District> saveAll(List<District> list){
        return districtRepository.saveAll(list);
    }
    public List<District> list(){
        return districtRepository.findAll();
    }
}
