drop database if exists DBconexionGuitarras;
create database DBconexionGuitarras;
use DBconexionGuitarras;

-- --------------********** TABLAS INDEPENDIENTES **********-------------------

Create table Usuarios(
    idUsuario int auto_increment,
    nombreUsuario varchar(50) not null,
    apellidoUsuario varchar (50) not null,
    emailUsuario varchar(100) not null unique,
    telefonoUsuario varchar(20),
    direccionUsuario varchar(255),
    fechaRegistro datetime default now(),
    contrasena varchar(255) not null,
    rol enum('Cliente', 'Admin') default 'Cliente',
    nit varchar(50) not null,
    constraint pk_usuarios primary key (idUsuario)
);

Create table Categoria(
    idCategoria int auto_increment,
    nombreCategoria varchar(100) not null unique,
    descripcion varchar(255) not null,
    estado enum('Activo', 'Inactivo') default 'Activo',
    constraint pk_categoria primary key (idCategoria)
);

CREATE TABLE Proveedor (
    idProveedor int auto_increment,
    nombreProveedor varchar(100) not null unique,
    contacto varchar(100),
    telefono varchar(20),
    email varchar(100),
    direccion varchar(255) not null,
    paisOrigen varchar(50),
    estado varchar(20) default 'Activo',
    constraint pk_proveedor primary key (idProveedor)
);


-- -----------------********* TABLAS DEPENDIENTES ****************---------------

Create table Productos(
    idProducto int auto_increment,
    idCategoria int not null,
    idProveedor int not null,
    nombreProducto varchar(255) not null,
    descripcionProducto text,
    precio decimal(10,2) not null,
    stock int not null,
    fechaCreacion datetime not null,
    constraint pk_productos primary key (idProducto),
	constraint fk_productos_categoria foreign key (idCategoria)
        references Categoria(idCategoria)
        on delete cascade,
    constraint fk_productos_proveedor foreign key (idProveedor)
        references Proveedor(idProveedor)
        on delete cascade
);

Create table Compras(
    idOrden int auto_increment,
    idUsuario int not null, 
    fechaOrden datetime not null default now(),
    totalOrden decimal(10,2) not null,
    estadoOrden varchar(50) not null,
    constraint pk_ordenes primary key (idOrden),
    constraint fk_ordenes_usuarios foreign key (idUsuario) 
        references Usuarios(idUsuario)
        on delete cascade
);

Create table DetalleCompra(
    idDetalleOrden int auto_increment,
    idOrden int not null,
    idProducto int not null,
    cantidad int not null,
    precioUnitario decimal(10,2) not null,
    constraint pk_detalleordenes primary key (idDetalleOrden),
    constraint fk_detalleordenes_ordenes foreign key (idOrden)
        references Compras(idOrden)
        on delete cascade,
    constraint fk_detalleordenes_productos foreign key (idProducto)
        references Productos(idProducto)
        on delete cascade
);

Create table Recibo(
    idRecibo int auto_increment,
    idOrden int not null,
    fechaRecibo datetime not null,
    total decimal(10,2) not null,
    metodoPago enum('Tarjeta', 'Efectivo'),
    constraint pk_recibo primary key (idRecibo),
    constraint fk_recibo_ordenes foreign key (idOrden)
        references Compras(idOrden)
        on delete cascade
);

-- ------------------------TUPLAS
INSERT INTO Usuarios (nombreUsuario, apellidoUsuario, emailUsuario, telefonoUsuario, direccionUsuario, fechaRegistro, contrasena, rol, nit)
VALUES 
('Carlos', 'Ramírez', 'cramirez@gmail.com	', '50212345678', 'Zona 1, Ciudad de Guatemala', NOW(), '12345', 'Cliente', '1234567-8'),
('Andrea', 'Morales', 'amorales@gmail.com', '50287654321', 'Zona 10, Ciudad de Guatemala', NOW(), 'abcde', 'Cliente', '2345678-9'),
('Luis', 'Gómez', 'lgomez@gmail.com', '50255667788', 'Antigua Guatemala, Sacatepéquez', NOW(), 'pass123', 'Admin', '3456789-0'),
('María', 'Pérez', 'mperez@gmail.com', '50299887766', 'Zona 5, Ciudad de Guatemala', NOW(), 'contrasena', 'Cliente', '4567890-1');




INSERT INTO Categoria (nombreCategoria, descripcion, estado)
VALUES 
('Guitarras Eléctricas', 'Instrumentos de cuerpo sólido con pastillas', 'Activo'),
('Guitarras Acústicas', 'Instrumentos con caja de resonancia sin amplificación eléctrica', 'Activo'),
('Pedales', 'Efectos para guitarras como distorsión o delay', 'Activo'),
('Amplificadores', 'Equipos que amplifican la señal de audio de la guitarra', 'Activo'),
('Accesorios', 'Complementos como cuerdas, púas, correas, etc.', 'Activo');



INSERT INTO Proveedor (nombreProveedor, contacto, telefono, email, direccion, paisOrigen, estado)
VALUES 
('Fender', 'fender@soporte.com', '001123456789', 'contacto@fender.com', 'California, USA', 'EE.UU.', 'Activo'),
('Yamaha', 'info@yamaha.com', '001987654321', 'ventas@yamaha.com', 'Hamamatsu, Japón', 'Japón', 'Activo'),
('Boss', 'boss-support@roland.com', '00122334455', 'info@boss.com', 'Osaka, Japón', 'Japón', 'Activo'),
('Marshall', 'support@marshall.com', '0044123456789', 'contacto@marshall.com', 'Bletchley, Inglaterra', 'Reino Unido', 'Activo'),
('Ernie Ball', 'info@ernieball.com', '00133445566', 'ventas@ernieball.com', 'Coachella, California', 'EE.UU.', 'Activo');



INSERT INTO Productos (idCategoria, idProveedor, nombreProducto, descripcionProducto, precio, stock, fechaCreacion)
VALUES 
(1, 1, 'Guitarra Eléctrica Stratocaster', 'Guitarra con cuerpo de aliso y pastillas single coil', 4500.00, 10, NOW()),
(2, 2, 'Guitarra Acústica Dreadnought', 'Guitarra acústica con cuerpo de caoba', 2200.00, 15, NOW()),
(3, 3, 'Pedal de distorsión', 'Pedal de distorsión clásico para guitarra eléctrica', 850.00, 25, NOW()),
(4, 4, 'Amplificador 30W', 'Amplificador compacto ideal para practicar', 1200.00, 8, NOW()),
(5, 5, 'Juego de cuerdas de acero', 'Cuerdas para guitarra eléctrica calibre .010', 150.00, 50, NOW());




INSERT INTO Compras (idUsuario, fechaOrden, totalOrden, estadoOrden)
VALUES 
(1, NOW(), 5350.00, 'Completado'),
(2, NOW(), 2350.00, 'Pendiente'),
(3, NOW(), 150.00, 'Completado'),
(4, NOW(), 850.00, 'Cancelado');


INSERT INTO DetalleCompra (idOrden, idProducto, cantidad, precioUnitario)
VALUES 
(1, 1, 1, 4500.00),
(1, 5, 2, 150.00),
(2, 2, 1, 2200.00),
(2, 5, 1, 150.00),
(3, 5, 1, 150.00),
(4, 3, 1, 850.00);


INSERT INTO Recibo (idOrden, fechaRecibo, total, metodoPago)
VALUES 
(1, NOW(), 5350.00, 'Tarjeta'),
(2, NOW(), 2350.00, 'Efectivo'),
(3, NOW(), 150.00, 'Tarjeta'),
(4, NOW(), 850.00, 'Efectivo');



