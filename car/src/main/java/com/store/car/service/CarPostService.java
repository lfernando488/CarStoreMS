package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    List<CarPostDTO> newPostDetails (CarPostDTO carPostDTO);

    List<CarPostDTO> getCarSales();

    void changeCarSale(CarPostDTO carPostDTO, long postId);

    void removeCarSale(Long postId);
}
