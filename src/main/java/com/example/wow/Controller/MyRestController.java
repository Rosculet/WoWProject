package com.example.wow.Controller;

import com.example.wow.Entity.WowCharacterEntity;
import com.example.wow.Services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private CharacterService characterService;

    @DeleteMapping("/character/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable int id){
        return characterService.deleteCharacter(id);
    }

    @GetMapping("/characters")
    public List<WowCharacterEntity> showAllCharacters(){
        return characterService.getAllCharacters();
    }

    @GetMapping("/character/{id}")
    public WowCharacterEntity showAllCharacters(@PathVariable int id){
        return characterService.getCharacter(id);
    }

    @PostMapping("/character")
    public ResponseEntity<String> addNewCharacter(@RequestBody WowCharacterEntity wowCharacter){
        return characterService.saveCharacter(wowCharacter);
    }
}
