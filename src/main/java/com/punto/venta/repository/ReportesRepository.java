package com.punto.venta.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.punto.venta.entity.Pedido;
import java.util.List;
public interface ReportesRepository extends JpaRepository<Pedido,Integer> {
 interface ProductoCategoria { String getProducto(); String getCategoria(); }
 interface PedidoCliente { String getFechaPedido(); String getCliente(); }
 interface PedidoDetalleCliente { String getFechaPedido(); String getCliente(); String getProducto(); Integer getCantidadPedido(); java.math.BigDecimal getPrecio(); java.math.BigDecimal getPrecioUnitario(); java.math.BigDecimal getSubtotal(); }
 @Query(value="SELECT p.NOMBRE AS producto, c.NOMBRE AS categoria FROM producto p JOIN categoria c ON p.ID_CATEGORIA=c.ID_CATEGORIA ORDER BY p.NOMBRE",nativeQuery=true)
 List<ProductoCategoria> productoCategoria();
 @Query(value="SELECT CAST(p.FECHA_PEDIDO AS CHAR) AS fechaPedido, CONCAT(c.NOMBRE,' ',c.APELLIDO) AS cliente FROM pedido p JOIN cliente c ON p.ID_CLIENTE=c.ID_CLIENTE ORDER BY p.FECHA_PEDIDO DESC",nativeQuery=true)
 List<PedidoCliente> pedidoCliente();
 @Query(value="SELECT CAST(p.FECHA_PEDIDO AS CHAR) AS fechaPedido, CONCAT(c.NOMBRE,' ',c.APELLIDO) AS cliente, pr.NOMBRE AS producto, d.CANTIDAD AS cantidadPedido, pr.PRECIO AS precio, d.PRECIO_UNITARIO AS precioUnitario, d.SUBTOTAL AS subtotal FROM pedido p JOIN cliente c ON p.ID_CLIENTE=c.ID_CLIENTE JOIN pedido_detalle d ON d.ID_PEDIDO=p.ID_PEDIDO JOIN producto pr ON pr.ID_PRODUCTO=d.ID_PRODUCTO ORDER BY p.FECHA_PEDIDO DESC, d.ID_PEDIDO_DETALLE",nativeQuery=true)
 List<PedidoDetalleCliente> pedidoClienteDetalle();
}
