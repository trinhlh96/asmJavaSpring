package com.example.asmjavaspring.entity;

import com.example.asmjavaspring.dto.StreetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long operationDate;
    private String description;
    private int status;

    @ManyToOne(cascade = {CascadeType.MERGE,  CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "districtId", referencedColumnName = "id")
    private District district;

    @Column(insertable = false, updatable = false)
    private int districtId;

    public Street(String name, long operationDate, String description, int status,District district) {
        this.name = name;
        this.operationDate = operationDate;
        this.description = description;
        this.status = status;
        this.district = district;
    }

    public StreetDTO toStreetDTO(){
        StreetDTO streetDTO = new StreetDTO();
        streetDTO.setId(this.id);
        streetDTO.setName(this.name);
        streetDTO.setOperationDate(this.operationDate);
        streetDTO.setDescription(this.description);
        streetDTO.setStatus(this.status);
        streetDTO.setDistrictId(this.district.getId());
        streetDTO.setDistrictName(this.district.getName());
        return streetDTO;
    }
}
