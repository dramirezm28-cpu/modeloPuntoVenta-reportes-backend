package com.punto.venta.dto;
public record RespuestaDTO<T>(boolean exito, String mensaje, T datos) {}
