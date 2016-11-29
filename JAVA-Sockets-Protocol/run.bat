@echo off

echo ..:: Limpiando Proyecto ::..
del .\build\co\edu\ucatolica\sistemas\servicios\Protocolo.class

echo ..:: Compilando Proyecto ::..
javac -d .\build\ .\src\co\edu\ucatolica\sistemas\servicios\Protocolo.java

echo "..:: Ejecutando Clase Principal ::.."
java -cp .\build\. co/edu/ucatolica/sistemas/servicios/Protocolo

pause