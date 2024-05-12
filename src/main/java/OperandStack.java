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

    public boolean isEmpty() {
        return this.num_elements == 0;
    }

    //metodo meter en la pila
    public boolean push(int _elemento) {
        if(this.num_elements < MAX_NUM) {
            this.stack[this.num_elements] = _elemento;
            this.num_elements++;
            return true;
        } else {
            return false;
        }
    }

    //metodo sacar de la pila
    public int pop() {
        if(isEmpty()) {
            return -1;
        } else {
            int ultimo = this.stack[num_elements - 1];
            this.stack[num_elements - 1] = 0;
            this.num_elements--;

            return ultimo;
        }

    }

    public String toString() {
        String cadena = "Pila: ";
        if (isEmpty()) {
            return cadena += "Nada que ver aquí...";
        }
        for(int i = 0; i < this.num_elements; i++) {
            cadena += (" " + this.stack[i] + " ");
        }
        return cadena;
    }

    
}
