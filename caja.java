public class caja {
    private double totalvendido;
    private int numeroventas;
public caja() {
    this.totalvendido = 0.0;
    this.numeroventas = 0;
    }
public double gettotalvendido() {
    return totalvendido;
    }
public int getnumeroventas() {
    return numeroventas;
    }
public boolean cobrar(producto producto, int cantidad) {
    if (!producto.vender(cantidad)) {
        System.out.println("No se pudo realizar la venta. Stock insuficiente o cantidad inválida.");
        return false;
        }
    double subtotal = producto.getprecio() * cantidad;
    double descuento = (subtotal >= 300) ? subtotal * 0.10 : 0.0;
    double iva = Math.round((subtotal - descuento) * 0.15 * 100.0) / 100.0;
    double total = Math.round((subtotal - descuento + iva) * 100.0) / 100.0;
    totalvendido += total;
    numeroventas++;
    System.out.println("\n========== TICKET ==========");
    System.out.println(producto.getnombre() + " x " + cantidad);
    System.out.println("Subtotal:   C$" + subtotal);
    System.out.println("Descuento:  C$" + descuento);
    System.out.println("IVA (15%):  C$" + iva);
    System.out.println("TOTAL:      C$" + total);
    System.out.println("============================\n");
        return true;
    }
public void mostrarReporte() {
    System.out.println("\n===== REPORTE DEL DÍA =====");
    System.out.println("Número de ventas: " + numeroventas);
    System.out.println("Total vendido:    C$" + Math.round(totalvendido * 100.0) / 100.0);
    System.out.println("===========================\n");
    }
} 
