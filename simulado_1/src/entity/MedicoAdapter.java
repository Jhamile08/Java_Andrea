package entity;

public class MedicoAdapter {

    private  Medico objMedico;

    public MedicoAdapter(Medico objMedico) {
        this.objMedico = objMedico;
    }

    public Medico getObjMedico() {
        return objMedico;
    }

    public void setObjMedico(Medico objMedico) {
        this.objMedico = objMedico;
    }

    @Override
    public String toString() {
        return objMedico.getName() + " "+objMedico.getSurname();
    }
}
