package com.example.asmjavaspring.repository;

import com.example.asmjavaspring.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Integer> {
    public List<Street> findStreetByDistrictId(int districtId);
    public List<Street> findStreetByNameContainsAndDistrictId(String streetName, int districtId);
    public List<Street> findStreetByNameContains(String streetName);


}
