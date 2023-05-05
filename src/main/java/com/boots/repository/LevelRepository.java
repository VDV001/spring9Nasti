package com.boots.repository;

import com.boots.entity.TablesLevelRegion.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Long> {

}
