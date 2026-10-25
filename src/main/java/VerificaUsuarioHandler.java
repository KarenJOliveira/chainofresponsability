public class VerificaUsuarioHandler extends Handler{
    private BancoDeDados bancoDeDados;

    public VerificaUsuarioHandler(BancoDeDados bancoDeDados)
    {
        this.bancoDeDados = bancoDeDados;
    }

    @Override
    public boolean handle(String username, String password) {
        if(!bancoDeDados.usuarioValido(username))
        {
            throw new IllegalArgumentException("Usuário não cadastrado");
        }
        return handleNext(username,password);
    }
}
