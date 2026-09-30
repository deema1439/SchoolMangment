package com.example.schoolmangment.Controller;
import com.example.schoolmangment.Api.ApiResponse;
import com.example.schoolmangment.DTO.AddressDto;
import com.example.schoolmangment.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllAddress() {
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody @Valid AddressDto addressDto) {

        addressService.addAddress(addressDto);

        return ResponseEntity.status(200).body(new ApiResponse("Address added"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody @Valid AddressDto addressDto) {
        addressService.updateAddress(addressDto);

        return ResponseEntity.status(200).body(new ApiResponse("Address updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address deleted"));
    }
}
