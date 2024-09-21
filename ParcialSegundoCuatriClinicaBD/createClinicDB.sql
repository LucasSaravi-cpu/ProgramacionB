CREATE TABLE public.medicalassurance (
  medicalassurance BIGSERIAL,
  name VARCHAR(20) NOT NULL,
  CONSTRAINT medicalassurance_pkey PRIMARY KEY(medicalassurance)
) ;

ALTER TABLE public.medicalassurance
  ALTER COLUMN medicalassurance SET STATISTICS 0;

ALTER TABLE public.medicalassurance
  OWNER TO postgres;
  
 CREATE TABLE public.medicine (
  medicine BIGSERIAL,
  description VARCHAR(30) NOT NULL,
  unitprice MONEY NOT NULL,
  CONSTRAINT medicine_pkey PRIMARY KEY(medicine)
) ;

ALTER TABLE public.medicine
  ALTER COLUMN medicine SET STATISTICS 0;

ALTER TABLE public.medicine
  ALTER COLUMN description SET STATISTICS 0;

ALTER TABLE public.medicine
  OWNER TO postgres;
  
  
CREATE TABLE public.patient (
  patient BIGSERIAL,
  name VARCHAR(20) NOT NULL,
  birthdate DATE,
  medicalassurance BIGINT NOT NULL,
  CONSTRAINT patient_pkey PRIMARY KEY(patient),
  CONSTRAINT patientmedicalassurance_fk FOREIGN KEY (medicalassurance)
    REFERENCES public.medicalassurance(medicalassurance)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
) ;

ALTER TABLE public.patient
  ALTER COLUMN patient SET STATISTICS 0;

ALTER TABLE public.patient
  ALTER COLUMN name SET STATISTICS 0;

ALTER TABLE public.patient
  OWNER TO postgres;
  

CREATE TABLE public.prescription (
  prescription BIGSERIAL,
  date DATE NOT NULL,
  professional VARCHAR(20) NOT NULL,
  prescriptiontype CHAR(1) NOT NULL,
  dailydose INTEGER,
  days INTEGER,
  studyrequired VARCHAR,
  diagnosis VARCHAR,
  medicine BIGINT,
  patient BIGINT DEFAULT 1 NOT NULL,
  CONSTRAINT prescription_pkey PRIMARY KEY(prescription),
  CONSTRAINT prescriptionmedicine_fk FOREIGN KEY (medicine)
    REFERENCES public.medicine(medicine)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE,
  CONSTRAINT prescriptionpatient_fk FOREIGN KEY (patient)
    REFERENCES public.patient(patient)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    NOT DEFERRABLE
) ;

ALTER TABLE public.prescription
  ALTER COLUMN prescription SET STATISTICS 0;

ALTER TABLE public.prescription
  ALTER COLUMN prescriptiontype SET STATISTICS 0;

ALTER TABLE public.prescription
  OWNER TO postgres;
  

/* Data for the 'public.medicalassurance' table  (Records 1 - 5) */

INSERT INTO public.medicalassurance ("medicalassurance", "name")
VALUES 
  (1, E'Obra Social UNE'),
  (2, E'Mutual America'),
  (3, E'Medical PLUS'),
  (4, E'Mutual Italiana'),
  (5, E'Obra Social MAX');
  
/* Data for the 'public.medicine' table  (Records 1 - 8) */

INSERT INTO public.medicine ("medicine", "description", "unitprice")
VALUES 
  (1, E'ibuprofeno compr. 600 mg', '100'),
  (2, E'amoxicilina compr. 850 mg', '250'),
  (3, E'epinefrina compr. 100 mg', '500'),
  (4, E'ampicilina inyectable 15mg', '700'),
  (5, E'lidocaina inyectable 50mg', '800'),
  (6, E'calcio comprimido 150mg', '50'),
  (7, E'paracetamol capsula 60mg', '300'),
  (8, E'efedrina comprimido 75mg', '400');
  
/* Data for the 'public.patient' table  (Records 1 - 8) */

INSERT INTO public.patient ("patient", "name", "birthdate", "medicalassurance")
VALUES 
  (1, E'Perez Juan', E'1970-11-30', 3),
  (2, E'Lopez Lina', E'1944-12-19', 1),
  (3, E'Dinal Luis', E'1964-08-17', 2),
  (4, E'Romero Ana', E'1984-01-15', 5),
  (5, E'Camino Luz', E'2004-04-14', 3),
  (6, E'Dalto Jose', E'2001-06-16', 4),
  (7, E'Padin Mara', E'1988-05-15', 3),
  (8, E'Barco Luka', E'2000-07-17', 4);
  
/* Data for the 'public.prescription' table  (Records 1 - 7) */
INSERT INTO public.prescription ("prescription", "date", "professional", "prescriptiontype", "dailydose", "days", "studyrequired", "diagnosis", "medicine", "patient")
VALUES 
  (1, E'2023-10-01', E'Dr. Aldana', E'M', 3, 5, E'', E'', 2, 1),
  (2, E'2023-10-01', E'Dra. Daher', E'S', NULL, NULL, E'Tomografia craneal', E'Traumatismo craneal', NULL, 1),
  (3, E'2023-10-01', E'Dr. Ruller', E'M', 2, 10, E'', E'', 3, 1),
  (4, E'2023-10-02', E'Dra. Daher', E'M', 1, 4, E'', E'', 7, 1),
  (5, E'2023-10-02', E'Dr. Kolin', E'S', NULL, NULL, E'Radiografía tobillo derecho', E'Fractura tobillo derecho', NULL, 3),
  (6, E'2023-10-02', E'Dra. Lujan', E'M', 4, 3, E'', E'', 8, 2),
  (7, E'2023-10-02', E'Dr. Ruller', E'S', NULL, NULL, E'Ecografía abdominal', E'Embarazo (6° mes)', NULL, 2);
  
