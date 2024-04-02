# Descripción

Este programa es una simulación de una máquina virtual donde ejecutas comandos y suceden cosas

## USO

**help**: Muestra esta ayuda 

**quit**: Cierra el programa


**run**: Ejecuta el programa


**newinst bytecode**: Introduce una nueva instrucción el programa:
	
* **push N**: Almacena un número en la pila
* **add**: Suma los valores
* **sub**: Resta los valores
* **mul**: Multiplica los valores
* **div**: Divide los valores
* **load N**: Carga el valor de la memoria en la posición N
* **store N**: Elimina el valor y lo guarda en la memoria en la posición N de esta
* **out**: Se escribe en la consola "Lo que hay encima de la pila es {numero}"
* **halt**: Detiene el programa, no se ejecutan las siguientes instrucciones

**reset**: Vacía el programa actual

**replace N**: Reemplaza la instrucción N por la solicitada por el usuario

# Dependencias

* jdk21

# Instalación
```bash
git clone https://github.com/MIK0ZZ/theMacHine.git
cd theMacHine
#insertar aqui el codigo de ejecucion de java que ahora mismo no me acuerdo
```