package Resort.Services.people;

import Resort.Domain.Reception.ReceptionRepository;
import Resort.Domain.Reception.ReceptionRepositoryImpl;
import Resort.Domain.Register.ReceptionRegister;

import java.util.Set;

public class ReceptionServiceImpl implements ReceptionService {
    private ReceptionServiceImpl service=null;
    private ReceptionRepository repository;

    private Set<ReceptionRegister> receptionRegisters;
    private ReceptionServiceImpl(){
        this.repository= ReceptionRepositoryImpl.getRepository();

    }
    public ReceptionServiceImpl getService(){
        if (service == null) service= new ReceptionServiceImpl();
        return service;
    }

    public Set<ReceptionRegister> getAll() {
        return this.receptionRegisters;
    }


    public ReceptionRegister create(ReceptionRegister ReceptionRegister) {
        return this.repository.create(ReceptionRegister);
    }


    public ReceptionRegister read(String s) {
        ReceptionRegister receptionRegister = findStaff(s);
        return receptionRegister;
    }


    public ReceptionRegister update(ReceptionRegister receptionRegister) {
        ReceptionRegister toDelete=findStaff(receptionRegister.getId());
        if(toDelete!=null){
            this.receptionRegisters.remove(toDelete);
            return create(receptionRegister);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        ReceptionRegister receptionRegister=findStaff(id);
        if(receptionRegister!=null)this.receptionRegisters.remove(receptionRegister);
    }
    private ReceptionRegister findStaff(String id) {
        return this.receptionRegisters.stream()
                .filter(receptionRegister -> receptionRegister.getId().trim().equals(id))
                .findAny()
                .orElse(null);
    }
}
