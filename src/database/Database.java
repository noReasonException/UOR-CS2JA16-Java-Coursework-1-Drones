package database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database<T> {
    protected List<T> data= Collections.synchronizedList(new ArrayList<T>());

    public Database() {

    }

    public List<T> asList() {
        return data;
    }
}
