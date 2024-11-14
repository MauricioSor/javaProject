INSERT INTO diagnostico (codigo, nombre) VALUES ('J00', 'Resfriado común');
INSERT INTO diagnostico (codigo, nombre) VALUES ('U07.1', 'COVID-19, virus identificado');
INSERT INTO diagnostico (codigo, nombre) VALUES ('A90', 'Dengue');
INSERT INTO diagnostico (codigo, nombre) VALUES ('J02', 'Faringitis aguda');
INSERT INTO diagnostico (codigo, nombre) VALUES ('J06', 'Infección aguda de las vías respiratorias superiores');
INSERT INTO diagnostico (codigo, nombre) VALUES ('J11', 'Gripe, virus no identificado');
INSERT INTO diagnostico (codigo, nombre) VALUES ('J18', 'Neumonía, organismo no especificado');
INSERT INTO diagnostico (codigo, nombre) VALUES ('J20', 'Bronquitis aguda');
INSERT INTO diagnostico (codigo, nombre) VALUES ('J45', 'Asma');
INSERT INTO diagnostico (codigo, nombre) VALUES ('K29', 'Gastritis y duodenitis');
INSERT INTO diagnostico (codigo, nombre) VALUES ('K35', 'Apendicitis aguda');
INSERT INTO diagnostico (codigo, nombre) VALUES ('K52', 'Gastroenteritis y colitis no infecciosas');
INSERT INTO diagnostico (codigo, nombre) VALUES ('K80', 'Colelitiasis');
INSERT INTO diagnostico (codigo, nombre) VALUES ('K85', 'Pancreatitis aguda');
INSERT INTO diagnostico (codigo, nombre) VALUES ('I10', 'Hipertensión esencial (primaria)');
INSERT INTO diagnostico (codigo, nombre) VALUES ('I25', 'Enfermedad isquémica crónica del corazón');
INSERT INTO diagnostico (codigo, nombre) VALUES ('I50', 'Insuficiencia cardíaca');
INSERT INTO diagnostico (codigo, nombre) VALUES ('E11', 'Diabetes mellitus tipo 2');
INSERT INTO diagnostico (codigo, nombre) VALUES ('E66', 'Obesidad');
INSERT INTO diagnostico (codigo, nombre) VALUES ('D50', 'Anemia por deficiencia de hierro');
INSERT INTO diagnostico (codigo, nombre) VALUES ('N18', 'Enfermedad renal crónica');
INSERT INTO diagnostico (codigo, nombre) VALUES ('N39', 'Infección del tracto urinario, sitio no especificado');
INSERT INTO diagnostico (codigo, nombre) VALUES ('B34', 'Infección viral, no especificada');
INSERT INTO diagnostico (codigo, nombre) VALUES ('B18', 'Hepatitis viral crónica');
INSERT INTO diagnostico (codigo, nombre) VALUES ('A09', 'Diarrea y gastroenteritis de presunto origen infeccioso');
INSERT INTO diagnostico (codigo, nombre) VALUES ('L30', 'Dermatitis no especificada');
INSERT INTO diagnostico (codigo, nombre) VALUES ('M54', 'Dorsalgia');
INSERT INTO diagnostico (codigo, nombre) VALUES ('M79', 'Dolor en partes blandas');
INSERT INTO diagnostico (codigo, nombre) VALUES ('G43', 'Migraña');
INSERT INTO diagnostico (codigo, nombre) VALUES ('F32', 'Episodio depresivo');
INSERT INTO diagnostico (codigo, nombre) VALUES ('F41', 'Trastornos de ansiedad');
INSERT INTO diagnostico (codigo, nombre) VALUES ('F33', 'Trastorno depresivo recurrente');


-- Medicamentos Genéricos
INSERT INTO medicamento_generico (nombre) VALUES ('Paracetamol');
INSERT INTO medicamento_generico (nombre) VALUES ('Ibuprofeno');
INSERT INTO medicamento_generico (nombre) VALUES ('Amoxicilina');
INSERT INTO medicamento_generico (nombre) VALUES ('Metformina');
INSERT INTO medicamento_generico (nombre) VALUES ('Omeprazol');
INSERT INTO medicamento_generico (nombre) VALUES ('Losartan');
INSERT INTO medicamento_generico (nombre) VALUES ('Atenolol');
INSERT INTO medicamento_generico (nombre) VALUES ('Levotiroxina');
INSERT INTO medicamento_generico (nombre) VALUES ('Simvastatina');
INSERT INTO medicamento_generico (nombre) VALUES ('Enalapril');
INSERT INTO medicamento_generico (nombre) VALUES ('Clonazepam');
INSERT INTO medicamento_generico (nombre) VALUES ('Diclofenac');
INSERT INTO medicamento_generico (nombre) VALUES ('Ciprofloxacina');
INSERT INTO medicamento_generico (nombre) VALUES ('Loratadina');
INSERT INTO medicamento_generico (nombre) VALUES ('Ranitidina');
INSERT INTO medicamento_generico (nombre) VALUES ('Aspirina');
INSERT INTO medicamento_generico (nombre) VALUES ('Furosemida');
INSERT INTO medicamento_generico (nombre) VALUES ('Prednisona');
INSERT INTO medicamento_generico (nombre) VALUES ('Tramadol');
INSERT INTO medicamento_generico (nombre) VALUES ('Diazepam');

-- Medicamentos Comerciales
INSERT INTO medicamento (codigo, nombre, marca, fecha_vencimiento, medicamento_generico_id)
VALUES ('PARA500', 'Paracetamol 500mg', 'Genfar', '2024-12-31', 1),
       ('ACT400', 'Actron 400mg', 'Bagó', '2025-06-30', 2),
       ('AMOX500', 'Amoxidal 500mg', 'Bagó', '2024-11-30', 3),
       ('GLUC850', 'Glucophage 850mg', 'Roemmers', '2025-01-15', 4),
       ('LOSEC20', 'Losec 20mg', 'AstraZeneca', '2024-10-20', 5),
       ('COZAAR50', 'Cozaar 50mg', 'Sanofi', '2024-09-30', 6),
       ('TENORMIN50', 'Tenormin 50mg', 'Gador', '2024-08-31', 7),
       ('EUTIROX50', 'Eutirox 50mcg', 'GSK', '2024-07-31', 8),
       ('ZOCOR20', 'Zocor 20mg', 'Pfizer', '2024-06-30', 9),
       ('RENITEC5', 'Renitec 5mg', 'Novartis', '2024-05-31', 10),
       ('RIVOTRIL2', 'Rivotril 2mg', 'Roche', '2025-01-31', 11),
       ('VOLTAREN50', 'Voltaren 50mg', 'Novartis', '2025-02-28', 12),
       ('CIPRO500', 'Ciprofloxacina 500mg', 'Bayer', '2025-03-31', 13),
       ('CLARITINE10', 'Claritine 10mg', 'Bayer', '2025-04-30', 14),
       ('ZANTAC150', 'Zantac 150mg', 'GlaxoSmithKline', '2025-05-31', 15),
       ('ASPIRINA100', 'Aspirina 100mg', 'Bayer', '2025-06-30', 16),
       ('LASIX40', 'Lasix 40mg', 'Sanofi', '2025-07-31', 17),
       ('PREDNISONA20', 'Prednisona 20mg', 'Roemmers', '2025-08-31', 18),
       ('TRAMADOL50', 'Tramadol 50mg', 'Gador', '2025-09-30', 19),
       ('VALIUM10', 'Valium 10mg', 'Roche', '2025-10-31', 20);