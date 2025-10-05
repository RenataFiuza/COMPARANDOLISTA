import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

class Aluno implements Comparable<Aluno> {
    String nome;
    String matricula;
    String dataNascimento;

    Aluno(String nome, String matricula, String dataNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }

    public int compareTo(Aluno o) {
        return nome.compareTo(o.nome);
    }
}

public class ComparandoListas {
    private static final int QUANT = 350_000;
    private static final String[] nomes = {"Ana","João","Carlos","Maria","Pedro","Juliana","Lucas","Fernanda"};
    private static final String[] sobrenomes = {"Silva","Souza","Oliveira","Costa","Pereira","Rodrigues","Almeida","Ferreira"};
    private static final Random rnd = new Random();

    private static String geraNome() {
        String n = nomes[rnd.nextInt(nomes.length)];
        String s = sobrenomes[rnd.nextInt(sobrenomes.length)];
        return n + " " + s;
    }

    private static String geraMatricula() {
        int v = rnd.nextInt(100000);
        return String.format("%05d", v);
    }

    private static String geraData() {
        int ano = 1990 + rnd.nextInt(21);
        int mes = 1 + rnd.nextInt(12);
        int dia;
        switch (mes) {
            case 2:
                dia = 1 + rnd.nextInt(28);
                break;
            case 4: case 6: case 9: case 11:
                dia = 1 + rnd.nextInt(30);
                break;
            default:
                dia = 1 + rnd.nextInt(31);
        }
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    private static long cadastrar(List<Aluno> list) {
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < QUANT; i++) {
            list.add(new Aluno(geraNome(), geraMatricula(), geraData()));
        }
        long t1 = System.currentTimeMillis();
        return t1 - t0;
    }

    private static long ordenar(List<Aluno> list) {
        long t0 = System.currentTimeMillis();
        Collections.sort(list);
        long t1 = System.currentTimeMillis();
        return t1 - t0;
    }

    private static long exportarCsv(List<Aluno> list, String arquivo) throws IOException {
        long t0 = System.currentTimeMillis();
        try (BufferedWriter w = new BufferedWriter(new FileWriter(arquivo))) {
            w.write("Nome,Matrícula,Data de Nascimento
");
            for (Aluno a : list) {
                w.write(String.format("%s,%s,%s
", a.nome, a.matricula, a.dataNascimento));
            }
        }
        long t1 = System.currentTimeMillis();
        return t1 - t0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando geração de listas com " + QUANT + " alunos cada...");

        List<Aluno> arrayList = new ArrayList<>(QUANT);
        List<Aluno> linkedList = new LinkedList<>();
        List<Aluno> vector = new Vector<>(QUANT);

        long tCadastroArray = cadastrar(arrayList);
        System.gc();
        long tCadastroLinked = cadastrar(linkedList);
        System.gc();
        long tCadastroVector = cadastrar(vector);
        System.gc();

        long tOrdenarArray = ordenar(arrayList);
        System.gc();
        long tOrdenarLinked = ordenar(linkedList);
        System.gc();
        long tOrdenarVector = ordenar(vector);
        System.gc();

        long tExportArray = exportarCsv(arrayList, "alunos_arraylist.csv");
        long tExportLinked = exportarCsv(linkedList, "alunos_linkedlist.csv");
        long tExportVector = exportarCsv(vector, "alunos_vector.csv");

        String tabela = String.format(
            "\nOperação\tArrayList (ms)\tLinkedList (ms)\tVector (ms)\n" +
            "Cadastro\t%d\t%d\t%d\n" +
            "Ordenação\t%d\t%d\t%d\n" +
            "Exportação\t%d\t%d\t%d\n",
            tCadastroArray, tCadastroLinked, tCadastroVector,
            tOrdenarArray, tOrdenarLinked, tOrdenarVector,
            tExportArray, tExportLinked, tExportVector
        );

        System.out.println(tabela);
    }
}