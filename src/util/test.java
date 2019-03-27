package util;

public class test {
	public static void main(String[] args) {
		CSVReader reader = new CSVReader("fichier.csv");
		System.out.println(reader.getLine(1));
	}
}
