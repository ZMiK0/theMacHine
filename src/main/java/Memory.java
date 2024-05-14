public class Memory {
    private Integer[] memory;
    private final int MAX_NUM;
    private int size;
    private boolean isEmpty;

    public Memory() {
        this.MAX_NUM = 10;
        this.memory = new Integer[MAX_NUM];
        this.size = 10;
        this.isEmpty = true;
    }

    private void resize(int _pos) {
        if (_pos >= this.size) {
            this.isEmpty = false;
            Integer[] new_memory = new Integer[_pos * 2];
            for (int i = 0; i < this.size; i++) {
                new_memory[i] = this.memory[i];
            }
            this.memory = new_memory;
        }
    }

    public String toString() {
        String cadena = "Memoria: ";
        if (isEmpty) {
            return cadena += "---";
        } else {
            for (int i = 0; i < this.memory.length; i++) {
                if (this.memory[i] != null) {
                    cadena += (" [" + i + "]: " + this.memory[i] + " ");
                }
            }
            return cadena;
        }

    }

    public boolean write(int _pos, int _value) {
        if (_pos >= 0) {
            this.isEmpty = false;
            this.resize(_pos);
            this.memory[_pos] = _value;
            return true;
        } else {
            return false;
        }
    }

    public int read(int _pos) {
        if (this.memory[_pos] != null) {
            return this.memory[_pos];
        } else {
            return -1;
        }
    }
}
