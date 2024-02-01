import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CorsFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Expose-Headers", "Location");
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}
    /***這段程式碼是一個Java Servlet的過濾器（Filter），用於處理CORS（跨來源資源共用）問題。
     * CORS是一種安全機制，用於瀏覽器中避免跨來源HTTP請求（例如從不同網域、協議或端口的請求）的安全風險。
    這個過濾器的主要功能是在每個HTTP請求上添加CORS標頭，以允許跨來源的HTTP請求。具體來說，它設置了以下標頭：

    Access-Control-Allow-Origin：允許跨來源訪問的來源，通常設置為"*"表示允許來自任何來源的訪問。
    Access-Control-Allow-Methods：允許的HTTP方法，包括GET、POST、PUT、DELETE和OPTIONS。
    Access-Control-Allow-Headers：允許的HTTP標頭，這裡包括Content-Type和Authorization。
    Access-Control-Expose-Headers：暴露給客戶端的自定義標頭，這裡設置了Location標頭。
    這樣配置的過濾器可以讓瀏覽器在發送跨來源的HTTP請求時不被阻擋，從而實現跨來源資源共用。這在開發基於Web的應用程序時非常有用，
    尤其是當前端代碼和後端服務位於不同的域名或端口時。**/

}

