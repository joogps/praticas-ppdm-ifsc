package pessoas;

public class Main {
    public static void main(String[] args) {
        MinhaListaPessoa lista = new MinhaListaPessoa();

        Endereco endereco1 = new Endereco("Gaspar", "Rua Sete de Setembro", "60");
        Pessoa pessoa1 = new Pessoa("João", "joogps@gmail.com", "(47) 99999-9999", endereco1);

        lista.adicionarPessoa(pessoa1);
        System.out.println(lista.listarPessoas());
    }
}
