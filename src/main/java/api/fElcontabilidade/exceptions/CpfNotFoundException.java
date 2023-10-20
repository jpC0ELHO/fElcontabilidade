package api.fElcontabilidade.exceptions;

public class CpfNotFoundException extends ModelNotFoundException{
    public CpfNotFoundException(){
        super("CPF nao encontrado...");
    }
    public CpfNotFoundException(String message){
        super(message);
    }
}
