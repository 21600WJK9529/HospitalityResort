package Database.Maintenance;

import Register.MaintenanceRegister;

import java.util.HashSet;
import java.util.Set;


public class MaintenanceRepositoryImpl implements MaintenanceRepository{
    private static MaintenanceRepository repository = null;
    private Set<MaintenanceRegister> maintenanceRegisterSet;

    private MaintenanceRepositoryImpl() {
        this.maintenanceRegisterSet = new HashSet<>();
    }

    public static MaintenanceRepository getRepository(){
        if(repository==null) repository=new MaintenanceRepositoryImpl();
        return repository;
    }

    public MaintenanceRegister create(MaintenanceRegister maintenance){
        this.maintenanceRegisterSet.add(maintenance);
        return maintenance;
    }
    public MaintenanceRegister read(String maintenanceID){
        return search(maintenanceID);
    }

    public MaintenanceRegister update(MaintenanceRegister maintenanceRegister){
        MaintenanceRegister update=search(maintenanceRegister.getId());
            if (maintenanceRegisterSet.contains(update)){
                maintenanceRegisterSet.remove(update);
                maintenanceRegisterSet.add(maintenanceRegister);
            }
        return maintenanceRegister;
    }
    public void delete(String maintenanceID){
        maintenanceRegisterSet.remove(search(maintenanceID));
    }
    public Set<MaintenanceRegister> getAll(){
        return this.maintenanceRegisterSet;
    }
    public MaintenanceRegister search(String maintenanceID){
        return maintenanceRegisterSet.stream().filter(MaintenanceRegister->
                                                            MaintenanceRegister.getId()==maintenanceID)
                                                                                    .findAny().orElse(null);

    }
}
