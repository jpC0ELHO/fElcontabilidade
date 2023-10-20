package api.fElcontabilidade.exceptions;

public class EnderecoNotFoundException extends ModelNotFoundException{
    public EnderecoNotFoundException(){
        super("Endereco não encontrado!");
    }
    public EnderecoNotFoundException(String message){
        super(message);
    }
}
