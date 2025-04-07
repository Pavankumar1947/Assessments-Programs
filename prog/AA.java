package prog;

public class AA {
	public static void main(String[] args) {
		String str="RAJAJINAGAR";
		char []ch=new char[str.length()];
		for (int i = 0; i < ch.length; i++) {
			ch=str.toCharArray();
		}
		for(int i=0;i<ch.length; i++) {
			for (int j = 0; j < ch.length; j++) {
				if(ch[i]==ch[j]) {
					System.out.println(str.replace(ch[j], '$'));
					break;
				}
			}
		}
		System.out.println(str);
	}
}
