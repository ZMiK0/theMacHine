public class CPU {
    private Memory memoria;
    private OperandStack pila;
    private boolean isHalt;

    public CPU() {
        this.memoria = new Memory();
        this.pila = new OperandStack();
        this.isHalt = false;
    }

    public boolean execute(ByteCode _instr) {
        switch (_instr.getName()) {
            case ADD:
                return this.sumaPila();
            case PUSH:
                return this.push(_instr.getParam());
            case LOAD:
                return this.loadMemoria(_instr.getParam());
            case STORE:
                return this.storeMemoria(_instr.getParam());
            case SUB:
                return this.restarPila();
            case MUL:
                return this.multiplicarPila();
            case DIV:
                return this.dividirPila();
            case OUT:
                return this.outPila();
            case HALT:
                return this.haltPrograma();
            default:
                return false;
        }
    }

    public boolean isHalt() {
        return isHalt;
    }

    public String toString() {
        return "\nEstado de la CPU:\n" + memoria.toString() + "\n" + pila.toString() + "\n-----------------";
    }

    public void runCPU() {
        this.isHalt = false;
    }

    public void erase() {
        this.memoria = new Memory();
        this.pila = new OperandStack();
    }

    public boolean push(int _n) {
        this.runCPU();
        this.pila.push(_n);
        return true;
    }

    public boolean sumaPila() {
        this.runCPU();
        int e1 = this.pila.pop();
        int e2 = this.pila.pop();
        if(e2!=-1) {
            int result = e1 + e2;
            this.pila.push(result);
            return true;
        } else {
            return false;
        }
    }

    public boolean restarPila() {
        this.runCPU();
        int e1 = this.pila.pop();
        int e2 = this.pila.pop();
        if(e2!=-1) {
            int result = e1 - e2;
            this.pila.push(result);
            return true;
        } else {
            return false;
        }
    }

    public boolean multiplicarPila() {
        this.runCPU();
        int e1 = this.pila.pop();
        int e2 = this.pila.pop();
        if(e2!=-1) {
            int result = e1 * e2;
            this.pila.push(result);
            return true;
        } else {
            return false;
        }
    }

    public boolean dividirPila() {
        this.runCPU();
        int e1 = this.pila.pop();
        int e2 = this.pila.pop();
        if(e2!=-1) {
            int result = e1 / e2;
            this.pila.push(result);
            return true;
        } else {
            return false;
        }
    }

    public boolean storeMemoria(int _pos) {
        this.runCPU();
        this.memoria.write(_pos, this.pila.pop());
        return true;
    }

    public boolean loadMemoria(int _pos) {
        this.runCPU();
        this.pila.push(this.memoria.read(_pos));
        return true;
    }

    public boolean outPila() {
        this.runCPU();
        int temp = this.pila.pop();
        this.pila.push(temp);
        System.out.println("La cima de la pila es: " + temp);
        return true;
    }

    public boolean haltPrograma() {
        this.isHalt = true;
        return true;
    }

    public boolean reset() {
        this.pila = new OperandStack();
        this.memoria = new Memory();
        return true;
    }

}
