# Descripción

Este programa es una simulación de una máquina virtual donde ejecutas comandos y suceden cosas

## USO

**help**
Comienza la ejecución de HELP
	HELP: Muestra esta ayuda
	QUIT: Cierra el programa
	RUN: Ejecuta el programa
	NEWINST BYTECODE: Introduce una nueva instrucción el programa
	RESET: Vacía el programa actual
	REPLACE N: Reemplaza la instrucción N por la solicitada por el usuario
	STORE N: Guarda en la memoria el último valor en la posición N
	LOAD N: Carga el valor de la memoria en la posición N

**newinst push 2**
Comienza la ejecución de NEWINST PUSH 2
Programa almacenado:
0: PUSH 2

**newinst push 3**
Comienza la ejecución de NEWINST PUSH 3
Programa almacenado:
0: PUSH 2
1: PUSH 3

**newinst mul**
Comienza la ejecución de NEWINST MUL
Programa almacenado
0: PUSH 2
1: PUSH 3
2: MUL

**newinst store 1**
Comienza la ejecución de NEWINST STORE 1
Programa almacenado
0: PUSH 2
1: PUSH 3
2: MUL
3: STORE 1

**newinst load 1**
Comienza la ejecución de NEWINST STORE 1
Programa almacenado
0: PUSH 2
1: PUSH 3
2: MUL
3: STORE 1
4: LOAD 1

**newinst push 2**
Comienza la ejecución de NEWINST STORE 1
Programa almacenado
0: PUSH 2
1: PUSH 3
2: MUL
3: STORE 1
4: LOAD 1
5: PUSH 2

**newinst add**
Comienza la ejecución de NEWINST STORE 1
Programa almacenado
0: PUSH 2
1: PUSH 3
2: MUL
3: STORE 1
4: LOAD 1
5: PUSH 2
6: ADD

**newinst store 2**
Comienza la ejecución de NEWINST STORE 1
Programa almacenado
0: PUSH 2
1: PUSH 3
2: MUL
3: STORE 1
4: LOAD 1
5: PUSH 2
6: ADD
7: STORE 2

**run**
Comienza la ejecución de RUN
El estado de la máquina tras ejecutar el bytecode PUSH 2 es:

Estado de la CPU:
	Memoria: <VACÍA>
	Pila: 2

El estado de la máquina tras ejecutar el bytecode PUSH 3 es:

Estado de la CPU:
	Memoria: <VACÍA>
	Pila: 2 3

El estado de la máquina tras ejecutar el bytecode MUL es:

Estado de la CPU:
	Memoria: <VACÍA>
	Pila: 6

El estado de la máquina tras ejecutar el bytecode STORE 1 es:

Estado de la CPU:
	Memoria: [1]6
	Pila: <VACÍA>

El estado de la máquina tras ejecutar el bytecode LOAD 1 es:

Estado de la CPU:
	Memoria: [1]6
	Pila: 6

El estado de la máquina tras ejecutar el bytecode PUSH 2 es:

Estado de la CPU:
	Memoria: [1]6
	Pila: 6 2

El estado de la máquina tras ejecutar el bytecode ADD es:

Estado de la CPU:
	Memoria: [1]6
	Pila: 8

El estado de la máquina tras ejecutar el bytecode ADD es:

Estado de la CPU:
	Memoria: [1]6
	Pila: 8

El estado de la máquina tras ejecutar el bytecode STORE 2 es:

Estado de la CPU:
	Memoria: [1]6 [2]8
	Pila: <VACÍA>

Programa almacenado
0: PUSH 2
1: PUSH 3
2: MUL
3: STORE 1
4: LOAD 1
5: PUSH 2
6: ADD
7: STORE 2