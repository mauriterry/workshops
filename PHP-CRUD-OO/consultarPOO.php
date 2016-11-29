
<html><head><meta charset="utf-8"> 
<title>Agenda de Personas :: Consultar Personas</title>
</head>
<body>
<?php
include ("includes.php");
$conexion = new Conexion("localhost", "root", "", "Agenda");
$conexion->conectar();

$personas = new Persona();
$personas->setConexion($conexion);
$pers;
$resultado = $personas->obtenerPersonas($conexion);
echo "<center><table border='1' cellspacing='2' cellpadding='2'>
<tr><td>Cedula</td><td>Nombre</td><td>Apellido</td><td>Apodo</td><td>Empresa</td><td>Fecha de Nacimiento</td><td>Localidad</td> <td>genero</td><tr> ";
foreach ($resultado as &$persona) {
	$pers = $persona;
	echo "<tr>";
   	echo "<td>".$persona->getcedula()."</td>";
	echo "<td>".$persona->getnombre()."</td>";
	echo "<td>".$persona->getapellido()."</td>";
	echo "<td>".$persona->getapodo()."</td>";
	echo "<td>".$persona->getempresa()."</td>";
	echo "<td>".$persona->getfechaNacimiento()."</td>";
	echo "<td>".$persona->getlocalidad()->getNombre()."</td>";
	echo "<td>".$persona->getgenero()."</td>";
	echo "</tr>";
}
echo "</table></center>";
?>
</body></html>