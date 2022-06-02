package com.COVINOC.USER.Controllers.Tourist;


import com.COVINOC.USER.Models.Tourist.Turista;
import com.COVINOC.USER.Repository.Tourist.TuristaRepository;
import com.COVINOC.USER.Services.Tourist.TuristaService;
import com.COVINOC.USER.Utils.Exceptions.ResourceNotFound;
import com.COVINOC.USER.Validations.Tourist.TuristaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/turista")
public class TuristaController {

    @Autowired
    private TuristaRepository turistaRepository;

    @Autowired
    private TuristaService turistaService;

    @Autowired
    private TuristaValidation turistaValidation;


    @RequestMapping(value = "turistas",method = RequestMethod.GET)
    public ResponseEntity<Collection<Turista>>getList(){
        return new ResponseEntity<>(turistaRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "turista/{id}",method = RequestMethod.GET)
    public ResponseEntity<Turista>getTuristaId(@PathVariable Integer id){
        Turista turista=turistaRepository.findById(id).orElseThrow();
        if (turista != null){
            return ResponseEntity.ok(turista);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?>UpdateTurista(@PathVariable Integer id,@RequestBody Turista turista){
        Map<String,Object>response=new HashMap<>();
        try {
            Turista updateTurista=turistaService.getTuristaId(id);
            turistaRepository.save(turista);
            response.put("Mensaje","El Turista Ha Sido Actualizado ".concat(id.toString()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
        }catch (DataAccessException exception){
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "New",method = RequestMethod.POST)
    public ResponseEntity<?>SaveTurista(@RequestBody Turista turista)throws ResourceNotFound {
        Map<String,Object>response=new HashMap<>();
        this.turistaValidation.ValidationTurista(turista);
        this.turistaRepository.save(turista);
        response.put("Mensaje","Turista Registrado En El Sistema");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?>DeleteTurista(@PathVariable Integer id){
        Map<String,Object>response=new HashMap<>();
        try {
            turistaRepository.deleteById(id);
            response.put("Mensaje","El Turista Ha sido Eliminado Del Sistema ".concat(id.toString()));
            return ResponseEntity.ok(response);
        }catch (DataAccessException exception){
            response.put("Mensaje","No se pudo Eliminar El Turista del Sistema ".concat(id.toString()));
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
        }

    }
}
