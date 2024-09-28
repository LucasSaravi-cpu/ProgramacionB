import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        List<Pedido> pedidos = db.obtenerPedidos();

        // Imprimir los pedidos
        for (Pedido pedido : pedidos) {
            System.out.println("Cliente: " + pedido.getCliente().getNombre() + 
                               " (" + pedido.getCliente().getEmail() + ")");
            for (DetallePedido detalle : pedido.getDetalles()) {
                System.out.println("Producto: " + detalle.getProducto().getNombre() + 
                                   ", Cantidad: " + detalle.getCantidad());
            }
            System.out.println("------------------------------------------------");
        }
    }
}