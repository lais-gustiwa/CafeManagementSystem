import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menuData = new ArrayList<>();
        List<User> users = new ArrayList<>();

        // Inisialisasi Data
        menuData.add(new MenuItem(1, "Kopi Hitam", 15000));
        menuData.add(new MenuItem(2, "Latte", 25000));
        
        users.add(new Admin("admin", "admin123"));
        users.add(new Cashier("kasir", "admin123"));

        while (true) {
            System.out.println("\n=== SISTEM MANAJEMEN KAFE ===");
            System.out.print("Username: ");
            String un = scanner.next();
            System.out.print("Password: ");
            String pw = scanner.next();

            boolean loggedIn = false;
            for (User u : users) {
                if (u.Login(un, pw)) {
                    loggedIn = true;
                    u.displayRole();
                    
                    if (u instanceof Admin) {
                        ((Admin) u).manageMenu(menuData, scanner);
                    } else if (u instanceof Cashier) {
                        ((Cashier) u).handleOrder(menuData, scanner);
                    }
                    break;
                }
            }

            if (!loggedIn) {
                System.out.println("Username atau password salah!");
            }
        }
    }
}