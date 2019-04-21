import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException; //Eccezioni per file
import java.io.PrintWriter;		//Classe per l'output su file di testo
//TODO: quando si apre il programma e si inserisce una nuova rete il counter riparte da 0.
public class Controller {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		//Creo 150 spazi possibili per l'inserimento di nuove reti.
		Wifi[] wifi = new Wifi [100];
		
		int menuChoice;
		int counter = 0;
		
		String bssid, pwd;
		
		System.out.println("Programma Gestore Password WiFi\n\nCosa vuoi fare?");
	do {	
		System.out.println("\nCosa vuoi fare?");
		System.out.println("\t1. Aggiungi una nuova rete WiFi conosciuta.");
		System.out.println("\t2. Visualizza reti conosciute.");
		System.out.println("\t0. Esci.");
		menuChoice = scan.nextInt();
		//Inserisco un nextLine per eliminare il carattere '\n' dopo il numero scelto nel menu
		scan.nextLine();
		
		switch (menuChoice) {
		
			case 0:
				System.out.println("Grazie per aver usato questo programma");
			break;
		
			case 1:			
				System.out.println("Inserisco i dati\n");
				System.out.print("Nome WiFi: ");
				bssid = scan.nextLine();
				System.out.print("Password: ");
				pwd = scan.nextLine();
				
				//Inserisci i dati
				wifi[counter] = new Wifi(counter, bssid, pwd);
				
				createFile (counter, bssid, pwd);
				counter += 1;
			break;
		
			case 2:
				System.out.println("Ho salvato queste reti:\n");
				
				openFile();
			break;
			
			default:
				System.out.println("Scelta errata");
			break;	
		}
	} while (menuChoice != 0);
		scan.close();	
	}
	
	
	
	public static void createFile (int counter,String bssid,String pwd) {
		String fileName = "pwd.txt";
		PrintWriter outputStream = null;
		
		try {
			//Crea un nuovo file ma ogni volta sovrascriver il contenuto
			//outputStream = new PrintWriter (fileName);
			
			//Crea un nuovo file solo se non esiste già, altrimenti aggiunge in coda il testo
			outputStream = new PrintWriter (new FileOutputStream (fileName, true));
		}catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file");
			System.exit(0);    //Termina il programma
		}
		//Inserisce nel file i dati e chiude lo chiude
		outputStream.printf("|%-5d| %-25s| %45s|\n", counter , bssid , pwd);
		outputStream.close();
		System.out.println("File scritto correttamente");
	}
	
	
	
	public static void openFile () {
		String fileName = "pwd.txt";
		Scanner inputStream = null;
		
		try {
			inputStream =  new Scanner (new File(fileName));	
		}catch (FileNotFoundException e) {
			System.out.println("Errore nell'apertura del file");
			System.exit(0);    //Termina il programma
		}
		//Legge i dati presenti nel file
		while(inputStream.hasNextLine()) {
		String riga = inputStream.nextLine();
		System.out.println(riga);
		}
	}
	
	
	
	
	
}
