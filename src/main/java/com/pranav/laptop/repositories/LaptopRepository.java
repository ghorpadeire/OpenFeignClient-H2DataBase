package com.pranav.laptop.repositories;

import com.pranav.laptop.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    void delete(Integer laptopId);

    Laptop findById(Integer laptopId);
}
