package com.example.schoolmangment.Repository;

import com.example.schoolmangment.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
  Address findAddressById(Integer id);













}
