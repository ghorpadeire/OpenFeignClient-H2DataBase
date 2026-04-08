package com.pranav.laptop.dto;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LaptopResponse {
    private int laptopId;
    private String laptopModelName;
    private String laptopManufacturer;
    private Double laptopPrice;
}
