package com.COVINOC.USER.Validations.City;

import com.COVINOC.USER.Models.City.Destino;
import com.COVINOC.USER.Utils.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

@Service
public interface CityValidate {

    public void ValidationCity(Destino destino)throws ResourceNotFound;
}
