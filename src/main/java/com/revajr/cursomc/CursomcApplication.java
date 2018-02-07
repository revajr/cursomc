package com.revajr.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

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
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		c1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		c2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1,c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		
		categoriaRepository.save(Arrays.asList(c1,c2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));

		
		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", e1);
		Cidade cid2 = new Cidade(null, "São Paulo", e2);
		Cidade cid3 = new Cidade(null, "Campinas", e2);
		
		e1.getCidades().addAll(Arrays.asList(cid1));
		e2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.save(Arrays.asList(e1,e2));
		cidadeRepository.save(Arrays.asList(cid1,cid2,cid3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "9999999999", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("123456789","999888777"));
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "7005060", cli1, cid1);
		Endereco end2 = new Endereco(null, "AvenidaMatos", "105", "Sala 800", "Centro", "650555444", cli1, cid2);
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		clienteRepository.save(Arrays.asList(cli1));
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
