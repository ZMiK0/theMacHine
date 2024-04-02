# Descripción

Este programa es una simulación de una máquina virtual donde ejecutas comandos y suceden cosas

## USO

HELP: Muestra esta ayuda
QUIT: Cierra el programa
RUN: Ejecuta el programa
NEWINST BYTECODE: Introduce una nueva instrucción el programa
	PUSH N: Almacena un número en la pila
	ADD
	SUB
	MUL
	DIV
	LOAD N: Carga el valor de la memoria en la posición N
	STORE N: Elimina el valor y lo guarda en la memoria en la posición N de esta
	OUT: Se escribe en la consola "Lo que hay encima de la pila es {numero}"
	HALT: Detiene el programa, no se ejecutan las siguientes instrucciones
RESET: Vacía el programa actual
REPLACE N: Reemplaza la instrucción N por la solicitada por el usuario