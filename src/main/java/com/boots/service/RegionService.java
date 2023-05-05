package com.boots.service;

import com.boots.entity.TablesLevelRegion.Region;
import com.boots.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    RegionRepository regionRepository;


    public List<Region> allRegion() {
        return regionRepository.findAll();
    }
}
