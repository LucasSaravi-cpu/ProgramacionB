--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.2

-- Started on 2022-08-26 14:59:22


CREATE TABLE public.pet (
    pet bigint NOT NULL,
    name character varying(25) NOT NULL,
    birthdate date,
    notes character varying,
    pettype bigint NOT NULL
);

CREATE SEQUENCE public.pet_pet_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.pet_pet_seq OWNED BY public.pet.pet;



CREATE TABLE public.pettype (
    pettype bigint NOT NULL,
    description character varying(25) NOT NULL
);

CREATE SEQUENCE public.pettype_pettype_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.pettype_pettype_seq OWNED BY public.pettype.pettype;


ALTER TABLE ONLY public.pet ALTER COLUMN pet SET DEFAULT nextval('public.pet_pet_seq'::regclass);

ALTER TABLE ONLY public.pettype ALTER COLUMN pettype SET DEFAULT nextval('public.pettype_pettype_seq'::regclass);

INSERT INTO public.pet (pet, name, birthdate, notes, pettype) VALUES (1, 'Bonita', '2018-01-15', 'Raza desconocida. Blanca con manchas marrones. Amistosa', 1);
INSERT INTO public.pet (pet, name, birthdate, notes, pettype) VALUES (2, 'Astor', '2019-11-30', 'Europeo de pelo largo. Negro.', 2);

INSERT INTO public.pettype (pettype, description) VALUES (1, 'Perro');
INSERT INTO public.pettype (pettype, description) VALUES (2, 'Gato');
INSERT INTO public.pettype (pettype, description) VALUES (3, 'Equino');
INSERT INTO public.pettype (pettype, description) VALUES (4, 'Ave');
INSERT INTO public.pettype (pettype, description) VALUES (5, 'Pez');

ALTER TABLE ONLY public.pet
    ADD CONSTRAINT pet_pkey PRIMARY KEY (pet);

ALTER TABLE ONLY public.pettype
    ADD CONSTRAINT pettype_pkey PRIMARY KEY (pettype);

ALTER TABLE ONLY public.pet
    ADD CONSTRAINT "FK_pet_pettype" FOREIGN KEY (pettype) REFERENCES public.pettype(pettype);

SELECT pg_catalog.setval('public.pet_pet_seq', (select max(pet.pet) from pet), true);

SELECT pg_catalog.setval('public.pettype_pettype_seq', (select max(pettype) from pettype), true);