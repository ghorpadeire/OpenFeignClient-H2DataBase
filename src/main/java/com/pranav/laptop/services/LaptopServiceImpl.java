package com.pranav.laptop.services;

import com.pranav.laptop.dto.LaptopRequest;
//import com.pranav.laptop.dto.LaptopResponce;
import com.pranav.laptop.dto.LaptopResponse;
import com.pranav.laptop.entities.Laptop;
import com.pranav.laptop.repositories.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;

    @Override
    public LaptopResponse addLaptop(LaptopRequest laptopRequest) {
        Laptop laptop = Laptop.builder()
                .laptopManufacturer(laptopRequest.getLaptopManufacturer())
                .laptopPrice(laptopRequest.getLaptopPrice())
                .laptopModelName(laptopRequest.getLaptopModelName())
                .build();
        Laptop lResponse = laptopRepository.save(laptop);
        return LaptopResponse.builder()
                .laptopId(lResponse.getLaptopId())
                .laptopPrice(lResponse.getLaptopPrice())
                .laptopManufacturer(laptopRequest.getLaptopManufacturer())
                .laptopModelName(lResponse.getLaptopModelName())
                .build();
    }

    @Override
    public LaptopResponse getLaptopById(Integer laptopId) {
        Laptop laptop = laptopRepository.findById(laptopId);
        return LaptopResponse.builder()
                .laptopId(laptop.getLaptopId())
                .laptopPrice(laptop.getLaptopPrice())
                .laptopManufacturer(laptop.getLaptopManufacturer())
                .laptopModelName(laptop.getLaptopModelName())
                .build();

    }


    @Override
    public LaptopResponse updateLaptop(Integer laptopId, LaptopRequest laptopRequest) {
        Laptop laptop = laptopRepository.findById(laptopId);
        laptop.setLaptopPrice(laptopRequest.getLaptopPrice());
        laptop.setLaptopModelName(laptopRequest.getLaptopModelName());
        laptop.setLaptopManufacturer(laptopRequest.getLaptopManufacturer());

        Laptop upadtedLaptop = laptopRepository.save(laptop);
        return LaptopResponse.builder()
                .laptopId(laptop.getLaptopId())
                .laptopPrice(laptop.getLaptopPrice())
                .laptopManufacturer(laptop.getLaptopManufacturer())
                .laptopModelName(laptop.getLaptopModelName())
                .build();
    }

    @Override
    public String deleteLaptopById(Integer laptopId) {
        laptopRepository.delete(laptopId);
        return "laptop is deleted";
    }
}
