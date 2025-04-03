package cognizant;

public class RemoveIntegers {
	public static void main(String[] args) {
		String input = "Hon1ey3we7l8l";
		String result = input.replaceAll("\\d", "");  // Remove digits (0-9)
		System.out.println(result);
		
		
		//or Using String Builder
		StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());

	}

}
