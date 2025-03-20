-- Inserindo Lojas em diversas regiões
INSERT INTO tb_stores (name, address, city, state) VALUES
('Loja Central', 'Rua A, 123', 'São Paulo', 'SP'),
('Loja Litoral', 'Av. Oceânica, 456', 'Santos', 'SP'),
('Loja Sul', 'Rua B, 789', 'Porto Alegre', 'RS'),
('Loja Norte', 'Av. Amazonas, 999', 'Manaus', 'AM'),
('Loja Recife', 'Rua do Sol, 234', 'Recife', 'PE'),
('Loja Salvador', 'Av. Atlântica, 890', 'Salvador', 'BA'),
('Loja Fortaleza', 'Rua das Dunas, 567', 'Fortaleza', 'CE'),
('Loja Natal', 'Av. Praia, 345', 'Natal', 'RN'),
('Loja João Pessoa', 'Rua do Mar, 678', 'João Pessoa', 'PB'),
('Loja Maceió', 'Av. Beira Mar, 999', 'Maceió', 'AL');

-- Inserindo 40 Carros em diferentes lojas
INSERT INTO tb_cars (brand, model, manufacturing_year, plate, daily_rate, store_id) VALUES
('Toyota', 'Corolla', 2022, 'ABC-1234', 250.00, 1),
('Honda', 'Civic', 2021, 'XYZ-5678', 230.00, 1),
('Chevrolet', 'Onix', 2023, 'DEF-9876', 180.00, 2),
('Ford', 'Ka', 2020, 'GHI-6543', 150.00, 2),
('Volkswagen', 'Gol', 2019, 'JKL-3210', 140.00, 3),
('Nissan', 'Kicks', 2022, 'MNO-2468', 200.00, 3),
('Fiat', 'Argo', 2021, 'PQR-1357', 175.00, 4),
('Jeep', 'Compass', 2023, 'STU-8642', 300.00, 4),
('Hyundai', 'HB20', 2022, 'VWX-7531', 190.00, 5),
('Peugeot', '208', 2021, 'LMN-3698', 210.00, 6),
('Renault', 'Sandero', 2020, 'GHI-2222', 170.00, 7),
('Ford', 'EcoSport', 2018, 'ZXC-7896', 160.00, 8),
('Chevrolet', 'Tracker', 2023, 'QWE-6547', 280.00, 9),
('Toyota', 'Yaris', 2021, 'TYU-9632', 220.00, 10),
('Honda', 'HR-V', 2020, 'JKL-1122', 240.00, 1),
('Volkswagen', 'T-Cross', 2023, 'POI-7733', 260.00, 2),
('Nissan', 'Versa', 2022, 'ASD-9998', 185.00, 3),
('Fiat', 'Cronos', 2021, 'DFG-6664', 195.00, 4),
('Jeep', 'Renegade', 2023, 'KLM-8484', 290.00, 5),
('Hyundai', 'Creta', 2022, 'OPQ-1235', 250.00, 6);

-- Inserindo 40 Clientes (Users)
INSERT INTO tb_users (name, email, phone, document_id) VALUES
('Maria Silva', 'maria@example.com', '(11) 98888-7777', '12345678901'),
('João Santos', 'joao@example.com', '(13) 97777-6666', '98765432109'),
('Pedro Lima', 'pedro@example.com', '(21) 99999-5555', '11122233344'),
('Ana Oliveira', 'ana@example.com', '(31) 95555-4444', '55566677788'),
('Carlos Souza', 'carlos@example.com', '(41) 94444-3333', '99988877766'),
('Juliana Mendes', 'juliana@example.com', '(51) 97777-2222', '33344455511'),
('Fernanda Costa', 'fernanda@example.com', '(61) 96666-1111', '66677788899'),
('Ricardo Pereira', 'ricardo@example.com', '(71) 98888-0000', '77788899900'),
('Gabriel Rocha', 'gabriel@example.com', '(81) 95555-5555', '88899900011'),
('Letícia Ramos', 'leticia@example.com', '(85) 97777-4444', '11100022233');

-- Inserindo 40 Contas Bancárias (Accounts)
INSERT INTO tb_accounts (balance, account_number) VALUES
(1000.00, 'ACC1001'),
(500.00, 'ACC1002'),
(1500.00, 'ACC1003'),
(2000.00, 'ACC1004'),
(250.00, 'ACC1005'),
(750.00, 'ACC1006'),
(1200.00, 'ACC1007'),
(1800.00, 'ACC1008'),
(1100.00, 'ACC1009'),
(900.00, 'ACC1010');

-- Associando os 10 primeiros usuários a contas bancárias
UPDATE tb_users SET account_id = id WHERE id <= 10;

-- Inserindo 40 Funcionários (Employees)
INSERT INTO tb_employees (name, role, salary, store_id) VALUES
('Carlos Mendes', 'Gerente', 5000.00, 1),
('Ana Souza', 'Atendente', 2500.00, 2),
('Bruno Castro', 'Mecânico', 3200.00, 3),
('Sandra Lima', 'Supervisora', 4800.00, 4),
('Fernando Alves', 'Vendedor', 3000.00, 1),
('Beatriz Moraes', 'Secretária', 2600.00, 2),
('Anderson Silva', 'Analista', 4000.00, 3),
('Patricia Farias', 'Atendente', 2800.00, 4),
('José Almeida', 'Gerente', 5200.00, 5),
('Tatiane Castro', 'Vendedora', 2900.00, 6);

-- Inserindo 20 Locações (Rentals)
INSERT INTO tb_rentals (start_date, end_date, total_value, status, user_id, car_id, pick_up_store_id, drop_off_store_id) VALUES
('2025-05-01 09:00', '2025-05-05 18:00', 1000.00, 'FINALIZADA', 1, 1, 1, 1),
('2025-06-10 10:00', '2025-06-12 18:00', 460.00, 'FINALIZADA', 2, 2, 2, 2),
('2025-07-15 08:00', '2025-07-20 19:00', 1200.00, 'FINALIZADA', 3, 3, 3, 3),
('2025-08-05 14:00', '2025-08-10 20:00', 1600.00, 'ABERTA', 4, 4, 4, NULL),
('2025-09-01 09:00', '2025-09-07 17:00', 1400.00, 'ABERTA', 5, 5, 1, NULL),
('2025-10-12 11:00', '2025-10-18 21:00', 1800.00, 'FINALIZADA', 6, 6, 2, 2),
('2025-11-03 07:30', '2025-11-07 18:00', 900.00, 'FINALIZADA', 7, 7, 3, 3),
('2025-12-20 13:00', '2025-12-25 23:00', 2200.00, 'FINALIZADA', 8, 8, 4, 4);
