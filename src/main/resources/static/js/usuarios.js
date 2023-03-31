// Call the dataTables jQuery plugin
$(document).ready(function () {
  loadUsers();
  $("#usuarios").DataTable();
});

const loadUsers = async () => {
  const request = await fetch("api/usuarios", {
    method: "GET",
    headers: {
      "Acepted": "application/json",
      "Content-Type": "application/json",
    },
  });
  const usuarios = await request.json();
  let textUsuarios = "";



  usuarios.forEach((user) => {
   let btnDelete = '<a href="#" class="btn btn-danger btn-circle" onclick="deleteUser('+ user.id +')"> <i class="fas fa-trash"></i></a>';
    textUsuarios += ` 
    <tr>
     <td> ${user.id} </td>
     <td>${user.nombre}</td>
     <td>${user.apellido}</td>
     <td>${user.email}</td>
     <td>${user.telefono}</td>
     <td>
        ${btnDelete}
        <a href="#"
            class="btn btn-info btn-circle">
            <i class="fas fa-info-circle"></i>
        </a>
      </td>
    </tr>`;
  });
  document.querySelector("#usuarios tbody").outerHTML = textUsuarios;
  console.log(textUsuarios);
};

const deleteUser = async (id) => {
    if(confirm("Esta seguro de eliminar el usuario ?")){
        await fetch(`api/usuario/${id}`, {
         method: "DELETE",
         headers: {
         "Acepted": "application/json",
         "Content-Type": "application/json",
        },
    });

    }else{
        alert("operacion cancelada")
    }

}
