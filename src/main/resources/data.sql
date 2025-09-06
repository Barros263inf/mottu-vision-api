-- Inserir usuário fixo
INSERT INTO usuario (id, usuario, senha) VALUES (usuario_seq.NEXTVAL, 'admin', 'senha123');

-- Inserir zonas
INSERT INTO zona (id, nome, letra) VALUES (zona_seq.NEXTVAL, 'Zona Norte', 'N');
INSERT INTO zona (id, nome, letra) VALUES (zona_seq.NEXTVAL, 'Zona Sul', 'S');
INSERT INTO zona (id, nome, letra) VALUES (zona_seq.NEXTVAL, 'Zona Leste', 'L');
INSERT INTO zona (id, nome, letra) VALUES (zona_seq.NEXTVAL, 'Zona Oeste', 'O');

-- Inserir pátios
INSERT INTO patio (id, nome) VALUES (patio_seq.NEXTVAL, 'Pátio 1');
INSERT INTO patio (id, nome) VALUES (patio_seq.NEXTVAL, 'Pátio 2');
INSERT INTO patio (id, nome) VALUES (patio_seq.NEXTVAL, 'Pátio 3');

-- Inserir grupos de status
INSERT INTO status_grupo (id, nome) VALUES (status_grupo_seq.NEXTVAL, 'Manutenção');
INSERT INTO status_grupo (id, nome) VALUES (status_grupo_seq.NEXTVAL, 'Aguardando');
INSERT INTO status_grupo (id, nome) VALUES (status_grupo_seq.NEXTVAL, 'Indisponível');
INSERT INTO status_grupo (id, nome) VALUES (status_grupo_seq.NEXTVAL, 'Pronta');

-- Inserir status específicos
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Específicos', (SELECT id FROM status_grupo WHERE nome = 'Manutenção'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Segurança', (SELECT id FROM status_grupo WHERE nome = 'Manutenção'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Corretiva', (SELECT id FROM status_grupo WHERE nome = 'Manutenção'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Preventiva', (SELECT id FROM status_grupo WHERE nome = 'Manutenção'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Peças', (SELECT id FROM status_grupo WHERE nome = 'Aguardando'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Limpeza', (SELECT id FROM status_grupo WHERE nome = 'Aguardando'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Inspeção', (SELECT id FROM status_grupo WHERE nome = 'Aguardando'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Aprovação', (SELECT id FROM status_grupo WHERE nome = 'Aguardando'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Documentação', (SELECT id FROM status_grupo WHERE nome = 'Indisponível'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Bloqueada', (SELECT id FROM status_grupo WHERE nome = 'Indisponível'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Furtada', (SELECT id FROM status_grupo WHERE nome = 'Indisponível'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Irreparável', (SELECT id FROM status_grupo WHERE nome = 'Indisponível'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Pronta', (SELECT id FROM status_grupo WHERE nome = 'Pronta'));
INSERT INTO status (id, nome, status_grupo_id) VALUES (status_seq.NEXTVAL, 'Reservada', (SELECT id FROM status_grupo WHERE nome = 'Pronta'));

-- Inserir modelos
INSERT INTO modelo (id, nome, imagem_url) VALUES (modelo_seq.NEXTVAL, 'SPORT-ESD', 'https://res.cloudinary.com/dh2xwffjw/image/upload/v1756745821/SPORT-ESD_u1hald.png');
INSERT INTO modelo (id, nome, imagem_url) VALUES (modelo_seq.NEXTVAL, 'SPORT', 'https://res.cloudinary.com/dh2xwffjw/image/upload/v1756745821/SPORT_ku7n7q.png');
INSERT INTO modelo (id, nome, imagem_url) VALUES (modelo_seq.NEXTVAL, 'MOTTU-E', 'https://res.cloudinary.com/dh2xwffjw/image/upload/v1756745820/MOTTU-E_v6zfg4.png');
INSERT INTO modelo (id, nome, imagem_url) VALUES (modelo_seq.NEXTVAL, 'POP', 'https://res.cloudinary.com/dh2xwffjw/image/upload/v1756745821/POP_yatqwi.png');