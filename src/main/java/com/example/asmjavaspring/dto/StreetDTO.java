package com.example.asmjavaspring.dto;

import com.example.asmjavaspring.entity.District;
import com.example.asmjavaspring.entity.Street;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Collections;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StreetDTO {
    private int id;
    private String name;
    private long operationDate;
    private String description;
    private int status;
    private int districtId;
    private String districtName;
    public Street toStreet(){
        Street street = new Street();
        street.setId(this.id);
        street.setName(this.name);
        street.setOperationDate(this.operationDate);
        street.setDescription(this.description);
        street.setStatus(this.status);
        street.setDistrictId(this.districtId);
        street.setDistrict(new District(this.districtId,this.districtName, Collections.singleton(street)));
        return street;
    }
}
