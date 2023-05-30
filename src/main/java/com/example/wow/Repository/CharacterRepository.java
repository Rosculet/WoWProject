package com.example.wow.Repository;

import com.example.wow.Entity.WowCharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<WowCharacterEntity, Integer> {

}
