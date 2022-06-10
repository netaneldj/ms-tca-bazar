package com.todocodeacademy.bazar.service;

import com.todocodeacademy.bazar.dto.ClienteVentaDTO;
import com.todocodeacademy.bazar.dto.ReporteVentasDTO;
import com.todocodeacademy.bazar.model.Cliente;
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
    public void saveVenta(Venta venta) {
        venta.setFecha_venta(LocalDate.now());
        venta.setTotal(calculateTotalProductos(venta.getListaProductos()));
        updateStock(venta.getListaProductos());
        Cliente c = clienteService.findCliente(venta.getUnCliente().getId_cliente());
        venta.setUnCliente(c);
        for(Producto p: venta.getListaProductos()){
            Producto producto = productoService.findProducto(p.getCodigo_producto());
            p.setCosto(producto.getCosto());
            p.setMarca(producto.getMarca());
            p.setCantidad_disponible(producto.getCantidad_disponible());
            p.setNombre(producto.getNombre());
        }
        repository.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void editVenta(Venta venta) {
        venta.setFecha_venta(LocalDate.now());
        venta.setTotal(calculateTotalProductos(venta.getListaProductos()));
        repository.save(venta);
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
        return findVenta(codigo_venta).getListaProductos();
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
        dto.setCantidad_total_productos(maxVenta.getListaProductos().size());
        dto.setNombre_cliente(maxVenta.getUnCliente().getNombre());
        dto.setApellido_cliente(maxVenta.getUnCliente().getApellido());
        return dto;
    }

    private void updateStock(List<Producto> listaProductos){
        for(Producto producto : listaProductos){
            Producto p = productoService.findProducto(producto.getCodigo_producto());
            p.setCantidad_disponible(p.getCantidad_disponible()-1);
            productoService.editProducto(p);
        }
    }

    private Double calculateTotalProductos(List<Producto> listaProductos){
        Double total = 0.0;
        for(Producto producto : listaProductos){
            total+=productoService.findProducto(producto.getCodigo_producto()).getCosto();
        }
        return total;
    }
}
