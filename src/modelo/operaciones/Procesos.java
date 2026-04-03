package modelo.operaciones;

import modelo.DTO.CompraDTO;
import modelo.DTO.UsuarioDTO;

/**
 * Clase con la lógica de negocio de la tienda DON APARATO.
 * Calcula los descuentos según el tipo de afiliación del usuario.
 */
public class Procesos {

    /**
     * Calcula el subtotal, el descuento y el total a pagar
     * basándose en el tipo de afiliación del usuario.
     *
     * @param miCompra  CompraDTO con los datos del producto ingresados en la vista.
     * @param miUsuario UsuarioDTO que contiene el "Tipo" de cliente (A, B, C o null).
     */
    public void calcularTotales(CompraDTO miCompra, UsuarioDTO miUsuario) {

        // 1. Calcular el Subtotal (Total Bruto)
        double subtotal = miCompra.getValorUnitario() * miCompra.getCantidad();
        double porcentajeDescuento = 0.0;

        // 2. Obtener el tipo del usuario (puede ser null si no tiene afiliación)
        String tipoUsuario = "";
        if (miUsuario != null && miUsuario.getTipo() != null) {
            tipoUsuario = miUsuario.getTipo().trim().toUpperCase();
        }

        // 3. Aplicar las reglas de negocio de la tienda "DON APARATO"
        switch (tipoUsuario) {
            case "A":
                porcentajeDescuento = 0.40; // 40% de descuento
                break;
            case "B":
                porcentajeDescuento = 0.20; // 20% de descuento
                break;
            case "C":
                porcentajeDescuento = 0.10; // 10% de descuento
                break;
            default:
                porcentajeDescuento = 0.0;  // Sin descuento
                break;
        }

        // 4. Calcular el monto a descontar y el total final neto
        double montoDescontado = subtotal * porcentajeDescuento;
        double totalNeto = subtotal - montoDescontado;

        // 5. Inyectar los resultados calculados de vuelta al DTO
        miCompra.setTotalBruto(subtotal);
        miCompra.setDescuentoAplicado(montoDescontado);
        miCompra.setTotalNeto(totalNeto);
    }
}