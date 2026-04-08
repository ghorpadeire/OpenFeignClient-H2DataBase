package com.pranav.laptop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LaptopRequest {

    private String laptopModelName;
    private String laptopManufacturer;
    private Double laptopPrice;
}
