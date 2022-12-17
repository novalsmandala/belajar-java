package noval.mandala.classes;

import java.util.Objects;

public class ObjectsApp {

    public static class Data{
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data1 = (Data) o;

            return data != null ? data.equals(data1.data) : data1.data == null;
        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
        }

        public String getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "data='" + data + '\'' +
                    '}';
        }

        public void setData(String data) {
            this.data = data;
        }

        public Data(String data) {
            this.data = data;
        }

        private String data;

    }

    public static void main(String[] args) {
        execute(new Data(null));
    }

    public static void execute(Data data){
//        if (data != null){
//            System.out.println(data.toString());
//            System.out.println(data.hashCode());
//        }

//        di banding mengecek secara manual lebi baik memakai object
        System.out.println(Objects.toString(data));
        System.out.println(Objects.hashCode(data));
    }
}
