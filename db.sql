create database logitrack_db;
use logitrack_db;

CREATE TABLE clients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    email varchar(100) NOT NULL,
    telephone VARCHAR(20),
    ville VARCHAR(100)
);

CREATE TABLE produits (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    categorie varchar(100) NOT NULL,
    prix DECIMAL(10, 2),
    quantite_stock INT
);

CREATE TABLE commandes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_commande DATETIME DEFAULT CURRENT_TIMESTAMP,
	statut ENUM('EN_ATTENTE', 'EXPEDIEE', 'LIVREE') NOT NULL,
    client_id BIGINT,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE ligne_commandes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantite int ,
    commande_id BIGINT, 
    produit_id BIGINT,
	FOREIGN KEY (commande_id) REFERENCES commandes(id),
    FOREIGN KEY (produit_id) REFERENCES produits(id)
);