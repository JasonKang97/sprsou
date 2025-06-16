package pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import java.util.Base64;

@WebServlet(loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            // 비밀 키 생성
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();

            // Base64 인코딩
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("encodedKey : " + encodedKey);

            // 서블릿 컨텍스트에 저장
            getServletContext().setAttribute("secretKey", encodedKey);
        } catch (Exception e) {
            throw new ServletException("키 생성 오류", e);
        }
    }
}
