
<html><head><meta charset="utf-8"> 
<title>Agenda de Personas :: Agregar Personas</title>
</head>
<body>
<?php
	$link = mysqli_connect("localhost", "root", "");
	mysqli_select_db($link, "agenda1");
	$tildes = $link->query("SET NAMES 'utf8'");
	$cedula= $_POST['cedula'];
	$nombre= $_POST['nombre'];
	$apellido= $_POST['apellido'];
	$telefono= $_POST['telefono'];
	$correo= $_POST['correo'];
	$query = "insert into Persona values (".$cedula.",'".$nombre."','".$apellido."','".$telefono."','".$correo."')";
	mysqli_query($link, $query);
	$result = mysqli_query($link, "SELECT * FROM Persona");
	if(!$result) {
	echo 'No se ha agregado el registro';
	} else {
	echo 'El registro se ha agregado satisfactoriamente';
	}
	mysqli_free_result($result);
	mysqli_close($link);
?>
</body></html>


