# Bazar Web Service
 Microservicio Ventas y Stock Bazar
 
## Karate Suite Automation
 https://github.com/netaneldj/lib-tca-automation-test/tree/main
 
## Postman Collection
 https://netaneldj.github.io/files/TodoCodeAcademy/Bazar.postman_collection.json
 
 ## Especificaciones tecnicas
 
 ### Modelado
#### Producto
- Long codigo_producto
- String nombre
- String marca
- Double costo
- Double cantidad_disponible

#### Cliente
- Long id_cliente
- String nombre
- String apellido
- String dni

#### Venta
- Long codigo_venta
- LocalDate fecha_venta
- Double total
- List<Producto> lista_productos
- Cliente un_cliente
 
 ### CRUD Producto
 - **CREATE** localhost:8080/productos/crear
 - **FIND ALL** localhost:8080/productos
 - **FIND BY ID** localhost:8080/productos/{codigo_producto}
 - **DELETE** localhost:8080/productos/eliminar/{codigo_producto}
 - **UPDATE** localhost:8080/productos/editar/{codigo_producto}

### CRUD Cliente
 - **CREATE** localhost:8080/clientes/crear
 - **FIND ALL** localhost:8080/clientes
 - **FIND BY ID** localhost:8080/clientes/{id_cliente}
 - **DELETE** localhost:8080/clientes/eliminar/{id_cliente}
 - **UPDATE** localhost:8080/clientes/editar/{id_cliente}

### CRUD Venta
 - **CREATE** localhost:8080/ventas/crear
 - **FIND ALL** localhost:8080/ventas
 - **FIND BY ID** localhost:8080/ventas/{codigo_venta}
 - **DELETE** localhost:8080/clientes/eliminar/{codigo_venta}
 - **UPDATE** localhost:8080/clientes/editar/{codigo_venta}
 
 ### Reportes
 - **FALTA STOCK** localhost:8080/productos/falta_stock
 - **LISTA PRODUCTOS VENTA** localhost:8080/ventas/productos/{codigo_venta}
 - **MONTO Y VENTAS POR DIA** localhost:8080/ventas/{fecha_venta}
 - **MAYOR VENTA** localhost:8080/ventas/mayor_venta
 
Nota: Se implemento la actualizacion de stock de un producto (descontar)
al realizar una venta y el control de si cuenta con la cantidad disponible para vender.
 
 
