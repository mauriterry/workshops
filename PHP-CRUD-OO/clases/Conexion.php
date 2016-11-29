<?php
class Conexion {
	
	public $servidor;
	public $puerto;
	public $usuario;
	public $pasword;
	public $basededatos;
	public $consulta;
	
	public $puntero;
	
	public function __construct($servidor, $usuario, $password, $basededatos){
		$this->servidor = $servidor;
		$this->usuario = $usuario;
		$this->password = $password;
		$this->basededatos = $basededatos;
	}
	
	function conectar() {
        $conexion = mysqli_connect($this->servidor, $this->usuario, $this->password, $this->basededatos);
		$this->puntero = $conexion;
        if (!$conexion) {
            die('No se puede conectar a la Base de Datos!');
        } else {
          
            echo 'Connection established!';}
        return $this->puntero;
    }

    function cerrar() {
        mysqli_close($this->puntero);
        echo 'Conexion Cerrada!';
    }
	
	function consultar($query){
		$this->consulta = $query;
		$resultado = mysqli_query($this->puntero, $this->consulta);
		return $resultado;	
	}

	
}

?>