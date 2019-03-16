package com.example.epam1.repository;

import com.example.epam1.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 15-Oct-18
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
