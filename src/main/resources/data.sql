CREATE TABLE Categorias (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE Pecas (
    id SERIAL PRIMARY KEY,
    categoria_id INT,
    codigo_unico VARCHAR(255) UNIQUE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    quantidade_estoque INT NOT NULL,
    dot VARCHAR(255), -- campo opcional para pneus
    FOREIGN KEY (categoria_id) REFERENCES Categorias(id)
);