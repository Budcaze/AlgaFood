insert into cozinha (nome) values ('Brasileira')
insert into cozinha (nome) values ('Mexicana')
insert into cozinha (nome) values ('Americana')
insert into cozinha (nome) values ('Australiana')
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Arena do sabor', 10, 1)
insert into restaurante (nome, taxa_frete, cozinha_id) values ('ChinaInBox', 20, 2)
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tios Sans', 50, 3)
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Cangurus', 70, 4)

insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');


