package Q1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringProcessor {

	private static final String ERROR_MESSAGE = "入力文字の読み込みでエラーが発生しました。";

	public static void main(String args[]) {
		List<String> inputString = getInputString();
		for (int i = 0; i < inputString.size(); i++) {
			outPutString(inputString.get(i));
		}

	}

	private static void outPutString(String arg) {
		System.out.println(getAnswer(arg));
	}

	private static List<String> getInputString() {
		int i = 0;
		System.out.print("文字列を入力してください(実行には、*を入力してエンターを押下してください)>");
		try {
			InputStreamReader fp = new InputStreamReader(System.in);
			ArrayList<String> inputString = new ArrayList<String>();
			StringBuffer sb = new StringBuffer();
			boolean endFlag = false;
			while (true) {
				i = fp.read();
				if (i == '\n' && endFlag)
					break;
				
				sb.append(String.valueOf((char) i));
				endFlag=false;

				if (i == '\n') {
					inputString.add(sb.toString());
					sb.delete(0,sb.length()-1);
					endFlag=true;
				}
			}
			fp.close();
			return inputString;
		} catch (IOException err) {
			System.out.println(ERROR_MESSAGE);
			return null;
		}

	}

	private static String getAnswer(String arg) {
		ArrayList<String> usedStrings = new ArrayList<String>();
		for (int i = 0; i < arg.length(); i++) {
			String checkString = String.valueOf(arg.charAt(i));
			if (usedStrings.contains(checkString)) {
				usedStrings.remove(checkString);
			} else {
				usedStrings.add(checkString);
			}
		}
		return String.valueOf(usedStrings.get(0));
	}
}
