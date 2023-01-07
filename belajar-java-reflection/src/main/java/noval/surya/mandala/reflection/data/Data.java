package noval.surya.mandala.reflection.data;

import java.io.Serializable;

public class Data<T extends AutoCloseable & Serializable>{

    private T data;

    public Data() {
    }

    public Data(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                '}';
    }
}
