CREATE DATABASE itiket;

use itiket;

CREATE TABLE `lugar`
  (
     `id`   INT(11) NOT NULL auto_increment,
     `lugar` VARCHAR(50) NOT NULL,
     PRIMARY KEY (`id`)
  )
engine=innodb
auto_increment=11
DEFAULT charset=utf8mb4;


INSERT INTO `lugar`
VALUES      (1,
             '#1'),
            (2,
             '#2'),
            (3,
             '#3'),
            (4,
             '#4');


CREATE TABLE `concierto`
	(
	`id` INT(11) NOT NULL auto_increment,
    `artista` VARCHAR(50) NOT NULL,
	`costo` VARCHAR(50) NOT NULL,
    `fecha` VARCHAR(50) NOT NULL,
    `capacidad_maxima` VARCHAR(50) NOT NULL,
    `lugar_id` INT(11) NOT NULL,
     PRIMARY KEY (`id`, `lugar_id`),
     KEY `fk_concierto_lugar_idx` (`lugar_id`),
     CONSTRAINT `fk_concierto_lugar` FOREIGN KEY (`lugar_id`) REFERENCES
     `lugar` (`id`) ON DELETE no action ON UPDATE no action
  );

 
  INSERT INTO `concierto`
VALUES      (7,
             '13 Exorcimos',
             '50000',
             '25 de Marzo del 2023',
             '40 personas', 
             1);
             
  INSERT INTO `concierto`
VALUES      (8,
             'Creed III',
             '3000',
             '19 de mayo del 2023',
             '50 personas', 
             4);            

  INSERT INTO `concierto`
VALUES      (9,
             'En algun sitio ',
             '3000',
             '13 de julio del 2023',
             '35 personas', 
             3);    
             
	INSERT INTO `concierto`
VALUES      (10,
             'John Wick',
             '3500',
             '30 de junio del 2023',
             '50 personas', 
             2);   
  


