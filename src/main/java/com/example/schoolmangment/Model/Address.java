package com.example.schoolmangment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Address {


    @Id
    private Integer id;

    @NotEmpty(message = "area should not be empty")
    @Size(min = 2, max = 30, message = "area should be between 2 and 30")
    @Column(columnDefinition = "varchar(30) not null")
    private String area;

    @NotEmpty(message = "street should not be empty")
    @Size(min = 2, max = 30, message = "street should be between 2 and 30")
    @Column(columnDefinition = "varchar(30) not null")
    private String street;

    @NotNull(message = "building number should not be empty")
    @Positive(message = "building number should be a positive number")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;



















}
