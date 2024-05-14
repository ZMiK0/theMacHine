import org.w3c.dom.ls.LSOutput;

public class OperandStack {
    private int[] stack;
    private int num_elements;
    private int MAX_NUM;

    public OperandStack() {
        this.MAX_NUM = 10;
        this.num_elements = 0;
        this.stack = new int[MAX_NUM];
    }

    /**
     * Comprueba que la pila no esté vacía
     * @return
     */
    public boolean isEmpty() {
        return this.num_elements == 0;
    }

    /**
     * Añade un elemento a la cima de la pila
     * @param _elemento
     * @return
     */
    public boolean push(int _elemento) {
        if(this.num_elements < MAX_NUM) {
            this.stack[this.num_elements] = _elemento;
            this.num_elements++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve el primer elemento de la pila y lo elimina
     * @return
     */
    public int pop() {
        if(this.isEmpty()) {
            return -1;
        } else {
            int ultimo = this.stack[this.num_elements - 1];
            this.num_elements--;
            return ultimo;
        }

    }

    /**
     * toString
     * @return
     */
    public String toString() {
        String cadena = "Pila: ";
        if (this.isEmpty()) {
            return cadena += "---";
        } else {
            for(int i = 0; i < this.num_elements; i++) {
                cadena += (" " + this.stack[i] + " ");
            }
            return cadena;
        }

    }

    
}
