-- H2 2.2.224;
;             
CREATE USER IF NOT EXISTS "DIODECOLATECH2025" SALT '705bb2826972e8da' HASH 'a4269b9c4ea29f12e8a686e8f2bab2b2b7f02fc886ad10bd47fdcc4798a61259' ADMIN;          
CREATE MEMORY TABLE "PUBLIC"."flyway_schema_history"(
    "installed_rank" INTEGER NOT NULL,
    "version" CHARACTER VARYING(50),
    "description" CHARACTER VARYING(200) NOT NULL,
    "type" CHARACTER VARYING(20) NOT NULL,
    "script" CHARACTER VARYING(1000) NOT NULL,
    "checksum" INTEGER,
    "installed_by" CHARACTER VARYING(100) NOT NULL,
    "installed_on" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    "execution_time" INTEGER NOT NULL,
    "success" BOOLEAN NOT NULL
);               
ALTER TABLE "PUBLIC"."flyway_schema_history" ADD CONSTRAINT "PUBLIC"."flyway_schema_history_pk" PRIMARY KEY("installed_rank");
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.flyway_schema_history;   
INSERT INTO "PUBLIC"."flyway_schema_history" VALUES
(-1, NULL, '<< Flyway Schema History table created >>', 'TABLE', '', NULL, 'DIODECOLATECH2025', TIMESTAMP '2025-03-19 21:29:39.001488', 0, TRUE),
(1, '1', 'init', 'SQL', 'V1__init.sql', -2015464731, 'DIODECOLATECH2025', TIMESTAMP '2025-03-19 21:29:39.065488', 31, TRUE),
(2, '2', 'seed data', 'SQL', 'V2__seed_data.sql', -1582151257, 'DIODECOLATECH2025', TIMESTAMP '2025-03-19 21:29:39.088491', 12, TRUE);  
CREATE INDEX "PUBLIC"."flyway_schema_history_s_idx" ON "PUBLIC"."flyway_schema_history"("success" NULLS FIRST);               
CREATE MEMORY TABLE "PUBLIC"."TB_ACCOUNTS"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 11) NOT NULL,
    "BALANCE" NUMERIC(38, 2) DEFAULT 0 NOT NULL,
    "ACCOUNT_NUMBER" CHARACTER VARYING(50) NOT NULL
);              
ALTER TABLE "PUBLIC"."TB_ACCOUNTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8" PRIMARY KEY("ID");  
-- 10 +/- SELECT COUNT(*) FROM PUBLIC.TB_ACCOUNTS;            
INSERT INTO "PUBLIC"."TB_ACCOUNTS" VALUES
(1, 1000.00, 'ACC1001'),
(2, 500.00, 'ACC1002'),
(3, 1500.00, 'ACC1003'),
(4, 2000.00, 'ACC1004'),
(5, 250.00, 'ACC1005'),
(6, 750.00, 'ACC1006'),
(7, 1200.00, 'ACC1007'),
(8, 1800.00, 'ACC1008'),
(9, 1100.00, 'ACC1009'),
(10, 900.00, 'ACC1010');    
CREATE MEMORY TABLE "PUBLIC"."TB_CREDIT_CARDS"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "NUMBER" CHARACTER VARYING(50) NOT NULL,
    "EXPIRATION_DATE" CHARACTER VARYING(10) NOT NULL,
    "CVV" CHARACTER VARYING(5) NOT NULL,
    "CREDIT_LIMIT" NUMERIC(38, 2) NOT NULL
);      
ALTER TABLE "PUBLIC"."TB_CREDIT_CARDS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C" PRIMARY KEY("ID");              
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TB_CREDIT_CARDS;         
CREATE MEMORY TABLE "PUBLIC"."TB_USERS"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 11) NOT NULL,
    "NAME" CHARACTER VARYING(255) NOT NULL,
    "EMAIL" CHARACTER VARYING(255) NOT NULL,
    "PHONE" CHARACTER VARYING(50),
    "DOCUMENT_ID" CHARACTER VARYING(50) NOT NULL,
    "ACCOUNT_ID" BIGINT,
    "CREDIT_CARD_ID" BIGINT
);               
ALTER TABLE "PUBLIC"."TB_USERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_6" PRIMARY KEY("ID");     
-- 10 +/- SELECT COUNT(*) FROM PUBLIC.TB_USERS;               
INSERT INTO "PUBLIC"."TB_USERS" VALUES
(1, 'Maria Silva', 'maria@example.com', '(11) 98888-7777', '12345678901', 1, NULL),
(2, U&'Jo\00e3o Santos', 'joao@example.com', '(13) 97777-6666', '98765432109', 2, NULL),
(3, 'Pedro Lima', 'pedro@example.com', '(21) 99999-5555', '11122233344', 3, NULL),
(4, 'Ana Oliveira', 'ana@example.com', '(31) 95555-4444', '55566677788', 4, NULL),
(5, 'Carlos Souza', 'carlos@example.com', '(41) 94444-3333', '99988877766', 5, NULL),
(6, 'Juliana Mendes', 'juliana@example.com', '(51) 97777-2222', '33344455511', 6, NULL),
(7, 'Fernanda Costa', 'fernanda@example.com', '(61) 96666-1111', '66677788899', 7, NULL),
(8, 'Ricardo Pereira', 'ricardo@example.com', '(71) 98888-0000', '77788899900', 8, NULL),
(9, 'Gabriel Rocha', 'gabriel@example.com', '(81) 95555-5555', '88899900011', 9, NULL),
(10, U&'Let\00edcia Ramos', 'leticia@example.com', '(85) 97777-4444', '11100022233', 10, NULL);
CREATE MEMORY TABLE "PUBLIC"."TB_STORES"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 11) NOT NULL,
    "NAME" CHARACTER VARYING(255) NOT NULL,
    "ADDRESS" CHARACTER VARYING(255),
    "CITY" CHARACTER VARYING(100),
    "STATE" CHARACTER VARYING(50)
);            
ALTER TABLE "PUBLIC"."TB_STORES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_A" PRIMARY KEY("ID");    
-- 10 +/- SELECT COUNT(*) FROM PUBLIC.TB_STORES;              
INSERT INTO "PUBLIC"."TB_STORES" VALUES
(1, 'Loja Central', 'Rua A, 123', U&'S\00e3o Paulo', 'SP'),
(2, 'Loja Litoral', U&'Av. Oce\00e2nica, 456', 'Santos', 'SP'),
(3, 'Loja Sul', 'Rua B, 789', 'Porto Alegre', 'RS'),
(4, 'Loja Norte', 'Av. Amazonas, 999', 'Manaus', 'AM'),
(5, 'Loja Recife', 'Rua do Sol, 234', 'Recife', 'PE'),
(6, 'Loja Salvador', U&'Av. Atl\00e2ntica, 890', 'Salvador', 'BA'),
(7, 'Loja Fortaleza', 'Rua das Dunas, 567', 'Fortaleza', 'CE'),
(8, 'Loja Natal', 'Av. Praia, 345', 'Natal', 'RN'),
(9, U&'Loja Jo\00e3o Pessoa', 'Rua do Mar, 678', U&'Jo\00e3o Pessoa', 'PB'),
(10, U&'Loja Macei\00f3', 'Av. Beira Mar, 999', U&'Macei\00f3', 'AL'); 
CREATE MEMORY TABLE "PUBLIC"."TB_STORE_ACCOUNTS"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "BALANCE" NUMERIC(38, 2) NOT NULL,
    "ACCOUNT_NUMBER" CHARACTER VARYING(50) NOT NULL,
    "STORE_ID" BIGINT
);          
ALTER TABLE "PUBLIC"."TB_STORE_ACCOUNTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("ID");            
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TB_STORE_ACCOUNTS;       
CREATE MEMORY TABLE "PUBLIC"."TB_EMPLOYEES"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 11) NOT NULL,
    "NAME" CHARACTER VARYING(255) NOT NULL,
    "ROLE" CHARACTER VARYING(100) NOT NULL,
    "SALARY" FLOAT NOT NULL,
    "STORE_ID" BIGINT
);     
ALTER TABLE "PUBLIC"."TB_EMPLOYEES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_D" PRIMARY KEY("ID"); 
-- 10 +/- SELECT COUNT(*) FROM PUBLIC.TB_EMPLOYEES;           
INSERT INTO "PUBLIC"."TB_EMPLOYEES" VALUES
(1, 'Carlos Mendes', 'Gerente', 5000.0, 1),
(2, 'Ana Souza', 'Atendente', 2500.0, 2),
(3, 'Bruno Castro', U&'Mec\00e2nico', 3200.0, 3),
(4, 'Sandra Lima', 'Supervisora', 4800.0, 4),
(5, 'Fernando Alves', 'Vendedor', 3000.0, 1),
(6, 'Beatriz Moraes', U&'Secret\00e1ria', 2600.0, 2),
(7, 'Anderson Silva', 'Analista', 4000.0, 3),
(8, 'Patricia Farias', 'Atendente', 2800.0, 4),
(9, U&'Jos\00e9 Almeida', 'Gerente', 5200.0, 5),
(10, 'Tatiane Castro', 'Vendedora', 2900.0, 6); 
CREATE MEMORY TABLE "PUBLIC"."TB_STORE_TRANSACTIONS"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "OPERATION_TYPE" CHARACTER VARYING(10) NOT NULL,
    "AMOUNT" NUMERIC(38, 2) NOT NULL,
    "CREATED_AT" TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "STORE_ACCOUNT_ID" BIGINT NOT NULL
);               
ALTER TABLE "PUBLIC"."TB_STORE_TRANSACTIONS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("ID");        
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TB_STORE_TRANSACTIONS;   
CREATE MEMORY TABLE "PUBLIC"."TB_CARS"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 21) NOT NULL,
    "BRAND" CHARACTER VARYING(100) NOT NULL,
    "MODEL" CHARACTER VARYING(100) NOT NULL,
    "MANUFACTURING_YEAR" INTEGER NOT NULL,
    "PLATE" CHARACTER VARYING(20) NOT NULL,
    "DAILY_RATE" NUMERIC(38, 2) NOT NULL,
    "STORE_ID" BIGINT
);  
ALTER TABLE "PUBLIC"."TB_CARS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_D1" PRIMARY KEY("ID");     
-- 20 +/- SELECT COUNT(*) FROM PUBLIC.TB_CARS;
INSERT INTO "PUBLIC"."TB_CARS" VALUES
(1, 'Toyota', 'Corolla', 2022, 'ABC-1234', 250.00, 1),
(2, 'Honda', 'Civic', 2021, 'XYZ-5678', 230.00, 1),
(3, 'Chevrolet', 'Onix', 2023, 'DEF-9876', 180.00, 2),
(4, 'Ford', 'Ka', 2020, 'GHI-6543', 150.00, 2),
(5, 'Volkswagen', 'Gol', 2019, 'JKL-3210', 140.00, 3),
(6, 'Nissan', 'Kicks', 2022, 'MNO-2468', 200.00, 3),
(7, 'Fiat', 'Argo', 2021, 'PQR-1357', 175.00, 4),
(8, 'Jeep', 'Compass', 2023, 'STU-8642', 300.00, 4),
(9, 'Hyundai', 'HB20', 2022, 'VWX-7531', 190.00, 5),
(10, 'Peugeot', '208', 2021, 'LMN-3698', 210.00, 6),
(11, 'Renault', 'Sandero', 2020, 'GHI-2222', 170.00, 7),
(12, 'Ford', 'EcoSport', 2018, 'ZXC-7896', 160.00, 8),
(13, 'Chevrolet', 'Tracker', 2023, 'QWE-6547', 280.00, 9),
(14, 'Toyota', 'Yaris', 2021, 'TYU-9632', 220.00, 10),
(15, 'Honda', 'HR-V', 2020, 'JKL-1122', 240.00, 1),
(16, 'Volkswagen', 'T-Cross', 2023, 'POI-7733', 260.00, 2),
(17, 'Nissan', 'Versa', 2022, 'ASD-9998', 185.00, 3),
(18, 'Fiat', 'Cronos', 2021, 'DFG-6664', 195.00, 4),
(19, 'Jeep', 'Renegade', 2023, 'KLM-8484', 290.00, 5),
(20, 'Hyundai', 'Creta', 2022, 'OPQ-1235', 250.00, 6);           
CREATE MEMORY TABLE "PUBLIC"."TB_FEATURES"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "NAME" CHARACTER VARYING(100) NOT NULL
);         
ALTER TABLE "PUBLIC"."TB_FEATURES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F" PRIMARY KEY("ID");  
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TB_FEATURES;             
CREATE MEMORY TABLE "PUBLIC"."TB_CAR_FEATURES"(
    "CAR_ID" BIGINT NOT NULL,
    "FEATURE_ID" BIGINT NOT NULL
);          
ALTER TABLE "PUBLIC"."TB_CAR_FEATURES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_6D" PRIMARY KEY("CAR_ID", "FEATURE_ID");           
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TB_CAR_FEATURES;         
CREATE MEMORY TABLE "PUBLIC"."TB_RENTALS"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1 RESTART WITH 9) NOT NULL,
    "START_DATE" TIMESTAMP NOT NULL,
    "END_DATE" TIMESTAMP,
    "TOTAL_VALUE" NUMERIC(13, 2) NOT NULL,
    "STATUS" CHARACTER VARYING(20) NOT NULL,
    "USER_ID" BIGINT NOT NULL,
    "CAR_ID" BIGINT NOT NULL,
    "PICK_UP_STORE_ID" BIGINT NOT NULL,
    "DROP_OFF_STORE_ID" BIGINT
);    
ALTER TABLE "PUBLIC"."TB_RENTALS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5" PRIMARY KEY("ID");   
-- 8 +/- SELECT COUNT(*) FROM PUBLIC.TB_RENTALS;              
INSERT INTO "PUBLIC"."TB_RENTALS" VALUES
(1, TIMESTAMP '2025-05-01 09:00:00', TIMESTAMP '2025-05-05 18:00:00', 1000.00, 'FINALIZADA', 1, 1, 1, 1),
(2, TIMESTAMP '2025-06-10 10:00:00', TIMESTAMP '2025-06-12 18:00:00', 460.00, 'FINALIZADA', 2, 2, 2, 2),
(3, TIMESTAMP '2025-07-15 08:00:00', TIMESTAMP '2025-07-20 19:00:00', 1200.00, 'FINALIZADA', 3, 3, 3, 3),
(4, TIMESTAMP '2025-08-05 14:00:00', TIMESTAMP '2025-08-10 20:00:00', 1600.00, 'ABERTA', 4, 4, 4, NULL),
(5, TIMESTAMP '2025-09-01 09:00:00', TIMESTAMP '2025-09-07 17:00:00', 1400.00, 'ABERTA', 5, 5, 1, NULL),
(6, TIMESTAMP '2025-10-12 11:00:00', TIMESTAMP '2025-10-18 21:00:00', 1800.00, 'FINALIZADA', 6, 6, 2, 2),
(7, TIMESTAMP '2025-11-03 07:30:00', TIMESTAMP '2025-11-07 18:00:00', 900.00, 'FINALIZADA', 7, 7, 3, 3),
(8, TIMESTAMP '2025-12-20 13:00:00', TIMESTAMP '2025-12-25 23:00:00', 2200.00, 'FINALIZADA', 8, 8, 4, 4);  
CREATE MEMORY TABLE "PUBLIC"."TB_TRANSACTIONS"(
    "ID" BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
    "OPERATION_TYPE" CHARACTER VARYING(10) NOT NULL,
    "AMOUNT" NUMERIC(38, 2) NOT NULL,
    "CREATED_AT" TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "ACCOUNT_ID" BIGINT NOT NULL
);           
ALTER TABLE "PUBLIC"."TB_TRANSACTIONS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("ID");              
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TB_TRANSACTIONS;         
ALTER TABLE "PUBLIC"."TB_STORE_TRANSACTIONS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_25" CHECK("OPERATION_TYPE" IN('CREDIT', 'DEBIT')) NOCHECK;   
ALTER TABLE "PUBLIC"."TB_RENTALS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5A" CHECK("STATUS" IN('ABERTA', 'FINALIZADA')) NOCHECK; 
ALTER TABLE "PUBLIC"."TB_TRANSACTIONS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_38" CHECK("OPERATION_TYPE" IN('CREDIT', 'DEBIT')) NOCHECK;         
ALTER TABLE "PUBLIC"."TB_ACCOUNTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8A" UNIQUE("ACCOUNT_NUMBER");          
ALTER TABLE "PUBLIC"."TB_USERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_602EF" UNIQUE("CREDIT_CARD_ID");          
ALTER TABLE "PUBLIC"."TB_CREDIT_CARDS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C9" UNIQUE("NUMBER");              
ALTER TABLE "PUBLIC"."TB_STORE_ACCOUNTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_133" UNIQUE("STORE_ID");         
ALTER TABLE "PUBLIC"."TB_USERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_602" UNIQUE("DOCUMENT_ID");               
ALTER TABLE "PUBLIC"."TB_STORE_ACCOUNTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_13" UNIQUE("ACCOUNT_NUMBER");    
ALTER TABLE "PUBLIC"."TB_USERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_60" UNIQUE("EMAIL");      
ALTER TABLE "PUBLIC"."TB_USERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_602E" UNIQUE("ACCOUNT_ID");               
ALTER TABLE "PUBLIC"."TB_CARS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_D18" UNIQUE("PLATE");      
ALTER TABLE "PUBLIC"."TB_FEATURES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F8" UNIQUE("NAME");    
ALTER TABLE "PUBLIC"."TB_CARS" ADD CONSTRAINT "PUBLIC"."FK_CAR_STORE" FOREIGN KEY("STORE_ID") REFERENCES "PUBLIC"."TB_STORES"("ID") ON DELETE SET NULL NOCHECK;               
ALTER TABLE "PUBLIC"."TB_TRANSACTIONS" ADD CONSTRAINT "PUBLIC"."FK_TRANSACTION_ACCOUNT" FOREIGN KEY("ACCOUNT_ID") REFERENCES "PUBLIC"."TB_ACCOUNTS"("ID") ON DELETE CASCADE NOCHECK;          
ALTER TABLE "PUBLIC"."TB_RENTALS" ADD CONSTRAINT "PUBLIC"."FK_RENTAL_USER" FOREIGN KEY("USER_ID") REFERENCES "PUBLIC"."TB_USERS"("ID") ON DELETE CASCADE NOCHECK;             
ALTER TABLE "PUBLIC"."TB_USERS" ADD CONSTRAINT "PUBLIC"."FK_USER_CREDIT_CARD" FOREIGN KEY("CREDIT_CARD_ID") REFERENCES "PUBLIC"."TB_CREDIT_CARDS"("ID") ON DELETE SET NULL NOCHECK;           
ALTER TABLE "PUBLIC"."TB_RENTALS" ADD CONSTRAINT "PUBLIC"."FK_RENTAL_PICKUP" FOREIGN KEY("PICK_UP_STORE_ID") REFERENCES "PUBLIC"."TB_STORES"("ID") ON DELETE CASCADE NOCHECK; 
ALTER TABLE "PUBLIC"."TB_EMPLOYEES" ADD CONSTRAINT "PUBLIC"."FK_EMPLOYEE_STORE" FOREIGN KEY("STORE_ID") REFERENCES "PUBLIC"."TB_STORES"("ID") ON DELETE SET NULL NOCHECK;     
ALTER TABLE "PUBLIC"."TB_CAR_FEATURES" ADD CONSTRAINT "PUBLIC"."FK_CAR_FEATURE_CAR" FOREIGN KEY("CAR_ID") REFERENCES "PUBLIC"."TB_CARS"("ID") ON DELETE CASCADE NOCHECK;      
ALTER TABLE "PUBLIC"."TB_RENTALS" ADD CONSTRAINT "PUBLIC"."FK_RENTAL_DROPOFF" FOREIGN KEY("DROP_OFF_STORE_ID") REFERENCES "PUBLIC"."TB_STORES"("ID") ON DELETE SET NULL NOCHECK;              
ALTER TABLE "PUBLIC"."TB_STORE_TRANSACTIONS" ADD CONSTRAINT "PUBLIC"."FK_STORE_TRANSACTION" FOREIGN KEY("STORE_ACCOUNT_ID") REFERENCES "PUBLIC"."TB_STORE_ACCOUNTS"("ID") ON DELETE CASCADE NOCHECK;          
ALTER TABLE "PUBLIC"."TB_STORE_ACCOUNTS" ADD CONSTRAINT "PUBLIC"."FK_STORE_ACCOUNT" FOREIGN KEY("STORE_ID") REFERENCES "PUBLIC"."TB_STORES"("ID") ON DELETE CASCADE NOCHECK;  
ALTER TABLE "PUBLIC"."TB_RENTALS" ADD CONSTRAINT "PUBLIC"."FK_RENTAL_CAR" FOREIGN KEY("CAR_ID") REFERENCES "PUBLIC"."TB_CARS"("ID") ON DELETE CASCADE NOCHECK;
ALTER TABLE "PUBLIC"."TB_USERS" ADD CONSTRAINT "PUBLIC"."FK_USER_ACCOUNT" FOREIGN KEY("ACCOUNT_ID") REFERENCES "PUBLIC"."TB_ACCOUNTS"("ID") ON DELETE SET NULL NOCHECK;       
ALTER TABLE "PUBLIC"."TB_CAR_FEATURES" ADD CONSTRAINT "PUBLIC"."FK_CAR_FEATURE_FEATURE" FOREIGN KEY("FEATURE_ID") REFERENCES "PUBLIC"."TB_FEATURES"("ID") ON DELETE CASCADE NOCHECK;          
