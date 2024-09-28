import java.util.List;

class Pedido {
    private int id;
    private Cliente cliente;
    private List<DetallePedido> detalles;

    public Pedido(int id, Cliente cliente, List<DetallePedido> detalles) {
        this.id = id;
        this.cliente = cliente;
        this.detalles = detalles;
    }

    public Cliente getCliente() { return cliente; }
    public List<DetallePedido> getDetalles() { return detalles; }
}