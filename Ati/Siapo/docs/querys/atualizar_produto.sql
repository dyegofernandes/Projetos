UPDATE produto AS p
SET unidadeorcamentaria_id=ac.unidadeorcamentaria_id
FROM acaoestrategica AS ac
WHERE p.acao_id=ac.id