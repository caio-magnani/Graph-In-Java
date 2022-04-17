package graph.matrix;

public class Matrix{
    int[][] matrix;
    private int c;
    private int l;
    /*
     * |00| 01 | 02 | 03 |
     * |01|0101|0102|0103|
     * |02|0201|0202|0203|
     * |03|0301|0302|0303|
     */

    public Matrix() {
        this.matrix = new int[1][1];
        this.c = 1;
        this.c = 1;
    }

    public int get(int l, int c){
        return this.matrix[l][c];
    }

    public void removeColumn(int column) {
        int[][] aux = new int[this.l][this.c-1];
        for (int l = 0; l < this.l; l++) {
            for (int c = 0; c < this.c; c++) {
                if(c < column){
                    aux[l][c] = this.matrix[l][c];
                }
                if(c > column)
                    aux[l][c-1]=this.matrix[l][c];
            }
        }
        this.matrix = aux;
        this.c-=1;
    }

    public void removeLine(int line) {
        int[][] aux = new int[this.l-1][this.c];
        for (int c = 0; c < this.c; c++) {
            for (int l = 0; l < this.l; l++) {
                if(l == line)
                    aux[l][c] = 0;
                else if(l<line){
                    aux[l][c] = this.matrix[l][c];
                }
                if(l>line)
                    aux[l-1][c]=this.matrix[l][c];
            }
        }
        this.matrix = aux;
        this.l-=1;
    }

    // Matrix Manupulation

    public void set(int line, int column, int value) {
        try {
            this.matrix[line][column] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            if(line > this.l - 1)
                this.l=line+1;
            if(column > this.c - 1)
                this.c=column+1;
            grow();
            this.matrix[line][column]=value;
        }
    }

    private void grow() {
        int[][] aux = new int[this.l][this.c];
        for (int l = 0; l < this.c; l++) {
            for (int c = 0; c < this.c; c++) {
                try {
                    aux[l][c] = this.matrix[l][c];
                } catch (ArrayIndexOutOfBoundsException e) {
                    aux[l][c] = 0;
                }
            }
        }
        this.matrix = aux;
    }

    @Override
    public String toString() {
        String s = new String();
        for(int l = 0; l < this.l; l++){
            for(int c = 0; c<this.c ; c++){
                s += "|" + this.matrix[l][c];
            }
            s += "|\n";
        }
        return s;
    }
}
