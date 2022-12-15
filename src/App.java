
import java.util.Scanner;
import models.Diarista;
import repository.DiaristaRepository;

public class App {

    public static void main(String[] args) {
        var keybord = new Scanner(System.in);
        var diarista = new DiaristaRepository();

        var opcao = "a";
        do {
            System.out.println("");
            AppAbrirMenu();
            System.out.println("Informe a opção desejada");
            opcao = keybord.nextLine();
            System.out.println("-----------------------------------------");
            switch (opcao) {
                case "1":
                    listarDiaristas(diarista);
                    break;
                case "2":
                    cadastrarDiarista(keybord, diarista);
                    break;
                case "3":
                    procurarDiarista(keybord, diarista);
                    break;
                case "4":
                    excluirDiarista(keybord, diarista);
                    break;
                case "a": System.out.println("Saindo do Sistema");
                break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (!opcao.equals("a"));

        keybord.close();

    }

    private static void AppAbrirMenu() {
        System.out.println("1- Listar Diaristas");
        System.out.println("2- Cadastrar Diaristas");
        System.out.println("3- Procucrar Diaristas");
        System.out.println("4- Excluir Diaristas");
        System.out.println("a- Sair");
    }

    private static void excluirDiarista(Scanner keybord, DiaristaRepository diarista) {
        System.out.print("Id: ");
        var id = keybord.nextLong();
        keybord.nextLine();
        var excluido = diarista.apagarPorId(id);
        if (excluido) {
            System.out.println("Diarista Excluido com sucesso!");
        } else {
            System.out.println("Diarista não enconntrado!");
        }
    }

    private static void procurarDiarista(Scanner keybord, DiaristaRepository diarista) {
        System.out.print("Infome o Id:");
        var id = keybord.nextLong();
        keybord.nextLine();
        var diaristaget = diarista.buscarPorId(id);
        if (diaristaget != null) {
            diaristaget.getId();
            System.out.println("id: " + diaristaget.getId() + " Nome " + diaristaget.getNome());
        } else {
            System.out.println("Diarista Não encontrado!");
        }
    }

    private static void cadastrarDiarista(Scanner keybord, DiaristaRepository diarista) {
        System.out.print("Nome: ");
        var nome = keybord.nextLine();
        System.out.print("Telefone: ");
        var telefone = keybord.nextLine();
        System.out.print("Numero Bi: ");
        var bI = keybord.nextLine();
        System.out.print("endereco:");
        var endereco = keybord.nextLine();
        var diaristaInsta = new Diarista(nome, telefone, bI, endereco);
        diarista.cadastrar(diaristaInsta);
        System.out.println("Diarista Adicionado com Sucesso!");
    }

    private static void listarDiaristas(DiaristaRepository diarista) {
        var diaristas = diarista.buscarTodos();
        if (diaristas.isEmpty()) {
            System.out.println("Não existem diaristas Cadastrados");
            
        }
        for (Diarista diarista1 : diaristas) {
            System.out.println(diarista1.getId() + "- " + diarista1.getNome());

        }
    }

}
