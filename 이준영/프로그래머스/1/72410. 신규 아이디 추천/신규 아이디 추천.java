class Solution {
    public String solution(String new_id) {
        String id1="",id2="",id3="",id4="",id5="",id6="";
		int len=new_id.length();
		for (int i=0;i<len;i++) {
			char ch=new_id.charAt(i);
			if ('A'<=ch&& ch<='Z') {
				int a= (int) ch;
				a=a+32;
				char new_a= (char) a;
				id1+=new_a;
			} else {
				id1+=new_id.charAt(i);
			}
		}
		len=id1.length();
		for (int i=0;i<len;i++) {
			char ch=id1.charAt(i);
			if (('a'<=ch&&ch<='z')||('0'<=ch&&ch<='9')||ch=='-'||ch=='_'||ch=='.')
				id2+=ch;
		}
		len=id2.length();
		int check=0;
		for (int i=0;i<len;i++) {
			char ch=id2.charAt(i);
			if (ch!='.') {
				check=0;
				id3+=ch;
			} else if (check==0) {
				id3+=ch;
				check=1;
			}
		}
		len=id3.length();
		for (int i=0;i<len;i++) {
			char ch=id3.charAt(i);
			if (ch!='.') {
				id4+=ch;
			} else if (i!=0 && i!=len-1) {
				id4+=ch;
			}
		}
		if (id4.isEmpty()) {
			id5="a";
		} else {
			id5=id4;
		}
		len=id5.length();
		if (len>15)
			len=15;
		for (int i=0;i<len;i++) {
			char ch=id5.charAt(i);
			if (ch=='.' &&i==len-1)
				continue;
			id6+=ch;
		}
		len=id6.length();
		char ch=id6.charAt(len-1);
		while (len<3) {
			id6+=ch;
			len+=1;
		}
		return id6;
    }
}