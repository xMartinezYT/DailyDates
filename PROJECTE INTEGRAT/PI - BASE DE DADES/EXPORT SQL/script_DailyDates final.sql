create database DailyDates;
use DailyDates;
create table Usuario(id_Usuario int primary key auto_increment, nombre varchar(50), apellidos varchar(50), gmail varchar(50), contrasenya varchar(10), telefono varchar(9));
create table Empresario(id_Empresario int primary key auto_increment, nombre varchar(50), apellidos varchar(50),gmail varchar(50), contrasenya varchar(10), telefono varchar(9));
create table Empresa(id_Empresa int primary key auto_increment,id_Empresario int references Empresario(id_Empresario), nombre varchar(50), CIF varchar(9), Horario varchar(15), ciudad varchar(50), foreign key (id_Empresario) references Empresario(id_Empresario));
create table Categoria(id_Categoria int primary key auto_increment, descripcion varchar(255), nombre varchar(50));
create table Pertenece (id_Categoria int references Categoria(id_Categoria), id_empresa int,foreign key (id_Categoria) references Categoria(id_Categoria),foreign key (id_empresa) references empresa(id_empresa));
create table Citas(id_cita int primary key auto_increment, id_Empresa int references empresa(id_empresa), id_Usuario int references Usuario(id_Usuario), fecha datetime, pedido varchar(255), foreign key (id_Empresa) references Empresa(id_Empresa), foreign key (id_Usuario) references Usuario(id_Usuario));

alter table Usuario add column foto_perfil mediumblob;
alter table Empresa add column foto_empresa mediumblob;
alter table empresa add column direccion varchar(255);
alter table Empresario add column foto_perfil mediumblob;


alter table citas drop column id_cita;

alter table citas modify column fecha date;
alter table citas add column hora time;
alter table citas add primary key (hora, fecha);

delimiter $$
create trigger GmailRepetidousuario before insert on usuario
for each row
begin

    if new.gmail in (select gmail from usuario) then
              SIGNAL SQLSTATE '45000'
              SET MESSAGE_TEXT = 'El correo ya esta registrado en la app';  
    elseif new.gmail in (select gmail from empresario) then            
 SIGNAL SQLSTATE '45000'
              SET MESSAGE_TEXT = 'El correo ya esta registrado en la app';
    end if;

end $$

delimiter $$
create trigger GmailRepetidoempresario before insert on empresario
for each row
begin

    if new.gmail in (select gmail from usuario) then
              SIGNAL SQLSTATE '45000'
              SET MESSAGE_TEXT = 'El correo ya esta registrado en la app';  
    elseif new.gmail in (select gmail from empresario) then            
 SIGNAL SQLSTATE '45000'
              SET MESSAGE_TEXT = 'El correo ya esta registrado en la app';
    end if;

end $$

delimiter $$
create trigger GmailRepetidoempresariomod before update on empresario
for each row
begin
if new.gmail != old.gmail then
    if new.gmail in (select gmail from usuario) then
              SIGNAL SQLSTATE '45000'
              SET MESSAGE_TEXT = 'El correo ya esta registrado en la app';  
    elseif new.gmail in (select gmail from empresario) then            
 SIGNAL SQLSTATE '45000'
              SET MESSAGE_TEXT = 'El correo ya esta registrado en la app';
    end if;
end if;

end $$

delimiter $$
create trigger GmailRepetidousuariomod before update on usuario
for each row
begin

if new.gmail != old.gmail then
    if new.gmail in (select gmail from usuario) then
              SIGNAL SQLSTATE '45000'
              SET MESSAGE_TEXT = 'El correo ya esta registrado en la app';  
    elseif new.gmail in (select gmail from empresario) then            
 SIGNAL SQLSTATE '45000'
              SET MESSAGE_TEXT = 'El correo ya esta registrado en la app';
    end if;
 end if;
end $$



delimiter $$
create procedure ver_categorias(in empresa int)
begin
select nombre from categoria where id_Categoria in (select id_categoria from pertenece where id_Empresa = empresa);
end$$

insert into categoria (id_categoria,nombre,descripcion) values (1,"pastelerias","Las pastelerías son establecimientos que se especializan en la creación y venta de productos de repostería, como pasteles, tartas, bollería y postres diversos.");
insert into categoria (id_categoria,nombre,descripcion) values (2,"fruterias","Las fruterías son establecimientos donde se venden frutas y, a menudo, verduras frescas. Suelen ofrecer una amplia variedad de productos de temporada, destacándose por la frescura y calidad.");
insert into categoria (id_categoria,nombre,descripcion) values (3,"pescaderias","Las pescaderías son tiendas especializadas en la venta de pescado y mariscos frescos. Ofrecen una variedad de productos del mar, desde peces comunes hasta mariscos exóticos, asegurando calidad y frescura.");
insert into categoria (id_categoria,nombre,descripcion) values (4,"extraescolares","Las extraescolares son actividades educativas, deportivas o artísticas que se realizan fuera del horario escolar regular. Están diseñadas para complementar la educación formal y desarrollar habilidades adicionales en los estudiantes.");
insert into categoria (id_categoria,nombre,descripcion) values (5,"salud","Los negocios de salud abarcan una amplia gama de servicios y productos relacionados con el bienestar y la medicina. Incluyen clínicas, hospitales, farmacias, laboratorios, y centros de rehabilitación, entre otros.");
insert into categoria (id_categoria,nombre,descripcion) values (6,"carnicerias","Las carnicerías son establecimientos especializados en la venta de carnes frescas, como res, cerdo, pollo y cordero. Ofrecen cortes específicos y productos derivados, como embutidos y carnes marinadas.");
insert into categoria (id_categoria,nombre,descripcion) values (7,"restaurantes","Los restaurantes son establecimientos donde se preparan y sirven comidas y bebidas para el consumo en el lugar. Ofrecen una variedad de platos, que pueden ser desde cocina local hasta internacional.");
insert into categoria (id_categoria,nombre,descripcion) values (8,"verdulerias","Las verdulerías son tiendas especializadas en la venta de verduras y hortalizas frescas. Ofrecen una amplia variedad de productos agrícolas, incluyendo hojas verdes, tubérculos, legumbres y otros vegetales de temporada.");
insert into categoria (id_categoria,nombre,descripcion) values (9,"talleres","Los talleres de mecánicos son establecimientos especializados en la reparación y mantenimiento de vehículos. Ofrecen servicios como cambio de aceite, alineación, reparaciones de motores, sistemas de frenos y más.");
insert into categoria (id_categoria,nombre,descripcion) values (10,"peluquerias","Las peluquerías son establecimientos donde se ofrecen servicios de cuidado y arreglo del cabello. Estos servicios incluyen cortes, peinados, tintes, tratamientos capilares y, a menudo, también servicios de estética como manicura, pedicura y depilación. ");
insert into categoria (id_categoria,nombre,descripcion) values (11,"otros","amplia variedad de negocios que no se ajustan fácilmente a categorías convencionales. Esto podría abarcar desde servicios profesionales como consultorías, agencias de viajes.");


ALTER TABLE Pertenece
ADD CONSTRAINT fk_Empresa_Pertenece
FOREIGN KEY (id_Empresa)
REFERENCES Empresa(id_Empresa)
ON DELETE CASCADE;

ALTER TABLE `dailydates`.`citas`
DROP FOREIGN KEY `citas_ibfk_1`;
ALTER TABLE `dailydates`.`citas`
CHANGE COLUMN `id_Empresa` `id_Empresa` INT NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`fecha`, `hora`, `id_Empresa`);

ALTER TABLE `dailydates`.`citas`
ADD CONSTRAINT `citas_ibfk_1`
  FOREIGN KEY (`id_Empresa`)
  REFERENCES `dailydates`.`empresa` (`id_Empresa`);
  
ALTER TABLE Citas DROP FOREIGN KEY citas_ibfk_1;
ALTER TABLE Citas DROP FOREIGN KEY citas_ibfk_2;

ALTER TABLE Citas
ADD CONSTRAINT fk_Empresa
FOREIGN KEY (id_Empresa) REFERENCES Empresa(id_Empresa)
ON DELETE CASCADE;

ALTER TABLE Citas
ADD CONSTRAINT fk_Usuario
FOREIGN KEY (id_Usuario) REFERENCES Usuario(id_Usuario)
ON DELETE CASCADE;
