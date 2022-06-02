$(document).ready(function() {


});


async function registrarTuristas(){
    let datos={};
    datos.nombre= document.getElementById('txtNombre').value;
    datos.apellido= document.getElementById('txtApellido').value;
    datos.fechaNacimiento= document.getElementById('txtFechaNacimiento').value;
    datos.identificacion= document.getElementById('txtIdentificacion').value;
    datos.tipoIdentificacion= document.getElementById('txtTipoIdentificacion').value;
    datos.frecuenciaViaje= document.getElementById('txtMesesViajando').value;
    datos.precioViajar= document.getElementById('txtPrecioViajar').value;
    datos.usarTarjetaCredito= document.getElementById('txtTarjetaCredito').value;



  const request = await fetch('api/turista/New', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
      body: JSON.stringify(datos)
  });

  window.location.href='registrarTuristas.html'

}

