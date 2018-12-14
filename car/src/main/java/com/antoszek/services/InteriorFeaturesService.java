package com.antoszek.services;

import com.antoszek.model.entityClass.InteriorFeatures;
import com.antoszek.repository.InteriorFeatureRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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


}

