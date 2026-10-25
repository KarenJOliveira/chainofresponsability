import java.util.HashMap;
import java.util.Map;

public class BancoDeDados {
    private final Map<String,String> usuarios;

    public BancoDeDados()
    {
        usuarios = new HashMap<>();
        usuarios.put("admin_username","admin_password");
        usuarios.put("user_username","user_password");
    }

    public boolean usuarioValido(String username)
    {
        return usuarios.containsKey(username);
    }

    public boolean senhaValida(String username, String password)
    {
        return usuarios.get(username).equals(password);
    }
}
