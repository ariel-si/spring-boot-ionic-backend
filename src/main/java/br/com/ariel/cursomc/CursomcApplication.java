package br.com.ariel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ariel.cursomc.domain.Categoria;
import br.com.ariel.cursomc.domain.Cidade;
import br.com.ariel.cursomc.domain.Cliente;
import br.com.ariel.cursomc.domain.Endereco;
import br.com.ariel.cursomc.domain.Estado;
import br.com.ariel.cursomc.domain.Produto;
import br.com.ariel.cursomc.domain.enums.TipoCliente;
import br.com.ariel.cursomc.repositories.CategoriaRepository;
import br.com.ariel.cursomc.repositories.CidadeRepository;
import br.com.ariel.cursomc.repositories.ClienteRepository;
import br.com.ariel.cursomc.repositories.EnderecoRepository;
import br.com.ariel.cursomc.repositories.EstadoRepository;
import br.com.ariel.cursomc.repositories.ProdutoRepository2;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository2 produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Conputador", 2000.00);
		Produto p2 = new Produto(null, "Impresora",800.00);
		Produto p3 = new Produto(null, "Mause",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São paulo", est2);
		Cidade c3 = new Cidade(null, "Canpinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Ariel Montovani", "am.si@outlook.com", "45302497867", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("11985113515","1129644573"));
		
		Endereco e1 = new Endereco(null, "R. sete", "358", "casa", "Horto do ipê", "08593470", cli1, c1);
		Endereco e2 = new Endereco(null, "R. Dr. arnaldo de morais", "228", "apto 503", "Cangaiba", "00000000", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
	}

}
