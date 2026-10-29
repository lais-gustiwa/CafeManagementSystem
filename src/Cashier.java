import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cashier extends User {
    public Cashier(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayRole() {
        System.out.println("Login Berhasil! Selamat datang, Kasir.");
    }

    public void handleOrder(List<MenuItem> menuList, Scanner scanner) {
        List<Order> cart = new ArrayList<>();
        while (true) {
            System.out.println("\n--- MENU KASIR ---");
            System.out.println("1. Buat Pesanan Baru");
            System.out.println("2. Proses Pembayaran");
            System.out.println("3. Logout");
            System.out.print("Pilih opsi: ");
            int opsi = scanner.nextInt();

            if (opsi == 1) {
                System.out.println("\n-- DAFTAR MENU --");
                for (MenuItem m : menuList) {
                    System.out.println(m.getId() + ". " + m.getName() + " - Rp. " + m.getPrice());
                }
                System.out.print("Masukkan ID Menu yang dipesan: ");
                int id = scanner.nextInt();
                System.out.print("Masukkan Jumlah: ");
                int qty = scanner.nextInt();

                MenuItem selected = null;
                for (MenuItem m : menuList) {
                    if (m.getId() == id) {
                        selected = m;
                        break;
                    }
                }

                if (selected != null) {
                    cart.add(new Order(selected, qty));
                    System.out.println("Berhasil dimasukkan ke pesanan!");
                } else {
                    System.out.println("Menu tidak ditemukan!");
                }

            } else if (opsi == 2) {
                if (cart.isEmpty()) {
                    System.out.println("Belum ada pesanan.");
                    continue;
                }
                
                double total = 0;
                System.out.println("\n--- STRUK PESANAN ---");
                for (Order o : cart) {
                    System.out.println(o.getReceiptLine());
                    total += o.getSubTotal();
                }
                System.out.println("--------------------");
                System.out.println("TOTAL: Rp. " + total);
                
                System.out.print("Masukkan Uang Bayar: Rp");
                double bayar = scanner.nextDouble();
                
                if (bayar >= total) {
                    System.out.println("Kembalian: Rp. " + (bayar - total));
                    System.out.println("Pembayaran Berhasil! Terima kasih.");
                    cart.clear();
                } else {
                    System.out.println("Uang tidak cukup!");
                }
            } else if (opsi == 3) {
                break;
            }
        }
    }
}