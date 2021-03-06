--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5 (Ubuntu 11.5-3.pgdg18.04+1)
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-26 15:02:48

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

--
-- TOC entry 24 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 4083 (class 0 OID 0)
-- Dependencies: 24
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

--
-- TOC entry 223 (class 1259 OID 4390534)
-- Name: autor; Type: TABLE; Schema: public; Owner: fisjuuyj
--

CREATE TABLE public.autor (
    codigo integer NOT NULL,
    nome character varying(100) NOT NULL
);


ALTER TABLE public.autor OWNER TO fisjuuyj;

--
-- TOC entry 222 (class 1259 OID 4390532)
-- Name: autor_codigo_seq; Type: SEQUENCE; Schema: public; Owner: fisjuuyj
--

ALTER TABLE public.autor ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.autor_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 232 (class 1259 OID 4390982)
-- Name: clientes; Type: TABLE; Schema: public; Owner: fisjuuyj
--

CREATE TABLE public.clientes (
    cart character varying(5),
    usuario integer NOT NULL,
    estudante boolean NOT NULL
);


ALTER TABLE public.clientes OWNER TO fisjuuyj;

--
-- TOC entry 225 (class 1259 OID 4390768)
-- Name: editora; Type: TABLE; Schema: public; Owner: fisjuuyj
--

CREATE TABLE public.editora (
    codigo integer NOT NULL,
    nome character varying(100) NOT NULL
);


ALTER TABLE public.editora OWNER TO fisjuuyj;

--
-- TOC entry 224 (class 1259 OID 4390766)
-- Name: edtiora_codigo_seq; Type: SEQUENCE; Schema: public; Owner: fisjuuyj
--

ALTER TABLE public.editora ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.edtiora_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 237 (class 1259 OID 4392044)
-- Name: emprestimo; Type: TABLE; Schema: public; Owner: fisjuuyj
--

CREATE TABLE public.emprestimo (
    codigo integer NOT NULL,
    "dtEmprestimo" date NOT NULL,
    "totalValor" double precision NOT NULL,
    "totalMulta" double precision NOT NULL,
    status boolean NOT NULL,
    funcionario integer NOT NULL,
    cliente integer NOT NULL
);


ALTER TABLE public.emprestimo OWNER TO fisjuuyj;

--
-- TOC entry 236 (class 1259 OID 4392042)
-- Name: emprestimo_codigo_seq; Type: SEQUENCE; Schema: public; Owner: fisjuuyj
--

ALTER TABLE public.emprestimo ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.emprestimo_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 238 (class 1259 OID 4392073)
-- Name: emprestimoexemplares; Type: TABLE; Schema: public; Owner: fisjuuyj
--

CREATE TABLE public.emprestimoexemplares (
    emprestimo integer NOT NULL,
    exemplar integer NOT NULL,
    "dataLim" date NOT NULL,
    "dataDev" date NOT NULL,
    danificado boolean NOT NULL
);


ALTER TABLE public.emprestimoexemplares OWNER TO fisjuuyj;

--
-- TOC entry 229 (class 1259 OID 4390819)
-- Name: exemplares; Type: TABLE; Schema: public; Owner: fisjuuyj
--

CREATE TABLE public.exemplares (
    codigo integer NOT NULL,
    local character varying(15) NOT NULL,
    qtde integer NOT NULL,
    valoremprestimo double precision NOT NULL,
    status boolean NOT NULL,
    livro integer NOT NULL
);


ALTER TABLE public.exemplares OWNER TO fisjuuyj;

--
-- TOC entry 228 (class 1259 OID 4390817)
-- Name: exemplares_codigo_seq; Type: SEQUENCE; Schema: public; Owner: fisjuuyj
--

ALTER TABLE public.exemplares ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.exemplares_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 233 (class 1259 OID 4391972)
-- Name: funcionarios; Type: TABLE; Schema: public; Owner: fisjuuyj
--

CREATE TABLE public.funcionarios (
    salario double precision NOT NULL,
    ctps character varying(10) NOT NULL,
    pis character varying(10) NOT NULL,
    usuario integer NOT NULL,
    matricula character varying(5)
);


ALTER TABLE public.funcionarios OWNER TO fisjuuyj;

--
-- TOC entry 227 (class 1259 OID 4390802)
-- Name: livros; Type: TABLE; Schema: public; Owner: fisjuuyj
--

CREATE TABLE public.livros (
    codigo integer NOT NULL,
    titulo character varying(70) NOT NULL,
    ano character varying(4) NOT NULL,
    genero character varying(45) NOT NULL,
    autor integer NOT NULL,
    editora integer NOT NULL
);


ALTER TABLE public.livros OWNER TO fisjuuyj;

--
-- TOC entry 226 (class 1259 OID 4390800)
-- Name: livros_codigo_seq; Type: SEQUENCE; Schema: public; Owner: fisjuuyj
--

ALTER TABLE public.livros ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.livros_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 235 (class 1259 OID 4392001)
-- Name: reserva; Type: TABLE; Schema: public; Owner: fisjuuyj
--

CREATE TABLE public.reserva (
    codigo integer NOT NULL,
    data date NOT NULL,
    cliente integer NOT NULL,
    exemplar integer NOT NULL
);


ALTER TABLE public.reserva OWNER TO fisjuuyj;

--
-- TOC entry 234 (class 1259 OID 4391999)
-- Name: reserva_codigo_seq; Type: SEQUENCE; Schema: public; Owner: fisjuuyj
--

ALTER TABLE public.reserva ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.reserva_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 231 (class 1259 OID 4390961)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: fisjuuyj
--

CREATE TABLE public.usuarios (
    codigo integer NOT NULL,
    nome character varying(100) NOT NULL,
    cpf character varying(14) NOT NULL,
    datanasc date NOT NULL,
    rg character varying(14) NOT NULL
);


ALTER TABLE public.usuarios OWNER TO fisjuuyj;

--
-- TOC entry 230 (class 1259 OID 4390959)
-- Name: usuarios_codigo_seq; Type: SEQUENCE; Schema: public; Owner: fisjuuyj
--

ALTER TABLE public.usuarios ALTER COLUMN codigo ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.usuarios_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3927 (class 2606 OID 4390538)
-- Name: autor autor_pkey; Type: CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3937 (class 2606 OID 4392057)
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (usuario);


--
-- TOC entry 3929 (class 2606 OID 4390772)
-- Name: editora edtiora_pkey; Type: CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.editora
    ADD CONSTRAINT edtiora_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3943 (class 2606 OID 4392048)
-- Name: emprestimo emprestimo_pkey; Type: CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT emprestimo_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3945 (class 2606 OID 4392077)
-- Name: emprestimoexemplares emprestimoexemplares_pkey; Type: CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.emprestimoexemplares
    ADD CONSTRAINT emprestimoexemplares_pkey PRIMARY KEY (emprestimo, exemplar);


--
-- TOC entry 3933 (class 2606 OID 4390823)
-- Name: exemplares exemplares_pkey; Type: CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.exemplares
    ADD CONSTRAINT exemplares_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3939 (class 2606 OID 4392055)
-- Name: funcionarios funcionarios_pkey; Type: CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT funcionarios_pkey PRIMARY KEY (usuario);


--
-- TOC entry 3931 (class 2606 OID 4390806)
-- Name: livros livros_pkey; Type: CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.livros
    ADD CONSTRAINT livros_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3941 (class 2606 OID 4392005)
-- Name: reserva reserva_pkey; Type: CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT reserva_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3935 (class 2606 OID 4390965)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (codigo);


--
-- TOC entry 3946 (class 2606 OID 4390807)
-- Name: livros autor_fk; Type: FK CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.livros
    ADD CONSTRAINT autor_fk FOREIGN KEY (autor) REFERENCES public.autor(codigo);


--
-- TOC entry 3951 (class 2606 OID 4392058)
-- Name: reserva cliente_fk; Type: FK CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT cliente_fk FOREIGN KEY (cliente) REFERENCES public.clientes(usuario) NOT VALID;


--
-- TOC entry 3952 (class 2606 OID 4392063)
-- Name: emprestimo cliente_fk; Type: FK CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT cliente_fk FOREIGN KEY (cliente) REFERENCES public.clientes(usuario) NOT VALID;


--
-- TOC entry 3947 (class 2606 OID 4390812)
-- Name: livros editora_fk; Type: FK CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.livros
    ADD CONSTRAINT editora_fk FOREIGN KEY (editora) REFERENCES public.editora(codigo);


--
-- TOC entry 3954 (class 2606 OID 4392078)
-- Name: emprestimoexemplares emprestimo_fk; Type: FK CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.emprestimoexemplares
    ADD CONSTRAINT emprestimo_fk FOREIGN KEY (emprestimo) REFERENCES public.emprestimo(codigo);


--
-- TOC entry 3950 (class 2606 OID 4392011)
-- Name: reserva exemplar_fk; Type: FK CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT exemplar_fk FOREIGN KEY (exemplar) REFERENCES public.exemplares(codigo);


--
-- TOC entry 3955 (class 2606 OID 4392083)
-- Name: emprestimoexemplares exemplar_fk; Type: FK CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.emprestimoexemplares
    ADD CONSTRAINT exemplar_fk FOREIGN KEY (exemplar) REFERENCES public.exemplares(codigo);


--
-- TOC entry 3953 (class 2606 OID 4392068)
-- Name: emprestimo funcionario_fk; Type: FK CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.emprestimo
    ADD CONSTRAINT funcionario_fk FOREIGN KEY (funcionario) REFERENCES public.funcionarios(usuario) NOT VALID;


--
-- TOC entry 3948 (class 2606 OID 4390824)
-- Name: exemplares livro_fk; Type: FK CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.exemplares
    ADD CONSTRAINT livro_fk FOREIGN KEY (livro) REFERENCES public.livros(codigo);


--
-- TOC entry 3949 (class 2606 OID 4391977)
-- Name: funcionarios usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: fisjuuyj
--

ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario) REFERENCES public.usuarios(codigo);


-- Completed on 2021-05-26 15:02:51

--
-- PostgreSQL database dump complete
--

