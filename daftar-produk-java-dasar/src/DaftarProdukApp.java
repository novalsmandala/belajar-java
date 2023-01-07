public class DaftarProdukApp {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    // membuat variabel array untuk menampung data array barang dan harga
    public static String[] namaProduk = new String[10];
    public static Integer[] hargaProduk = new Integer[10];

    public static void main(String[] args) {
        viewShowProduk();
    }

    // menampilkan produk
    public static void showProduk(){
        for (var i = 0; i < namaProduk.length; i++){
            var no = i + 1;

            if ((namaProduk[i] != null) && (hargaProduk[i] != null)){
                System.out.println(no + ". " + namaProduk[i] + " (Rp. " + hargaProduk[i] + ")");
            }
        }
    }

    public static void testShowProduk(){
        namaProduk[0] = "Minyak";
        hargaProduk[0] = 10000;
        namaProduk[1] = "Beras";
        hargaProduk[1] = 12500;
        namaProduk[2] = "Pangsit";
        hargaProduk[2] = 25000;

        showProduk();
    }


    // menambah produk
    public static void addProduk(String nama, Integer harga){
        // cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < namaProduk.length; i++){
            if (namaProduk[i] == null){
                // model belum penuh
                isFull = false;
            }
        }

        // jika penuh, kita resize ukuran array 2x lipat
        if (isFull){

            // mengcopy data dari model ke temporary
            var tmpNamaProduk = namaProduk;
            var tmpHargaProduk = hargaProduk;
            namaProduk = new String[namaProduk.length * 2];
            hargaProduk = new Integer[hargaProduk.length * 2];

            // memasukan data dari temporary ke data model yang sudah di resize
            for (int i = 0; i < tmpNamaProduk.length; i++){
                namaProduk[i] = tmpNamaProduk[i];
                hargaProduk[i] = tmpHargaProduk[i];
            }
        }

        // tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < namaProduk.length; i++){
            if (namaProduk[i] == null){
                namaProduk[i] = nama;
                hargaProduk[i] = harga;
                break;
            }
        }
    }

    // test menambah produk
    // test add todo list method
    public static void testAddProduk(){
        // test menambah data sampai 25 yang mana itu melewati batas
        for (var i = 0; i < 25; i++){
            addProduk("test " + i, 10000);
        }

        showProduk();
        System.out.println("Panjang model sekarang : " + namaProduk.length + " " + hargaProduk.length);
    }

    // menghapus produk
    public static boolean removeProduk(Integer number) {

        if ((number - 1) >= namaProduk.length) {
            return false;
        } else if (namaProduk[number - 1] == null) {
            return false;
        } else {
            namaProduk[number - 1] = null;
            hargaProduk[number - 1] = null;

            for (int i = (number - 1); i < namaProduk.length; i++) {
                if (i == (namaProduk.length - 1)) {
                    namaProduk[i] = null;
                    hargaProduk[i] = null;
                } else {
                    namaProduk[i] = namaProduk[i + 1];
                    hargaProduk[i] = hargaProduk[i + 1];
                }
            }
            return true;
        }
    }

    // test menghapus produk
    public static void testRemoveProduk(){
        addProduk("minyak", 10000);
        addProduk("Beras", 12500);
        addProduk("Pangsit", 25000);

        showProduk();
        removeProduk(4);
        showProduk();
    }

    // membuat edit produk
    public static void editProduk(Integer info){
        if (info < namaProduk.length){
            if (namaProduk[info - 1] != null){
                var namaBaru = input("Nama Produk Baru (tidak boleh kosong)");
                var hargaBaru = input("Harga Produk Baru");
                System.out.println(namaProduk[info - 1] + " -> " + namaBaru);
                System.out.println(hargaProduk[info - 1] + " -> " + hargaBaru);
                var input = input( "Tekan Enter (x Untuk Membatalkan Edit)");
                if (!input.toLowerCase().equals("x")){
                    System.out.println("dog");
                    namaProduk[info - 1] = namaBaru;
                    hargaProduk[info - 1] = Integer.valueOf(hargaBaru);
                }else {
                    System.out.println("Operasi dibatalkan");
                }
            }else{
                System.out.println("Data Tidak Ditemukan!!!");
            }
        }else {
            System.out.println("Data Tidak Ditemukan!!!");
        }

    }

    public static void testEditProduk(){
        addProduk("minyak", 10000);
        addProduk("Beras", 12500);
        addProduk("Pangsit", 25000);

        showProduk();
        editProduk(5);
        showProduk();
    }

    // membuat input
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

    // membuat view show todolist
    public static void viewShowProduk(){
        while (true){
            System.out.println("DAFTAR PRODUK");
            showProduk();

            System.out.println("Menu : ");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Edit Barang");
            System.out.println("3. Hapus Barang");
            System.out.println("x. Keluar");

            var input = input("Pilih Aksi");

            if (input.equals("1")){
                viewAddProduk();
            }else if (input.equals("2")) {
                viewEditProduk();
            }else if (input.equals("3")){
                viewRemoveProduk();
            }else if (input.toLowerCase().equals("x")){
                break;
            }
        }
    }

    public static void testViewShowProduk(){
        addProduk("Kentang", 1000);
        addProduk("Burger", 5000);
        viewShowProduk();
    }

    // menambah view
    public static void viewAddProduk(){
        System.out.println("MENAMBAH PRODUK");

        var namaProduk = input("Nama Produk (x Jika Batal) ");
        var hargaProduk = input("Harga Produk (x Jika Batal)");

        if (!(namaProduk.toLowerCase().equals("x") || hargaProduk.toLowerCase().equals("x"))){
            addProduk(namaProduk, Integer.valueOf(hargaProduk));
        }else {
            System.err.println("Operasi Dibatalkan!");
        }
    }

    public static void testViewAddProduk(){
        addProduk("Kecap", 5000);
        addProduk("Sauce", 15000);

        showProduk();
        viewShowProduk();
        showProduk();
    }

    public static void viewEditProduk(){
        System.out.println("MENGEDIT PRODUK");

        var input = input("Nomor Produk (x Jika Batal) ");

        if (!input.toLowerCase().equals("x")){
            editProduk(Integer.valueOf(input));
        }
    }

    public static void testViewEditProduk(){
        addProduk("Kecap", 5000);
        addProduk("Sauce", 15000);

        showProduk();
        viewEditProduk();
        showProduk();
    }

    public static void viewRemoveProduk(){
        System.out.println("MENGHAPUS Produk");

        var number = input("Nomor Produk (x Jika Batal) ");

        if (!number.toLowerCase().equals("x")){
            boolean success = removeProduk(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal Menghapus TodoList : " + number);
            }
        }
    }

    public static void testViewRemoveProduk(){
        addProduk("Kecap", 5000);
        addProduk("Sauce", 15000);

        showProduk();
        viewRemoveProduk();
        showProduk();
    }
}
