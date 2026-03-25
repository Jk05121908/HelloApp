public class HelloApp {
    public static void main(String[] args) {

        String result;

        if (args.length == 0) {
            result = "World";
        } else {
            StringBuilder sb = new StringBuilder();

            for (String name : args) {
                sb.append(name).append(", ");
            }

            // remove last ", "
            if (sb.length() > 0) {
                result = sb.substring(0, sb.length() - 2);
            } else {
                result = "";
            }
        }

        System.out.println("Hello, " + result + "!");
    }
}