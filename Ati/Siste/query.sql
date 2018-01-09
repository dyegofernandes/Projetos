select  r.codigo as "competencia", u.codigo as "cod unidade", u.nome as "nome unidade", count (*) as "total registros", sum(m.valor) as "bruto", (sum(m.valor)-sum(m.desconto1)) as "liquido" from movimento m left join referencia r on (r.id= m.referencia_id) 
left join servidor s on (s.id=m.servidor_id) left join dadosfuncionais dados on (dados.id=s.dadosfuncionais_id)
left join unidade u on (u.id=dados.unidade_id)
where r.codigo=201609
group by r.codigo, u.codigo, u.nome
order by u.codigo
