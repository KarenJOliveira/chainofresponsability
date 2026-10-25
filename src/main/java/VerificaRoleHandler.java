public class VerificaRoleHandler extends Handler{
    @Override
    public boolean handle(String username, String password) {
        if("admin_username".equals(username))
        {
            return true;
        }
        return handleNext(username, password);
    }

    @Override
    public String getTipoPerfil() {
        return "Administrador";
    }
}
