package web.Lab3.data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class History implements Serializable {

    private List<Data> history;
    public History(){
        this.history = new LinkedList<>();
    }

    public void addData(Data data){
        history.add(data);
    }

    public List<Data> getHistory(){
        return history;
    }

    public void setHistory(List<Data> history){
        this.history= history;
    }
}