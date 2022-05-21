package com.todocodeacademy.bazar.utils;

import com.todocodeacademy.bazar.dto.VentaDTO;
import com.todocodeacademy.bazar.model.Venta;

public class VentaMapper {
    public static Venta dtoToVenta(VentaDTO dto){
        Venta venta = new Venta();
        venta.setListaProductos(dto.getListaProductos());
        venta.setUnCliente(dto.getUnCliente());
        return venta;
    }

    public static VentaDTO ventaToDto(Venta venta){
        VentaDTO dto = new VentaDTO();
        dto.setListaProductos(venta.getListaProductos());
        dto.setUnCliente(venta.getUnCliente());
        return dto;
    }
}
