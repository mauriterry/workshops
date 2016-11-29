<?php
class Persona {
	
	public $cedula;
	public $nombre;
	public $apellido;
	public $apodo;
	public $fechaNacimiento;
	public $empresa;
	public $localidad;
	public $genero;
	
	public $conexion;
	
	public function __construct(){
		$this->cedula = 0;
		$this->nombre = "";
		$this->apellido = "";
		$this->apodo = "";
		$this->fechaNacimiento = "";
		$this->empresa = "";
		$this->localidad = new Localidad();
		$this->genero = 1;
	}
	
	public function crearPersona($conexion, $persona){
		$this->conexion = $conexion;
		$consulta = "insert into Persona values(";
		$consulta = $consulta.$persona->cedula.", "; 
		$consulta = $consulta."'".$persona->nombre."', "; 
		$consulta = $consulta."'".$persona->apellido."', "; 
		$consulta = $consulta."'".$persona->apodo."', "; 
		$consulta = $consulta."'".$persona->fechaNacimiento."', "; 
		$consulta = $consulta."'".$persona->empresa."', "; 
		$consulta = $consulta.$persona->localidad->getid().", "; 
		$consulta = $consulta.$persona->genero." "; 
		$consulta = $consulta.");";
		$resultado = $conexion->consultar($consulta);
	}

	public function borrarPersona($conexion, $id){
		$this->conexion = $conexion;
		$consulta = "delete from Persona where cedula = ". $id. ";";
		$resultado = $conexion->consultar($consulta);
	}
	
	public function obtenerPersona($conexion, $cedula){
		$this->conexion = $conexion;
		$resultado = $conexion->consultar("SELECT * FROM Persona where cedula=". $cedula. ";");
		$persona = new Persona();
		while ($fila = mysqli_fetch_array($resultado)){
			if ($fila !=NULL) {
				$persona->cedula = $fila['cedula'];
				$persona->nombre = $fila['nombre'];
				$persona->apellido = $fila['apellido'];
				$persona->apodo = $fila['apodo'];
				$persona->fechaNacimiento = $fila['fechaNacimiento'];
				$persona->empresa = $fila['empresa'];
				$localidad = new Localidad();
				$localidad = $localidad->obtenerLocalidad($conexion, $fila['localidad']);
				$siguientePersona->localidad = $localidad;
				$persona->genero = $fila['genero'];
			}
		}
		return $persona;
	}
	
	public function obtenerPersonas($conexion){
		$this->conexion = $conexion;
		$resultado = $conexion->consultar("SELECT * FROM Persona;");
		$listadodePersonas = array();
		while ($fila = mysqli_fetch_array($resultado)){
			if ($fila !=NULL) {
				$siguientePersona = new Persona();
				$siguientePersona->cedula = $fila['cedula'];
				$siguientePersona->nombre = $fila['nombre'];
				$siguientePersona->apellido = $fila['apellido'];
				$siguientePersona->apodo = $fila['apodo'];
				$siguientePersona->fechaNacimiento = $fila['fechaNacimiento'];
				$siguientePersona->empresa = $fila['empresa'];
				$localidad = new Localidad();
				$localidad = $localidad->obtenerLocalidad($conexion, $fila['localidad']);
				$siguientePersona->localidad = $localidad;
				$siguientePersona->genero = $fila['genero'];
				$listadodePersonas[] = $siguientePersona;
			}
		}
		return $listadodePersonas;
	}
	
	public function obtenerTelefonosPersonas(){
		$resultado = $conexion->consultar("SELECT CONCAT(Persona.nombre, ' ',Persona.apellido) as 'Nombre', Persona.apodo as 'Apodo', Telefono.numero 'Numero de Telefono', Telefono.tipo 'Tipo' FROM Persona INNER JOIN Telefono on Telefono.cedula = Persona.cedula;");
		//Para hacer!
	}
	
	public function actualizarPersona($conexion, $persona){
		$this->conexion = $conexion;
		$consulta = "update Persona set ";
		$consulta = $consulta."cedula=".$persona->cedula.", "; 
		$consulta = $consulta."nombre='".$persona->nombre."', "; 
		$consulta = $consulta."apellido='".$persona->apellido."', "; 
		$consulta = $consulta."apodo='".$persona->apodo."', "; 
		$consulta = $consulta."fechaNacimiento='".$persona->fechaNacimiento."', "; 
		$consulta = $consulta."empresa='".$persona->empresa."', "; 
		$consulta = $consulta."localidad=".$persona->localidad.", "; 
		$consulta = $consulta."genero=".$persona->genero." "; 
		$consulta = $consulta."where cedula=".$persona->cedula.";";
		$resultado = $conexion->consultar($consulta);
	}
	
	
	public function getgenero() {
		return $this->genero;
	}   
	public function setgenero($valor) {
		$this->genero = $valor;
	}
		
	public function getlocalidad() {
		return $this->localidad;
	}   
	public function setlocalidad($valor) {
		$this->localidad = $valor;
	}
	
	public function getempresa() {
		return $this->empresa;
	}   
	public function setempresa($valor) {
		$this->empresa = $valor;
	}
	
	public function getfechaNacimiento() {
		return $this->fechaNacimiento;
	}   
	public function setfechaNacimiento($valor) {
		$this->fechaNacimiento = $valor;
	}
	
	public function getapodo() {
		return $this->apodo;
	}   
	public function setapodo($valor) {
		$this->apodo = $valor;
	}
	
	public function getapellido() {
		return $this->apellido;
	}   
	public function setapellido($valor) {
		$this->apellido = $valor;
	}
	
	public function getnombre() {
		return $this->nombre;
	}   
	public function setnombre($valor) {
		$this->nombre = $valor;
	}
	
	public function getcedula() {
		return $this->cedula;
	}   
	function setcedula($valor) {
		$this->cedula = $valor;
	}
	
	function setConexion($valor) {
		$this->conexion = $valor;
	}
}

?>
