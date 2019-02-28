package cn.edu.tju.base.util;

import java.io.FileWriter;
import java.io.IOException;


public class Unicode {
	
	public static void main(String[] args) throws IOException {
		System.out.println(isChinese('中'));
		System.out.println(chinaToUnicode("中 国"));
		System.out.println(Unicode2Chn(chinaToUnicode("中  国")));
//		String name = "21wsws\u4e2d\u56fd";
//		String t = "\u4e2d\u56fd";
//		StringReader sr = new StringReader(name);
		
//		String sql = " where kj.id like '%"+t+"%'";
//		System.out.println("sql - " + sql);
//		FileWriter fw = new FileWriter("d:/temp.txt");
//		fw.write(name);
//		fw.close();
	}
	
	/**  
     * 把中文转成Unicode码  
     * @param str  
     * @return  
     */  
	public static String chinaToUnicode(String str){   
        String result="";   
        for (int i = 0; i < str.length(); i++){   
            int chr1 = (char) str.charAt(i);   
//            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)   
                result+="\\u" + Integer.toHexString(chr1);   
//            }else{   
//                result+=str.charAt(i);   
//            }   
        }   
        return result;   
    }   

	
	/**  
     * 判断是否为中文字符  
     * @param c  
     * @return  
     */  
    public static boolean isChinese(char c) {   
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);   
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS   
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS   
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A   
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION   
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION   
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {   
            return true;   
        }   
        return false;   
    }  
    
    /**
    * 编码从GBK转换成Unicode
    * @param str
    * @return
    */
    public static String Gbk2Unicode(String str) {
		StringBuffer buffer = new StringBuffer();
		String splitString = "";
		for (int i = 0; i < str.length(); i++) {
			buffer.append(splitString);
			buffer.append(Integer.toHexString(str.charAt(i)));
			splitString = ",";
		}
		return buffer.toString();
	}

    /**
	 * 编码从Unicode转换成GBK
	 * 
	 * @param str
	 * @return
	 */
    public static String Unicode2Gbk(String str) {
		StringBuffer buffer = new StringBuffer();
		String[] arr = str.split(",");
		for (int i = 0; i < arr.length; i++) {
			buffer.append((char) Integer.parseInt(arr[i], 16));
		}
		return buffer.toString();
	}
    
public static String Unicode2Chn(String str) {
    	
    	/** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        String[] strs = str.split("\\\\u");
        String returnStr = "";
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strs.length; i++) {
          returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
        }
        return returnStr;
    	
	}
    
    
}
