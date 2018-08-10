select * from circunscricao cc left join circunscricao_cidade on (circunscricoes_id=cc.id) left join cidade cid on (cidades_id=cid.id)
where cid.nome='Pedro II'


select * from circunscricaobairro cb left join circunscricaobairro_bairro cbb on (cb.id=circunscricoes_id) left join bairro b on (b.id=bairros_id)
where b.nome='Campestre'