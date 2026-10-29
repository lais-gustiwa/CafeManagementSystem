import java.util.List;
import  java.util.Scanner;

public class Admin extends User {
    public Admin(String username, String Password) {
        super(username, Password);
    }

    @Override 
    public void displayRole() {
        System.out.println("Login Berhasil!");
    }

    public void manageMenu(List<MenuItem> menuList, Scanner scanner) {
        while (true) {
            System.out.println("\nMENU ADMIN");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Lihat Menu");
            System.out.println("3. Logout");
            System.out.print("Pilih Opsi: ");
            int opsi = scanner.nextInt();
            scanner.nextLine();

            if (opsi == 1) {
            System.out.print("Masukan ID Menu: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Masukan Nama Menu: ");
            String name = scanner.nextLine();
            System.out.print("Masukan Harga: ");
            double price = scanner.nextDouble();

            menuList.add(new MenuItem(id, name, price));
            System.out.println("Menu Berhasil Ditambahkan!");
            } else if (opsi == 2) {
                System.out.println("Daftar Menu");
                for (MenuItem m : menuList) {
                    System.out.println(m.getId() + ". " + m.getName() + " - Rp" + m.getPrice());
                }
            } else if (opsi == 3) {
                break;
            }
        }
    }
}