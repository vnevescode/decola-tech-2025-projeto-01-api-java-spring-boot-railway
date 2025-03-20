-- ===========================================
-- V1__init.sql - Criação das tabelas principais
-- ===========================================

-- Criando a tabela de Contas dos Usuários (deve vir antes de tb_users)
CREATE TABLE tb_accounts (
    id BIGSERIAL PRIMARY KEY,
    balance NUMERIC(38,2) DEFAULT 0 NOT NULL,
    account_number VARCHAR(50) UNIQUE NOT NULL
);

-- Criando a tabela de Cartões de Crédito (deve vir antes de tb_users)
CREATE TABLE tb_credit_cards (
    id BIGSERIAL PRIMARY KEY,
    number VARCHAR(50) UNIQUE NOT NULL,
    expiration_date VARCHAR(10) NOT NULL,
    cvv VARCHAR(5) NOT NULL,
    credit_limit  NUMERIC(38,2) NOT NULL
);

-- Criando a tabela de Usuários (Clientes)
CREATE TABLE tb_users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(50),
    document_id VARCHAR(50) UNIQUE NOT NULL,
    account_id BIGINT UNIQUE,
    credit_card_id BIGINT UNIQUE,
    CONSTRAINT fk_user_account FOREIGN KEY (account_id) REFERENCES tb_accounts(id) ON DELETE SET NULL,
    CONSTRAINT fk_user_credit_card FOREIGN KEY (credit_card_id) REFERENCES tb_credit_cards(id) ON DELETE SET NULL
);

-- Criando a tabela de Lojas (Filiais)
CREATE TABLE tb_stores (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(50)
);

-- Criando a tabela de Contas das Lojas (deve vir depois de tb_stores)
CREATE TABLE tb_store_accounts (
    id BIGSERIAL PRIMARY KEY,
    balance NUMERIC(38,2) NOT NULL,
    account_number VARCHAR(50) UNIQUE NOT NULL,
    store_id BIGINT UNIQUE,
    CONSTRAINT fk_store_account FOREIGN KEY (store_id) REFERENCES tb_stores(id) ON DELETE CASCADE
);

-- Criando a tabela de Funcionários (deve vir depois de tb_stores)
CREATE TABLE tb_employees (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(100) NOT NULL,
    salary FLOAT NOT NULL,
    store_id BIGINT,
    CONSTRAINT fk_employee_store FOREIGN KEY (store_id) REFERENCES tb_stores(id) ON DELETE SET NULL
);

-- Criando a tabela de Transações das Lojas (deve vir depois de tb_store_accounts)
CREATE TABLE tb_store_transactions (
    id BIGSERIAL PRIMARY KEY,
    operation_type VARCHAR(10) CHECK (operation_type IN ('CREDIT', 'DEBIT')) NOT NULL,
    amount NUMERIC(38,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    store_account_id BIGINT NOT NULL,
    CONSTRAINT fk_store_transaction FOREIGN KEY (store_account_id) REFERENCES tb_store_accounts(id) ON DELETE CASCADE
);

-- Criando a tabela de Carros (deve vir depois de tb_stores)
CREATE TABLE tb_cars (
    id BIGSERIAL PRIMARY KEY,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    manufacturing_year INT NOT NULL,
    plate VARCHAR(20) UNIQUE NOT NULL,
    daily_rate NUMERIC(38,2) NOT NULL,
    store_id BIGINT,
    CONSTRAINT fk_car_store FOREIGN KEY (store_id) REFERENCES tb_stores(id) ON DELETE SET NULL
);

-- Criando a tabela de Recursos (Features) para os Carros
CREATE TABLE tb_features (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

-- Criando a tabela de Relacionamento entre Carros e Features (N:N) (deve vir depois de tb_cars e tb_features)
CREATE TABLE tb_car_features (
    car_id BIGINT NOT NULL,
    feature_id BIGINT NOT NULL,
    PRIMARY KEY (car_id, feature_id),
    CONSTRAINT fk_car_feature_car FOREIGN KEY (car_id) REFERENCES tb_cars(id) ON DELETE CASCADE,
    CONSTRAINT fk_car_feature_feature FOREIGN KEY (feature_id) REFERENCES tb_features(id) ON DELETE CASCADE
);

-- Criando a tabela de Locações de Carros (deve vir depois de tb_users, tb_cars e tb_stores)
CREATE TABLE tb_rentals (
    id BIGSERIAL PRIMARY KEY,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP,
    total_value NUMERIC(13,2) NOT NULL,
    status VARCHAR(20) CHECK (status IN ('ABERTA', 'FINALIZADA')) NOT NULL,
    user_id BIGINT NOT NULL,
    car_id BIGINT NOT NULL,
    pick_up_store_id BIGINT NOT NULL,
    drop_off_store_id BIGINT,
    CONSTRAINT fk_rental_user FOREIGN KEY (user_id) REFERENCES tb_users(id) ON DELETE CASCADE,
    CONSTRAINT fk_rental_car FOREIGN KEY (car_id) REFERENCES tb_cars(id) ON DELETE CASCADE,
    CONSTRAINT fk_rental_pickup FOREIGN KEY (pick_up_store_id) REFERENCES tb_stores(id) ON DELETE CASCADE,
    CONSTRAINT fk_rental_dropoff FOREIGN KEY (drop_off_store_id) REFERENCES tb_stores(id) ON DELETE SET NULL
);

-- Criando a tabela de Transações dos Clientes (deve vir depois de tb_accounts)
CREATE TABLE tb_transactions (
    id BIGSERIAL PRIMARY KEY,
    operation_type VARCHAR(10) CHECK (operation_type IN ('CREDIT', 'DEBIT')) NOT NULL,
    amount NUMERIC(38,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    account_id BIGINT NOT NULL,
    CONSTRAINT fk_transaction_account FOREIGN KEY (account_id) REFERENCES tb_accounts(id) ON DELETE CASCADE
);
