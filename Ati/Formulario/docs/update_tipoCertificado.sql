update controledecertificado 
Set tipocertificado_id = (case infra 
			when 'PF_A1' then 1
			when 'PF_A3' then 2
			when 'PJ_A1' then 3
			when 'PJ_A3' then 4
			when 'EQP_A1' then 5
			when 'APL_A1' then 6
			end);