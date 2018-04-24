create database MADEM;
use MADEM;

CREATE TABLE ADMINISTRADOR(
	ID_ADMINISTRADOR INT PRIMARY KEY,
	NOMBRE_ADMINISTRADOR VARCHAR(50)
);

CREATE TABLE USUARIO(
	ID_ADMINISTRADOR INT FOREIGN KEY REFERENCES ADMINISTRADOR(ID_ADMINISTRADOR),
	USUARIO VARCHAR(20),
	PASS_ADMIN VARCHAR(20)
);

CREATE TABLE PROVEEDOR(
	ID_PROVEEDOR INT PRIMARY KEY,
	DESCRIPCION VARCHAR(50)
);

CREATE TABLE CATEGORIA(
	ID_CATEGORIA INT PRIMARY KEY,
	DESCRIPCION_CATEGORIA VARCHAR(50)
);

CREATE TABLE MARCA(
	ID_MARCA INT PRIMARY KEY,
	DESCRIPCION_MARCA VARCHAR(50)
);

CREATE TABLE PRODUCTO(
	ID_PRODUCTO INT PRIMARY KEY,
	NOMBRE_PRODUCTO VARCHAR(40),
	ID_CATEGORIA INT FOREIGN KEY REFERENCES CATEGORIA(ID_CATEGORIA),
	ID_MARCA INT FOREIGN KEY REFERENCES MARCA(ID_MARCA),
	STOCK_PRODUCTO INT,
	FECHA_INGRESO DATE,
	ID_PROVEEDOR INT FOREIGN KEY REFERENCES PROVEEDOR(ID_PROVEEDOR),
	PRECIO_COMPRA FLOAT,
	PRECIO_POR_UNIDAD FLOAT
);

CREATE TABLE CLIENTE(
	ID_CLIENTE INT PRIMARY KEY,
	DESCRIPCION_CLIENTE VARCHAR(50),
	RUC VARCHAR(11),
	DIRECCION VARCHAR(50),
	CORREO VARCHAR(50)
);

CREATE TABLE PEDIDO(
	ID_PEDIDO INT PRIMARY KEY,
	ID_CLIENTE INT FOREIGN KEY REFERENCES CLIENTE(ID_CLIENTE),
	FECHA_DE_EMISION DATE,
	DESC_PEDIDO VARCHAR(200),
	MONTO FLOAT,
);

