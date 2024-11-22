import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class JsonAnalyzer {

    public static JSONObject readJsonFile(String filePath) {
        JSONObject jsonObject = null;
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
            jsonObject = new JSONObject(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static String extractInformation(JSONObject jsonObject, String route) {
        String result = "";
        switch (route) {
            case "Tienda":
                result = jsonObject.getJSONObject("Tienda").toString();
                break;
            case "Productos":
                result = jsonObject.getJSONArray("Productos").toString();
                break;
            case "Usuarios":
                result = jsonObject.getJSONArray("Usuarios").toString();
                break;
            case "Pedidos":
                result = jsonObject.getJSONArray("Pedidos").toString();
                break;
            default:
                result = "Ruta inválida";
        }
        return result;
    }

    public static void main(String[] args) {
        JSONObject jsonObject = readJsonFile("C:/Users/ivisd/Desktop/Diseño Web/JsonPrimaDona.json");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una ruta: ");
        String route = scanner.nextLine();
        String result = extractInformation(jsonObject, route);
        System.out.println("Información solicitada: " + result);
    }
}