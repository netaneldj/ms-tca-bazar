package com.todocodeacademy.bazar.service;

import com.todocodeacademy.bazar.dto.ClienteVentaDTO;
import com.todocodeacademy.bazar.dto.ReporteVentasDTO;
import com.todocodeacademy.bazar.model.Producto;
import com.todocodeacademy.bazar.model.Venta;
import com.todocodeacademy.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService{
    @Autowired
    private IProductoService productoService;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IVentaRepository repository;

    @Override
    public List<Venta> getVentas() {
        return repository.findAll();
    }

    @Override
    public Venta findVenta(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean saveVenta(Venta venta) {
        venta.setFecha_venta(LocalDate.now());
        venta.setTotal(calculateTotalProductos(venta.getLista_productos()));
        if (!updateStock(venta.getLista_productos())) return false;
        venta.setUn_cliente(clienteService.findCliente(venta.getUn_cliente().getId_cliente()));
        for(int i=0;  i < venta.getLista_productos().size(); i++){
            venta.getLista_productos().set(i,
                    productoService.findProducto(venta.getLista_productos().get(i).getCodigo_producto()));
        }
        repository.save(venta);
        return true;
    }

    @Override
    public void deleteVenta(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean editVenta(Venta venta) {
        venta.setFecha_venta(LocalDate.now());
        venta.setTotal(calculateTotalProductos(venta.getLista_productos()));
        if (!updateStock(venta.getLista_productos())) return false;
        venta.setUn_cliente(clienteService.findCliente(venta.getUn_cliente().getId_cliente()));
        for(int i=0;  i < venta.getLista_productos().size(); i++){
            venta.getLista_productos().set(i,
                    productoService.findProducto(venta.getLista_productos().get(i).getCodigo_producto()));
        }
        repository.save(venta);
        return true;
    }

    public boolean availableStock(List<Producto> listaProductos) {
        for (Producto producto : listaProductos) {
            Producto p = productoService.findProducto(producto.getCodigo_producto());
            if (p.getCantidad_disponible() < 1) return false;
        }
        return true;
    }

    @Override
    public List<Producto> getProductosVenta(Long codigo_venta) {
        return findVenta(codigo_venta).getLista_productos();
    }

    @Override
    public ReporteVentasDTO getReporteVentas(LocalDate fecha_venta) {
        ReporteVentasDTO dto = new ReporteVentasDTO();
        Double monto = 0.0;
        List<Venta> listVentasFecha = getVentas();
        listVentasFecha.removeIf(v ->v.getFecha_venta().compareTo(fecha_venta) != 0);
        for(Venta v: listVentasFecha) monto += v.getTotal();
        dto.setCantidad_total_ventas(listVentasFecha.size());
        dto.setMonto(monto);
        return dto;
    }

    @Override
    public ClienteVentaDTO getReporteMayorVenta() {
        ClienteVentaDTO dto = new ClienteVentaDTO();
        List<Venta> listVentas = getVentas();
        Double maxMonto = listVentas.get(0).getTotal();
        Long maxCodigoVenta = listVentas.get(0).getCodigo_venta();
        for(Venta v: listVentas){
            if(v.getTotal() > maxMonto){
                maxMonto = v.getTotal();
                maxCodigoVenta = v.getCodigo_venta();
            }
        }
        Venta maxVenta = findVenta(maxCodigoVenta);
        dto.setCodigo_venta(maxVenta.getCodigo_venta());
        dto.setTotal(maxVenta.getTotal());
        dto.setCantidad_total_productos(maxVenta.getLista_productos().size());
        dto.setNombre_cliente(maxVenta.getUn_cliente().getNombre());
        dto.setApellido_cliente(maxVenta.getUn_cliente().getApellido());
        return dto;
    }

    private boolean updateStock(List<Producto> listaProductos){
        for(Producto producto : listaProductos){
            Producto p = productoService.findProducto(producto.getCodigo_producto());
            if (p.getCantidad_disponible() < 1) return false;
            p.setCantidad_disponible(p.getCantidad_disponible()-1);
            productoService.editProducto(p);
        }
        return true;
    }

    private Double calculateTotalProductos(List<Producto> listaProductos){
        Double total = 0.0;
        for(Producto producto : listaProductos){
            total+=productoService.findProducto(producto.getCodigo_producto()).getCosto();
        }
        return total;
    }
}
