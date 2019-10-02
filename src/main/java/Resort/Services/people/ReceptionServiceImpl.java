package Resort.Services.people;

import Resort.Domain.Reception.ReceptionRepository;
import Resort.Domain.Reception.ReceptionRepositoryImpl;
import Resort.Domain.Register.ReceptionRegister;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("ReceptionServiceImpl")
public class ReceptionServiceImpl implements ReceptionService {
    private ReceptionServiceImpl service=null;
    private ReceptionRepository repository;

    private Set<ReceptionRegister> receptionRegisters;
    private ReceptionServiceImpl(){
        repository= ReceptionRepositoryImpl.getRepository();

    }
    public ReceptionServiceImpl getService(){
        if (service == null) service= new ReceptionServiceImpl();
        return service;
    }

    public Set<ReceptionRegister> getAll() {
        return this.receptionRegisters;
    }


    public ReceptionRegister create(ReceptionRegister receptionRegister) {
        return this.repository.create(receptionRegister);
    }


    public ReceptionRegister read(String id) {
        return repository.read(id);
    }


    public ReceptionRegister update(ReceptionRegister receptionRegister) {
        ReceptionRegister toDelete=repository.read(receptionRegister.getId());
        if(toDelete!=null){
            this.repository.delete(toDelete.getId());
        }
        return repository.create(receptionRegister);
    }

    public void delete(String id) {
        ReceptionRegister receptionRegister=repository.read(id);
        if(receptionRegister!=null) {
            repository.delete(receptionRegister.getId());
        }
    }
}
