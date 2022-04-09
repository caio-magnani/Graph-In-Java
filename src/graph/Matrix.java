package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Matrix<L extends Object, C extends Object> {
    private TreeMap<Integer, L> lines;
    private TreeMap<Integer, C> columns;
    private int[][] matrix;
    private int x;
    private int y;
    /*
     * |00| 01 | 02 | 03 |
     * |01|0101|0102|0103|
     * |02|0201|0202|0203|
     * |03|0301|0302|0303|
     */

    public Matrix() {
        this.matrix = new int[1][1];
        this.lines = new TreeMap<Integer, L>();
        this.columns = new TreeMap<Integer, C>();
        this.x = 1;
        this.y = 1;
    }

    public int get(int x, int y){
        return this.matrix[x][y];
    }

    // CRUD colunm

    public void addColunm(C obj) {
        this.columns.put(this.x, obj);
        this.x++;
        this.update();
        this.set(this.x - 1, 0, this.x - 1);
    }

    public C getColumn(int key) {
        return this.columns.get(key);
    }

    public C getColumnByObject(C obj){
        for(int c = 1; c < this.x; c++){
            if( this.getLine(c).equals(obj)){
                obj = this.getColumn(c);
            }
        }
        return obj;
    }

    public void setColumn(int key, C object) {
        this.columns.replace(key, this.columns.get(key), object);
    }

    public boolean removeColunm(int key) {
        boolean isRemoved = !(this.columns.remove(this.columns.get(key)) == null);
        for (int i = key; i < this.columns.size(); i++) {
            try {
                this.columns.replace(i, this.columns.get(i), this.columns.get(i + 1));
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        x--;
        this.update();
        return isRemoved;
    }

    // CRUD line

    public void addLine(L obj) {
        this.y++;
        this.lines.put(this.y, obj);
        update();
        set(0, this.y - 1, this.y - 1);
    }

    public L getLine(int key) {
        return this.lines.get(key);
    }

    public L getLineByObject(L obj){
        for(int l = 1; l < this.y; l++){
            if( this.getLine(l).equals(obj)){
                obj = this.getLine(l);
            }
        }
        return obj;
    }

    public void setLine(int key, L object) {
        this.lines.replace(key, this.lines.get(key), object);
    }

    public boolean removeLine(int key) {
        boolean isRemoved = !(this.lines.remove(this.columns.get(key)) == null);
        for (int i = key; i < this.lines.size(); i++) {
            try {
                this.lines.replace(i, this.lines.get(i), this.lines.get(i + 1));
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        x--;
        this.update();
        return isRemoved;
    }

    // Matrix Manupulation

    public void set(int x, int y, int value) {
        try {
            this.matrix[x][y] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }

    private void update() {
        // [0][1]
        //
        int[][] aux = new int[x][y];
        for (int l = 0; l < this.y; l++) {
            for (int c = 0; c < this.x; c++) {
                try {
                    aux[c][l] = this.matrix[c][l];
                } catch (ArrayIndexOutOfBoundsException e) {
                    aux[c][l] = 0;
                }
            }
        }
        this.matrix = aux;
    }

    public String toString() {
        String str = "Matrix:\n";
        for (int l = 0; l <= this.lines.size(); l++) {
            for (int c = 0; c <= this.columns.size(); c++) {
                str += this.matrix[c][l] + ";";
            }
            str += "\n";
        }
        return str;
    }

}
