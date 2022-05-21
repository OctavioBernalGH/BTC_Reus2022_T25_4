
CREATE TABLE `peliculas` (
    `codigo` INT,
    `nombre_pelicula` VARCHAR(100),
    `calificacion_edad` INT,
    PRIMARY KEY (`codigo`)
);

CREATE TABLE `salas` (
    `codigo` INT,
    `pelicula` INT,
    `nombre_sala` VARCHAR(100),
    `id_peliculas` INT,
    PRIMARY KEY (`codigo`),
    FOREIGN KEY (`id_peliculas`)
        REFERENCES `peliculas` (`codigo`)
);

insert into `peliculas`(`codigo`,`nombre_pelicula`, `calificacion_edad`) values (1,'Harry popotter', 1);
insert into `peliculas`(`codigo`,`nombre_pelicula`, `calificacion_edad`) values (2,'La momia', 2);
insert into `peliculas`(`codigo`,`nombre_pelicula`, `calificacion_edad`) values (3,'Star guarros', 3);
insert into `peliculas`(`codigo`,`nombre_pelicula`, `calificacion_edad`) values (4,'Alvin y las ardillas', 4);
insert into `peliculas`(`codigo`,`nombre_pelicula`, `calificacion_edad`) values (5,'El señor de los martillos', 5);

insert into `salas`(`codigo`,`pelicula`, `nombre_sala`, `id_peliculas`)values(1,1,'Sala 1',1);
insert into `salas`(`codigo`,`pelicula`, `nombre_sala`, `id_peliculas`)values(2,2,'Sala 2',2);
insert into `salas`(`codigo`,`pelicula`, `nombre_sala`, `id_peliculas`)values(3,3,'Sala 3',3);
insert into `salas`(`codigo`,`pelicula`, `nombre_sala`, `id_peliculas`)values(4,4,'Sala 4',4);
insert into `salas`(`codigo`,`pelicula`, `nombre_sala`, `id_peliculas`)values(5,5,'Sala 5',5);