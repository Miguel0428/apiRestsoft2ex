package com.software2ex.apiRest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.software2ex.apiRest.model.Camisa;

@RestController
@RequestMapping("/api/camisas")
public class CamisaController {

private List<Camisa> camisas;

public CamisaController(){

    try {
        ObjectMapper objectMapper = new ObjectMapper();
        Camisa[] camisasArray = objectMapper.readValue(new ClassPathResource("camisas.json").getFile(),Camisa[].class);
        camisas = new ArrayList<>(Arrays.asList(camisasArray));
    } catch (IOException e) {
        e.printStackTrace();
        camisas = new ArrayList<>();
    }
}

@GetMapping("/all")
public List<Camisa> getAllCamisas(){
    return camisas;
}

@GetMapping("/{id}")
public Camisa getCamisaByid(@PathVariable Long id){
    return camisas.stream().filter(camisa -> camisa.getId().equals(id)).findFirst().orElse(null);
}

@PostMapping("/add/camisa")
public Camisa createCamisa(@RequestBody Camisa camisa){
    camisas.add(camisa);
    return camisa;
}

@PutMapping("/update-camisa/{id}")
public Camisa updateCamisa(@PathVariable Long id, @RequestBody Camisa updatedCamisa){
    Camisa camisa = getCamisaByid(id);
    if (camisa != null){
        camisa.setName(updatedCamisa.getName());
        camisa.setValue(updatedCamisa.getValue());
        return camisa;
    }
    return null;
}

@DeleteMapping("/delete-camisa/{id}")
public void deleteCamisa(@PathVariable Long id){
    camisas.removeIf(camisa -> camisa.getId().equals(id));
}

}
