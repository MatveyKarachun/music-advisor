import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] urlAndParams = scanner.nextLine().split("\\?");
        String params = urlAndParams[1];
        String[] paramsAndValuesArr = params.split("&");

        String password = null;
        for (String pv : paramsAndValuesArr) {
            String[] paramAndValue = pv.split("=");
            String param = paramAndValue[0];
            String value = (paramAndValue.length == 2) ? paramAndValue[1] : "not found";
            if ("pass".equals(paramAndValue[0])) {
                password = value;
            }
            System.out.println(param + " : " + value);
        }
        if (password != null) {
            System.out.println("password : " + password);
        }
    }
}