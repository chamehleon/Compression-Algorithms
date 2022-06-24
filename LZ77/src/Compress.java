import java.util.ArrayList;
public class Compress {
	ArrayList <String> match;
	ArrayList <Integer> pos;
	int searchBuffer;
	String tags;  
	String s;
	public Compress(String s ) {
		this.s = s;
		match=new ArrayList<String>();
		tags ="";
		pos =new ArrayList<Integer>();
	}
	public String findBestMatch(ArrayList<String>match){
		int len =0;
		int index=0;
		for(int i=match.size()-1;i>=0;i--){
			if(match.get(i).length()>=len){
				index=i;
				len=match.get(i).length();
			}
		}
		//String bestMatch = match.get(index)+'.'+Integer.toString(index);
		String bestMatch=match.get(index);
		return bestMatch;
	}
	public String CreateTags(){
			for( int i=0;i <s.length();i++){
				searchBuffer=(int) Math.ceil((s.length()/2));
				match.clear();
				pos.clear();
				for( int j =i-1;searchBuffer>0&&j>=0;j--,searchBuffer--){
					if(s.charAt(i)==s.charAt(j)){
						String str="";
						str=str+s.charAt(j);
						int k=i+1,m=j+1;
						while(k<s.length()&&m<s.length()&&s.charAt(k)==s.charAt(m)){
							str=str+s.charAt(m);
							k++;m++;
						}	
						pos.add(i-j);
						match.add(str);
					}
				}
				if (match.isEmpty()) {
					String none ="(0,0,"+s.charAt(i)+")";
					tags=tags+none;
					continue;
				}
				String bestMatch=findBestMatch(match);
				//int index=Integer.parseInt(bestMatch.substring(bestMatch.indexOf('.')+1,(bestMatch.length())));
				int index =match.indexOf(bestMatch);
				i=i+bestMatch.length();
				if(i>=s.length()){
					tags=tags+"("+pos.get(index)+","+bestMatch.length()+","+"0"+")";
				}
				else tags=tags+"("+pos.get(index)+","+bestMatch.length()+","+s.charAt(i)+")";
			}
//			for( int i =0; i<tags.length();i++){
//				System.out.print(tags.charAt(i));
//			}
		return tags;
	}
}