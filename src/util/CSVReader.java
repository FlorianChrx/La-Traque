package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class qui permet la lecture de fichier CSV
 * @author geoffrey
 *
 */
public class CSVReader {
	
	/**
	 * ArrayList correspondant a l'ensemble des informations contenu dans le CSV
	 */
	private ArrayList<String> file;
	private Scanner scanner;
	
	
	/**
	 * Constructeur en passant en paramètre le chemin d'accès du fichier .csv et le delimiteur 
	 * qui correspond au caractère ou suite de caractère qui separe les informations
	 * @param file
	 */
	public CSVReader(String file, String delimiter) {
		this.file = new ArrayList<>();
		try {
			this.scanner = new Scanner(new File(file));
			this.scanner.useDelimiter(delimiter);
			while(this.scanner.hasNextLine())
				this.file.add(this.scanner.nextLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("lol pas toruvé");
		}
	}
	
	/**
	 * Constructeur en passant uniquement le chemin d'accès le delimiteur sera par défaut ";"
	 * @param file
	 */
	public CSVReader(String file) {
		this(file, ";");
	}
	
	/**
	 * toString, délegation du toString de l' ArrayList file
	 */
	@Override
	public String toString() {
		return this.file.toString();
	}
	
	
	/**
	 * Permet d'obtenir une ligne du fichier
	 * @param i le numéro de la ligne que l'on veut obtenir, indice commencent à 0
	 * @return la ligne sous la forme d'un String
	 */
	public String getLine(int i) {
		return this.file.get(i);
	}

	/**
	 * Permet d'obtenir l'ArrayList correspondant au fichier CSV
	 * @return
	 */
	public ArrayList<String> getList() {
		return this.file;
	}
}