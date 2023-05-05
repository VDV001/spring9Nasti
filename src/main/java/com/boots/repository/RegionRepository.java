package com.boots.repository;

import com.boots.entity.TablesLevelRegion.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {

}
