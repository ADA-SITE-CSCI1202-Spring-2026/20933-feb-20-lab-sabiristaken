public class StringReverser {

    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String original = "Hello World";
        
        String result = reverseString(original);

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + result);
    }
}
