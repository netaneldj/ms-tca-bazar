package com.todocodeacademy.bazar.service;

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

    private Double calculateTotalProductos(List<Producto> listaProductos){
        Double total = 0.0;
        for(Producto producto : listaProductos){
            total+=productoService.findProducto(producto.getCodigo_producto()).getCosto();
        }
        return total;
    }
}
