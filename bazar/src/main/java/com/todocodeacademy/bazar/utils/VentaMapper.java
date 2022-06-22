package com.todocodeacademy.bazar.utils;

import com.todocodeacademy.bazar.dto.VentaDTO;
import com.todocodeacademy.bazar.model.Venta;

public class VentaMapper {
    public static Venta dtoToVenta(VentaDTO dto){
        Venta venta = new Venta();
        venta.setLista_productos(dto.getLista_productos());
        venta.setUn_cliente(dto.getUn_cliente());
        return venta;
    }

    public static VentaDTO ventaToDto(Venta venta){
        VentaDTO dto = new VentaDTO();
        dto.setLista_productos(venta.getLista_productos());
        dto.setUn_cliente(venta.getUn_cliente());
        return dto;
    }
}
