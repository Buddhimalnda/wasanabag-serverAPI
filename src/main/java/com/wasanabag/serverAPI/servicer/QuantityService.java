package com.wasanabag.serverAPI.servicer;

import com.wasanabag.serverAPI.model.Quantity;
import com.wasanabag.serverAPI.repository.QuantityRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service
public class QuantityService {
    private final QuantityRepository quantityRepository;


    public List<Quantity> getAllQuantity() {
        return quantityRepository.findAll();
    }

    public Quantity createQuantity(Quantity quantity) {
        //
        if (quantityRepository.findByCode(quantity.getCode()).isPresent()) {
            return updateQuantity(quantity);
        }
        return quantityRepository.save(quantity);
    }

    public Quantity updateQuantity(Quantity quantity) {
        Quantity existingQuantity = quantityRepository.findByCode(quantity.getCode()).orElseThrow(null);
        if (quantity.getType().equals("ADD"))
            existingQuantity.setQuantity(existingQuantity.getQuantity() + quantity.getQuantity());
        else
            existingQuantity.setQuantity(existingQuantity.getQuantity() - quantity.getQuantity());

        existingQuantity.setUnit(quantity.getUnit());
        return quantityRepository.save(existingQuantity);
    }

    public Quantity getQuantityByCode(String code) {
        return quantityRepository.findByCode(code).orElse(null);
    }

    public void deleteQuantity(String id) {
        quantityRepository.deleteById(id);
    }
}
