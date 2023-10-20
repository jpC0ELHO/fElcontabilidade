package api.fElcontabilidade.exceptions;

public class ClienteNotFoundException extends ModelNotFoundException{
    public ClienteNotFoundException(){
        super("Cliente não encontrado");
    }
    public ClienteNotFoundException(String message){
        super(message);
    }
}
