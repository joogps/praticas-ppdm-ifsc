package pessoas;
import java.util.ArrayList;

public class MinhaListaPessoa {
    ArrayList<Pessoa> pessoas = new ArrayList<>();

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public ArrayList<Pessoa> listarPessoas() {
        return pessoas;
    }
}
