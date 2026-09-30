package com.example.schoolmangment.Service;

import com.example.schoolmangment.Api.ApiException;
import com.example.schoolmangment.DTO.AddressDto;
import com.example.schoolmangment.Model.Address;
import com.example.schoolmangment.Model.Teacher;
import com.example.schoolmangment.Repository.AddressRepository;
import com.example.schoolmangment.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
 private final AddressRepository addressRepository;
 private final TeacherRepository teacherRepository;

 public List<Address>getAllAddress(){
     return addressRepository.findAll();
 }

 public void addAddress(AddressDto addressDto){
     Teacher t=teacherRepository.findTeacherById(addressDto.getTeacher_id());//هنا تآكدت من ال تيتشر لان اصلا الادريس ما انضاف فبديهي استخدم التيتشر اوبجيكت عشان اتاكد انه هو هو نفسه الايدي حق الادرس
     if(t==null){
         throw new ApiException("Teacher Not Found");
     }
     Address address=new Address(null,addressDto.getArea(),addressDto.getStreet(),addressDto.getBuilding_number(),t);
     addressRepository.save(address);
 }

 public void updateAddress(AddressDto addressDto){
   Address address=addressRepository.findAddressById(addressDto.getTeacher_id());//هنا بما ان اصلا في اختمالية انه ضاف الريدي الادريس ف انا ادور عليه باستخدام الادريس اوبجيكت عادي لانه هو هو نفسه الايدي حق التيتشر
    if(address==null){
        throw new ApiException("Teacher Address Not Found");
    }
    address.setArea(addressDto.getArea());
    address.setBuildingNumber(addressDto.getBuilding_number());
    address.setStreet(addressDto.getStreet());
    addressRepository.save(address);
 }

 public void deleteAddress(Integer id){
     Address address=addressRepository.findAddressById(id);
     if(address==null){
         throw new ApiException("address not found");
     }
     addressRepository.delete(address);
 }













}
