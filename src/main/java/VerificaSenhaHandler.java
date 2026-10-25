public class VerificaSenhaHandler extends Handler{
    private BancoDeDados bancoDeDados;

    public VerificaSenhaHandler(BancoDeDados bancoDeDados)
    {
        this.bancoDeDados = bancoDeDados;
    }

    @Override
    public boolean handle(String username, String password) {
        if(!bancoDeDados.senhaValida(username,password))
        {
            throw new IllegalArgumentException("Senha inválida");
        }
        return handleNext(username, password);
    }
}
