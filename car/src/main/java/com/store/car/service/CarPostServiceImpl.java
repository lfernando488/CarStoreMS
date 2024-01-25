package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService{

    @Autowired
    private CarPostRepository carPostRepository;

    @Override
    public List<CarPostDTO> newPostDetails(CarPostDTO carPostDTO) {
        return null;
    }

    @Override
    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item ->{
            listCarsSales.add(mapCarEntityDTO(item));
        });
        return listCarsSales;
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, long postId) {
        carPostRepository.findById(postId).ifPresentOrElse(item ->{
            item.setDescription(carPostDTO.getDescription());
            item.setContact(carPostDTO.getContact());
            item.setPrice(carPostDTO.getPrice());
            item.setBrand(carPostDTO.getBrand());
            item.setEngineVersion(carPostDTO.getBrand());
            item.setModel(carPostDTO.getModel());
            carPostRepository.save(item);
        }, () ->{
            throw new NoSuchElementException();
        });
    }

    @Override
    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }

    private CarPostDTO mapCarEntityDTO(CarPostEntity carPostEntity){
            return CarPostDTO.builder()
                    .brand(carPostEntity.getBrand())
                    .city(carPostEntity.getCity())
                    .model(carPostEntity.getModel())
                    .description(carPostEntity.getDescription())
                    .engineVersion(carPostEntity.getEngineVersion())
                    .createdAt(carPostEntity.getCreatedAt())
                    .ownerName(carPostEntity.getOwnerPost().getName())
                    .price(carPostEntity.getPrice()).build();
    }
}
