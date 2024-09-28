import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/Empresa";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";
   
    public List<Pedido> obtenerPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        Map<Integer, Pedido> pedidoMap = new HashMap<>();

        String query = "SELECT " +
                       "clientes.nombre AS nombre_cliente, " +
                       "clientes.email, " +
                       "pedidos.pedido_id, " +
                       "pedidos.fecha_pedido, " +
                       "productos.nombre_producto, " +
                       "productos.precio, " +
                       "detalles_pedidos.cantidad " +
                       "FROM clientes " +
                       "LEFT JOIN pedidos ON clientes.cliente_id = pedidos.cliente_id " +
                       "LEFT JOIN detalles_pedidos ON pedidos.pedido_id = detalles_pedidos.pedido_id " +
                       "LEFT JOIN productos ON detalles_pedidos.producto_id = productos.producto_id " +
                       "LEFT JOIN categorias ON productos.producto_id = categorias.producto_id " +
                       "ORDER BY pedidos.fecha_pedido DESC";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String nombreCliente = resultSet.getString("nombre_cliente");
                String email = resultSet.getString("email");
                int pedidoId = resultSet.getInt("pedido_id");
                String nombreProducto = resultSet.getString("nombre_producto");
                double precio = resultSet.getDouble("precio");
                int cantidad = resultSet.getInt("cantidad");

                // Crear o recuperar el cliente
                Cliente cliente = new Cliente(-1, nombreCliente, email); // ID se puede ajustar según sea necesario

                // Crear el detalle del pedido
                Producto producto = new Producto(-1, nombreProducto, precio); // ID se puede ajustar según sea necesario
                DetallePedido detallePedido = new DetallePedido(producto, cantidad);

                // Agrupar detalles por pedido
                if (!pedidoMap.containsKey(pedidoId)) {
                    List<DetallePedido> detalles = new ArrayList<>();
                    detalles.add(detallePedido);
                    Pedido pedido = new Pedido(pedidoId, cliente, detalles);
                    pedidoMap.put(pedidoId, pedido);
                } else {
                    pedidoMap.get(pedidoId).getDetalles().add(detallePedido);
                }
            }

            // Convertir el mapa a lista
            pedidos.addAll(pedidoMap.values());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }
}