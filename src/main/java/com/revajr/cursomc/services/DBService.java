package com.revajr.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.revajr.cursomc.dominio.Categoria;
import com.revajr.cursomc.dominio.Cidade;
import com.revajr.cursomc.dominio.Cliente;
import com.revajr.cursomc.dominio.Endereco;
import com.revajr.cursomc.dominio.Estado;
import com.revajr.cursomc.dominio.ItemPedido;
import com.revajr.cursomc.dominio.Pagamento;
import com.revajr.cursomc.dominio.PagamentoComBoleto;
import com.revajr.cursomc.dominio.PagamentoComCartao;
import com.revajr.cursomc.dominio.Pedido;
import com.revajr.cursomc.dominio.Produto;
import com.revajr.cursomc.dominio.enums.EstadoPagamento;
import com.revajr.cursomc.dominio.enums.Perfil;
import com.revajr.cursomc.dominio.enums.TipoCliente;
import com.revajr.cursomc.repositories.CategoriaRepository;
import com.revajr.cursomc.repositories.CidadeRepository;
import com.revajr.cursomc.repositories.ClienteRepository;
import com.revajr.cursomc.repositories.EnderecoRepository;
import com.revajr.cursomc.repositories.EstadoRepository;
import com.revajr.cursomc.repositories.ItemPedidoRepository;
import com.revajr.cursomc.repositories.PagamentoRepository;
import com.revajr.cursomc.repositories.PedidoRepository;
import com.revajr.cursomc.repositories.ProdutoRepository;


@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRespository;
	@Autowired
	private PagamentoRepository pagtoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	

	public void instantiateTestDatabase() throws ParseException {
		
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		Categoria c3 = new Categoria(null, "Cama Mesa e Banho");
		Categoria c4 = new Categoria(null, "Eletronicos");
		Categoria c5 = new Categoria(null, "Jardinagem");
		Categoria c6 = new Categoria(null, "Decoração");
		Categoria c7 = new Categoria(null, "Perfumaria");
//		Categoria c8 = new Categoria(null, "Categoria teste");
		
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		Produto p12 = new Produto(null, "Produto 12", 10.00);
		Produto p13 = new Produto(null, "Produto 13", 10.00);
		Produto p14 = new Produto(null, "Produto 14", 10.00);
		Produto p15 = new Produto(null, "Produto 15", 10.00);
		Produto p16 = new Produto(null, "Produto 16", 10.00);
		Produto p17 = new Produto(null, "Produto 17", 10.00);
		Produto p18 = new Produto(null, "Produto 18", 10.00);
		Produto p19 = new Produto(null, "Produto 19", 10.00);
		Produto p20 = new Produto(null, "Produto 20", 10.00);
		Produto p21 = new Produto(null, "Produto 21", 10.00);
		Produto p22 = new Produto(null, "Produto 22", 10.00);
		Produto p23 = new Produto(null, "Produto 23", 10.00);
		Produto p24 = new Produto(null, "Produto 24", 10.00);
		Produto p25 = new Produto(null, "Produto 25", 10.00);
		Produto p26 = new Produto(null, "Produto 26", 10.00);
		Produto p27 = new Produto(null, "Produto 27", 10.00);
		Produto p28 = new Produto(null, "Produto 28", 10.00);
		Produto p29 = new Produto(null, "Produto 29", 10.00);
		Produto p30 = new Produto(null, "Produto 30", 10.00);
		Produto p31 = new Produto(null, "Produto 31", 10.00);
		Produto p32 = new Produto(null, "Produto 32", 10.00);
		Produto p33 = new Produto(null, "Produto 33", 10.00);
		Produto p34 = new Produto(null, "Produto 34", 10.00);
		Produto p35 = new Produto(null, "Produto 35", 10.00);
		Produto p36 = new Produto(null, "Produto 36", 10.00);
		Produto p37 = new Produto(null, "Produto 37", 10.00);
		Produto p38 = new Produto(null, "Produto 38", 10.00);
		Produto p39 = new Produto(null, "Produto 39", 10.00);
		Produto p40 = new Produto(null, "Produto 40", 10.00);
		Produto p41 = new Produto(null, "Produto 41", 10.00);
		Produto p42 = new Produto(null, "Produto 42", 10.00);
		Produto p43 = new Produto(null, "Produto 43", 10.00);
		Produto p44 = new Produto(null, "Produto 44", 10.00);
		Produto p45 = new Produto(null, "Produto 45", 10.00);
		Produto p46 = new Produto(null, "Produto 46", 10.00);
		Produto p47 = new Produto(null, "Produto 47", 10.00);
		Produto p48 = new Produto(null, "Produto 48", 10.00);
		Produto p49 = new Produto(null, "Produto 49", 10.00);
		Produto p50 = new Produto(null, "Produto 50", 10.00);
		
		
		c1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		c2.getProdutos().addAll(Arrays.asList(p2, p4));
		c3.getProdutos().addAll(Arrays.asList(p5, p6));
		c4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		c5.getProdutos().addAll(Arrays.asList(p8));
		c6.getProdutos().addAll(Arrays.asList(p9, p10));
		c7.getProdutos().addAll(Arrays.asList(p11));
		c1.getProdutos().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		p1.getCategorias().addAll(Arrays.asList(c1, c4));
		p12.getCategorias().add(c1);
		p13.getCategorias().add(c1);
		p14.getCategorias().add(c1);
		p15.getCategorias().add(c1);
		p16.getCategorias().add(c1);
		p17.getCategorias().add(c1);
		p18.getCategorias().add(c1);
		p19.getCategorias().add(c1);
		p20.getCategorias().add(c1);
		p21.getCategorias().add(c1);
		p22.getCategorias().add(c1);
		p23.getCategorias().add(c1);
		p24.getCategorias().add(c1);
		p25.getCategorias().add(c1);
		p26.getCategorias().add(c1);
		p27.getCategorias().add(c1);
		p28.getCategorias().add(c1);
		p29.getCategorias().add(c1);
		p30.getCategorias().add(c1);
		p31.getCategorias().add(c1);
		p32.getCategorias().add(c1);
		p33.getCategorias().add(c1);
		p34.getCategorias().add(c1);
		p35.getCategorias().add(c1);
		p36.getCategorias().add(c1);
		p37.getCategorias().add(c1);
		p38.getCategorias().add(c1);
		p39.getCategorias().add(c1);
		p40.getCategorias().add(c1);
		p41.getCategorias().add(c1);
		p42.getCategorias().add(c1);
		p43.getCategorias().add(c1);
		p44.getCategorias().add(c1);
		p45.getCategorias().add(c1);
		p46.getCategorias().add(c1);
		p47.getCategorias().add(c1);
		p48.getCategorias().add(c1);
		p49.getCategorias().add(c1);
		p50.getCategorias().add(c1);		
		p2.getCategorias().addAll(Arrays.asList(c1, c2, c4));
		p3.getCategorias().addAll(Arrays.asList(c1, c4));
		p4.getCategorias().addAll(Arrays.asList(c2));
		p5.getCategorias().addAll(Arrays.asList(c3));
		p6.getCategorias().addAll(Arrays.asList(c3));
		p7.getCategorias().addAll(Arrays.asList(c4));
		p8.getCategorias().addAll(Arrays.asList(c5));
		p9.getCategorias().addAll(Arrays.asList(c6));
		p10.getCategorias().addAll(Arrays.asList(c6));
		p11.getCategorias().addAll(Arrays.asList(c7));
		
		categoriaRepository.save(Arrays.asList(c1,c2,c3,c4,c5,c6,c7));
		produtoRepository.save(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		produtoRepository.save(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", e1);
		Cidade cid2 = new Cidade(null, "São Paulo", e2);
		Cidade cid3 = new Cidade(null, "Campinas", e2);
		
		e1.getCidades().addAll(Arrays.asList(cid1));
		e2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.save(Arrays.asList(e1,e2));
		cidadeRepository.save(Arrays.asList(cid1,cid2,cid3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "revajr@hotmail.com", "9999999999", TipoCliente.PESSOAFISICA, pe.encode("12345"));
		cli1.getTelefones().addAll(Arrays.asList("123456789","999888777"));
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "7005060", cli1, cid1);
		Endereco end2 = new Endereco(null, "AvenidaMatos", "105", "Sala 800", "Centro", "650555444", cli1, cid2);
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		Cliente cli2 = new Cliente(null, "Revailton", "revajr@gmail.com", "9999999999", TipoCliente.PESSOAFISICA, pe.encode("12345"));
		cli2.addPerfil(Perfil.ADMIN);
		cli2.getTelefones().addAll(Arrays.asList("123456789","999888777"));
		Endereco end3 = new Endereco(null, "AvenidaMatos", "105", "Sala 800", "Centro", "650555444", cli2, cid2);
		cli2.getEnderecos().addAll(Arrays.asList(end3));
		
		
		
		clienteRepository.save(Arrays.asList(cli1, cli2));
		enderecoRepository.save(Arrays.asList(end1,end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("06/02/2018 14:00"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/01/2018 08:00"), cli1, end2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2,	sdf.parse("20/10/2017 00:00"), null );
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRespository.save(Arrays.asList(ped1, ped2));
		pagtoRepository.save(Arrays.asList(pagto1, pagto2));
		
		//----------------------------------------------------------
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
		//----------------------------------------------------------
		

		
	}
	
	
}
