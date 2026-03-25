public class HelloApp {
    public static void main(String[] args) {

        String result;

        if (args.length == 0) {
            result = "World";
        } else {
            StringBuilder sb = new StringBuilder();

            for (String name : args) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(name);
            }

            result = sb.toString();
        }

        System.out.println("Hello, " + result + "!");
    }
}