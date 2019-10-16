package Resort.Services.people;

import Resort.Domain.Reception.ReceptionRepository;
import Resort.Domain.Register.Reception.ReceptionRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class ReceptionServiceImpl implements ReceptionService {
    private ReceptionServiceImpl service=null;
    @Autowired
    private ReceptionRepository repository;

    private Set<ReceptionRegister> receptionRegisters;
    private ReceptionServiceImpl(){

    }
    public ReceptionServiceImpl getService(){
        if (service == null) service= new ReceptionServiceImpl();
        return service;
    }

    public Set<ReceptionRegister> getAll() {
        return this.receptionRegisters;
    }


    public ReceptionRegister create(ReceptionRegister receptionRegister) {
        return this.repository.save(receptionRegister);
    }


    public ReceptionRegister read(String id) {
        Optional<ReceptionRegister> optionalReceptionRegister = repository.findById(id);
        return optionalReceptionRegister.orElse(null);
    }


    public ReceptionRegister update(ReceptionRegister receptionRegister) {
       return repository.save(receptionRegister);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
