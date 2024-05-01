import java.io.*;

class TinyEdit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, System.console().charset()));

        String[] strs = new String[100];

        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to quit.");


        for (int i = 0; i < 100; i++) {
            String str = br.readLine();

            strs[i] = str;

            if (str.equals("stop")) break;
        }

        for (int i = 0; i < 100; i++) {
            String str = strs[i];

            if (str.equals("stop")) break;
            System.out.println(str);
        }
    }
}