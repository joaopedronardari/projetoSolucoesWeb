import repository.LoginRepository;
import controller.SessionUtils;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean
@SessionScoped
public class Login implements Serializable {

    
	private static final long serialVersionUID = 1094801825228386363L;
	
	private String pwd;
	private String msg;
	private String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	//validate login
	public String validateUsernamePassword() {
		Long userId = LoginRepository.validate(user, pwd);
                
		if (userId > -1) {
                        System.out.println(userId);
			SessionUtils.setParam("username", user);
                        SessionUtils.setParam("userid", userId);
			return "index.xhtml?faces-redirect=true";
		} else {
			return "login.xhtml?faces-redirect=true&alert=loginfail";
		}
	}

	//logout event, invalidate session
	public String logout() {
		SessionUtils.invalidate();
		return "/login.xhtml";
	}
        
        public String displayLogout;
        public String displayLogin;

        public String getDisplayLogout() {
            return displayLogout;
        }

        public void setDisplayLogout(String displayLogout) {
            this.displayLogout = displayLogout;
        }

        public String getDisplayLogin() {
            return displayLogin;
        }

        public void setDisplayLogin(String displayLogin) {
            this.displayLogin = displayLogin;
        }
        
        public void onPreRender() {
            displayLogout = SessionUtils.getParam("username") != null ? "" : "none";
            displayLogin = SessionUtils.getParam("username") != null ? "none" : "";
            if (SessionUtils.getParam("username") != null) {
                user = (String) SessionUtils.getParam("username");
            }
        }

        
}