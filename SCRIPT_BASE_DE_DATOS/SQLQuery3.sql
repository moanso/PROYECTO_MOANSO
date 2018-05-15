SELECT * FROM CATEGORIA, PRODUCTO
select * from PRODUCTO
SELECT * FROM PROVEEDOR

Select distinct * from CATEGORIA C join PRODUCTO P on (C.ID_CATEGORIA = P.ID_CATEGORIA) where C.DESCRIPCION_CATEGORIA ='Repuestos'
insert into PROVEEDOR values(2,'MCM PRODUCTOS INDUSTRIALES')
insert into PRODUCTO values(4,'sd',2,20,'14-5-2018',2,250,10)

SELECT * FROM PRODUCTO ORDER BY ID_PRODUCTO;


SELECT C.ID_CATEGORIA, C.DESCRIPCION_CATEGORIA, C.PRECIO_COMPRA, A.stock , C.nombre_cat FROM CATEGORIA A JOIN PRODUCTO C ON C.categ = C.cod_cat
ORDER BY A.cod;


create procedure sp_Modificar(
@cod int,
@nombre varchar(40),
@stock int,
@fecha_i varchar(12),
@precio float,
@precio_uni float
)
as
begin
update PRODUCTO
SET 
	NOMBRE_PRODUCTO = @nombre,
	STOCK_PRODUCTO = @stock,
	FECHA_INGRESO = @fecha_i,
	PRECIO_COMPRA = @precio, 
	PRECIO_POR_UNIDAD = @precio_uni
WHERE ID_PRODUCTO = @cod
end
go

SELECT * FROM CATEGORIA C join PRODUCTO P ON C.ID_CATEGORIA=P.ID_CATEGORIA

exec sp_Modificar '1','uwu','100','12-5-2018',150,16;

select * from CLIENTE
select* from PRODUCTO
INSERT INTO CLIENTE VALUES (1, 'Peru Plast', '1054863218', 'Av Buena Aventura', 'abcd@gmail.com')

Select distinct P.STOCK_PRODUCTO from CATEGORIA C JOIN PRODUCTO P ON C.ID_CATEGORIA=P.ID_CATEGORIA WHERE C.DESCRIPCION_CATEGORIA ='Limpieza'

Select distinct * from PRODUCTO P join CATEGORIA C on(P.ID_CATEGORIA = C.ID_CATEGORIA) where c.DESCRIPCION_CATEGORIA ='Limpieza'

DELETE FROM CLIENTE
WHERE ID_CLIENTE=8;

SELECT * FROM PRODUCTO ORDER BY ID_PRODUCTO