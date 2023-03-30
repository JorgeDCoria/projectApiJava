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
    textUsuarios += ` 
    <tr>
     <td> ${user.id} </td>
     <td>${user.nombre}</td>
     <td>${user.apellido}</td>
     <td>${user.email}</td>
     <td>${user.telefono}</td>
     <td>61456132</td>
     <td>
        <a href="#" class="btn btn-danger btn-circle">
            <i class="fas fa-trash"></i>
        </a>
        <a href="#" class="btn btn-info btn-circle">
            <i class="fas fa-info-circle"></i>
        </a>
      </td>
    </tr>`;
  });
  document.querySelector("#usuarios tbody").outerHTML = textUsuarios;
  console.log(textUsuarios);
};
