package com.COVINOC.USER.Validations.Tourist;

import com.COVINOC.USER.Models.City.Destino;
import com.COVINOC.USER.Models.Tourist.Turista;
import com.COVINOC.USER.Utils.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

@Service
public interface TuristaValidate {

    public void ValidationTurista(Turista turista)throws ResourceNotFound;

}
