import java.util.ArrayList;


public class Decompress {
	ArrayList <String> dict;
	String tags;
	String str="";
	public Decompress(String tags) {
		super();
		dict = new ArrayList<String>();
		dict.add("");
		this.tags = tags;
	}
	public String createString(){
		for( int i =0;i <tags.length();i++){
			if(tags.charAt(i)=='('){
				if(tags.charAt(i+1)=='0'){
					str=str+tags.substring(tags.indexOf(',',i+1)+1,tags.indexOf(')',i+1));
					dict.add(tags.substring(tags.indexOf(',',i+1)+1,tags.indexOf(')',i+1)));
				}
				else{
					int index=Integer.parseInt(tags.substring(i+1,tags.indexOf(',',i+1)));
					String c =tags.substring(tags.indexOf(',',i+1)+1,tags.indexOf(')',i+1));
					str= str+dict.get(index)+c;
					dict.add(dict.get(index)+c);
				}
			}
		}
//		for( int i =0;i<str.length();i++){
//			System.out.print(str.charAt(i));
//		}
		return str;
	}

}
