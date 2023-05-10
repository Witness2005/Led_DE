package co.edu.umanizales.led_de.controller;

import co.edu.umanizales.led_de.controller.dto.LedDTO;
import co.edu.umanizales.led_de.controller.dto.ResponseDTO;
import co.edu.umanizales.led_de.model.Led;
import co.edu.umanizales.led_de.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/listde")
public class ListDEController {


    @Autowired
    private ListDEService listDEService;


    @GetMapping
    public ResponseEntity<ResponseDTO> printLeds() {
        List<Led> pets = listDEService.getLeds().toList();
        return new ResponseEntity<>(new ResponseDTO(
                200, pets, null), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ResponseDTO> addKid(@RequestBody LedDTO ledDTO){

        listDEService.getLeds().add(
                new Led(ledDTO.getIdentification(),false,null,null));

        return new ResponseEntity<>(new ResponseDTO(
                200,"Se ha adicionado el led",
                null), HttpStatus.OK);

    }





}
