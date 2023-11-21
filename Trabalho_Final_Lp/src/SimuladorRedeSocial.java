import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.sql.*;

class Usuario {
    private String nome;
    private String email;
    private String senha;
    private List<Usuario> amigos;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.amigos = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    // Método para adicionar um amigo
    public void adicionarAmigo(Usuario amigo) {
        amigos.add(amigo);
    }

    // Método para remover um amigo
    public void removerAmigo(Usuario amigo) {
        amigos.remove(amigo);
    }

    public Object getSenha() {
        return null;
    }
}

public class SimuladorRedeSocial {
    private Map<String, Usuario> usuarios;
    private Usuario usuarioAtual;
    private Scanner scanner;
    private Connection connection;

    public SimuladorRedeSocial() {
        this.usuarios = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.connection = criarConexao();
    }

    // Método para criar uma conexão com o banco de dados SQLite
    private Connection criarConexao() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:minisocial.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados.");
        }
    }

    // Método para cadastrar um novo usuário
    public void cadastrarUsuario() {
        System.out.println("Cadastro de Usuário:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuarios.put(email, novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");

        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)")) {
            statement.setString(1, nome);
            statement.setString(2, email);
            statement.setString(3, senha);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar usuário.");
        }

    }

    // Método para fazer login
    public void fazerLogin() {
        System.out.println("Login:");
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = usuarios.get(email);
        if (usuario != null && usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
            usuarioAtual = usuario;
            System.out.println("Login bem-sucedido. Bem-vindo, " + usuarioAtual.getNome() + "!");
        } else {
            System.out.println("E-mail ou senha incorretos. Tente novamente.");

            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM usuarios WHERE email = ? AND senha = ?")) {
                statement.setString(1, email);
                statement.setString(2, senha);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    usuarioAtual = new Usuario(
                            resultSet.getString("nome"),
                            resultSet.getString("email"),
                            resultSet.getString("senha")
                    );
                    System.out.println("Login bem-sucedido. Bem-vindo, " + usuarioAtual.getNome() + "!");
                } else {
                    System.out.println("E-mail ou senha incorretos. Tente novamente.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erro ao fazer login.");
            }
        }
    }


    // Método para fazer logout
    public void fazerLogout() {
        usuarioAtual = null;
        System.out.println("Logout realizado com sucesso.");
    }

    // Método para mostrar amigos
    public void consultarAmigos() {
        if (usuarioAtual != null) {
            List<Usuario> amigos = usuarioAtual.getAmigos();
            if (!amigos.isEmpty()) {
                System.out.println("Amigos de " + usuarioAtual.getNome() + ":");
                for (Usuario amigo : amigos) {
                    System.out.println("- " + amigo.getNome());
                }
            } else {
                System.out.println("Você ainda não tem amigos.");
            }
        } else {
            System.out.println("Faça login antes de consultar amigos.");
        }
    }

    // Método para adicionar amigo
    public void incluirAmigo() {
        if (usuarioAtual != null) {
            System.out.print("E-mail do amigo: ");
            String emailAmigo = scanner.nextLine();
            Usuario amigo = usuarios.get(emailAmigo);
            if (amigo != null) {
                usuarioAtual.adicionarAmigo(amigo);
                System.out.println(amigo.getNome() + " adicionado como amigo.");
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } else {
            System.out.println("Faça login antes de adicionar amigos.");
        }
    }

    // Método para remover amigo
    public void excluirAmigo() {
        if (usuarioAtual != null) {
            System.out.print("E-mail do amigo a ser removido: ");
            String emailAmigo = scanner.nextLine();
            Usuario amigo = usuarios.get(emailAmigo);
            if (amigo != null && usuarioAtual.getAmigos().contains(amigo)) {
                usuarioAtual.removerAmigo(amigo);
                System.out.println(amigo.getNome() + " removido da lista de amigos.");
            } else {
                System.out.println("Amigo não encontrado.");
            }
        } else {
            System.out.println("Faça login antes de remover amigos.");
        }
    }

    public void exibirMenuPrincipal() {
        System.out.println("\n--- Mini Simulador de Rede Social ---");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Fazer Login");
        System.out.println("3. Fazer Logout");
        System.out.println("4. Consultar Amigos");
        System.out.println("5. Incluir Amigo");
        System.out.println("6. Excluir Amigo");
        System.out.println("0. Sair");
    }

    public void exibirMensagemBemVindo() {
        if (usuarioAtual != null) {
            System.out.println("Bem-vindo, " + usuarioAtual.getNome() + "!");
        }
    }

    // ... (sem alterações nas demais funções)

    public static void main(String[] args) {
        SimuladorRedeSocial simulador = new SimuladorRedeSocial();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            simulador.exibirMenuPrincipal();
            simulador.exibirMensagemBemVindo();
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            switch (opcao) {
                case 1:
                    simulador.cadastrarUsuario();
                    break;
                case 2:
                    simulador.fazerLogin();
                    break;
                case 3:
                    simulador.fazerLogout();
                    break;
                case 4:
                    simulador.consultarAmigos();
                    break;
                case 5:
                    simulador.incluirAmigo();
                    break;
                case 6:
                    simulador.excluirAmigo();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
    private void inicializarBancoDeDados() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS usuarios ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "nome TEXT NOT NULL,"
                    + "email TEXT UNIQUE NOT NULL,"
                    + "senha TEXT NOT NULL)");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inicializar o banco de dados.");
        }
    }
}