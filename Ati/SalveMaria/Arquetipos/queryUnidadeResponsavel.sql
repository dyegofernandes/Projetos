select * from unidade u left join circunscricao c on (u.circunscricao_id=c.id) left join circunscricaobairro cb on (u.circunscricaobairro_id=cb.id)
	left join circunscricaobairro_bairro cirbairro on (cb.id=cirbairro.circunscricoes_id) 
	left join bairro bair on (cirbairro.bairros_id=bair.id)
	where bair.id=404

select unidade0_.id as id1_21_0_, circunscri1_.id as id1_5_1_, circunscri2_.id as id1_6_2_, unidade0_.circunscricao_id as circunsc8_21_0_, 
unidade0_.circunscricaoBairro_id as circunsc9_21_0_, unidade0_.endereco_id as enderec10_21_0_, unidade0_.faixaEtariaDeDenuncias as faixaEta2_21_0_, 
unidade0_.nome as nome3_21_0_, unidade0_.sigla as sigla4_21_0_, unidade0_.tipo as tipo5_21_0_, unidade0_.visualizarDenunciaNormal as visualiz6_21_0_, 
unidade0_.visualizarDenunciaPanico as visualiz7_21_0_, circunscri1_.baseMunicipal_id as baseMuni5_5_1_, circunscri1_.latitude as latitude2_5_1_, 
circunscri1_.longitude as longitud3_5_1_, circunscri1_.nome as nome4_5_1_, circunscri2_.cidade_id as cidade_i5_6_2_, circunscri2_.latitude as latitude2_6_2_, 
circunscri2_.longitude as longitud3_6_2_, circunscri2_.nome as nome4_6_2_ from Unidade unidade0_ left outer join Circunscricao circunscri1_ on 
unidade0_.circunscricao_id=circunscri1_.id left outer join CircunscricaoBairro circunscri2_ on unidade0_.circunscricaoBairro_id=circunscri2_.id 
where (circunscri2_.id in (1 , 8 , 13)) and (circunscri1_.id in (2 , 13)) and tipo=1


select * from unidade u left join circunscricao c on (u.circunscricao_id=c.id) left join circunscricao_cidade cc on (c.id=cc.circunscricoes_id)
	left join cidade cid on (cid.id=cc.cidades_id) left join bairro bar on (bar.cidade_id=cid.id) 
	where bar.id=404

select * from unidade u left join circunscricao c on (u.circunscricao_id=c.id) left join circunscricaobairro cb on (u.circunscricaobairro_id=cb.id)
	where c.id in (2,13) and cb.id in (1,8,9)

select * from circunscricaobairro c where c.id=2
select * from circunscricao where id=2

select * from bairro b left join cidade c on (c.id=b.cidade_id) where b.id=404 