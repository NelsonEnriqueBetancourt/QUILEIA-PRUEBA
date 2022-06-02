$(document).ready(function() {


});


async function registrarCiudades(){
    let datos={};
    datos.name= document.getElementById('txtNombreCity').value;
    datos.hotelMasReservado= document.getElementById('txtHotelVisitado').value;
    datos.sitioMasTuristico= document.getElementById('txtSitiosTuristicos').value;
    datos.cantidadHabitantes= document.getElementById('txtNumeroHabitantes').value;



  const request = await fetch('api/destino/New', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
      body: JSON.stringify(datos)
  });

  window.location.href='registrarCiudades.html'

}

