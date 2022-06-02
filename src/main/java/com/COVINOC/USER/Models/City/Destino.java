package com.COVINOC.USER.Models.City;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "City")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer id;
    @Column(name = "Name_City")
    private String Name;
    @Column(name = "Cantidad_Habitante")
    private int CantidadHabitantes;
    @Column(name = "SitioMas_Turistico")
    private String SitioMasTuristico;
    @Column(name = "HotelMas_Reservado")
    private String HotelMasReservado;


}
