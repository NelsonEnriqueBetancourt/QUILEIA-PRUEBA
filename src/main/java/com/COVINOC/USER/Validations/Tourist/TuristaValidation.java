package com.COVINOC.USER.Validations.Tourist;


import com.COVINOC.USER.Models.City.Destino;
import com.COVINOC.USER.Models.Tourist.Turista;
import com.COVINOC.USER.Utils.Exceptions.ResourceNotFound;
import org.springframework.stereotype.Component;

@Component
public class TuristaValidation implements TuristaValidate{

    private void Message(String message)throws ResourceNotFound {
        throw new ResourceNotFound(message);
    }

    @Override
    public void ValidationTurista(Turista turista) throws ResourceNotFound {
        if (turista.getNombre() == null) {
            this.Message("El Nombre is Obligatorio,Intente Nuevamente");
        }
        if (turista.getApellido() == null) {
            this.Message("El Apellido is Obligatorio,Intente Nuevamente");
        }

        if (turista.getFechaNacimiento() == null) {
            this.Message("La Date is Obligatorio,Intente Nuevamente");

        }
        if (turista.getIdentificacion() == 0) {
            this.Message("La Identification is Obligatorio,Intente Nuevamente");

        }
        if (turista.getTipoIdentificacion() == null) {
            this.Message("El TypeIdentification is Obligatorio,Intente Nuevamente");

        }
        if (turista.getFrecuenciaViaje() == 0) {
            this.Message("la FrecuenciaTravel is Obligatorio,Intente Nuevamente");

        }
        if (turista.getPrecioViajar() == 0) {
            this.Message("El PriceTravel is Obligatorio,Intente Nuevamente");

        }

    }

}
