package hu.bme.mit.train.system;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class Tachograph {
    public Table<Integer, Integer, Integer> table;

    Tachograph(){
        table = TreeBasedTable.create();
    }

    void add(int time, int position, int speed){
        table.put(time, position, speed);
    }
}
