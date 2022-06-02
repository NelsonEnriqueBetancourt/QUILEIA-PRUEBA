// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarTurista();
  $('#turistas').DataTable();
});


async function cargarTurista(){
  const request = await fetch('api/turista/turistas', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const turistas = await request.json();

  let listadoHtml ='';
  for(let Turista of turistas){
    let botonEliminar = '<a href="#" onclick="eliminarTurista('+Turista.id+')" class="btn btn-danger btn-circle btn-sn"><i class="fas fa-trash"></i></a>';
    let turistaHtml  =  '<tr><td>'+Turista.id+'</td><td>'+ Turista.nombre +'</td><td>'+ Turista.apellido +'</td><td>'+ Turista.fechaNacimiento
                        +'</td><td>'+Turista.identificacion+'</td><td>'+Turista.tipoIdentificacion
                        +'</td><td>'+Turista.frecuenciaViaje +'</td><td>'+Turista.precioViajar+'</td><td>'+Turista.usarTarjetaCredito+'</td><td>'+botonEliminar+'</td></tr>';
    listadoHtml += turistaHtml;
  }

document.querySelector('#turistas tbody').outerHTML=listadoHtml;

//<td>'+Turista.destino.name+'</td><td>'+Turista.destino.cantidadHabitantes+'</td><td>'+Turista.destino.hotelMasReservado+'</td><td>'+Turista.destino.sitioMasTuristico+'</td>
}



async function eliminarTurista(id){
    if(!confirm('¿ Desea Eliminar El Paciente Del Sistema ?')){
        return;
    }

  const request = await fetch('api/turista/delete/'+ id ,{
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  location.reload()
}

