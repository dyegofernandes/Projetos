CREATE TABLE circunscricao_cidade
(
  circunscricao_id bigint NOT NULL,
  cidades_id bigint NOT NULL,
  CONSTRAINT fk_5brn684csf2q20f53lcag5oit FOREIGN KEY (cidades_id)
      REFERENCES cidade (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_diyctxdq0kn7prdpsb9nsvkk5 FOREIGN KEY (circunscricao_id)
      REFERENCES circunscricao (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE circunscricao_cidade
  OWNER TO postgres;

CREATE TABLE circunscricao_bairro_bairro
(
  circunscricao_bairro_id bigint NOT NULL,
  bairros_id bigint NOT NULL,
  CONSTRAINT fk_n3d3hw583hxjk8oifj2rc06hw FOREIGN KEY (bairros_id)
      REFERENCES bairro (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_nk3rc7rk9umb1lekxx65g1oo0 FOREIGN KEY (circunscricao_bairro_id)
      REFERENCES circunscricao_bairro (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE circunscricao_bairro_bairro
  OWNER TO postgres;


insert into circunscricao_cidade(circunscricao_id,cidades_id) select c.circunscricao_id,c.id from cidade c;

insert into circunscricao_bairro_bairro (circunscricao_bairro_id, bairros_id) select circunscricao_bairro_id,id from bairro where circunscricao_bairro_id is not null;