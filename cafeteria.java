import java.util.Scanner;
public class cafeteria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    caja caja = new caja();
    producto[] productos = {
        new producto("Café americano", 45.0, 20),
        new producto("Cappuccino", 70.0, 15),
        new producto("Sándwich", 95.0, 10),
        new producto("Galleta de avena", 30.0, 25)
        };
    int opcion = -1;
    do {
        System.out.println("===== CAFETERIA CI =====");
        System.out.println("1. Ver productos");
        System.out.println("2. Vender");
        System.out.println("3. Reabastecer");
        System.out.println("4. Cambiar precio");
        System.out.println("5. Reporte del día");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    if (!scanner.hasNextInt()) {
        System.out.println("Opción inválida. Intente de nuevo.\n");
        scanner.next();
        continue;
        }
    opcion = scanner.nextInt();
    switch (opcion) {
        case 1 -> {
            System.out.println("\n--- LISTA DE PRODUCTOS ---");
            for (int i = 0; i < productos.length; i++) {
                producto p = productos[i];
                String aviso = (p.getstock() < 5) ? " (stock bajo)" : "";
                System.out.println((i + 1) + ". " + p.getnombre() + " - C$" + p.getprecio() + " [Stock: " + p.getstock() + "]" + aviso);
                }
            System.out.println();
            }
        case 2 -> {
            System.out.print("Seleccione el número del producto (1-4): ");
            int num = scanner.nextInt() - 1;
            if (num >= 0 && num < productos.length) {
                System.out.print("Ingrese la cantidad a vender: ");
                int cant = scanner.nextInt();
                caja.cobrar(productos[num], cant);
                } 
            else {
                System.out.println("Producto no encontrado.\n");
                }
            }
        case 3 -> {
            System.out.print("Seleccione el número del producto (1-4): ");
            int num = scanner.nextInt() - 1;
            if (num >= 0 && num < productos.length) {
                System.out.print("Ingrese la cantidad a reabastecer: ");
                int cant = scanner.nextInt();
                productos[num].reabastecer(cant);
                System.out.println("Stock actualizado correctamente.\n");
            } else {
                System.out.println("Producto no encontrado.\n");
                }
            }
        case 4 -> {
            System.out.print("Seleccione el número del producto (1-4): ");
            int num = scanner.nextInt() - 1;
            if (num >= 0 && num < productos.length) {
                System.out.print("Ingrese el nuevo precio: C$");
                double nuevoPrecio = scanner.nextDouble();
                productos[num].setprecio(nuevoPrecio);
                System.out.println("Precio actualizado.\n");
            } else {
                System.out.println("Producto no encontrado.\n");
                }
            }
        case 5 -> caja.mostrarReporte();
            case 0 -> System.out.println("¡Gracias por usar el sistema!");
            default -> System.out.println("Opción inválida. Vuelva a intentar.\n");
            }
    } while (opcion != 0);
    scanner.close();
    }
}
