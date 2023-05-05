package com.boots.service;

import com.boots.entity.TablesLevelRegion.Level;
import com.boots.entity.TablesLevelRegion.Region;
import com.boots.entity.TablesUserRole.Role;
import com.boots.entity.TablesUserRole.User;
//import com.boots.entity.TablesUserRole.UserRole;
import com.boots.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LevelService {
    @Autowired
    LevelRepository levelRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RegionRepository regionRepository;

    @Autowired
    UserRepository userRepository;

    int ADMIN = 0;
    public  void  FillTables(){

        if (ADMIN < 1)
        {
            /** Создаем объекты классов для таблиц Boss, Depart и заполняем их **/

            Level level_1 = new Level(1L, "ур 1 - чисто");
            Level level_2 = new Level(2L, "ур 2 -грязно");
            Level level_3 = new Level(3L, "ур 3 - очень грязно");

            Region region_1 = new Region(1L, "Хабаровская область");
            Region region_2 = new Region(2L, "Свердловская область");
            Region region_3 = new Region(3L, "Московская область");
            region_1.add(level_1);
            region_1.add(level_2);
            region_2.add(level_3);
            region_3.add(level_2);

            /** Создаем объекты классов для таблиц Role, User и заполняем их **/

            Role role_admin = new Role(2L, "ROLE_ADMIN");
            Role role_user = new Role(1L, "ROLE_USER");

            // пароль  =  "admin". Записал ее как Хэш
            User admin = new User(1L, "admin", "$2a$10$jeCQe4UwkH0lLKd3hGQFreXwhKBEvLuLoe7FwjEtVQX77v7hD.nMy");

            /** Сохраняем объекты в БД  **/

            levelRepository.save(level_1);
            levelRepository.save(level_2);
            levelRepository.save(level_3);

            regionRepository.save(region_1);
            regionRepository.save(region_2);
            regionRepository.save(region_3);

            roleRepository.save(role_admin);
            roleRepository.save(role_user);

            /** После сохранения в БД ролей, устанавливаем User-у : admin роль - role_admin **/

            admin.setRoles(Collections.singleton(role_admin));

            userRepository.save(admin);

            roleRepository.save(role_admin);
            roleRepository.save(role_user);

            ADMIN++;
        }
    }

    public List<Level> allLevels() {
        return levelRepository.findAll();
    }

    public boolean deleteLevels(Long levelId) {
        if (levelRepository.findById(levelId).isPresent()) {
            levelRepository.deleteById(levelId);
            return true;
        }
        return false;
    }

}
