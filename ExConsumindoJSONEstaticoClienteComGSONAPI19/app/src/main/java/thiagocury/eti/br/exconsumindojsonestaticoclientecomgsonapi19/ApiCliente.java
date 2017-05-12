package thiagocury.eti.br.exconsumindojsonestaticoclientecomgsonapi19;

/**
 * Created by thiagocury on 10/05/17.
 */

public class ApiCliente {

    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    class Cliente{

        private int id;
        private String nome;
        private String RG;
        private String email;

        public Cliente() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getRG() {
            return RG;
        }

        public void setRG(String RG) {
            this.RG = RG;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Cliente{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", RG=" + RG +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}