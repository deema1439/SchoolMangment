package com.example.schoolmangment.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class AddressDto {

    private Integer teacher_id;
    private Integer building_number;
    private String area;
    private String street;


}
