package com.example.wow.Services;

import com.example.wow.Entity.WowCharacterEntity;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CharacterService {

    List<WowCharacterEntity> getAllCharacters();

    ResponseEntity<String> saveCharacter(WowCharacterEntity wowCharacter);

    WowCharacterEntity getCharacter(int id);

    ResponseEntity<String> deleteCharacter(int id);

}
