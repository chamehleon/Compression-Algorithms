import java.util.Scanner;
public class lz77 {
	public static void main(String args[]){ 
		String input;
		Scanner scanner = new Scanner(System.in);
		input=scanner.nextLine();
		Compress c = new Compress(input);
		String tags=c.CreateTags();
		System.out.print("compressed string\n" +tags+"\n");
		Decompress d = new Decompress(tags);
		String str = d.createString();
		System.out.print("decompressed string \n"+str);
	}
}
