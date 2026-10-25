import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {
    AuthService authService;

    @BeforeEach
    void setUp()
    {
        BancoDeDados bancoDeDados = new BancoDeDados();
        Handler handler = new VerificaUsuarioHandler(bancoDeDados);
        handler.setNextHandler(new VerificaSenhaHandler(bancoDeDados)).setNextHandler(new VerificaRoleHandler());
        authService = new AuthService(handler);
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoCadastrado()
    {
        try {
            boolean login = authService.logIn("gerente_username","gerente_password");
        } catch (Exception e) {

        }
    }

    @Test
    void deveRetornarExcecaoSenhaInvalida()
    {
        try {
            boolean login = authService.logIn("user_username","password");
        } catch (Exception e) {
            assertEquals("Senha inválida",e.getMessage());
        }
    }

    @Test
    void deveRetornarVerdadeiroLogIn()
    {
        assertTrue(authService.logIn("user_username","user_password"));
    }
}
