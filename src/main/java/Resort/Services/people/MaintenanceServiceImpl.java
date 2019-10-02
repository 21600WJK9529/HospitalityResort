package Resort.Services.people;

import Resort.Domain.Maintenance.MaintenanceRepository;
import Resort.Domain.Maintenance.MaintenanceRepositoryImpl;
import Resort.Domain.Register.Maintenance.MaintenanceRegister;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("MaintenanceServiceImpl")
public class MaintenanceServiceImpl implements MaintenanceService {
    private MaintenanceServiceImpl service=null;
    private MaintenanceRepository repository;

    private Set<MaintenanceRegister> maintenanceRegisters;
    private MaintenanceServiceImpl(){
        repository= MaintenanceRepositoryImpl.getRepository();

    }
    public MaintenanceServiceImpl getService(){
        if (service == null) service= new MaintenanceServiceImpl();
        return service;
    }

    public MaintenanceRegister create(MaintenanceRegister maintenanceRegister) {
        return this.repository.create(maintenanceRegister);
    }


    public MaintenanceRegister read(String id) {
        return repository.read(id);
    }


    public MaintenanceRegister update(MaintenanceRegister maintenanceRegister) {
        MaintenanceRegister toDelete=repository.read(maintenanceRegister.getId());
        if(toDelete!=null){
            this.repository.delete(toDelete.getId());
        }
        return repository.create(maintenanceRegister);
    }

    public void delete(String id) {
        MaintenanceRegister maintenanceRegister=repository.read(id);
        if(maintenanceRegister!=null) {
            repository.delete(maintenanceRegister.getId());
        }
    }

    public Set<MaintenanceRegister> getAll() {
        return maintenanceRegisters;
    }
}
