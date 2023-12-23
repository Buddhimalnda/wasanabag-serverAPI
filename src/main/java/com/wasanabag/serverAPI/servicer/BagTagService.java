package com.wasanabag.serverAPI.servicer;

import com.wasanabag.serverAPI.model.BagTag;
import com.wasanabag.serverAPI.repository.BagTagRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class BagTagService {
    private final BagTagRepository bagTagRepository;

    public BagTag createBagTag(BagTag bagTag) {
        return bagTagRepository.save(bagTag);
    }

    public List<BagTag> getAllBagTags() {
        return bagTagRepository.findAll();
    }

    public BagTag updateBagTag(String code, BagTag bagTag) {
        BagTag bagTag1 = bagTagRepository.findByCode(code).orElseThrow(() -> new RuntimeException("BagTag not found"));
        bagTag1.setCode(bagTag.getCode());
        bagTag1.setTag(bagTag.getTag());
        bagTag1.setStatus(bagTag.getStatus());
        bagTag1.setCreatedAt(bagTag.getCreatedAt());
        bagTag1.setUpdatedAt(bagTag.getUpdatedAt());
        return bagTagRepository.save(bagTag1);
    }

    public void deleteBagTag(String id) {
        bagTagRepository.deleteById(id);
    }

    public BagTag getBagTagById(String id) {
        return bagTagRepository.findById(id).orElseThrow(() -> new RuntimeException("BagTag not found"));
    }

    public BagTag getBagTagByTag(String tag) {
        return bagTagRepository.findByTag(tag).orElseThrow(() -> new RuntimeException("BagTag not found"));
    }

    public BagTag updateBagTagByTag(String tag, BagTag bagTag) {
        BagTag bagTag1 = bagTagRepository.findByTag(tag).orElseThrow(() -> new RuntimeException("BagTag not found"));
        bagTag1.setCode(bagTag.getCode());
        bagTag1.setTag(bagTag.getTag());
        bagTag1.setStatus(bagTag.getStatus());
        bagTag1.setCreatedAt(bagTag.getCreatedAt());
        bagTag1.setUpdatedAt(bagTag.getUpdatedAt());
        return bagTagRepository.save(bagTag1);
    }
}
