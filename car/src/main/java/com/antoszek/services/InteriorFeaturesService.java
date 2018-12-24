package com.antoszek.services;

import com.antoszek.model.entityClass.InteriorFeatures;
import com.antoszek.repository.InteriorFeatureRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
    public class InteriorFeaturesService {
        private final InteriorFeatureRepository interiorFeatureRepository;

        @Autowired
        public InteriorFeaturesService(InteriorFeatureRepository interiorFeatureRepository) {
            this.interiorFeatureRepository = interiorFeatureRepository;
        }


        public InteriorFeatures save(InteriorFeatures interiorFeatures){
            InteriorFeatures saveInteriorFeatures = interiorFeatureRepository.save(interiorFeatures);
            return saveInteriorFeatures;
        }

        public List<InteriorFeatures> findAll() {
            Iterable<InteriorFeatures> interiorFeaturesIterable = interiorFeatureRepository.findAll();
            List<InteriorFeatures> interiorFeatures = Lists.newArrayList(interiorFeaturesIterable);
            return interiorFeatures;
        }
        public InteriorFeatures findById(Long id) {
            Optional<InteriorFeatures> interiorFeatures = interiorFeatureRepository.findById(id);
            if (interiorFeatures.isPresent()) {
                return interiorFeatures.get();
            }
            return null;
        }

        public InteriorFeatures update(InteriorFeatures interiorFeatures) {
            if(interiorFeatureRepository.existsById(interiorFeatures.getId())){
                return interiorFeatureRepository.save(interiorFeatures);
            }
            else{
                return null;      }
        }
        public String deleteInteriorFeatures(Long id){
            interiorFeatureRepository.deleteById(id);
            return "Pomyslnie usunieto wyposazenie wenwentrzne";

        }


}

