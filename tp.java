import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);

System.out.print("Quantidade de partições: ");
int nump = in.nextInt();
int[] parti = new int[nump];

System.out.println("Tamanho das partições: ");
for (int i = 0; i < nump; i++) {
System.out.print("Partição " + (i + 1) + ": ");
parti[i] = in.nextInt();
}

System.out.print("Quantidade de processos: ");
int numpr = in.nextInt();
int[] processos = new int[numpr];

System.out.println("Tamanho dos processos: ");
for (int i = 0; i < numpr; i++) {
System.out.print("Processo " + (i + 1) + ": ");
processos[i] = in.nextInt();
}

System.out.print("Escolha o algoritmo de alocação (1: First-fit, 2: Best-fit, 3: Worst-fit): ");
int op = in.nextInt();

switch (op) {
case 1:
firstFit(parti, processos);
break;
case 2:
bestFit(parti, processos);
break;
case 3:
worstFit(parti, processos);
break;
default:
System.out.println("Opção inválida.");
break;
}

System.out.println("Estado final dos processos: ");
for (int i = 0; i < numpr; i++) {
System.out.println("Processo" + (i + 1) + ": " + processos[i]);
}
}

/**
* Algoritmo de alocação First-fit.
* @param partitions Array com os tamanhos das partições.
* @param processes Array com os tamanhos dos processos.
*/
public static void firstFit(int[] parti, int[] processos) {
for (int i = 0; i < parti.length; i++) {
for (int j = 0; j < processos.length; j++) {
if (processos[j] > parti[i]) {
processos[j]=parti[i];
break;
}
}
}
}

/**
* Algoritmo de alocação Best-fit.
* @param partitions Array com os tamanhos das partições.
* @param processes Array com os tamanhos dos processos.
*/
public static void bestFit(int[] parti, int[] processos) {
for (int i = 0; i < processos.length; i++) {
int bestFitIndex = -1;
int bestFitDifference = Integer.MAX_VALUE;

for (int j = 0; j < parti.length; j++) {
int diferença = processos [i]-parti[j];
if (processos[i] >= parti[j] && diferença<=parti[j]) {
bestFitIndex = j;
processos[i]=parti[j];
}
}
}


}


/**
* Algoritmo de alocação Worst-fit.
* @param parti Array com os tamanhos das partições.
* @param processos Array com os tamanhos dos processos.
*/
public static void worstFit(int[] parti, int[] processos) {
for (int i = 0; i < processos.length; i++) {
int worstFitIndex = -1;
int worstFitDifference = Integer.MIN_VALUE;

for (int j = 0; j < parti.length; j++) {
int diferença = processos [i]-parti[j];
if (processos[i] > parti[j] && diferença>=parti[j]) {
worstFitIndex = j;
processos[i]=parti[j];
}
}


}
}
}