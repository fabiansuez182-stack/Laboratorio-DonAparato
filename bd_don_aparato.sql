-- ==============================================
-- Script SQL para la Tienda DON APARATO
-- Base de datos: bd_don_aparato
-- ==============================================

CREATE DATABASE IF NOT EXISTS bd_don_aparato;
USE bd_don_aparato;

-- Tabla de usuarios (clientes)
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    tipo CHAR(1) DEFAULT NULL  -- A, B, C o NULL (sin afiliación)
);

-- Tabla de compras
CREATE TABLE IF NOT EXISTS compras (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(100) NOT NULL,
    valor_unitario DOUBLE NOT NULL,
    cantidad INT NOT NULL,
    total_bruto DOUBLE NOT NULL,
    descuento_aplicado DOUBLE NOT NULL,
    total_neto DOUBLE NOT NULL,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

-- ==============================================
-- Datos de prueba
-- ==============================================
INSERT INTO usuarios (nombre, apellido, edad, telefono, tipo) VALUES
('Carlos', 'García', 30, '3001234567', 'A'),
('María', 'López', 25, '3109876543', 'B'),
('Pedro', 'Ramírez', 40, '3205551234', 'C'),
('Ana', 'Torres', 22, '3154447890', NULL);
