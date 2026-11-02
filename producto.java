public class producto {
    private String nombre;
    private double precio;
    private int stock;

public producto(String nombre, double precio, int stock) {
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
    }
public String getnombre() {
    return nombre;
    }
public double getprecio() {
    return precio;
    }
public int getstock() {
    return stock;
    }
public void setprecio(double precio) {
    if (precio > 0) {
        this.precio = precio;
    } else {
        System.out.println("Error: El precio debe ser mayor que 0.");
        }
    }
public boolean vender(int cantidad) {
    if (cantidad <= 0 || cantidad > stock) {
        return false;
        }
    stock -= cantidad;
        return true;
    }
public void reabastecer(int cantidad) {
    if (cantidad > 0) {
        stock += cantidad;
        } 
    else {
        System.out.println("Error: La cantidad a reabastecer debe ser positiva.");
        }
    }
}
