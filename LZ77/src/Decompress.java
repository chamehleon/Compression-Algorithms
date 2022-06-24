public class Decompress {
	String tags;
	String str="";
	public Decompress(String tags) {
		this.tags = tags;
	}
	public char getChar(int j){
		int iOfChar =tags.indexOf(',',tags.indexOf(',',j+1)+1);
		return tags.charAt(iOfChar+1);
		
	}
	public int getLength(int j){
		int iOfLength=tags.indexOf(',',j+1);
				return Integer.parseInt(tags.substring(iOfLength+1,tags.indexOf(',',iOfLength+1)));
	}
	public String createString(){
		for( int i =0;i <tags.length();i++){
			if(tags.charAt(i)=='('){
				if(tags.charAt(i+1)=='0'){
					str=str+getChar(i);
				}
				else{
					int strIndex=Integer.parseInt(tags.substring(i+1,tags.indexOf(',',i+1)));
					int position =str.length()-strIndex;
					for(int j =position;j<position+getLength(i);j++){
						str=str+str.charAt(j);
					}
					if(getChar(i)=='0')continue;
					str=str+getChar(i);
				}
			}
		}
//		for( int i =0; i<str.length();i++){
//			System.out.print(str.charAt(i));
//		}
		return str;
	}
}
