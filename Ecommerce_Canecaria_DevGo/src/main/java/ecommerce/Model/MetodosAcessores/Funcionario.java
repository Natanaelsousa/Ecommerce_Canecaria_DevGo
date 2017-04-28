package ecommerce.Model.MetodosAcessores;

/* @author sibele */
public class Funcionario {

    private Integer cod_funcionario;
    private String nome_funcionario;
    private String cpf_funcionario;
    private String login_funcionario;
    private String senha_funcionario;
    private String departamento_funcionario;

    public String getDepartamento_funcionario() {
        return departamento_funcionario;
    }

    public void setDepartamento_funcionario(String departamento_funcionario) {
        this.departamento_funcionario = departamento_funcionario;
    }
    

    public Integer getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(Integer cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getCpf_funcionario() {
        return cpf_funcionario;
    }

    public void setCpf_funcionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    public String getLogin_funcionario() {
        return login_funcionario;
    }

    public void setLogin_funcionario(String login_funcionario) {
        this.login_funcionario = login_funcionario;
    }

    public String getSenha_funcionario() {
        return senha_funcionario;
    }

    public void setSenha_funcionario(String senha_funcionario) {
        this.senha_funcionario = senha_funcionario;
    }

    public void CadastrarFuncionario(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
