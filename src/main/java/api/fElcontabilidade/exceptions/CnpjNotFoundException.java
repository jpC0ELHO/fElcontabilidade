package api.fElcontabilidade.exceptions;

public class CnpjNotFoundException extends ModelNotFoundException{
    public CnpjNotFoundException(){
        super("CNPJ não encontrado!");
    }
    public CnpjNotFoundException(String message){
        super(message);
    }
}
