public class CPU {
    private Memory memoria;
    private OperandStack pila;
    private boolean isHalt;

    boolean bienhecho = true;//borrar

    public boolean execute(ByteCode _instr) {
        if(bienhecho) { //borrar bien hecho
            return true;
        } else {return false;}
    }

    public String toString() {
        return "Estado de la CPU:\n" + memoria.toString() + "\n" + pila.toString();
    }
}
