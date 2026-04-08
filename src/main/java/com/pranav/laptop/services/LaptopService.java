package com.pranav.laptop.services;

import com.pranav.laptop.dto.LaptopRequest;
import com.pranav.laptop.dto.LaptopResponse;

public interface LaptopService {
    LaptopResponse addLaptop(LaptopRequest laptopRequest);
    LaptopResponse getLaptopById(Integer laptopId);
    LaptopResponse updateLaptop(Integer laptopId, LaptopRequest laptopRequest);
    String deleteLaptopById(Integer laptopId);

}
