import java.util.Scanner;


public class LZZ8 {

	public static void main(String[] args) {
		String s;
		Scanner sc = new Scanner(System.in);
		s=sc.nextLine();
		Compress c = new Compress(s);
		String compressed = c.createTags();
		System.out.print("compressed String: "+compressed+"\n");	
		Decompress d = new Decompress(compressed);
		String decompressed = d.createString();
		System.out.print("decompressed String: "+decompressed+"\n");	
	}
}
