package me.dio.java_spring_boot_railway.service.impl;

import me.dio.java_spring_boot_railway.domain.model.Feature;
import me.dio.java_spring_boot_railway.domain.repository.FeatureRepository;
import me.dio.java_spring_boot_railway.dto.FeatureDTO;
import me.dio.java_spring_boot_railway.service.FeatureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FeatureServiceImpl implements FeatureService {
    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public FeatureDTO findById(Long id) {
        Feature feature = featureRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Feature ID " + id + " not found."));
        return new FeatureDTO(feature.getId(), feature.getName());
    }

    @Override
    public FeatureDTO create(FeatureDTO dto) {
        Feature feature = new Feature();
        feature.setName(dto.getName());
        feature = featureRepository.save(feature);
        return new FeatureDTO(feature.getId(), feature.getName());
    }

    @Override
    public List<FeatureDTO> findAll() {
        return featureRepository.findAll().stream()
                .map(f -> new FeatureDTO(f.getId(), f.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!featureRepository.existsById(id))
            throw new NoSuchElementException("Feature ID " + id + " not found.");
        featureRepository.deleteById(id);
    }
}
