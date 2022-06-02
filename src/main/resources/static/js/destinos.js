$(document).ready(function() {
    cargarCity();
  $('#destinos').DataTable();
});


async function cargarCity(){
  const request = await fetch('api/destino/ciudades', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const destinos = await request.json();

  let listadoHtml ='';
  for(let Destino of destinos){
    let botonEliminar = '<a href="#" onclick="eliminarDestino('+Destino.id+')" class="btn btn-danger btn-circle btn-sn"><i class="fas fa-trash"></i></a>';
    let destinoHtml  =  '<tr><td>'+Destino.id+'</td><td>'+ Destino.name +'</td><td>'+ Destino.cantidadHabitantes +'</td><td>'+ Destino.sitioMasTuristico
                        +'</td><td>'+Destino.hotelMasReservado+'</td><td>'+botonEliminar+'</td></tr>';
    listadoHtml += destinoHtml;
  }

document.querySelector('#destinos tbody').outerHTML=listadoHtml;


}



async function eliminarDestino(id){
    if(!confirm('¿ Desea Eliminar El Paciente Del Sistema ?')){
        return;
    }

  const request = await fetch('api/destino/delete/'+ id ,{
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  location.reload()
}