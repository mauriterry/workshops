
<html><head><meta charset="utf-8"> 
<title>Agenda de Personas :: Agregar Personas</title>
</head>
<body>
<?php
include ("includes.php");
$conexion = new Conexion("localhost", "root", "", "agendaoo");
$conexion->conectar();

$localidad = new Localidad();
$localidad = $localidad->obtenerLocalidad($conexion,10);

$p1 = new Persona();
$p1->setConexion($conexion);
$p1->setcedula(124522);
$p1->setnombre("Pedro");
$p1->setapellido("Perez");
$p1->setapodo("chanfles");
$p1->setempresa("La Mia");
<<<<<<< HEAD

$p1->setfechanacimiento("2016-02-01");
$p1->setlocalidad($localidad);
$p1->crearPersona($conexion,$p1);
=======
>>>>>>> 4b399faabb59662ddd2ba2c7ddc34372c49b8a83

$p1->setfechanacimiento("2016-02-01");
$p1->setlocalidad($localidad);
$p1->crearPersona($conexion,$p1);

echo "<h3>Datos Personales</h3>";
echo "Cedula: \t".$p1->getcedula()."<br>";
echo "Nombre: \t".$p1->getnombre()."<br>";
echo "Apellido: \t".$p1->getapellido()."<br>";
echo "Apodo: \t".$p1->getapodo()."<br>";
echo "Empresa: \t".$p1->getempresa()."<br>";
?>
</body></html>
