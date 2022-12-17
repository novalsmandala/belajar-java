import java.util.Locale;

public class AplikasiTodoList {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * Membuat model yakni string dengan nilai maksimal 10
     */

    public static String[] model  = new String[10];

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan todo list
     */

    public static void showTodoList(){

        for (int i = 0; i < model.length; i++){
            String todo = model[i];
            var no = i + 1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi Todo List";
        showTodoList();
    }

    /**
     * Menambah todo list
     */

    public static void addTodoList(String todo){

        // cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < model.length; i++){
            if (model[i] == null){
                // model masih penuh
                isFull = false;
            }
        }

        // jika penuh, kita resize ukuran array 2x lipat
        if (isFull){

            // mengcopy data dari model ke temporary
            var tmp = model;
            model = new String[model.length * 2];

            // memasukan data dari temporary ke data model yang sudah di resize
            for (int i = 0; i < tmp.length; i++){
                model[i] = tmp[i];
            }
        }

        // tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    // test add todo list method
    public static void testAddtodolist(){
        // test menambah data sampai 25 yang mana itu melewati batas
        for (var i = 0; i < 25; i++){
            addTodoList("test " + i);
        }

        showTodoList();
        System.out.println("Panjang model sekarang : " + model.length);
    }

    /**
     * Menghapus todo dari list
     */

    public static boolean removeTodoList(Integer number){

        if ((number - 1) >= model.length){
            return false;
        }else if (model[number - 1] == null){
            return false;
        }else {
            model[number - 1] = null;

            for (int i = (number - 1); i < model.length; i++){
                if (i == (model.length - 1)){
                    model[i] = null;
                }else{
                    model[i]= model[i + 1];
                }
            }
            return true;
        }
    }

    // test remove todo list
    public static void testRemoveTodolist(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(4);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    /**
     * Membuat fungsi untuk input
     * @param info
     * @return
     */

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println("Channel : " + channel);
    }

    /**
     * Menampilkan view todo list
     */

    public static void viewShowTodoList(){

        while (true){
            System.out.println("TODOLIST");
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")){
                viewAddTodoList();
            }else if (input.equals("2")){
                viewRemoveTodoList();
            }else if (input.toLowerCase().equals("x")) {
                break;
            }else{
                System.out.println("Pilihan Tidak diMengerti!");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        viewShowTodoList();
    }

    /**
     * Menampilkan view menambahkan todo list
     */

    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x Jika Batal) ");

        if (!todo.toLowerCase().equals("x")){
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("satu");
        addTodoList("dua");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * Menampilkan view menhapus todo list
     */

    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Todo (x Jika Batal) ");

        if (!number.toLowerCase().equals("x")){
            boolean succes = removeTodoList(Integer.valueOf(number));
            if (!succes) {
                System.err.println("Gagal Menghapus TodoList : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("sati");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
