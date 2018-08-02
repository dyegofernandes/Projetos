select * from poligono
select * from poligono_ponto

select '|' as x, p.nome,'(' as x, pon.latitude, pon.longitude, ')' as x from poligono p left join poligono_ponto pp on (p.id=pp.poligono_id) left join 
ponto pon on (pon.id=pp.pontos_id)