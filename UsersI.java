package GerenciadorDeProjetos.ProjetoOO;

public interface UsersI {
    public int getID();
    public String getEmail();
    public String getPassword();
    public String getName();
    public StatusUser getStatusUser();
    public String printUserInfo();


    public void setID();
    public void setEmail();
    public void setPassword();
    public void setName();
    public void setStatusUser();
}
