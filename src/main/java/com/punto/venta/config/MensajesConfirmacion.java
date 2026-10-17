package com.punto.venta.config;
import com.punto.venta.dto.RespuestaDTO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@RestControllerAdvice(basePackages="com.punto.venta.controller")
public class MensajesConfirmacion implements ResponseBodyAdvice<Object> {
 @Override public boolean supports(MethodParameter returnType, Class converterType){return true;}
 @Override public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType mediaType, Class converterType, ServerHttpRequest request, ServerHttpResponse response){
  if(body instanceof RespuestaDTO || !"POST".equals(request.getMethod().name()) && !"PUT".equals(request.getMethod().name()) && !"DELETE".equals(request.getMethod().name()))return body;
  // Mantener compatibilidad de GET; las operaciones de escritura devuelven confirmación.
  if(converterType.getName().contains("StringHttpMessageConverter"))return body;
  return new RespuestaDTO<>(true,"Operación realizada correctamente",body);
 }
}
