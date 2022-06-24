import java.util.ArrayList;
public class Compress {
	ArrayList <String> dict;
	String tags="";
	String s;
	public Compress(String s) {
		dict = new ArrayList <String>();
		dict.add(" ");
		this.s = s;
	}
	public String createTags(){
	for(int i =0; i<s.length();i++){
			String str=String.valueOf((s.charAt(i)));
			i++;
			while(i<s.length()&&dict.indexOf(str)!=-1){
				str=str+s.charAt(i);
				i++;
			}
			if(str.length()==1)tags=tags+"("+"0"+","+s.charAt(i-1)+")";
			else tags= tags+"("+dict.indexOf(str.substring(0,str.length()-1))+","+s.charAt(i-1)+")";
			i--;
			if(dict.indexOf(str)!=-1) continue;
			dict.add(str);
	}
//	for( int i =0;i<tags.length();i++){
//		System.out.print(tags.charAt(i));
//	}
	return tags;
	}
	
}
