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

CREATE TABLE public.pet (
    pet bigint NOT NULL,
    name character varying(25) NOT NULL,
    yearofbirth int NOT NULL,
    notes character varying,
    pettype bigint NOT NULL
);

CREATE SEQUENCE public.pet_pet_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE ONLY public.pet
    ADD CONSTRAINT pet_pkey PRIMARY KEY (pet);

ALTER TABLE ONLY public.pettype
    ADD CONSTRAINT pettype_pkey PRIMARY KEY (pettype);

ALTER TABLE ONLY public.pet
    ADD CONSTRAINT "FK_pet_pettype" FOREIGN KEY (pettype) REFERENCES public.pettype(pettype);


INSERT INTO public.pettype (pettype, description) VALUES (1, 'Perro');
INSERT INTO public.pettype (pettype, description) VALUES (2, 'Gato');
INSERT INTO public.pettype (pettype, description) VALUES (3, 'Equino');
INSERT INTO public.pettype (pettype, description) VALUES (4, 'Ave');
INSERT INTO public.pettype (pettype, description) VALUES (5, 'Pez');

INSERT INTO public.pet (pet, name, yearofbirth, notes, pettype) VALUES (1, 'Bonita', '2018', 'Raza desconocida. Blanca con manchas marrones. Amistosa', 1);
INSERT INTO public.pet (pet, name, yearofbirth, notes, pettype) VALUES (2, 'Astor', '2019', 'Europeo de pelo largo. Negro.', 2);


SELECT pg_catalog.setval('public.pet_pet_seq', (select max(pet.pet) from pet), true);

SELECT pg_catalog.setval('public.pettype_pettype_seq', (select max(pettype) from pettype), true);