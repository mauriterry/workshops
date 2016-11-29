<?php
class Localidad {
	
	public $id;
	public $nombre;
	
	public $conexion;
	
	public function __construct(){
		$this->id = 0;
		$this->nombre = "";
	}
	
	public function crearLocalidad($conexion, $localidad){
		$this->conexion = $conexion;
		$consulta = "insert into Localidad values(";
		$consulta = $consulta.$localidad->id.", "; 
		$consulta = $consulta."'".$localidad->nombre."', "; 
		$consulta = $consulta.");";
		$resultado = $conexion->consultar($consulta);
	}
	
	public function borrarLocalidad($conexion, $id){
		$this->conexion = $conexion;
		$consulta = "delete from Localidad where cedula = ".$id. ";";
		$resultado = $conexion->consultar($consulta);
	}
	
	public function obtenerLocalidad($conexion, $id){
		$this->conexion = $conexion;
		$consulta = "SELECT * FROM Localidad where id=". $id. ";";
		$localidad = new Localidad();
		$resultado = $conexion->consultar($consulta);
		while ($fila = mysqli_fetch_array($resultado)){
			if ($fila !=NULL) {
				$localidad->id = $fila['id'];
				$localidad->nombre = $fila['nombre'];
			}
		}
		return $localidad;
	}
	
	public function obtenerLocalidades($conexion){
		$this->conexion = $conexion;
		$resultado = $conexion->consultar("SELECT * FROM Localidad;");
		$listadodeLocalidades = array();
		while ($fila = mysqli_fetch_array($resultado)){
			if ($fila !=NULL) {
				$localidad = new Localidad();
				$localidad->id = $fila['id'];
				$localidad->nombre = $fila['nombre'];
				$listadodeLocalidades[] = $localidad;
			}
		}
		return $listadodeLocalidades;
	}
	
	public function editarLocalidad($conexion, $localidad){
		$this->conexion = $conexion;
		$consulta = "update Localidad set ";
		$consulta = $consulta."id=".$localidad->id.", "; 
		$consulta = $consulta."nombre='".$localidad->nombre."', "; 
		$consulta = $consulta."where id=".$localidad->id.";";
		$resultado = $conexion->consultar($consulta);
	}
		
	public function getnombre() {
		return $this->nombre;
	}   
	public function setnombre($valor) {
		$this->nombre = $valor;
	}
	
	public function getid() {
		return $this->id;
	}   
	function setid($valor) {
		$this->id = $valor;
	}

	function setConexion($valor) {
		$this->conexion = $valor;
	}
	
}

?>