package com.todocodeacademy.bazar.controller;

import com.todocodeacademy.bazar.dto.ProductoDTO;
import com.todocodeacademy.bazar.model.Producto;
import com.todocodeacademy.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.todocodeacademy.bazar.utils.ProductoMapper.dtoToProducto;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService service;

    @GetMapping("/productos/traer")
    public List<Producto> getProductos() {
        return service.getProductos();
    }

    @GetMapping("/productos/traer/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return service.findProducto(id);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> getProductosFaltaStock() {
        return service.getProductosFaltaStock();
    }

    @PostMapping("/productos/crear")
    public ResponseEntity<Producto> saveProducto(@RequestBody @Valid ProductoDTO dto) {
        Producto producto = dtoToProducto(dto);
        service.saveProducto(producto);
        return new ResponseEntity<Producto>(producto, null, HttpStatus.CREATED);
    }

    @DeleteMapping ("/productos/borrar/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        service.deleteProducto(id);
        return new ResponseEntity<String>("El producto fue eliminado correctamente", null, HttpStatus.OK);
    }

    @PutMapping ("/productos/editar/{id}")
    public ResponseEntity<Producto> editProducto(@PathVariable Long id, @RequestBody @Valid ProductoDTO dto) {
        Producto producto = dtoToProducto(dto);
        producto.setCodigo_producto(id);
        service.editProducto(producto);
        return new ResponseEntity<Producto>(producto, null, HttpStatus.OK);
    }
}
