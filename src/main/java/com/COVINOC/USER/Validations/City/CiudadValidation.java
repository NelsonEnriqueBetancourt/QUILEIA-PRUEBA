package com.COVINOC.USER.Validations.City;

import com.COVINOC.USER.Models.City.Destino;
import com.COVINOC.USER.Utils.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Component;

@Component
public class CiudadValidation implements CityValidate{

    private void Message(String message)throws ResourceNotFound {
        throw new ResourceNotFound(message);
    }

    @Override
    public void ValidationCity(Destino destino) throws ResourceNotFound {
        if (destino.getName()==null){
            this.Message("El Name is Obligatorio,Intente Nuevamente");
        }
        if (destino.getCantidadHabitantes()==0){
            this.Message("La Campo is Obligatorio,Intente Nuevamente");

        }
        if (destino.getSitioMasTuristico()==null){
            this.Message("El Campo is Obligatorio,Intente Nuevamente");

        }
        if (destino.getHotelMasReservado()==null){
            this.Message("El Campo is Obligatorio,Intente Nuevamente");

        }


    }
}
