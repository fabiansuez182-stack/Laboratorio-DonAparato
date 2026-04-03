package modelo.operaciones;

import modelo.DTO.CompraDTO;
import modelo.DTO.UsuarioDTO;

public class Procesos {

    public void calcularTotales(CompraDTO miCompra, UsuarioDTO miUsuario) {

        double subtotal = miCompra.getValorUnitario() * miCompra.getCantidad();
        double porcentajeDescuento = 0.0;

        String tipoUsuario = "";
        if (miUsuario != null && miUsuario.getTipo() != null) {
            tipoUsuario = miUsuario.getTipo().trim().toUpperCase();
        }

        switch (tipoUsuario) {
            case "A":
                porcentajeDescuento = 0.40;
            case "B":
                porcentajeDescuento = 0.20;
                break;
            case "C":
                porcentajeDescuento = 0.10;
                break;
            default:
                porcentajeDescuento = 0.0;
                break;
        }

        double montoDescontado = subtotal * porcentajeDescuento;
        double totalNeto = subtotal - montoDescontado;

        miCompra.setTotalBruto(subtotal);
        miCompra.setDescuentoAplicado(montoDescontado);
        miCompra.setTotalNeto(totalNeto);
    }
}