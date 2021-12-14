insert into cozinha (nome) values ('Brasileira')
insert into cozinha (nome) values ('Mexicana')
insert into cozinha (nome) values ('Americana')
insert into cozinha (nome) values ('Australiana')

insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cep, endereco_bairro, endereco_logradouro, endereco_numero, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values ('Arena do sabor', 10, 1, '53437460', 'Janga', 'Rua Severino Marques Dias', '633', 'Atras da Drogasil', 1,utc_timestamp, utc_timestamp )
insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cep, endereco_bairro, endereco_logradouro, endereco_numero, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values ('ChinaInBox', 20, 2, '23452345', 'Olinda', 'Rua Teodoro Peixoto', '456', 'Atras do SESA', 2,utc_timestamp, utc_timestamp )
insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cep, endereco_bairro, endereco_logradouro, endereco_numero, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values ('Tios Sans', 50, 3, '789345', 'Recife', 'Rua Maradilhas de Morais', '009', 'Do outro lado do XERO', 3,utc_timestamp, utc_timestamp )
insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cep, endereco_bairro, endereco_logradouro, endereco_numero, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values ('Cangurus', 70, 4, '7858675', 'Jaboatao', 'Rua Fernando Pessoa', '554', 'Do lado do MOKA', 4,utc_timestamp, utc_timestamp )



insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3), (4,3);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 2);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 4);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 4);




