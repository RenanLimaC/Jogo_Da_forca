import java.util.*;

public class JogoDaForca {

    static ArrayList lista = new ArrayList<String>();
    static Scanner scanner = new Scanner(System.in);
    static Integer estado = 0;

    public static void main(String[] args) {
        System.out.println("BEM VINDO AO JOGO DA FORCA! \n");
        palavrasIniciais();
        estadoInicial();

    }

    private static void estadoInicial() {
        while (estado != -2) {
            switch (estado) {
                case 0:
                    imprimeMenu();
                    break;
                case 1:
                    imprimeMenuPalavras();
                    break;
                case 2:
                    jogar();
                    break;
                case 3:
                    System.out.println("SAINDO... ATÉ LOGO.");
                    estado = -2;
                    break;
                default:
                    System.out.println("VALOR INCORRETO, DIGITE NOVAMENTE.");
                    estado = 0;
            }
        }
    }

    private static void palavrasIniciais() {
        List<String> palavras = Arrays.asList("gato", "rato", "papel", "boneco", "copo", "controle", "prato", "maquina", "mascara", "garrafa", "banheiro");
        lista.addAll(palavras);
    }


    public static void imprimeMenu() {
        System.out.println("MENU \n" +
                "1 - PALAVRAS \n" +
                "2 - JOGAR \n" +
                "3 - SAIR");
        selecaoMenu();


    }

    private static Integer selecaoMenu() {
        System.out.println("SELECIONE UMA DAS OPÇÕES");

        while (true) {
            try {
                return estado = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("VALOR INCORRETO, DIGITE NOVAMENTE");
                scanner.nextLine();
            }
        }
    }


    private static void jogar() {
        //List<String> palavra = Arrays.asList(sortearPalavra());
        int tentativas = 0;
        int acertos = 0;
        String palavra = sortearPalavra();
        List<String> letras = new ArrayList<>();
        List<String> letrasOcultas = new ArrayList<>();
        // System.out.println(palavra);
        for (int i = 0; i < palavra.length(); i++) {
            letras.add(String.valueOf(palavra.charAt(i)).toUpperCase());
            letrasOcultas.add("_");
        }
        while (tentativas < 6 && acertos < letras.size()) {
            System.out.println("DIGITE UMA LETRA.");
            String letraDigitada = scanner.next().toUpperCase();
            boolean acertou = false;
            for (int i = 0; i < letras.size(); i++) {
                if (letras.get(i).equalsIgnoreCase(letraDigitada)) {
                    letrasOcultas.set(i, letraDigitada);
                    acertos++;
                    acertou = true;
                }
            }
            if (!acertou){
                System.out.println("NÃO TEM ESSA LETRA. SUAS TENTATIVAS SÃO: " + (tentativas + 1) + "/6");
                tentativas++;
            }
            System.out.println(letrasOcultas);
        }if (acertos == letras.size()){
            System.out.println("PARABENS VOCÊ GANHOU ! !");
        }else if (tentativas == 6){
            System.out.println("VOCÊ É BURRO E PERDEU ! =(");
        }


        estado = 0;
    }
    // PEDIR PARA USUARIO DIGITAR UMA LETRA ENQUANTO TENTATIVAS < 6 || ACERTOS == LETRAS.SIZE;
    // FOR EACH COM IF, PARA VERIFICAR SE TEM A LETRA DIFITADA NA LISTA "LETRAS".
    //letrasOcultas.set(3, "g");

//        System.out.println("");
//        System.out.println(letrasOcultas);
//        System.out.println(letras);
//        System.out.println("");


    private static String sortearPalavra() {
        Random gerador = new Random();
        Integer sortear = gerador.nextInt(lista.size());
        String palavraSorteada = (String) lista.get(sortear);
        return palavraSorteada;
    }

    public static void imprimeMenuPalavras() {
        System.out.println("MENU DE PALAVRAS \n" +
                "1 - ADICIONAR PALAVRA \n" +
                "2 - REMOVER PALAVRA \n" +
                "3 - VISUALIZAR PALAVRAS \n" +
                "4 - VOLTAR PARA O MENU ANTERIOR");
        selecaoMenu();
        while (estado != -1) {
            switch (estado) {
                case 0:
                    imprimeMenuPalavras();
                    break;
                case 1:
                    adicionarPalavra();
                    break;
                case 2:
                    removerPalavra();
                    break;
                case 3:
                    visualizarPalavras();
                    break;
                case 4:
                    estado = -1;
                    break;
                default:
                    System.out.println("VALOR INVÁLIDO, DIGITE NOVAMENTE");
                    estado = 0;
            }
        }


    }

    private static void visualizarPalavras() {
        System.out.println("AS PALAVRAS DISPONIVEIS NO MOMENTO SÃO: \n" + lista);
        estado = 0;
    }

    private static void removerPalavra() {
        System.out.println("QUAL PALAVRA DESEJA REMOVER?");
        String palavra = scanner.next();
        if (lista.contains(palavra)) {
            lista.remove(palavra);
            System.out.println("A PALAVRA " + palavra.toUpperCase() + "  FOI REMOVIDA");
        } else {
            System.out.println("PALAVRA NÃO ENCONTRADA, A PALAVRA TEM QUE SER ALGUMAS DAS SEGUINTES: \n" + lista);
            removerPalavra();
        }
        estado = 0;
    }

    private static void adicionarPalavra() {
        System.out.println("DIGITE A PALAVRA PARA SER ADICIONADA.");
        String palavra = scanner.next();
        lista.add(palavra);
        System.out.println("A PALAVRA " + palavra.toUpperCase() + " ADICIONADA!");
        estado = 0;
    }

}

