Drop database sgpeliculas;
Create database sgpeliculas;
Use sgpeliculas;

create table genero (
idgenero int primary key,
nombre varchar(45)
);

Create table pelicula (
idpelicula int primary key,
nombre varchar(45),
director varchar(45),
fechaEstreno date ,
idgenero int references genero(idgenero)
);

Insert into genero (idgenero,nombre) values
	(1, 'Drama'),
    (2, 'Action'),
    (3, 'Crime'),
    (4, 'Biography'),
    (5, 'Romance');

Select * from genero;

Insert into pelicula (idpelicula, nombre,director,fechaEstreno,idgenero) values
	(1, 'The Shawshank Redemption', 'Frank Darabont', '1994-09-23', 1),
    (2, 'The Godfather', 'Francis Ford Coppola', '1972-03-24', 1),
    (3, 'The Dark Knight', 'Christopher Nolan', '2008-07-18', 2),
    (4, 'Inception', 'Christopher Nolan', '2010-07-16', 2),
    (5, 'Pulp Fiction', 'Quentin Tarantino', '1994-10-14', 3),
    (6, 'Schindler''s List', 'Steven Spielberg', '1993-12-15', 4),
    (7, 'Forrest Gump', 'Robert Zemeckis', '1994-07-06', 5);

Select * from pelicula;





