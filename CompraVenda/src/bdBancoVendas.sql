
create database dbVendas;

use dbVendas;

create table Endereco(

	end_Codigo int primary key auto_increment,
    end_Estado varchar(60),
    end_Cidade varchar(60),
    end_Bairro varchar(60),
    end_Rua varchar(60),
    end_UF varchar(2),
    end_Complemento varchar(60),
    end_Numero int,
    end_CEP varchar(9)

);

create table Cliente(

	cli_Codigo int primary key auto_increment,
    cli_Nome varchar(60) not null,
    cli_DocumentoIdentificador varchar(20),
    cli_Telefone varchar(15),
    cli_Email varchar(70),
    cli_Tipo boolean,
    end_Codigo int null,
    FOREIGN KEY(end_Codigo) REFERENCES Endereco(end_Codigo)
);

create table Fornecedor(

	for_Codigo int primary key auto_increment,
    for_Nome varchar(60) not null,
    for_NomeFantasia varchar(60) not null,
    for_CNPJ varchar(20) not null,
    for_Email varchar(70),
    for_Telefone varchar(15),
	end_Codigo int null,
    FOREIGN KEY(end_Codigo) REFERENCES Endereco(end_Codigo)

);

create table notaFiscal(

	nof_Codigo int primary key auto_increment,
    nof_valorTotal decimal(8,2) not null,
    nof_DataEmissao date not null,
	nof_FormaPagamento varchar(60) not null,
    nof_TipoNota boolean not null, -- 0 - Entrada, 1 - Saida
    cli_Codigo int null,
    for_Codigo int null,
	FOREIGN KEY(cli_Codigo) REFERENCES Cliente(cli_Codigo),
    FOREIGN KEY(for_Codigo) REFERENCES Fornecedor(for_Codigo)

);

create table Produto(

	pro_Codigo int primary key auto_increment,
    pro_Nome varchar(60) not null,
    pro_Valor decimal(8,2) not null,
    pro_QuantidadeEstoque int not null,
    pro_Quantidadelimite int not null,
    pro_Descricao varchar(90)

);

create table ProdutosNota(

	prn_Codigo int primary key auto_increment,
    prn_valorUnidade decimal(8,2) not null,
    prn_Quantidade int not null,
    pro_Codigo int not null,
    nof_Codigo int not null,
    FOREIGN KEY(pro_Codigo) REFERENCES Produto(pro_Codigo),
    FOREIGN KEY(nof_Codigo) REFERENCES notaFiscal(nof_Codigo)

);

Delimiter $$
create procedure inserirFornecedor(

pend_Estado varchar(60), 
pend_Cidade varchar(60), 
pend_Bairro varchar(60), 
pend_Rua varchar(60), 
pend_UF varchar(2), 
pend_Complemento varchar(60), 
pend_Numero int, 
pend_CEP varchar(9),
pfor_Nome varchar(60),
pfor_NomeFantasia varchar(60), 
pfor_CNPJ varchar(20),
pfor_Email varchar(70), 
pfor_Telefone varchar(15)

)	
	BEGIN
    
    /*Primeiro cadastro o endereço*/
    INSERT INTO Endereco(end_Estado, end_Cidade, end_Bairro, end_Rua, end_UF, end_Complemento, end_Numero, end_CEP)
        Values(pend_Estado, pend_Cidade, pend_Bairro, pend_Rua, pend_UF, pend_Complemento, pend_Numero, pend_CEP);
               
    /*Depois insiro no fornecedor*/        
    Insert into Fornecedor(for_Nome, for_NomeFantasia, for_CNPJ, for_Email, for_Telefone, end_Codigo)
		Values(pfor_Nome, pfor_NomeFantasia, pfor_CNPJ, pfor_Email, pfor_Telefone, last_insert_id()); /* insiro o ultimo ID gerado*/
    END $$
Delimiter ;



Delimiter $$
create procedure inserirCliente(

pend_Estado varchar(60), 
pend_Cidade varchar(60), 
pend_Bairro varchar(60), 
pend_Rua varchar(60), 
pend_UF varchar(2), 
pend_Complemento varchar(60), 
pend_Numero int, 
pend_CEP varchar(9),
pcli_Nome varchar(60), 
pcli_DocumentoIdentificador varchar(20), 
pcli_Tipo boolean,
pcli_Email varchar(70), 
pcli_Telefone varchar(15)


)	
	BEGIN
    
    /*Primeiro cadastro o endereço*/
    INSERT INTO Endereco(end_Estado, end_Cidade, end_Bairro, end_Rua, end_UF, end_Complemento, end_Numero, end_CEP)
        Values(pend_Estado, pend_Cidade, pend_Bairro, pend_Rua, pend_UF, pend_Complemento, pend_Numero, pend_CEP);
               
    /*Depois insiro no cliente*/   
    Insert into Cliente(cli_Nome, cli_DocumentoIdentificador, cli_Email, cli_Telefone, cli_Tipo, end_Codigo)
		Values(pcli_Nome, pcli_DocumentoIdentificador, pcli_Email, pcli_Telefone, pcli_Tipo, last_insert_id()); /* insiro o ultimo ID gerado*/
    END $$
Delimiter ;



DELIMITER $$
CREATE PROCEDURE inserirNota (
    IN p_valorTotal DECIMAL(8,2),
    IN p_dataEmissao DATE,
    IN p_formaPagamento VARCHAR(60),
    IN p_tipoNota BOOLEAN,
    IN p_cliCodigo INT,
    IN p_forCodigo INT,
    OUT p_idGerado INT -- preciso retornar esse id para que consiga inserir os itens
)
BEGIN
    INSERT INTO notaFiscal (nof_valorTotal, nof_DataEmissao, nof_FormaPagamento, nof_TipoNota, cli_Codigo, for_Codigo)
    VALUES (p_valorTotal, p_dataEmissao, p_formaPagamento, p_tipoNota, p_cliCodigo, p_forCodigo);

    -- pego o id gerado após inserir a nota e guardo para retornar
    SET p_idGerado = LAST_INSERT_ID();
    
END$$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE InserirItemSaida(
    IN pvalorUnidade DECIMAL(8, 2), 
    IN pquantidade INT,
    IN pproCodigo INT,
    IN pcodNotaFiscal INT
)
BEGIN
    -- insiro a nota
    INSERT INTO ProdutosNota (prn_valorUnidade, prn_Quantidade, pro_Codigo, nof_Codigo)
    VALUES (pvalorUnidade, pquantidade, pproCodigo, pcodNotaFiscal);

    -- atualizo o estoque do produto
    UPDATE Produto 
    SET pro_QuantidadeEstoque = pro_QuantidadeEstoque - pquantidade
    WHERE pro_Codigo = pproCodigo;

END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE InserirItemEntrada(
    IN pvalorUnidade DECIMAL(8, 2), 
    IN pquantidade INT,
    IN pproCodigo INT,
    IN pcodNotaFiscal INT
)
BEGIN
    -- insiro a nota
    INSERT INTO ProdutosNota (prn_valorUnidade, prn_Quantidade, pro_Codigo, nof_Codigo)
    VALUES (pvalorUnidade, pquantidade, pproCodigo, pcodNotaFiscal);

    -- atualizo o estoque do produto
    UPDATE Produto 
    SET pro_QuantidadeEstoque = pro_QuantidadeEstoque + pquantidade
    WHERE pro_Codigo = pproCodigo;

END$$

DELIMITER ;