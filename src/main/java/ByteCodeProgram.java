public class ByteCodeProgram {
    private ByteCode[] program;
    private int numElements;
    private int size;

    public ByteCodeProgram() {
        this.size = 10;
        this.program = new ByteCode[this.size];
        this.numElements = 0;
    }

    public String toString() {
        String chain = "Programa almacenado:\n";
        for (int i = 0; i < this.numElements; i++) {
            chain += i + ": " + this.program[i].getName() + " " + this.program[i].getParam() + "\n";
        }
        return chain;
    }


    private void resize(int _numElements) {
        ByteCode[] new_program = new ByteCode[_numElements * 2];
        for (int i = 0; i < this.program.length; i++) {
            new_program[i] = this.program[i];
        }
        this.program = new_program;
    }

    public void addByteCode(ByteCode _byteCode) {
        if (this.numElements >= this.program.length) {
            this.resize(this.numElements);
            this.program[this.numElements] = _byteCode;
            this.numElements++;
        } else {
            this.program[this.numElements] = _byteCode;
            this.numElements++;
        }
    }

    public boolean replaceByteCode(ByteCode _byteCode, int _i) {
        this.program[_i] = _byteCode;
        return true;
    }

    public String runProgram(CPU _cpu) {
        String mensaje = "";
        for (int i = 0; i < this.numElements; i++) {
            if (!_cpu.isHalt() && _cpu.execute(this.program[i])) {
                mensaje += "\n-----------------\nEl estado de la máquina tras ejecutar " + this.program[i].getName() + " " + this.program[i].getParam() + " es:\n" + _cpu.toString() + "\n";
            } else if (!_cpu.isHalt()) {
                mensaje += "No se ha podido ejecutar, ejecución incorrecta";
            }
        }
        _cpu.erase();
        _cpu.runCPU();
        return mensaje;
    }

    public void reset() {
        this.numElements = 0;
        this.program = new ByteCode[this.size];
    }
}