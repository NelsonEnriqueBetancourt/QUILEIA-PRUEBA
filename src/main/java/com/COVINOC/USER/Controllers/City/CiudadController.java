package com.COVINOC.USER.Controllers.City;


import com.COVINOC.USER.Models.City.Destino;
import com.COVINOC.USER.Repository.City.CiudadRepository;
import com.COVINOC.USER.Services.City.CiudadService;
import com.COVINOC.USER.Utils.Exceptions.ResourceNotFound;
import com.COVINOC.USER.Validations.City.CiudadValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/destino")
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private CiudadService ciudadService;

    @Autowired
    private CiudadValidation ciudadValidation;


    @RequestMapping(value = "ciudades",method = RequestMethod.GET)
    public ResponseEntity<Collection<Destino>>GetList(){
        return new ResponseEntity<>(ciudadRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "destino/{id}",method = RequestMethod.GET)
    public ResponseEntity<Destino>GetCityId(@PathVariable Integer id){
        Destino destino =ciudadRepository.findById(id).orElseThrow();
        if (destino != null){
            return ResponseEntity.ok(destino);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?>UpdateCity(@RequestBody Destino destino, @PathVariable Integer id){
        Map<String,Object>response=new HashMap<>();
        try {
            Destino updateCity=ciudadService.getCityId(id);
            ciudadRepository.save(destino);
            response.put("Mensaje","La Destino Ha Sido Actualizada ".concat(id.toString()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
        }catch (DataAccessException exception){
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "New",method = RequestMethod.POST)
    public ResponseEntity<?>SaveCity(@RequestBody Destino destino)throws ResourceNotFound {
        Map<String,Object>response=new HashMap<>();
        this.ciudadValidation.ValidationCity(destino);
        this.ciudadRepository.save(destino);
        response.put("Mensaje","La Destino Ha Sido Registrada En El Sistema ");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?>DeleteCity(@PathVariable Integer id){
        Map<String,Object>response=new HashMap<>();
        try {
            ciudadRepository.deleteById(id);
            response.put("Mensaje","La Destino Ha sido Eliminada Del Sistema ".concat(id.toString()));
            return ResponseEntity.ok(response);
        }catch (DataAccessException exception){
            response.put("Mensaje","La Destino no se Pudo Eliminar del Sistema ".concat(id.toString()));
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
        }
    }










}
