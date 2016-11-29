<html><head><meta charset="utf-8"> 
<title>Agenda de Personas :: Consultar Personas</title>
</head>
<body>
<?php
function mostrarDatos ($resultados) {
	if ($resultados !=NULL) {
		echo "<tr><td>".$resultados['cedula']."</td>";
		echo "<td>".$resultados['nombre']."</td>";
		echo "<td>".$resultados['apellido']."</td>";
		echo "<td>".$resultados['telefono']."</td>";
		echo "<td>".$resultados['correo']."</td></tr>";
	}
	else {
		echo "<br/>No hay más datos!!! <br/>";
		}
}
	$link = mysqli_connect("localhost", "root", "");
	mysqli_select_db($link, "agenda1");
	$tildes = $link->query("SET NAMES 'utf8'");
	$result = mysqli_query($link, "SELECT * FROM Persona");
	echo"<center> <table border=1 align='center'>" ;	
	while ($fila = mysqli_fetch_array($result)){
	mostrarDatos($fila);
	}
	echo"</table></center>";	
	mysqli_free_result($result);
	mysqli_close($link);
?>
</body></html>