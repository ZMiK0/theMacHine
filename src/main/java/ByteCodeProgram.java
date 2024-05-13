public class ByteCodeProgram {
    private ByteCode[] program;
    private int num_elements;
    private int size;

    public ByteCodeProgram() {
        this.program = new ByteCode[this.size];
        this.size = 10;
        this.num_elements = 0;
    }

    public void resize(int _numElements) {
        if(_numElements >= this.size) {
            ByteCode[] program2 = new ByteCode[this.size * 2];
            System.arraycopy(this.program, 0, program2, 0, this.size);
            this.program = program2;
        }
    }

    public boolean addByteCode(ByteCode _byteCode, int _i) {
        if(this.num_elements >= this.size) {
            this.resize(this.size);
        }
        this.program[_i] = _byteCode;
        return true;
    }

    public String runProgram(CPU _cpu) {
        String mensaje = "";
        for(int i = 0; i < this.num_elements; i++) {
            if(!_cpu.isHalt() && _cpu.execute(this.program[i])) {

                mensaje += this.program[i].toString() + "\n";
            } else if (_cpu.isHalt()){
                mensaje += "HALT\n";
            }
        }
        _cpu.erase();
        _cpu.runCPU();
        return mensaje;
    }

    public ByteCode getProgram(int _i) {
        return this.program[_i];
    }
    //metodo para colocar un bytecode en una instruccion. Bytecode Int
}
