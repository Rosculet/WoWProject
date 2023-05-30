package com.example.wow.Services;

import com.example.wow.Entity.WowCharacterEntity;
import com.example.wow.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService{

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<WowCharacterEntity> getAllCharacters() {
        return characterRepository.findAll();
    }

    @Override
    public ResponseEntity<String> saveCharacter(WowCharacterEntity wowCharacter) {

        characterRepository.save(wowCharacter);
        return ResponseEntity.ok("Character created successfully");
    }

    @Override
    public WowCharacterEntity getCharacter(int id) {
        Optional<WowCharacterEntity> optionalCharacter = characterRepository.findById(id);
        return optionalCharacter.orElseThrow(() -> new NullPointerException("Character not found with id: " + id));
    }

    @Override
    public ResponseEntity<String> deleteCharacter(int id) {
        Optional<WowCharacterEntity> characterOptional = characterRepository.findById(id);

        if (characterOptional.isPresent()) {
            characterRepository.deleteById(id);
            return ResponseEntity.ok("Character deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
