package Resort.Services.people;

import Resort.Domain.Maintenance.MaintenanceRepository;
import Resort.Domain.Register.Maintenance.MaintenanceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    private MaintenanceServiceImpl service=null;
    @Autowired
    private MaintenanceRepository repository;

    private Set<MaintenanceRegister> maintenanceRegisters;
    private MaintenanceServiceImpl(){

    }
    public MaintenanceServiceImpl getService(){
        if (service == null) service= new MaintenanceServiceImpl();
        return service;
    }

    public Set<MaintenanceRegister> getAll() {
        return this.maintenanceRegisters;
    }


    public MaintenanceRegister create(MaintenanceRegister maintenanceRegister) {
        return this.repository.save(maintenanceRegister);
    }


    public MaintenanceRegister read(String id) {
        Optional<MaintenanceRegister> optMaintenanceRegister = repository.findById(id);
        return optMaintenanceRegister.orElse(null);
    }


    public MaintenanceRegister update(MaintenanceRegister maintenanceRegister) {

        return repository.save(maintenanceRegister);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
