
<html><head><meta charset="utf-8"> 
<title>Agenda de Personas :: Consultar Personas</title>
</head>
<body>
<?php
	$link = mysqli_connect("localhost", "root", "");
	mysqli_select_db($link, "agenda1");
	$tildes = $link->query("SET NAMES 'utf8'");
	$id = $_POST['eliminado']; 
	$result = mysqli_query($link, " DELETE FROM Persona WHERE cedula =".$id);
	if(!$result) {
	echo 'No se ha eliminado el registro';
	} else {
	echo 'El registro se ha eliminado satisfactoriamente';
	}
	mysqli_free_result($result);
	mysqli_close($link);
?>
</body></html>




