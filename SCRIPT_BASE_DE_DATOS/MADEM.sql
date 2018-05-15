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

insert into PROVEEDOR values (1, 'Electrosil');

CREATE TABLE CATEGORIA(
	ID_CATEGORIA INT PRIMARY KEY,
	DESCRIPCION_CATEGORIA VARCHAR(50)
);

SELECT * FROM PRODUCTO;

Select distinct * from CATEGORIA 

SELECT * FROM CATEGORIA C join PRODUCTO P ON C.ID_CATEGORIA=P.ID_CATEGORIA and DESCRIPCION_CATEGORIA='Limpieza' and STOCK_PRODUCTO= '30';


Select distinct * from CATEGORIA C join PRODUCTO P on(C.ID_CATEGORIA=P.ID_CATEGORIA) where C.DESCRIPCION_CATEGORIA = 'Limpieza'

SELECT * FROM CATEGORIA C join PRODUCTO P ON C.ID_CATEGORIA=P.ID_CATEGORIA;

Select distinct * from CATEGORIA C join PRODUCTO P
                     on(C.ID_CATEGORIA=P.ID_CATEGORIA)
insert into CATEGORIA values (1, 'Limpieza');
insert into CATEGORIA values (2, 'Repuestos');

CREATE TABLE MARCA(
	ID_MARCA INT PRIMARY KEY,
	DESCRIPCION_MARCA VARCHAR(50)
);

CREATE TABLE PRODUCTO(
	ID_PRODUCTO INT PRIMARY KEY,
	NOMBRE_PRODUCTO VARCHAR(40),
	ID_CATEGORIA INT FOREIGN KEY REFERENCES CATEGORIA(ID_CATEGORIA),
	--ID_MARCA INT FOREIGN KEY REFERENCES MARCA(ID_MARCA),
	STOCK_PRODUCTO INT,
	FECHA_INGRESO VARCHAR(12),
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

----- Procedures -----

create procedure sp_Registrar(
	@cod_pro int,
	@nom_prod varchar(40),
	@des_prov VARCHAR(50),
	@precio_total float,
	@precio_pro_uni float,
	@stock_pro int,
	@fec_ingre VARCHAR(12),
	@des_cat varchar(50)
)
as
begin
declare 
	@cod_Cat int
declare 
	@cod_prov int
set 
	@cod_Cat = (select c.ID_CATEGORIA from CATEGORIA c where c.DESCRIPCION_CATEGORIA = @des_cat)
set
	@cod_prov = (select p.ID_PROVEEDOR from PROVEEDOR p where p.DESCRIPCION = @des_prov)
insert into PRODUCTO
values(@cod_pro,@nom_prod,@cod_Cat,@stock_pro,@fec_ingre, @cod_prov, @precio_total, @precio_pro_uni)
end
go

Select distinct * from CATEGORIA
SELECT DISTINCT O.DESCRIPCION FROM CATEGORIA C JOIN PRODUCTO P ON C.ID_CATEGORIA=P.ID_CATEGORIA JOIN PROVEEDOR O ON P.ID_PROVEEDOR=O.ID_PROVEEDOR WHERE C.DESCRIPCION_CATEGORIA='Limpieza'
