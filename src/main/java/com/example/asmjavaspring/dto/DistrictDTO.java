package com.example.asmjavaspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {
    private int id;
    private String name;
    private List<StreetDTO> streets;
}

