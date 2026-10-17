package com.punto.venta.controller;
import com.punto.venta.dto.RespuestaDTO;
import com.punto.venta.repository.ReportesRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/reportes")
public class ReportesController {
 private final ReportesRepository repository;
 public ReportesController(ReportesRepository repository){this.repository=repository;}
 @GetMapping("/producto-categoria")
 public RespuestaDTO<List<ReportesRepository.ProductoCategoria>> productos(){var datos=repository.productoCategoria();return new RespuestaDTO<>(true,"Reporte de productos por categoría generado correctamente",datos);}
 @GetMapping("/pedido-cliente")
 public RespuestaDTO<List<ReportesRepository.PedidoCliente>> pedidos(){var datos=repository.pedidoCliente();return new RespuestaDTO<>(true,"Reporte de pedidos por cliente generado correctamente",datos);}
 @GetMapping("/pedido-cliente-detalle")
 public RespuestaDTO<List<ReportesRepository.PedidoDetalleCliente>> detalles(){var datos=repository.pedidoClienteDetalle();return new RespuestaDTO<>(true,"Reporte detallado generado correctamente",datos);}
}
