package api.fElcontabilidade.exceptions;

public class CellphoneNotFoundException extends ModelNotFoundException{
    public CellphoneNotFoundException(){
        super("Telefone não encontrado...");
    }
    public CellphoneNotFoundException(String message){
        super(message);
    }
}
