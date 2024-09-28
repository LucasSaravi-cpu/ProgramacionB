--
-- PostgreSQL database dump
--

-- Dumped from database version 16.4
-- Dumped by pg_dump version 16.4

-- Started on 2024-09-27 23:52:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 17381)
-- Name: deportes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.deportes (
    iddeporte bigint NOT NULL,
    descripcion character varying(30),
    valor numeric(10,2)
);


ALTER TABLE public.deportes OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 17380)
-- Name: deporte_iddeporte_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.deporte_iddeporte_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.deporte_iddeporte_seq OWNER TO postgres;

--
-- TOC entry 4806 (class 0 OID 0)
-- Dependencies: 217
-- Name: deporte_iddeporte_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.deporte_iddeporte_seq OWNED BY public.deportes.iddeporte;


--
-- TOC entry 216 (class 1259 OID 17374)
-- Name: socios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.socios (
    idsocio bigint NOT NULL,
    nombre character varying(30),
    genero character(1),
    vitalicio boolean
);


ALTER TABLE public.socios OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 17373)
-- Name: socio_idsocio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.socio_idsocio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.socio_idsocio_seq OWNER TO postgres;

--
-- TOC entry 4807 (class 0 OID 0)
-- Dependencies: 215
-- Name: socio_idsocio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.socio_idsocio_seq OWNED BY public.socios.idsocio;


--
-- TOC entry 219 (class 1259 OID 17387)
-- Name: socios_deportes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.socios_deportes (
    idsocio bigint NOT NULL,
    iddeporte bigint NOT NULL
);


ALTER TABLE public.socios_deportes OWNER TO postgres;

--
-- TOC entry 4644 (class 2604 OID 17384)
-- Name: deportes iddeporte; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deportes ALTER COLUMN iddeporte SET DEFAULT nextval('public.deporte_iddeporte_seq'::regclass);


--
-- TOC entry 4643 (class 2604 OID 17377)
-- Name: socios idsocio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.socios ALTER COLUMN idsocio SET DEFAULT nextval('public.socio_idsocio_seq'::regclass);


--
-- TOC entry 4799 (class 0 OID 17381)
-- Dependencies: 218
-- Data for Name: deportes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.deportes (iddeporte, descripcion, valor) FROM stdin;
2	Basquet	1000.00
3	Voley	800.00
4	Tenis	1200.00
5	Destreza	690.00
6	Rugby	1250.00
7	Futbol	600.00
8	padel	120.00
1	Natacion	2500.00
\.


--
-- TOC entry 4797 (class 0 OID 17374)
-- Dependencies: 216
-- Data for Name: socios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.socios (idsocio, nombre, genero, vitalicio) FROM stdin;
3	Carlos	M	f
4	Ana	F	t
5	Lara	F	f
6	Diego	M	f
7	Esteban	M	f
8	Pedro	M	t
9	Aldo	M	t
10	Clara	F	t
\.


--
-- TOC entry 4800 (class 0 OID 17387)
-- Dependencies: 219
-- Data for Name: socios_deportes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.socios_deportes (idsocio, iddeporte) FROM stdin;
3	2
3	3
3	4
4	1
4	5
5	2
6	4
7	1
8	4
8	5
9	2
9	6
9	7
10	2
\.


--
-- TOC entry 4808 (class 0 OID 0)
-- Dependencies: 217
-- Name: deporte_iddeporte_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.deporte_iddeporte_seq', 8, true);


--
-- TOC entry 4809 (class 0 OID 0)
-- Dependencies: 215
-- Name: socio_idsocio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.socio_idsocio_seq', 11, true);


--
-- TOC entry 4648 (class 2606 OID 17386)
-- Name: deportes deporte_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.deportes
    ADD CONSTRAINT deporte_pkey PRIMARY KEY (iddeporte);


--
-- TOC entry 4646 (class 2606 OID 17379)
-- Name: socios socio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.socios
    ADD CONSTRAINT socio_pkey PRIMARY KEY (idsocio);


--
-- TOC entry 4650 (class 2606 OID 17391)
-- Name: socios_deportes socios_deportes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.socios_deportes
    ADD CONSTRAINT socios_deportes_pkey PRIMARY KEY (idsocio, iddeporte);


--
-- TOC entry 4651 (class 2606 OID 17397)
-- Name: socios_deportes socios_deportes_iddeporte_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.socios_deportes
    ADD CONSTRAINT socios_deportes_iddeporte_fkey FOREIGN KEY (iddeporte) REFERENCES public.deportes(iddeporte) ON DELETE CASCADE;


--
-- TOC entry 4652 (class 2606 OID 17392)
-- Name: socios_deportes socios_deportes_idsocio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.socios_deportes
    ADD CONSTRAINT socios_deportes_idsocio_fkey FOREIGN KEY (idsocio) REFERENCES public.socios(idsocio) ON DELETE CASCADE;


-- Completed on 2024-09-27 23:52:52

--
-- PostgreSQL database dump complete
--

