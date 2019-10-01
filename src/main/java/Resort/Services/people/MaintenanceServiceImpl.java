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

    public Set<MaintenanceRegister> getAll() {
        return this.maintenanceRegisters;
    }


    public MaintenanceRegister create(MaintenanceRegister maintenanceRegister) {
        return this.repository.create(maintenanceRegister);
    }


    public MaintenanceRegister read(String id) {
        return repository.read(id);
    }
    public MaintenanceRegister findStaff(String id) {
        return this.maintenanceRegisters.stream()
                .filter(maintenanceRegister -> maintenanceRegister.getId().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
    }

    public MaintenanceRegister update(MaintenanceRegister maintenanceRegister) {
        MaintenanceRegister toDelete=findStaff(maintenanceRegister.getId());
        if(toDelete!=null){
            this.maintenanceRegisters.remove(toDelete);
            return create(maintenanceRegister);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        MaintenanceRegister maintenanceRegister=findStaff(id);
        if(maintenanceRegister!=null)this.maintenanceRegisters.remove(maintenanceRegister);

    }
}
